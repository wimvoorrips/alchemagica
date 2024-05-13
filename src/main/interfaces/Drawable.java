package main.interfaces;

import java.awt.*;

public interface Drawable extends GameEntity {
    void draw(Graphics2D g2);
    void drawOverlay(Graphics2D g2);
}
