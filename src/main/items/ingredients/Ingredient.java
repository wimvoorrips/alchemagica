package main.items.ingredients;

import main.StaticImage.ImageButton;
import main.StaticImage.StaticImage;
import main.interfaces.Hoverable;
import main.items.Cauldron;
import main.items.Tags;
import main.screens.Screen;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Ingredient extends ImageButton implements Hoverable {

    protected int amountInStock = 10;
    private String name = "unnamed";

    private boolean isHovered = false;

    private StaticImage defaultImage;
    private StaticImage hoverImage;

    //private AttributeList attributeList = new AttributeList();
    private ArrayList<Tags.effectTag> tagList = new ArrayList<Tags.effectTag>();


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
        for(Tags.effectTag tag : tagList ){
        //for(String attribute : attributeList.getAttributeList()){
            g2.drawString(tag.name(), x + 10, tekstHoogte);
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

    public void changeAmount(int amount){
        if(canChangeAmountInStock(amount)) {
            this.amountInStock += amount;
        }
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

    public ArrayList<Tags.effectTag> getTagList() {
        return tagList;
    }
    public void addTag(Tags.effectTag tag){
        tagList.add(tag);
    }

    public void removeTag(Tags.effectTag tag){
        int index = tagList.lastIndexOf(tag);
        if(index >= 0){
            tagList.remove(index);
        }
    }

    protected void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }

    //public void setAttributeList(AttributeList attributeList) {
        //this.attributeList = attributeList;
    //}
}
