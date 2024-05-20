package main.items.ingredients;

import main.items.Tags;

public class WolfTooth extends Ingredient{
    public WolfTooth(int x, int y) {
        super("sprites/ingredients/tooth.png", x, y);
        addTag(Tags.effectTag.STRENGTH);
        addTag(Tags.effectTag.PERISHING);
        addTag(Tags.effectTag.SENSATION);
        addTag(Tags.effectTag.DEATH);
    }
}
