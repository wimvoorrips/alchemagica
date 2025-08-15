package main.nieuwepoging;

import main.nieuwepoging.enums.Attributes;
import main.nieuwepoging.enums.IngredientNames;
import main.nieuwepoging.enums.Themes;

public class WolfTooth extends Ingredient {
    WolfTooth() {
        super(IngredientNames.WOLF_TOOTH);

        addAttribute(Attributes.AGILITY);
        addAttribute(Attributes.STRENGTH);

        setTheme(Themes.WOLF);
    }
}
