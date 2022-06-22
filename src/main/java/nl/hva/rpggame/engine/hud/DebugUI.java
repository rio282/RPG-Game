package nl.hva.rpggame.engine.hud;

import nl.hva.rpggame.engine.Stage;

import java.awt.*;
import java.util.ArrayList;

public class DebugUI extends UIElement {

    @Override
    public void update() {

    }

    @Override
    public void draw(Stage stage, Graphics2D g) {
        ArrayList<String> gameInfo = new ArrayList<>();
        gameInfo.add("FPS: " + stage.getFPS());
        gameInfo.add(String.format("Frame time: %.3f ms", stage.getLFRT()));

        // draw box
        g.setColor(new Color(0, 0, 0, 128));
        g.fillRect(stage.getWidth() - 150, 0, 150, gameInfo.size() * 20 + 10);

        // draw text
        g.setColor(Color.GREEN);
        g.setFont(new Font(Font.DIALOG, Font.PLAIN, 12));
        for (int i = 0; i < gameInfo.size(); i++) {
            g.drawString(gameInfo.get(i), stage.getWidth() - 140, (i + 1) * 20);
        }
    }
}
