package main.items.ingredients;

import main.items.Tags;

public class BrownMushroom extends Ingredient{


    public BrownMushroom(int x, int y) {
        super("sprites/ingredients/mushroom.png", x, y);
        this.setName("brown mushroom");
        addTag(Tags.effectTag.GROWTH);
        addTag(Tags.effectTag.REPULSION);
        addTag(Tags.effectTag.WEAKNESS);
        addTag(Tags.effectTag.SENSATION);
        /*
        AttributeList attributeList = getAttributeList();
        attributeList.setAttributeValue(AttributeList.attributes.ENERGY, 40);
        attributeList.setAttributeValue(AttributeList.attributes.STRENGTH, -20);
        attributeList.setAttributeValue(AttributeList.attributes.HEALING, 80);*/
    }
}
