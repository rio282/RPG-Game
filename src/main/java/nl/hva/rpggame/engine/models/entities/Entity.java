package nl.hva.rpggame.engine.models.entities;

import nl.hva.rpggame.engine.Game;
import nl.hva.rpggame.engine.Stage;
import nl.hva.rpggame.engine.models.world.Tile;

import java.awt.*;

public class Entity {

    protected int id;
    protected String name;
    protected EntityStats entityStats;
    protected Image sprite;
    protected boolean colliding;
    protected int width, height; // TODO: load in entity specific data later
    protected int screenX, screenY;
    protected int worldX, worldY;

    public Entity(int id, String name, EntityStats entityStats, Image sprite, int worldX, int worldY) {
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
    public void update() {
        screenX = (int) (worldX - Game.SCREEN_WIDTH);
        screenY = (int) (worldY - Game.SCREEN_HEIGHT);
    }

    /**
     * Load sprite(s), setup vars etc.
     */
    public void load() {

    }

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

    public Point getWorldPos() {
        return new Point(worldX, worldY);
    }

    public Point getScreenPos() {
        return new Point(screenX, screenY);
    }
}
