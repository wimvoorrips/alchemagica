package main.screens;

import java.awt.*;
import java.util.ArrayList;

public class TextBox extends Pane {

    private ArrayList<String> text;

    public TextBox(int x, int y, int width, int height, ArrayList<String> text){
        super(x, y, width, height);
        this.text = text;
    }

    /*
    public TextBox(int x, int y, int width, int height, String text){
        this(x, y, width, height, new ArrayList<String>(text));
        //super(x, y, width, height);
        //this.text = text;
    }*/



    public TextBox(int x, int y, int width, int height){
        this(x, y, width, height, new ArrayList<String>());
    }

    public void draw(Graphics2D g2){
        g2.setColor(Color.white);
        g2.fillRect(x, y, width, height);
        g2.setColor(Color.darkGray);
        g2.fillRect(x + 4, y + 4, width - 8, height - 8);
        g2.setColor(Color.white);

        int currentY = y + 40;
        for(String line : text){
            g2.drawString(line, x + 20,currentY);
            currentY += 20;
        }

    }

    public void setText(ArrayList<String> text) {
        this.text = text;
    }
}
