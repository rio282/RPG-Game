package nl.hva.rpggame.engine;

import nl.hva.rpggame.engine.data.PlayerEntityDAO;
import nl.hva.rpggame.engine.models.entities.Entity;
import nl.hva.rpggame.engine.models.entities.PlayerEntity;

import java.awt.*;
import java.util.Collections;

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
            entities.forEach(entity -> entity.draw(this, graphics));
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
        entities.forEach(Entity::update);
    }

    @Override
    protected void load() {
        // TODO: call map DAO

        PlayerEntityDAO playerDAO = new PlayerEntityDAO();
        PlayerEntity player = playerDAO.get(1);
        entities.add(player);


        // remove null values to prevent errors
        entities.removeAll(Collections.singleton(null));
    }
}
