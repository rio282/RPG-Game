package nl.hva.rpggame.engine.hud;

import nl.hva.rpggame.engine.Stage;

import java.awt.*;

public abstract class UIElement {

    public UIElement() {

    }

    public abstract void update();

    public abstract void draw(Stage stage, Graphics2D g);

    /**
     * Draw a String centered in the middle of a Rectangle.
     *
     * @param g    The Graphics instance.
     * @param text The String to draw.
     * @param rect The Rectangle to center the text in.
     */
    public void drawCenteredString(Graphics2D g, String text, Rectangle rect) {
        FontMetrics metrics = g.getFontMetrics();
        int x = rect.x + (rect.width - metrics.stringWidth(text)) / 2;
        int y = rect.y + ((rect.height - metrics.getHeight()) / 2) + metrics.getAscent();
        g.drawString(text, x, y);
    }
}
