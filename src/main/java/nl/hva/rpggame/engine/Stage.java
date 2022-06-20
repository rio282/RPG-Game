package nl.hva.pokebattle.engine;


import nl.hva.pokebattle.engine.gui.BattleOverlay;
import nl.hva.pokebattle.engine.gui.ScreenOverlay;
import nl.hva.pokebattle.engine.models.entities.Pokemon;
import nl.hva.pokebattle.engine.models.entities.Trainer;

import java.awt.*;

public class Stage extends Engine {

    public Stage() {
        setLayout(null);
        setFocusable(true);
        requestFocus();
    }

    /**
     * Frame update
     *
     * @param g - Graphics object
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        try {
            graphics = (Graphics2D) g;
		

        } finally {
            g.dispose();
            graphics.dispose();
        }
    }

    /**
     * Game update
     */
    @Override
    protected void update() {

    }

    @Override
    protected void load() {

    }
}
