package nl.hva.rpggame.engine;

import nl.hva.rpggame.engine.controllers.InputMethod;
import nl.hva.rpggame.engine.controllers.Keyboard;
import nl.hva.rpggame.engine.models.entities.Entity;
import nl.hva.rpggame.utils.Logger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public abstract class Engine extends JPanel implements Runnable {

    protected static final int FPS_CAP = Game.getMonitorRefreshRate();
    protected static final int TICK_RATE = 60;

    // game inputs
    protected static InputMethod inputMethod;

    // engine stuff
    protected boolean running;
    protected Thread thread;
    protected Graphics2D graphics;
    protected int currentFps;
    protected double currentFrametimeMS;

    // entities, ui components etc.
    protected ArrayList<Entity> entities;

    public Engine() {
        initialize();

        setLayout(null);
        setDoubleBuffered(true);
        setBackground(Color.DARK_GRAY);

        // TODO: if we add support for controllers this might need to change?
        addKeyListener((KeyListener) inputMethod);
        setFocusable(true);
        requestFocus();
    }

    private void initialize() {
        inputMethod = new Keyboard();
        entities = new ArrayList<>();
        running = false;
        thread = new Thread(this);
    }

    // GAME LOOP
    @Override
    public void run() {
        // constants
        final double NANOS_IN_1_SECOND = 1e9;
        final double MILLIS_IN_1_SECOND = 1e6;
        final double DRAW_INTERVAL = NANOS_IN_1_SECOND / FPS_CAP;
        final double TICK_INTERVAL = NANOS_IN_1_SECOND / TICK_RATE;

        // vars needed for game loop
        long currentTime;
        long lastTime = System.nanoTime();
        long frameTimer = 0;
        double deltaFrame = 0;
        double deltaTick = 0;
        double delta;
        int frameDrawCount = 0;

        // to measure frame time
        long start, end;

        while (thread != null && running) {
            // if game alt tabbed, skip
            if (!hasFocus()) continue;

            currentTime = System.nanoTime();
            delta = currentTime - lastTime;
            deltaFrame += delta / DRAW_INTERVAL;
            deltaTick += delta / TICK_INTERVAL;
            frameTimer += delta;
            lastTime = currentTime;

            // every tick
            if (deltaTick > 0) {
                update();
                deltaTick--;
            }
            // every frame
            if (deltaFrame > 0) {
                start = System.nanoTime();

                repaint(); // redraw screen
                deltaFrame--;
                frameDrawCount++;

                end = System.nanoTime();
                currentFrametimeMS = (end - start) / MILLIS_IN_1_SECOND;
            }
            // if timer hits 1 second
            if (frameTimer > NANOS_IN_1_SECOND) {
                // amount of times we drew a frame in the last second
                currentFps = frameDrawCount;
                frameDrawCount = 0;
                frameTimer = 0;

                if (Game.DEV_MODE) {
                    System.out.println("FPS: " + currentFps);
                    System.out.printf("LFRT: %.2f ms\n", currentFrametimeMS); // Last Frame Render Time
                    System.out.println();
                }
            }
        }
    }

    protected abstract void update();

    protected abstract void load();

    protected void pause() {
        running = false;
    }

    protected void unpause() {
        running = true;
    }

    public void start() {
        Logger.log("Load game");
        load();

        // start thread
        Logger.log("Start game thread");
        running = true;
        thread.start();
    }

    public void stop() {
        running = false;
        thread.interrupt();
        thread = null;
        System.exit(0);
    }
}
