package main.ingredients;

import main.StaticImage.ImageButton;

import java.awt.event.MouseEvent;

public class Ingredient extends ImageButton {
    double energy = 0;
    double strength = 0;
    double intellect = 0;
    double dexterity = 0;
    double healing = 0;


    public Ingredient(String imageString, int x, int y){
        super(imageString, x, y);
        energy = (Math.random() - 0.5) * 200;
        intellect = (Math.random() - 0.5) * 200;
        addListeners();
    }

    private void addListeners(){

    }

    @Override
    public void onMouseClick(MouseEvent e) {
        Cauldron.addIngredient(this);
    }


}
