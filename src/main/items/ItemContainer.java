package main.items;

import main.GamePanel;
import main.StaticImage.StaticImage;
import main.interfaces.Drawable;
import main.items.ingredients.Ingredient;
import main.screens.Screen;
import main.witch.Character;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.List;

public class ItemContainer extends Screen {
    private StaticImage kast;
    private Character owner;

    public ItemContainer(Character owner, int x, int y){
        this.x = x;
        this.y = y;
        this.owner = owner;


        kast = new StaticImage("sprites/kastgroot.png", x , y);
        int kastX = (GamePanel.screenWidth / 2) - (kast.getWidth() / 2);
        int kastY = GamePanel.screenHeight - (kast.getHeight() + 400);
        kast.setX(kastX);
        kast.setY(kastY);

        this.x = kastX;
        this.y = kastY;

        drawables.add(kast);

        this.setWidth(kast.getWidth());
        this.setHeight(kast.getHeight());

        positionEntities();
    }

    public void positionEntities(){
        List<Ingredient> ingredientList = owner.getIngredientList();
        int x = this.x + 20;
        int y = this.y + 20;
        for(Ingredient ingredient : ingredientList){
            ingredient.setX(x);
            ingredient.setY(y);
            x += 50;
            if (x > this.x + this.getWidth()){
                x = this.x + 20;
                y += 100;
            }
            this.drawables.add(ingredient);
            this.clickables.add(ingredient);
            this.hoverables.add(ingredient);
        }
    }

    @Override
    public void setIsHovered(boolean isHovered) {

    }

//    @Override
//    public void onMouseClick(MouseEvent e){
//        System.out.println("er is in de container geklikt");
//
//    }

    @Override
    public void draw (Graphics2D g2){
        for(Drawable drawable : drawables){
            drawable.draw(g2);
        }
    }

    @Override
    public void drawOverlay(Graphics2D g2) {
        for(Drawable drawable : drawables){
            drawable.drawOverlay(g2);
        }
    }
}
