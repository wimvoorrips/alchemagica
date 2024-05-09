package main.ingredients;

import java.util.ArrayList;
import java.util.List;

public class Cauldron {
    private static List<Ingredient> contents = new ArrayList<Ingredient>();
    private static int size = 3;

    public static void addIngredient(Ingredient ingredient){
        if(! isFull()){
            System.out.println("toegevoegd aan cauldron");
            contents.add(ingredient);
            if( isFull() ){
                createPotion();
            }
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

    private static void createPotion(){
        double totalStrength = 0;
        double totalEnergy = 0;
        double totalIntellect = 0;
        for(Ingredient ingredient : contents){
            totalStrength += ingredient.strength;
            totalIntellect += ingredient.intellect;
            totalEnergy += ingredient.energy;
        }
        int resultingEnergy = (int) totalEnergy / contents.size();
        int resultingStrength = (int) totalStrength / contents.size();
        int resultingIntellect = (int) totalIntellect / contents.size();

        System.out.println("je hebt een potion met de volgende stats");
        System.out.println("energy: " + resultingEnergy);
        System.out.println("strength: " + resultingStrength);
        System.out.println("intellect" + resultingIntellect);

        empty();
    }
}
