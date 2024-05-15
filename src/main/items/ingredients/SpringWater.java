package main.items.ingredients;

import main.items.AttributeList;

public class SpringWater extends Ingredient{
    public SpringWater(int x, int y) {
        super("sprites/ingredients/waterdrop.png", x, y);
        AttributeList attributeList = getAttributeList();
        attributeList.setAttributeValue(AttributeList.attributes.STRENGTH, 10);
        attributeList.setAttributeValue(AttributeList.attributes.HEALING, 20);
        attributeList.setAttributeValue(AttributeList.attributes.INTELLECT, 80);
    }
}
