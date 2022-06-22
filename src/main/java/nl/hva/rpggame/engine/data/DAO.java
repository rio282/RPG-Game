package nl.hva.rpggame.engine.data;

import org.json.JSONObject;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * Data Access Object
 */
public abstract class DAO<T> {

    protected final String RESOURCE_FOLDER = "./res";

    public String readFile(String filepath) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filepath)));
    }

    public JSONObject parseJsonFile(String filepath) throws IOException {
        return new JSONObject(readFile(filepath));
    }

    public BufferedImage getTexture(int textureId) {
        try {
            return ImageIO.read(Path.of(RESOURCE_FOLDER, "textures", "tiles", String.format("tile_%d.png", textureId)).toFile());
        } catch (IOException ignored) {
        }
        return null;
    }


    public abstract T get(int id);

    public abstract ArrayList<T> getAll();

    public abstract boolean create(T item);

    public abstract boolean save(T item);
}
