package main.screens;

import java.awt.*;

public class TextBox extends Pane {

    public TextBox(int x, int y){
        super(x, y);
    }
    public void draw(Graphics2D g2){
        g2.setColor(Color.white);
        g2.fillRect(x, y, 100, 100);
        g2.setColor(Color.darkGray);
        g2.fillRect(x + 4, y + 4, 92, 92);
        g2.setColor(Color.white);
        g2.drawString("energy: ", 0,0);
    }
}
