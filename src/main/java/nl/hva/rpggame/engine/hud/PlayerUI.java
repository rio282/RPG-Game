package nl.hva.rpggame.engine.hud;

import nl.hva.rpggame.engine.Game;
import nl.hva.rpggame.engine.Stage;
import nl.hva.rpggame.engine.models.entities.PlayerEntity;

import javax.swing.*;
import java.awt.*;

public class PlayerUI extends UIElement {

    private PlayerEntity player;

    private JLabel hpLbl;

    public PlayerUI() {
        player = Stage.getPlayer();

        hpLbl = new JLabel();
    }

    @Override
    public void update() {
        // update ui

    }

    @Override
    public void draw(Stage stage, Graphics2D g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, Game.SCREEN_WIDTH, g.getFontMetrics().getHeight()*2);

        String hpText = String.format("HP: %.1f", player.getEntityStats().hp());
        g.setColor(Color.WHITE);
        super.drawCenteredString(g, hpText, new Rectangle(0, 10, Game.SCREEN_WIDTH, g.getFontMetrics().getHeight()));
    }
}
