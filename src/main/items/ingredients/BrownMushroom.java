package main.items.ingredients;

import main.items.AttributeList;

public class BrownMushroom extends Ingredient{
    public BrownMushroom(int x, int y) {
        super("sprites/ingredients/mushroom.png", x, y);
        AttributeList attributeList = getAttributeList();
        attributeList.setAttributeValue(AttributeList.attributes.ENERGY, 40);
        attributeList.setAttributeValue(AttributeList.attributes.STRENGTH, -20);
        attributeList.setAttributeValue(AttributeList.attributes.HEALING, 80);
    }
}
