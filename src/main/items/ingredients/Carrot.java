package main.items.ingredients;

import main.items.AttributeList;

public class Carrot extends Ingredient {

    public Carrot(int x, int y){
        super("sprites/ingredientselectedgroot.png", x, y);
        AttributeList attributeList = getAttributeList();
        attributeList.setAttributeValue(AttributeList.attributes.ENERGY, 80);
        attributeList.setAttributeValue(AttributeList.attributes.INTELLECT, -10);
        attributeList.setAttributeValue(AttributeList.attributes.DEXTERITY, 60);
    }
}
