package main.items.ingredients;

import main.StaticImage.ImageButton;
import main.StaticImage.StaticImage;
import main.interfaces.Hoverable;
import main.items.AttributeList;
import main.items.Cauldron;
import main.screens.Screen;

import java.awt.*;
import java.awt.event.MouseEvent;

public class Ingredient extends ImageButton implements Hoverable {

    protected int amountInStock = 10;

    private boolean isHovered = false;

    private StaticImage defaultImage;
    private StaticImage hoverImage;

    private AttributeList attributeList = new AttributeList();


    public Ingredient(String imageString, int x, int y){
        super(imageString, x, y);
        createHoveredImage(x, y);
    }


    private void createHoveredImage(int x, int y){
        hoverImage = new StaticImage("sprites/ingredients/ingredientselectedgroot.png", x,y);
    }

    private void createDropDown(Graphics2D g2, int x, int y){
        g2.setColor(Color.white);
        g2.fillRect(x, y, 100, 140);
        g2.setColor(Color.darkGray);
        g2.fillRect(x + 4, y + 4, 92, 132);
        g2.setColor(Color.white);

        int tekstHoogte = y + 20;
        for(AttributeList.attributes attribute : attributeList.getAttributeList() ){
        //for(String attribute : attributeList.getAttributeList()){
            g2.drawString(attribute + ": " + attributeList.getAttributeValue(attribute), x + 10, tekstHoogte);
            tekstHoogte += 20;
        }
        /*
        g2.drawString("energy: " + energy, x + 10, y + 20);
        g2.drawString("strength: " + strength, x + 10, y + 40);
        g2.drawString("intellect: " + intellect, x + 10, y + 60);
        g2.drawString("dexterity: " + dexterity, x + 10, y + 80);
        g2.drawString("healing: " + healing, x + 10, y + 100);*/
        g2.drawString("Aantal over: " + amountInStock, x + 10, y + 120);
    }

    @Override
    public void onMouseClick(MouseEvent e) {
        if(canChangeAmountInStock(-1)){
            amountInStock -= 1;
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

    public AttributeList getAttributeList() {
        return attributeList;
    }

    public void setAttributeList(AttributeList attributeList) {
        this.attributeList = attributeList;
    }
}
