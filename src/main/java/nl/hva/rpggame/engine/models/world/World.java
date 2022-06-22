package nl.hva.rpggame.engine.models.world;

import nl.hva.rpggame.engine.Game;
import nl.hva.rpggame.engine.data.MapDAO;
import nl.hva.rpggame.utils.Logger;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * Handles loading/switching between maps and rooms.
 */
public abstract class World {

    protected Tile[][] mapTiles;
    protected ArrayList<Tile> tilesOnScreen;

    public World(Tile[][] mapTiles) {
        Logger.log("Creating: world/scene");
        this.mapTiles = mapTiles;
        tilesOnScreen = new ArrayList<>();
    }

    // update tile positions, states etc
    public abstract void update();

    public void draw(Graphics2D g) {
        for (Tile tile : tilesOnScreen) {
            // decide which texture to use
            if (tile.texture == null) {
                g.setColor(Color.BLACK);
                g.fillRect(tile.screenX, tile.screenY, Game.tileSize, Game.tileSize);
            } else g.drawImage(tile.texture, tile.screenX, tile.screenY, Game.tileSize, Game.tileSize, null);
        }
    }


    protected boolean isTileOnScreen(Tile tile) {
        // positions relative to game (not to screen)
        final int leftScreenBorder = (int) Math.floor(Game.getPlayer().getWorldPos().x - Game.getPlayer().getScreenPos().x);
        final int rightScreenBorder = (int) Math.floor(Game.getPlayer().getWorldPos().x + Game.getPlayer().getScreenPos().x);
        final int topScreenBorder = (int) Math.floor(Game.getPlayer().getWorldPos().y - Game.getPlayer().getScreenPos().y);
        final int bottomScreenBorder = (int) Math.floor(Game.getPlayer().getWorldPos().y + Game.getPlayer().getScreenPos().y);

        // check if tile is within screen borders
        return (tile.x + Game.tileSize) > leftScreenBorder &&
                (tile.x - Game.tileSize) < rightScreenBorder &&
                (tile.y + Game.tileSize) > topScreenBorder &&
                (tile.y - Game.tileSize) < bottomScreenBorder;
    }
}
