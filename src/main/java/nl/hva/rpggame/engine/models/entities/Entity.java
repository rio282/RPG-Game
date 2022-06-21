package nl.hva.rpggame.engine.models.entities;

import nl.hva.rpggame.engine.Stage;

import java.awt.*;

public abstract class Entity {

    protected int id;
    protected String name;
    protected Image sprite;
    protected boolean hostile;
    protected int width, height;
    protected int screenX, screenY;
    protected double worldX, worldY;

    public Entity(int id, String name, Image sprite, boolean hostile, int width, int height, double worldX, double worldY) {
        this.id = id;
        this.name = name;
        this.sprite = sprite; // TODO: change this into an array when we get multiple sprites working
        this.hostile = hostile;
        this.width = width;
        this.height = height;
        this.worldX = worldX;
        this.worldY = worldY;
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
        } else g.drawImage(sprite, screenX, screenY, width, height, stage);
    }
}
