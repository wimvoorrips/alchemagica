package main.screens;

import main.interfaces.Drawable;
import main.interfaces.Clickable;
import main.interfaces.Updatable;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public abstract class Screen implements Clickable {
    private int x = 0;
    private int y = 0;
    private int width = 0;
    private int height = 0;
    protected List<Updatable> updatables = new ArrayList<Updatable>();
    protected List<Drawable> drawables = new ArrayList<Drawable>();
    protected List<Clickable> clickables = new ArrayList<Clickable>();

    public void update(){
        for(Updatable updatable : updatables){
            updatable.update();
        }
    }

    public void draw(Graphics2D g2){
        for(Drawable drawable : drawables){
            drawable.draw(g2);
        }
    }

    public void onMouseClick(MouseEvent e){
        int mouseX = e.getX();
        int mouseY = e.getY();
        System.out.println(mouseX + ", " + mouseY);
        for( Clickable clickable : clickables){
            if(mouseX >= clickable.getX() && mouseX <= clickable.getX() + clickable.getWidth() &&
               mouseY >= clickable.getY() && mouseY <= clickable.getY() + clickable.getHeight()){
                clickable.onMouseClick(e);
            }
        }
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
