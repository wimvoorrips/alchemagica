package main.StaticImage;

import main.interfaces.Drawable;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class StaticImage implements Drawable {
    private String imageString;
    private int x;
    private int y;
    private BufferedImage image = null;

    private boolean isFlipped = false;

    public StaticImage(String imageString, int x, int y){
        this(imageString, x, y, 0,0);
        /*
        this.imageString = imageString;
        this.x = x;
        this.y = y;
        loadImage(imageString);*/
    }

    public StaticImage(String imageString, int x, int y, int width, int height){
        this.imageString = imageString;
        this.x = x;
        this.y = y;
        loadImage(imageString, width, height);
    }

    protected void loadImage(String imageString){
        loadImage(imageString, 0, 0);
    }

    protected void loadImage(String imageString, int width, int height){
        String realImageString = "/resources/" + imageString;
        try {
            image = ImageIO.read(getClass().getResource(realImageString));

            if(width > 0){
                resizeImage(width, height);
            }

            if(isFlipped){
                flipImage();
            }
        } catch (IOException e){
            System.out.println(e);
        }
    }

    private void resizeImage(int width, int height){
        image = image.getSubimage(0,0, width, height);

    }

    @Override
    public void draw(Graphics2D g2) {
        g2.drawImage(image,x,y, null  );
    }

    @Override
    public void drawOverlay(Graphics2D g2) {

    }

    public void setFlipped(boolean flipped) {
        isFlipped = flipped;
        flipImage();
    }

    private void flipImage(){
        AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);
        tx.translate(-image.getWidth(null), 0);
        AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
        image = op.filter(image, null);
    }


    public int getX(){
        return x;
    }

    public void setX(int x){
        this.x = x;
    }

    public int getY(){
        return y;
    }

    public void setY(int y){
        this.y = y;
    }

    public int getWidth(){
        return image.getWidth();
    }

    public int getHeight(){
        return image.getHeight();
    }
}
