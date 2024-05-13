package main.screens;

import main.interfaces.Drawable;
import main.interfaces.Clickable;
import main.interfaces.Hoverable;
import main.interfaces.Updatable;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public abstract class Screen extends Pane {

    @Override
    public void draw(Graphics2D g2){
        for(Drawable drawable : drawables){
            drawable.draw(g2);
        }
        for(Drawable drawable : drawables){
            drawable.drawOverlay(g2);
        }
    }
}
