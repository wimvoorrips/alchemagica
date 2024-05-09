package main.ingredients;

import java.util.ArrayList;
import java.util.List;

public class Cauldron {
    private static List<Ingredient> contents = new ArrayList<Ingredient>();
    private static int size = 3;

    public static void addIngredient(Ingredient ingredient){
        if(! isFull()){
            contents.add(ingredient);
        }
    }

    public static boolean isFull(){
        return (contents.size() >= size);
    }

    public static void empty(){
        contents.clear();
    }

    public static List<Ingredient> getContents(){
        return contents;
    }
}
