package nl.hva.rpggame.engine.models.world.map;

import nl.hva.rpggame.engine.Game;
import nl.hva.rpggame.engine.models.world.Tile;
import nl.hva.rpggame.engine.models.world.World;

import java.util.Stack;

public class Map extends World {

    public Map() {
        super();
    }

    @Override
    public void update() {
        tilesOnScreen = new Stack<>();

        // if tiles on screen, add to our arraylist
        for (int worldCol = 0; worldCol < Game.WORLD_COLS; ++worldCol) {
            for (int worldRow = 0; worldRow < Game.WORLD_ROWS; ++worldRow) {
                Tile tile = tiles[worldCol][worldRow];
                tile.x = worldRow * Game.tileSize;
                tile.y = worldCol * Game.tileSize;
                tile.screenX = (int) Math.floor(tile.x - Game.getPlayer().getWorldPos().x + Game.getPlayer().getScreenPos().y);
                tile.screenY = (int) Math.floor(tile.y - Game.getPlayer().getWorldPos().y + Game.getPlayer().getScreenPos().y);
                tile.textureId = 0;
                if (isTileOnScreen(tile)) {
                    tilesOnScreen.push(tile);
                }
            }
        }
    }
}
