package main.items.ingredients;

import main.items.Tags;

public class Carrot extends Ingredient {

    public Carrot(int x, int y){
        super("sprites/ingredients/carrot.png", x, y);
        this.setName("carrot");
        addTag(Tags.effectTag.VISION);
        addTag(Tags.effectTag.FLEXIBILITY);
        addTag(Tags.effectTag.ATTRACTION);
        /*
        AttributeList attributeList = getAttributeList();
        attributeList.setAttributeValue(AttributeList.attributes.ENERGY, 80);
        attributeList.setAttributeValue(AttributeList.attributes.INTELLECT, -10);
        attributeList.setAttributeValue(AttributeList.attributes.DEXTERITY, 60);*/
    }
}
