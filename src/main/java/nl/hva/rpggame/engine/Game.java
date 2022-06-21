package nl.hva.rpggame.engine;

import nl.hva.rpggame.utils.Logger;

import javax.swing.*;
import java.awt.*;

public class Game extends JFrame {

    // TODO: add getters and setters
    public static final String TITLE = "@RPG-Game!";
    public static final boolean DEV_MODE = true;

    public static final int ORIGINAL_TILE_SIZE = 16;
    public static final int SCALE = 3;

    public static final int SCREEN_COLS = 24;
    public static final int SCREEN_ROWS = 16;
    public static final int WORLD_COLS = 32;
    public static final int WORLD_ROWS = 24;

    public static int tileSize = ORIGINAL_TILE_SIZE * SCALE;
    public static final int SCREEN_WIDTH = SCREEN_COLS * tileSize;
    public static final int SCREEN_HEIGHT = SCREEN_ROWS * tileSize;
    public static final int WORLD_WIDTH = WORLD_COLS * tileSize;
    public static final int WORLD_HEIGHT = WORLD_ROWS * tileSize;

    // game panel
    private Stage stage;

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


    public void start() {
        Logger.log("Start game");
        stage.start();
    }
}
