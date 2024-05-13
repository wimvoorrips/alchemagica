package main.screens;

import main.interfaces.Clickable;
import main.interfaces.Drawable;
import main.interfaces.Hoverable;
import main.interfaces.Updatable;
import main.screens.Screen;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class Pane implements Clickable, Hoverable, Drawable {

    protected int x = 0;
    protected int y = 0;
    protected int width = 0;
    protected int height = 0;
    protected java.util.List<Updatable> updatables = new ArrayList<Updatable>();
    protected java.util.List<Drawable> drawables = new ArrayList<Drawable>();
    protected java.util.List<Drawable> popups = new ArrayList<Drawable>();
    protected java.util.List<Clickable> clickables = new ArrayList<Clickable>();
    protected List<Hoverable> hoverables = new ArrayList<Hoverable>();

    private static int mouseX;
    private static int mouseY;
    private boolean isHovered;

    public void update(){
        for(Updatable updatable : updatables){
            updatable.update();
        }
    }

    @Override
    public void draw(Graphics2D g2){
        for(Drawable drawable : drawables){
            drawable.draw(g2);
        }
    }

    public void drawOverlay(Graphics2D g2){
        for(Drawable drawable : drawables){
            drawable.drawOverlay(g2);
        }
    }

    public void onMouseClick(MouseEvent e){
        int mouseX = e.getX();
        int mouseY = e.getY();
        //System.out.println(mouseX + ", " + mouseY);
        for( Clickable clickable : clickables){
            if(mouseX >= clickable.getX() && mouseX <= clickable.getX() + clickable.getWidth() &&
                    mouseY >= clickable.getY() && mouseY <= clickable.getY() + clickable.getHeight()){
                clickable.onMouseClick(e);
            }
        }
    }

    public void onMouseMove(MouseEvent e){
        mouseX = e.getX();
        mouseY = e.getY();
        for( Hoverable hoverable : hoverables){
            if(mouseX >= hoverable.getX() && mouseX <= hoverable.getX() + hoverable.getWidth() &&
                    mouseY >= hoverable.getY() && mouseY <= hoverable.getY() + hoverable.getHeight()){
                hoverable.setIsHovered(true);
                hoverable.onMouseMove(e);
            } else {
                hoverable.setIsHovered(false);
            }

        }
    }

    @Override
    public void setIsHovered(boolean isHovered) {
        this.isHovered = isHovered;
    }

    public boolean getIsHovered(){
        return isHovered;
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

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public static int getMouseX() {
        return mouseX;
    }

    public static int getMouseY() {
        return mouseY;
    }
}
