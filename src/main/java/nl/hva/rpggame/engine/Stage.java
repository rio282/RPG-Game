package nl.hva.rpggame.engine;

import nl.hva.rpggame.engine.controllers.InputMethod;
import nl.hva.rpggame.engine.data.PlayerEntityDAO;
import nl.hva.rpggame.engine.models.entities.Entity;
import nl.hva.rpggame.engine.models.entities.EntityStats;
import nl.hva.rpggame.engine.models.entities.PlayerEntity;
import nl.hva.rpggame.engine.models.world.World;
import nl.hva.rpggame.engine.models.world.map.Map;

import javax.imageio.ImageIO;
import java.awt.*;
import java.util.Collections;

public class Stage extends Engine {

    public Stage() {
        super();
    }

    public static InputMethod getActiveInputMethod() {
        return inputMethod;
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

            world.draw(graphics);
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
        world.update();
        entities.forEach(Entity::update);
    }

    @Override
    protected void load() {
        // TODO: call map DAO
        world = new Map();


        PlayerEntityDAO playerDAO = new PlayerEntityDAO();
        PlayerEntity player = playerDAO.get(1);
        Engine.player = player;
        entities.add(player);

        EntityStats stats = new EntityStats(false, 4, 4, 4, 4);
        entities.add(new Entity(1, "Entity1", stats, null, 150, 150));

        // remove null values to prevent errors
        entities.removeAll(Collections.singleton(null));
    }
}
