package main.screens;

import main.StaticImage.ImageButton;
import main.items.ingredients.Ingredient;
import main.witch.Character;

import java.awt.event.MouseEvent;

public class GardenPlot extends ImageButton {
    int state = 1;
    Ingredient ingredient;
    int maxState = 3;
    Character owner;

    GardenPlot(Character owner ,int x, int y){
        super("sprites/garden1.png", x, y);
        this.owner = owner;
    }

    @Override
    public void onMouseClick(MouseEvent e) {
        System.out.println("current state is " + state);
        if (state == maxState){
            System.out.println("you harvest some " + ingredient.getClass().getSimpleName());
            owner.addIngredient(ingredient, 3);
        }

        state += 1;
        if (state > maxState){
            state = 1;
        }
        loadImage("sprites/garden" + state + ".png");
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }
}
