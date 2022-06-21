package nl.hva.rpggame.engine.data;

import nl.hva.rpggame.engine.Game;
import nl.hva.rpggame.engine.models.entities.EntityStats;
import nl.hva.rpggame.engine.models.entities.PlayerEntity;
import nl.hva.rpggame.utils.Logger;
import org.json.JSONObject;

import javax.imageio.ImageIO;
import java.awt.*;
import java.nio.file.Path;
import java.util.ArrayList;

public class PlayerEntityDAO extends DAO<PlayerEntity> {

    private ArrayList<PlayerEntity> players;

    public PlayerEntityDAO() {
        players = new ArrayList<>();
    }

    @Override
    public PlayerEntity get(int id) {
        try {
            final String playerFolder = Path.of(RESOURCE_FOLDER, "data", "players", String.valueOf(id)).toString();
            // default values
            String username = "ERROR";
            Image playerSprite = null;
            int worldX = Game.WORLD_WIDTH >> 1;
            int worldY = Game.WORLD_HEIGHT >> 1;

            // load player data
            JSONObject playerDataJson = super.parseJsonFile(Path.of(playerFolder, "player.json").toString());
            if (!playerDataJson.has("username") || !playerDataJson.has("pos"))
                throw new Exception("file: 'player.json' doesn't contain user data.");

            username = playerDataJson.optString("username", username);
            worldX = playerDataJson.optJSONObject("pos").optInt("worldX", worldX);
            worldY = playerDataJson.optJSONObject("pos").optInt("worldY", worldY);

            // load player sprite(s)
            playerSprite = ImageIO.read(Path.of(playerFolder, "sprites", "idle.png").toFile());

            // load entity stats
            double atk = 10.0;
            double def = 1.0;
            double hp = 10.0;
            int speed = 4;

            atk = playerDataJson.optJSONObject("entityStats").optDouble("atk", atk);
            def = playerDataJson.optJSONObject("entityStats").optDouble("def", def);
            hp = playerDataJson.optJSONObject("entityStats").optDouble("hp", hp);
            speed = playerDataJson.optJSONObject("entityStats").optInt("speed", speed);
            EntityStats entityStats = new EntityStats(false, atk, def, hp, speed);

            // return new player obj
            return new PlayerEntity(id, username, entityStats, playerSprite, worldX, worldY);
        } catch (Exception e) {
            Logger.errf("Couldn't load player with id: %d (%s).", id, e.getMessage());
        }
        return null;
    }

    @Override
    public ArrayList<PlayerEntity> getAll() {
        return players;
    }

    @Override
    public boolean create(PlayerEntity item) {
        return false;
    }

    @Override
    public boolean save(PlayerEntity item) {
        return false;
    }
}
