package nl.hva.rpggame.engine.data;

import java.util.ArrayList;

/**
 * Data Access Object
 */
public interface DAO<T> {
    String resourceFolder = "./res";
    T get(int id);
    ArrayList<T> getAll();
    boolean create(T item);
    boolean save(T item);
}
