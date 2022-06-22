package nl.hva.rpggame.engine.models.world.map;

import nl.hva.rpggame.engine.Game;
import nl.hva.rpggame.engine.models.world.Tile;
import nl.hva.rpggame.engine.models.world.World;

import java.util.ArrayList;

public class Map extends World {

    public Map(Tile[][] mapTiles) {
        super(mapTiles);
    }

    @Override
    public void update() {
        tilesOnScreen = new ArrayList<>();

        // if tiles on screen, add to our arraylist
        for (int worldCol = 0; worldCol < Game.WORLD_COLS; ++worldCol) {
            for (int worldRow = 0; worldRow < Game.WORLD_ROWS; ++worldRow) {
                Tile tile = mapTiles[worldCol][worldRow];
                tile.x = worldCol * Game.tileSize;
                tile.y = worldRow * Game.tileSize;
                tile.screenX = (int) Math.floor(tile.x - Game.getPlayer().getWorldPos().x + Game.getPlayer().getScreenPos().x);
                tile.screenY = (int) Math.floor(tile.y - Game.getPlayer().getWorldPos().y + Game.getPlayer().getScreenPos().y);
                if (isTileOnScreen(tile)) {
                    tilesOnScreen.add(tile);
                }
            }
        }
    }
}
