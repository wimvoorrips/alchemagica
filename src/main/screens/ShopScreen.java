package main.screens;

import main.StaticImage.StaticImage;

import java.awt.event.MouseEvent;

public class ShopScreen extends Screen {
    public ShopScreen(){
        addEntities();
    }

    private void addEntities(){
        StaticImage testSprite = new StaticImage("sprites/witch.jpeg", 0, 0);
        this.drawables.add(testSprite);
    }

    @Override
    public void onMouseClick(MouseEvent e) {
        super.onMouseClick(e);
        System.out.println("er is geklikt in de shop");
    }
}
