package main.witch;

import main.StaticImage.StaticImage;
import main.interfaces.Clickable;
import main.interfaces.Drawable;

import java.awt.*;
import java.awt.event.MouseEvent;

public class Witch implements Drawable, Clickable {
    private int x;
    private int y;
    private int width;
    private int height;

    private StaticImage expression;
    private String currentExpression;

    public Witch(int x, int y) {
        this.x = x;
        this.y = y;
    }


    @Override
    public void draw(Graphics2D g2) {
        StaticImage image = new StaticImage("sprites/witch.jpeg", x, y);
        width = image.getWidth();
        height = image.getHeight();
        image.draw(g2);

        //drawHead

        //drawTorso

        //drawLegs
    }

    @Override
    public void drawOverlay(Graphics2D g2) {

    }

    private  void changeExpression(String newExpression){
        currentExpression = newExpression;
        expression = new StaticImage("sprites/witch/expressions/" + currentExpression, 0,0 );

    }

    @Override
    public void onMouseClick(MouseEvent e) {
        System.out.println("you clicked the witch!");
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }
}
