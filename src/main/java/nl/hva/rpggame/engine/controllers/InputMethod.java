package nl.hva.rpggame.engine.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class InputMethod {

    /**
     * KeyEvent keycode and InputCommand
     */
    protected HashMap<Integer, InputCommand> keymap;
    /**
     * Active inputs
     */
    protected ArrayList<InputCommand> activeInputs;

    public InputMethod() {
        keymap = new HashMap<>();
        activeInputs = new ArrayList<>();
    }

    public ArrayList<InputCommand> getActiveInputs() {
        activeInputs.removeAll(Collections.singleton(null));
        return activeInputs;
    }
}
