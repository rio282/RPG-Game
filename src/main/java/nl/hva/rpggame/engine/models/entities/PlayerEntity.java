package nl.hva.rpggame.engine.models.entities;

import nl.hva.rpggame.engine.Game;
import nl.hva.rpggame.utils.Logger;

import java.awt.*;

public class PlayerEntity extends Entity {


    public PlayerEntity(final int playerId, String username, Image playerSprite, double worldX, double worldY) {
        super(playerId, username, playerSprite, false, Game.TILE_SIZE, Game.TILE_SIZE, worldX, worldY);
        Logger.logf("Init player: %s", name);
    }

    @Override
    public void update() {

    }

    @Override
    public void load() {
        Logger.logf("Load player: %s", name);
    }
}
