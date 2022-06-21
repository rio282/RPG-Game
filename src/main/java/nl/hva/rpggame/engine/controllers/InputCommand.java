package nl.hva.rpggame.engine.controllers;

public enum InputCommand {
    // movement
    MOVE_FORWARD,
    MOVE_BACKWARD,
    MOVE_LEFT,
    MOVE_RIGHT,
    // camera
    LOOK_FORWARD,
    LOOK_BACKWARD,
    LOOK_LEFT,
    LOOK_RIGHT,
    ZOOM_IN,
    ZOOM_OUT,

    // game
    PAUSE,
    EXIT // TODO: remove once we have a pause screen
}
