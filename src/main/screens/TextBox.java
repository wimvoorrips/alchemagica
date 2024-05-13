package main.screens;

import java.awt.*;

public class TextBox extends Pane {

    private String text;

    public TextBox(int x, int y, int width, int height, String text){
        super(x, y, width, height);
        this.text = text;
    }

    public TextBox(int x, int y, int width, int height){
        this(x, y, width, height, "");
    }
    public void draw(Graphics2D g2){
        g2.setColor(Color.white);
        g2.fillRect(x, y, width, height);
        g2.setColor(Color.darkGray);
        g2.fillRect(x + 4, y + 4, width - 8, height - 8);
        g2.setColor(Color.white);
        g2.drawString(text, x + 20,y + 40);
    }

    public void setText(String text) {
        this.text = text;
    }
}
