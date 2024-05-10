package main.ingredients;

import main.StaticImage.ImageButton;
import main.StaticImage.StaticImage;
import main.interfaces.Hoverable;
import main.screens.Screen;

import java.awt.*;
import java.awt.event.MouseEvent;

public class Ingredient extends ImageButton implements Hoverable {

    protected int amountInStock = 0;

    private double energy = 0;
    private double strength = 0;
    private double intellect = 0;
    private double dexterity = 0;
    private double healing = 0;
    private boolean isHovered = false;

    private StaticImage hoverImage;


    public Ingredient(String imageString, int x, int y){
        super(imageString, x, y);
        energy = Math.round((Math.random() - 0.5) * 200);
        intellect = Math.round((Math.random() - 0.5) * 200);
        createHoveredImage(x, y);
    }

    private void createHoveredImage(int x, int y){
        hoverImage = new StaticImage("sprites/ingredientselectedgroot.png", x,y);
    }

    private void createDropDown(Graphics2D g2, int x, int y){
        g2.setColor(Color.white);
        g2.fillRect(x, y, 100, 100);
        g2.setColor(Color.darkGray);
        g2.fillRect(x + 4, y + 4, 92, 92);
        g2.setColor(Color.white);
        g2.drawString("energy: " + energy, x + 10, y + 20);
        g2.drawString("strength: " + strength, x + 10, y + 40);
        g2.drawString("intellect: " + intellect, x + 10, y + 60);
    }

    @Override
    public void onMouseClick(MouseEvent e) {
        if(canChangeAmountInStock(-1)){
            Cauldron.addIngredient(this);
        }
    }

    private boolean canChangeAmountInStock(int amount){
        return amountInStock + amount >= 0;
    }


    @Override
    public void onMouseMove(MouseEvent e) {

    }

    public void setIsHovered(boolean isHovered){
        this.isHovered = isHovered;
    }

    @Override
    public void draw(Graphics2D g2){
        super.draw(g2);
        if(isHovered){
            hoverImage.draw(g2);
        }

    }

    @Override
    public void drawOverlay(Graphics2D g2) {
        if(isHovered){

            createDropDown(g2, Screen.getMouseX(), Screen.getMouseY());
        }
    }

    public void setEnergy(double energy) {
        this.energy = energy;
    }

    public void setStrength(double strength) {
        this.strength = strength;
    }

    public void setIntellect(double intellect) {
        this.intellect = intellect;
    }

    public double getEnergy() {
        return energy;
    }

    public double getStrength() {
        return strength;
    }

    public double getIntellect() {
        return intellect;
    }
}
