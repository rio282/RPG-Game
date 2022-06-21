package nl.hva.rpggame.engine.data;

import nl.hva.rpggame.engine.Game;
import nl.hva.rpggame.engine.models.entities.PlayerEntity;
import nl.hva.rpggame.utils.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;

public class PlayerEntityDAO implements DAO<PlayerEntity> {

    private ArrayList<PlayerEntity> players;

    public PlayerEntityDAO() {
        players = new ArrayList<>();
    }

    @Override
    public PlayerEntity get(int id) {
        try {
            final String playerFolder = Path.of(DAO.resourceFolder, "data", "players", String.valueOf(id)).toString();
            // default values
            String username = "ERROR";
            Image playerSprite = null;
            double worldX = Game.WORLD_WIDTH >> 1;
            double worldY = Game.WORLD_HEIGHT >> 1;

            // load player data
            JSONObject playerDataJson = new JSONObject(Path.of(playerFolder, "player.json").toFile());
            if (!(playerDataJson.has("username") && playerDataJson.has("worldX") && playerDataJson.has("worldY")))
                throw new Exception("file: 'player.json' doesn't contain user data.");

            username = playerDataJson.getString("username");
            worldX = playerDataJson.getJSONObject("pos").getDouble("worldX");
            worldY = playerDataJson.getJSONObject("pos").getDouble("worldY");

            // load player sprite & return player obj
            playerSprite = ImageIO.read(Path.of(playerFolder, "sprites", "idle.png").toFile());
            return new PlayerEntity(id, username, playerSprite, worldX, worldY);
        } catch (Exception e) {
            Logger.errf("Couldn't load player with id: %d (%s)", id, e.getMessage());
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
