package nl.hva.rpggame.engine.models.entities;

import nl.hva.rpggame.engine.Game;
import nl.hva.rpggame.utils.Logger;

import java.awt.*;

public class PlayerEntity extends Entity {

    private final int playerId;

    public PlayerEntity(final int playerId, String username, Image playerSprite, double worldX, double worldY) {
        super(0, username, playerSprite, false, Game.tileSize, Game.tileSize, worldX, worldY);
        this.playerId = playerId;
        Logger.logf("Init player %d: %s", playerId, name);
    }

    @Override
    public void update() {
        screenX = (int) Math.floor((Game.SCREEN_WIDTH >> 1) - (Game.tileSize >> 1));
        screenY = (int) Math.floor((Game.SCREEN_HEIGHT >> 1) - (Game.tileSize >> 1));
    }

    @Override
    public void load() {
        Logger.logf("Load player: %s", name);
    }
}
