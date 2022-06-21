package nl.hva.rpggame.engine.models.world;

import java.awt.image.BufferedImage;

public class Tile {
    public static final BufferedImage DEFAULT_TEXTURE = null;
    public boolean hasCollision;
    public int textureId;
    public int row, col;
    public int x, y;
    public int screenX, screenY;

    public Tile() {
        this.textureId = 0; // void texture
        this.hasCollision = false;
    }
}
