package nl.hva.pokebattle.engine;

import nl.hva.pokebattle.engine.gui.BattleOverlay;
import nl.hva.pokebattle.engine.gui.ScreenOverlay;
import nl.hva.pokebattle.utils.Logger;
import org.apache.maven.plugin.logging.Log;

import javax.swing.*;
import java.awt.*;

public class Game extends JFrame {

    public static final String TITLE = "@RPG-Game!";
    public static final int DEFAULT_WIDTH = 800;
    public static final int DEFAULT_HEIGHT = 800;
    private int width, height;

    private ScreenOverlay stageOverlay;
    private Stage stage;

    public Game(final int width, final int height) {
        this.width = width;
        this.height = height;

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
