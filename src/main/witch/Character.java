package main.witch;

import main.items.ingredients.*;

import java.util.ArrayList;
import java.util.List;

public class Character {
    protected String name;
    protected List<Ingredient> ingredientList = new ArrayList<Ingredient>();

    Character(String name){
        this.name = name;
        fillIngredientList();
    }

    private void fillIngredientList(){
        ingredientList.add(new BrownMushroom(0,0));
        ingredientList.add(new FineSand(0,0));
        ingredientList.add(new LongGrass(0,0));
        ingredientList.add(new SpringWater(0,0));
    }

    public List<Ingredient> getIngredientList() {
        return ingredientList;
    }
}
