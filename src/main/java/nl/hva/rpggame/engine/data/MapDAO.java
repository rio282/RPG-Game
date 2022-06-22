package nl.hva.rpggame.engine.data;

import nl.hva.rpggame.engine.Game;
import nl.hva.rpggame.engine.models.world.Tile;
import nl.hva.rpggame.engine.models.world.map.Map;
import nl.hva.rpggame.utils.Logger;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class MapDAO extends DAO<Map> {

    private ArrayList<Map> maps;

    public MapDAO() {
        maps = new ArrayList<>();
    }

    @Override
    public Map get(int id) {
        try {
            final String mapFile = Path.of(RESOURCE_FOLDER, "level", "maps", String.format("map_%d.design", id)).toString();
            String mapFileContent = super.readFile(mapFile);

            // prepare mapTiles
            Tile[][] mapTiles = new Tile[Game.WORLD_COLS][Game.WORLD_ROWS];
            for (int col = 0; col < Game.WORLD_COLS; ++col) {
                for (int row = 0; row < Game.WORLD_ROWS; ++row) {
                    mapTiles[col][row] = new Tile(row, col);
                }
            }

            // load map data
            int row = 0;
            Scanner mapFileContentScanner = new Scanner(mapFileContent);
            while (mapFileContentScanner.hasNextLine()) {
                String line = mapFileContentScanner.nextLine();
                String[] tilesInThisRow = line.split(" ");

                // apply texture to correct texture
                int col = 0;
                for (String tile : tilesInThisRow) {
                    mapTiles[col][row].texture = getTexture(Integer.parseInt(tile));
                    col++;
                }
                row++;
            }

            return new Map(mapTiles);
        } catch (Exception e) {
            Logger.errf("Couldn't load map with id: %d (%s).", id, e.getMessage());
        }
        return null;
    }

    @Override
    public ArrayList<Map> getAll() {
        return maps;
    }

    @Override
    public boolean create(Map item) {
        return false;
    }

    @Override
    public boolean save(Map item) {
        return false;
    }
}
