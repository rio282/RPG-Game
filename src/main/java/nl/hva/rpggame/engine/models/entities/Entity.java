package nl.hva.pokebattle.engine.models.entities;

import nl.hva.pokebattle.engine.Stage;

import java.awt.*;

public abstract class Entity {

    protected String name;
    protected boolean friendly;
    protected Image sprite;
    protected int x, y;
    protected int width, height;


    public Entity() {
        name = "UNDEFINED";
        width = 256;
        height = width;
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
        // draw horizontally mirrored
        int drawX = x, drawWidth = width;
        if (friendly) {
            drawX = x + width;
            drawWidth = -width;
        }

        if (sprite == null) {
            g.setColor(Color.RED);
            g.fillRect(x, y, width, height);
        } else g.drawImage(sprite, drawX, y, drawWidth, height, stage);
    }
}
