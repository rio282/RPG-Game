package nl.hva.rpggame.engine.models.entities;

import nl.hva.rpggame.engine.Game;
import nl.hva.rpggame.engine.Stage;

import java.awt.*;

public abstract class Entity {

    protected int id;
    protected String name;
    protected EntityStats entityStats;
    protected Image sprite;
    protected int width, height; // TODO: load in entity specific data later
    protected int screenX, screenY;
    protected double worldX, worldY;

    public Entity(int id, String name, EntityStats entityStats, Image sprite, double worldX, double worldY) {
        // id will be 0 if entity is a player
        this.id = id;
        this.name = name;
        this.entityStats = entityStats;
        this.sprite = sprite; // TODO: change this into an array when we get multiple sprites working
        this.worldX = worldX;
        this.worldY = worldY;

        width = Game.tileSize;
        height = Game.tileSize;
    }

    /**
     * Update position, status, sprite number etc.
     */
    public abstract void update();

    /**
     * Load sprite(s), setup vars etc.
     */
    public abstract void load();

    /**
     * Draw entity in the correct position using the correct sprite
     *
     * @param g - our graphics object passed from our stage
     */
    public void draw(Stage stage, Graphics2D g) {
        if (sprite == null) {
            g.setColor(Color.RED);
            g.fillRect(screenX, screenY, width, height);
            return;
        }

        g.drawImage(sprite, screenX, screenY, width, height, stage);
    }
}
