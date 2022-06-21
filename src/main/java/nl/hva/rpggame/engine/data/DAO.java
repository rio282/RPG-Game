package nl.hva.rpggame.engine.data;

import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
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

    abstract T get(int id);

    abstract ArrayList<T> getAll();

    abstract boolean create(T item);

    abstract boolean save(T item);
}
