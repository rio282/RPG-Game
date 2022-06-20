package nl.hva.pokebattle.engine.data;

import java.util.ArrayList;

/**
 * Data Access Object
 */
public interface DAO<T> {
    T get(int id);
    ArrayList<T> getAll();
}
