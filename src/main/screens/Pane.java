package main.screens;

import main.interfaces.*;

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

    public Pane(int x, int y){
        this(x, y, 0, 0);
    }

    public Pane(int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void addEntity(GameEntity entity){
        //System.out.println(entity);
        //System.out.println(entity instanceof Clickable);


        if(entity instanceof Updatable){
            updatables.add((Updatable) entity);
        }
        if(entity instanceof Drawable){
            drawables.add((Drawable) entity);
        }
        if(entity instanceof Clickable){
            clickables.add((Clickable) entity);
        }
        if(entity instanceof Hoverable){
            hoverables.add((Hoverable) entity);
        }
    }

    public void update(){
        for(Updatable updatable : updatables){
            updatable.update();
        }
    }

    @Override
    public void draw(Graphics2D graphics2D){
        for(Drawable drawable : drawables){
            drawable.draw(graphics2D);
        }
    }

    public void drawOverlay(Graphics2D g2){
        for(Drawable drawable : drawables){
            drawable.drawOverlay(g2);
        }
    }

    public void onMouseClick(MouseEvent e){
        //System.out.println("we checken of er in een ding geklikt is");
        int mouseX = e.getX();
        int mouseY = e.getY();
        for( Clickable clickable : clickables){
            //System.out.println(clickable);
            boolean withinXBounds = mouseX >= clickable.getX() && mouseX <= clickable.getX() + clickable.getWidth();
            boolean withinYBounds = mouseY >= clickable.getY() && mouseY <= clickable.getY() + clickable.getHeight();
            if(withinXBounds && withinYBounds){
                //System.out.println("raak");
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
