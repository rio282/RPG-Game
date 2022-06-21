package nl.hva.rpggame.engine.data;

import nl.hva.rpggame.engine.models.levels.map.Map;
import nl.hva.rpggame.utils.Logger;
import org.json.JSONObject;

import java.nio.file.Path;
import java.util.ArrayList;

public class MapDAO extends DAO<Map> {

    private ArrayList<Map> maps;

    public MapDAO() {
        maps = new ArrayList<>();
    }

    @Override
    Map get(int id) {
        try {
            final String mapFile = Path.of(RESOURCE_FOLDER, "level", "maps", String.format("map_%d.design", id)).toString();
            String mapFileContent = super.readFile(mapFile);
            System.out.println(mapFileContent);

            return new Map();
        } catch (Exception e) {
            Logger.errf("Couldn't load player with id: %d (%s).", id, e.getMessage());
        }
        return null;
    }

    @Override
    ArrayList<Map> getAll() {
        return null;
    }

    @Override
    boolean create(Map item) {
        return false;
    }

    @Override
    boolean save(Map item) {
        return false;
    }
}
