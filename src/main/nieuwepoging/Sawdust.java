package main.nieuwepoging;

import main.nieuwepoging.enums.IngredientNames;
import main.nieuwepoging.enums.Themes;

public class Sawdust extends Ingredient {
    Sawdust() {
        super(IngredientNames.SAWDUST);
        setTheme(Themes.NORMAL);
    }

    @Override
    public void onAddedTo() {
        super.onAddedTo();
    }
}
