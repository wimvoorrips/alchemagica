package main.gameobjects;

import java.awt.*;
import java.awt.event.MouseEvent;

public interface GameObjectInterface {
    void draw(Graphics2D g2);
    void update();
    void addChild(GameObject o, int position);
    //void onMouseMove(MouseEvent e);
    //void setIsHovered(boolean isHovered);
}
