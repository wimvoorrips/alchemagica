package main.screens;

import main.GamePanel;
import main.StaticImage.Patroon;
import main.StaticImage.StaticImage;
import main.ingredients.Ingredient;
import main.witch.Witch;

import java.awt.event.MouseEvent;

public class ShopScreen extends Screen {
    public ShopScreen(){
        addEntities();
    }

    private void addEntities(){
        Patroon achterwand = new Patroon("sprites/plankenmuurgroot.png",0,0, GamePanel.screenWidth, 800);// GamePanel.screenHeight);
        drawables.add(achterwand);

        Witch witch = new Witch(0,0);
        this.drawables.add(witch);
        this.clickables.add(witch);

        StaticImage kast = new StaticImage("sprites/kastgroot.png", 0 , 0);
        int kastX = (GamePanel.screenWidth / 2) - (kast.getWidth() / 2);
        int kastY = GamePanel.screenHeight - (kast.getHeight() + 400);
        kast.setX(kastX);
        kast.setY(kastY);
        this.drawables.add(kast);

        Ingredient ingredient1 = new Ingredient("sprites/ingredientgroot.png", 500,100);
        drawables.add(ingredient1);
        clickables.add(ingredient1);
        hoverables.add(ingredient1);

        Ingredient ingredient2 = new Ingredient("sprites/ingredientgroot.png", 600,100);
        drawables.add(ingredient2);
        clickables.add(ingredient2);
        hoverables.add(ingredient2);

        StaticImage cauldron = new StaticImage("sprites/cauldrongroot.png", 0,0);
        int startKnopX = (GamePanel.screenWidth / 2) - (cauldron.getWidth() / 2);
        int startKnopY = GamePanel.screenHeight - (cauldron.getHeight() + 100);
        cauldron.setX(startKnopX);
        cauldron.setY(startKnopY);
        this.drawables.add(cauldron);

        //StaticImage testSprite = new StaticImage("sprites/witch.jpeg", 0, 0);

    }

    @Override
    public void onMouseClick(MouseEvent e) {
        super.onMouseClick(e);
        System.out.println("er is geklikt in de shop");
    }
}
