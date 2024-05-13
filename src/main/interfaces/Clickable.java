package main.interfaces;

import java.awt.event.MouseEvent;

public interface Clickable extends GameEntity {
    void onMouseClick(MouseEvent e);
    int getX();
    int getY();
    int getWidth();
    int getHeight();

}
