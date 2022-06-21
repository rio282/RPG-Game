package nl.hva.rpggame.engine.models.entities;

import nl.hva.rpggame.engine.Game;
import nl.hva.rpggame.engine.Stage;
import nl.hva.rpggame.utils.Logger;

import java.awt.*;

public class PlayerEntity extends Entity {

    private final int playerId;

    public PlayerEntity(int playerId, String username, EntityStats entityStats, Image playerSprite, double worldX, double worldY) {
        super(0, username, entityStats, playerSprite, worldX, worldY);
        this.playerId = playerId;
        Logger.logf("Init player %d: %s", playerId, name);
    }

    @Override
    public void update() {
        // center character on screen
//        screenX = (int) Math.floor((Game.SCREEN_WIDTH >> 1) - (Game.tileSize >> 1));
//        screenY = (int) Math.floor((Game.SCREEN_HEIGHT >> 1) - (Game.tileSize >> 1));

        Stage.getActiveInputMethod().getActiveInputs().forEach(input -> {
            switch (input) {
                case MOVE_FORWARD -> {
                    screenY -= entityStats.speed();
                }
                case MOVE_BACKWARD -> {
                    screenY += entityStats.speed();
                }
                case MOVE_LEFT -> {
                    screenX -= entityStats.speed();
                }
                case MOVE_RIGHT -> {
                    screenX += entityStats.speed();
                }
                case EXIT -> {
                    Game.stop();
                }
                default -> {

                }
            }
        });
    }

    @Override
    public void load() {
        Logger.logf("Load player: %s", name);
    }
}
