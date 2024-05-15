package main.items.ingredients;

import main.items.AttributeList;

public class LongGrass extends Ingredient{
    public LongGrass(int x, int y) {
        super("sprites/ingredients/grass.png", x, y);
        AttributeList attributeList = getAttributeList();
        attributeList.setAttributeValue(AttributeList.attributes.ENERGY, -40);
        attributeList.setAttributeValue(AttributeList.attributes.STRENGTH, 80);
        attributeList.setAttributeValue(AttributeList.attributes.DEXTERITY, 20);
    }
}
