package nl.hva.rpggame.engine.hud;

import nl.hva.rpggame.engine.Stage;

import java.awt.*;

public abstract class UIElement {

    public UIElement() {

    }

    public abstract void update();

    public abstract void draw(Stage stage, Graphics2D g);
}
