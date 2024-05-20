package main.items.ingredients;

import main.items.Tags;

public class FineSand extends Ingredient{
    public FineSand(int x, int y) {
        super("sprites/ingredients/sand.png", x, y);
        addTag(Tags.effectTag.LETHARGY);
        addTag(Tags.effectTag.HEARING);
        addTag(Tags.effectTag.DISEASE);
        addTag(Tags.effectTag.NUMBNESS);
        /*
        attributeList.setAttributeValue(AttributeList.attributes.ENERGY, 10);
        attributeList.setAttributeValue(AttributeList.attributes.STRENGTH, 10);
        attributeList.setAttributeValue(AttributeList.attributes.HEALING, 10);
        attributeList.setAttributeValue(AttributeList.attributes.INTELLECT, 20);
        attributeList.setAttributeValue(AttributeList.attributes.DEXTERITY, 10);*/
    }
}
