package nl.hva.rpggame.engine;

import nl.hva.rpggame.utils.Logger;

import javax.swing.*;
import java.awt.*;

public class Game extends JFrame {

    public static final String TITLE = "@RPG-Game!";
    public static final int DEFAULT_WIDTH = 800;
    public static final int DEFAULT_HEIGHT = 800;

    public static final int TILE_SIZE = 16;
    public static final int WORLD_WIDTH = 1200;
    public static final int WORLD_HEIGHT = 800;


    private Stage stage;

    public Game(final int width, final int height) {
        // setup window settings
        Logger.log("Setup window");
        setTitle(TITLE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(width, height));
        setResizable(false);
        setLocationRelativeTo(null);

        // setup game stage
        Logger.log("LOAD: stage");
        stage = new Stage();
        add(stage);

        setVisible(true);
        Logger.log("SHOW: game window");
    }

    public Game() {
        this(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }


    public void start() {
        Logger.log("Start game");
        stage.start();
    }
}
