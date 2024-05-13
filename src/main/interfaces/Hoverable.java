package main.interfaces;

import java.awt.event.MouseEvent;

public interface Hoverable extends GameEntity {
    void onMouseMove(MouseEvent e);
    void setIsHovered(boolean isHovered);

    int getX();
    int getY();
    int getWidth();
    int getHeight();
}
