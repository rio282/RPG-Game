package nl.hva.rpggame.engine.models.world;

import nl.hva.rpggame.engine.Game;

import java.awt.*;
import java.util.Stack;

/**
 * Handles loading/switching between maps and rooms.
 */
public abstract class World {

    protected Tile[][] tiles;
    protected Stack<Tile> tilesOnScreen;

    public World() {
        tilesOnScreen = new Stack<>();
        tiles = new Tile[Game.WORLD_COLS][Game.WORLD_ROWS];
        for (int col = 0; col < Game.WORLD_COLS; ++col) {
            for (int row = 0; row < Game.WORLD_ROWS; ++row) {
                this.tiles[col][row] = new Tile();
                this.tiles[col][row].row = col;
                this.tiles[col][row].col = row;
            }
        }
    }

    // update tile positions, states etc
    public abstract void update();

    public void draw(Graphics2D g) {
        Stack<Tile> tiles = tilesOnScreen;
        for (int i = 0; i < tiles.size(); i++) {
            Tile tile = tilesOnScreen.pop();
            g.setColor(Color.BLACK);
            g.fillRect(tile.screenX, tile.screenY, Game.tileSize, Game.tileSize);
//        g.drawImage(texture, tile.screenX, tile.screenY, Game.tileSize, Game.tileSize, null);
        }
    }

    protected boolean isTileOnScreen(Tile tile) {
        final int leftScreenBorder = (int) Math.floor(Game.getPlayer().getWorldPos().x - Game.getPlayer().getScreenPos().x);
        final int rightScreenBorder = (int) Math.floor(Game.getPlayer().getWorldPos().x + Game.getPlayer().getScreenPos().x);
        final int topScreenBorder = (int) Math.floor(Game.getPlayer().getWorldPos().y - Game.getPlayer().getScreenPos().y);
        final int bottomScreenBorder = (int) Math.floor(Game.getPlayer().getWorldPos().y + Game.getPlayer().getScreenPos().y);

        return tile.x + Game.tileSize > leftScreenBorder &&
                tile.x - Game.tileSize < rightScreenBorder &&
                tile.y + Game.tileSize > topScreenBorder &&
                tile.y - Game.tileSize < bottomScreenBorder;
    }
}
