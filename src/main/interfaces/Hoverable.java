package main.interfaces;

import java.awt.event.MouseEvent;

public interface Hoverable {
    void onMouseMove(MouseEvent e);

    int getX();
    int getY();
    int getWidth();
    int getHeight();
}
