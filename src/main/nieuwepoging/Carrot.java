package main.nieuwepoging;

import main.nieuwepoging.enums.Attributes;
import main.nieuwepoging.enums.IngredientNames;
import main.nieuwepoging.enums.Themes;

public class Carrot extends Ingredient {
    Carrot() {
        super(IngredientNames.CARROT);

        addAttribute(Attributes.AGILITY);
        addAttribute(Attributes.PERCEPTION);

        setTheme(Themes.BUNNY);
    }
}
