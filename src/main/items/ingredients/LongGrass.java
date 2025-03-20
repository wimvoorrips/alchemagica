package main.items.ingredients;

import main.items.Tags;

public class LongGrass extends Ingredient{
    public LongGrass(int x, int y) {
        super("sprites/ingredients/grass.png", x, y);
        this.setName("long grass");
        addTag(Tags.effectTag.GROWTH);
        addTag(Tags.effectTag.WEAKNESS);
        addTag(Tags.effectTag.LIFE);
    }
}
