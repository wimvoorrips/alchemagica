package main.interfaces;

import java.awt.event.MouseEvent;

public interface Clickable {
    void onMouseClick(MouseEvent e);
    int getX();
    int getY();
    int getWidth();
    int getHeight();

}
