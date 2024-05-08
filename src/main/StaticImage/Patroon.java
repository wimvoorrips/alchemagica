package main.StaticImage;

import main.interfaces.Drawable;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Patroon implements Drawable {
    protected List<Drawable> drawables = new ArrayList<Drawable>();
    private int spriteWidth;
    private int spriteHeight;

    public Patroon(String afbeelding, int x, int y, int width, int height){
        StaticImage image = new StaticImage(afbeelding,0,0);
        spriteWidth = image.getWidth();
        spriteHeight = image.getHeight();
        int amountHorizontal = (int) Math.ceil(width / spriteWidth);
        int amountVertical = (int) Math.ceil(height / spriteHeight);

        int drawX = x;
        int drawY = y;

        for(int i = 0; i < amountHorizontal; i++){
            for (int j = 0; j < amountVertical; j++){
                StaticImage plaatje = new StaticImage(afbeelding, x + (i*spriteWidth), y + (j*spriteHeight));
                drawables.add(plaatje);
            }
        }
    }


    @Override
    public void draw(Graphics2D g2) {
        for(Drawable drawable : drawables){
            drawable.draw(g2);
        }
    }
}
