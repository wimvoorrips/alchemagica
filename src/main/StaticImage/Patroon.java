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
        double amountHorizontal = Math.ceil(((double) width) / spriteWidth);
        double amountVertical = Math.ceil(((double) height) / spriteHeight);

        int horizontalRoundedUp = (int) amountHorizontal;
        int verticalRoundedUp = (int) amountVertical;

        for(int i = 0; i < horizontalRoundedUp; i++){
            for (int j = 0; j < verticalRoundedUp; j++){
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

    @Override
    public void drawOverlay(Graphics2D g2) {

    }
}
