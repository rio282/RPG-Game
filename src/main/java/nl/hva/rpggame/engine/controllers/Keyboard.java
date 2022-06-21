package nl.hva.rpggame.engine.controllers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard extends InputMethod implements KeyListener {

    // TODO: make constructor that takes in config file
    public Keyboard() {
        // load config
        keymap.put(KeyEvent.VK_W, InputCommand.MOVE_FORWARD);
        keymap.put(KeyEvent.VK_UP, InputCommand.MOVE_FORWARD);

        keymap.put(KeyEvent.VK_A, InputCommand.MOVE_LEFT);
        keymap.put(KeyEvent.VK_LEFT, InputCommand.MOVE_LEFT);

        keymap.put(KeyEvent.VK_S, InputCommand.MOVE_BACKWARD);
        keymap.put(KeyEvent.VK_DOWN, InputCommand.MOVE_BACKWARD);

        keymap.put(KeyEvent.VK_D, InputCommand.MOVE_RIGHT);
        keymap.put(KeyEvent.VK_RIGHT, InputCommand.MOVE_RIGHT);


        keymap.put(KeyEvent.VK_MINUS, InputCommand.ZOOM_OUT);
        keymap.put(KeyEvent.VK_PLUS, InputCommand.ZOOM_IN);
        keymap.put(KeyEvent.VK_EQUALS, InputCommand.ZOOM_IN);

        keymap.put(KeyEvent.VK_ESCAPE, InputCommand.EXIT);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        final int keyCode = e.getKeyCode();
        if (activeInputs.contains(keymap.get(keyCode)))
            return;

        activeInputs.add(keymap.get(keyCode));
    }

    @Override
    public void keyReleased(KeyEvent e) {
        final int keyCode = e.getKeyCode();
        activeInputs.remove(keymap.get(keyCode));
    }
}
