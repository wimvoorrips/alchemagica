package main.items.ingredients;

import main.items.Tags;

public class SpringWater extends Ingredient{
    public SpringWater(int x, int y) {
        super("sprites/ingredients/waterdrop.png", x, y);
        this.setName("spring water");
        addTag(Tags.effectTag.SENSATION);
        addTag(Tags.effectTag.LIFE);
        addTag(Tags.effectTag.HEALTH);
        addTag(Tags.effectTag.DISEASE);
        /*
        AttributeList attributeList = getAttributeList();
        attributeList.setAttributeValue(AttributeList.attributes.STRENGTH, 10);
        attributeList.setAttributeValue(AttributeList.attributes.HEALING, 20);
        attributeList.setAttributeValue(AttributeList.attributes.INTELLECT, 80);*/
    }
}
