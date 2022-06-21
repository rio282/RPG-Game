package nl.hva.rpggame.engine;

import nl.hva.rpggame.engine.models.entities.PlayerEntity;
import nl.hva.rpggame.utils.Logger;

import javax.swing.*;
import java.awt.*;

public class Game extends JFrame {

    // TODO: add getters and setters

    public static final String TITLE = "@RPG-Game!";
    public static final boolean DEV_MODE = true;

    public static final int ORIGINAL_TILE_SIZE = 16;
    public static final int SCALE = 3;

    // r,c
    public static final int SCREEN_COLS = 24;
    public static final int SCREEN_ROWS = 16;
    public static final int WORLD_COLS = 32;
    public static final int WORLD_ROWS = 24;

    // w,h
    public static int tileSize = ORIGINAL_TILE_SIZE * SCALE;
    public static final int SCREEN_WIDTH = SCREEN_COLS * tileSize;
    public static final int SCREEN_HEIGHT = SCREEN_ROWS * tileSize;
    public static final int WORLD_WIDTH = WORLD_COLS * tileSize;
    public static final int WORLD_HEIGHT = WORLD_ROWS * tileSize;

    // game panel
    private static Stage stage;

    public Game(final int width, final int height) {
        // setup window settings
        Logger.log("Setup window");
        setTitle(TITLE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(width, height));
        setResizable(false);

        // setup game stage
        Logger.log("LOAD: stage");
        stage = new Stage();
        add(stage);
        pack();

        // center & show game window
        Logger.log("SHOW: game window");
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public Game() {
        this(SCREEN_WIDTH, SCREEN_HEIGHT);
    }


    public static void start() {
        if (stage == null)
            return;

        Logger.log("Start game");
        stage.start();
    }

    public static void stop() {
        if (stage == null)
            return;

        Logger.log("Exit game");
        stage.stop();
    }

    public static PlayerEntity getPlayer() {
        return stage.getPlayer();
    }

    /**
     * Gets monitor refresh rate by using java.awt; Will return 60 if refresh rate is unknown.
     *
     * @return refresh rate
     */
    public static int getMonitorRefreshRate() {
        int refreshRate = 60;
        GraphicsDevice[] gs = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices();

        // get max refresh rate (multiple monitors)
        for (GraphicsDevice graphicsDevice : gs) {
            DisplayMode dm = graphicsDevice.getDisplayMode();
            refreshRate = Math.max(dm.getRefreshRate(), refreshRate);
        }

        return refreshRate;
    }
}
