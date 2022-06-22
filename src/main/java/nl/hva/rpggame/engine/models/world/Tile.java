package nl.hva.rpggame.engine.models.world;

import java.awt.image.BufferedImage;

public class Tile {
    public boolean hasCollision;
    public BufferedImage texture = null;
    public int row, col;
    public int x, y;
    public int screenX, screenY;

    public Tile(int row, int col) {
        this.row = row;
        this.col = col;
    }
}
