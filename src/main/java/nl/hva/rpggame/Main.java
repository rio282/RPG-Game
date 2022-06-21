package nl.hva.rpggame;

import nl.hva.rpggame.engine.Game;
import nl.hva.rpggame.utils.Logger;

public class Main {
    public static void main(String[] args) {
        // config
        Logger.useShorthand(false);

        // start game
        Game game = new Game();
        game.start();
    }
}
