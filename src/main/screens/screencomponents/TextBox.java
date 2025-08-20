package main.screens.screencomponents;

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

        int startPos = Math.max(0, text.size() - 8);
        for(int i = startPos; i < text.size(); i++){
            g2.drawString(text.get(i), x + 20,currentY);
            currentY += 20;
        }

    }

    public void setText(ArrayList<String> text) {
        this.text = text;
    }
    public void addText(String text){
        this.text.add(text);
    }
    public void addText(ArrayList<String> text){
        text.forEach(this::addText);
    }
}
