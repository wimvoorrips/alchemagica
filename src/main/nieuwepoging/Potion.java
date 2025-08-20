package main.nieuwepoging;

import main.nieuwepoging.enums.Attributes;
import main.nieuwepoging.enums.IngredientNames;

import java.util.ArrayList;

public class Potion extends Ingredient {
    private ArrayList<IngredientNames> addedIngredients = new ArrayList<IngredientNames>();

    Potion() {
        super(IngredientNames.POTION);
    }

    public boolean addIngredient(Ingredient ingredient){
        //check if ingredient can be added
        if(addedIngredients.contains(ingredient.getName())){
            return false;
        }
        addedIngredients.add((ingredient.getName()));
        attributes.add(ingredient.getAttributes());
        return true;
    }
}
