package main.screens;

import main.GamePanel;
import main.StaticImage.StaticImage;

import java.awt.event.MouseEvent;

public class ShopScreen extends Screen {
    public ShopScreen(){
        addEntities();
    }

    private void addEntities(){

        StaticImage kast = new StaticImage("sprites/kastgroot.png", 0 , 0);
        int kastX = (GamePanel.screenWidth / 2) - (kast.getWidth() / 2);
        int kastY = GamePanel.screenHeight - (kast.getHeight() + 400);
        kast.setX(kastX);
        kast.setY(kastY);
        this.drawables.add(kast);

        StaticImage cauldron = new StaticImage("sprites/cauldrongroot.png", 0,0);
        int startKnopX = (GamePanel.screenWidth / 2) - (cauldron.getWidth() / 2);
        int startKnopY = GamePanel.screenHeight - (cauldron.getHeight() + 100);
        cauldron.setX(startKnopX);
        cauldron.setY(startKnopY);
        this.drawables.add(cauldron);

        StaticImage testSprite = new StaticImage("sprites/witch.jpeg", 0, 0);
        this.drawables.add(testSprite);
    }

    @Override
    public void onMouseClick(MouseEvent e) {
        super.onMouseClick(e);
        System.out.println("er is geklikt in de shop");
    }
}
