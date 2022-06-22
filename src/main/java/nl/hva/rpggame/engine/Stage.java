package nl.hva.rpggame.engine;

import nl.hva.rpggame.engine.controllers.InputMethod;
import nl.hva.rpggame.engine.data.MapDAO;
import nl.hva.rpggame.engine.data.PlayerEntityDAO;
import nl.hva.rpggame.engine.hud.UIElement;
import nl.hva.rpggame.engine.models.entities.Entity;
import nl.hva.rpggame.engine.models.entities.EntityStats;
import nl.hva.rpggame.engine.models.entities.PlayerEntity;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class Stage extends Engine {

    public Stage() {
        super();
    }

    public static InputMethod getActiveInputMethod() {
        return inputMethod;
    }

    public static ArrayList<UIElement> getUIElements() {
        return uiElements;
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

            if (world != null) world.draw(graphics);
            entities.forEach(entity -> entity.draw(this, graphics));
            uiElements.forEach(uiElement -> uiElement.draw(this, graphics));
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
        uiElements.forEach(UIElement::update);
    }

    @Override
    protected void load() {
        // WORLD
        MapDAO mapDAO = new MapDAO();
        world = mapDAO.get(1);

        // ENTITIES
        PlayerEntityDAO playerDAO = new PlayerEntityDAO();
        PlayerEntity player = playerDAO.get(1);
        Engine.player = player;
        entities.add(player);

        EntityStats stats = new EntityStats(false, 4, 4, 4, 4);
        entities.add(new Entity(1, "Entity1", stats, null, 150, 150));

        // remove null values to prevent errors
        entities.removeAll(Collections.singleton(null));

        // UI
//        uiElements.add(new DebugUI());
    }
}
