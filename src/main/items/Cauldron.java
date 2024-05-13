package main.items;

import main.items.ingredients.Ingredient;
import main.screens.ShopScreen;
import main.witch.Potion;

import java.util.ArrayList;
import java.util.List;

public class Cauldron {
    private static List<Ingredient> contents = new ArrayList<Ingredient>();
    private static int size = 3;
    public static ShopScreen shopScreen;

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
        double totalHealing = 0;
        double totalDexterity = 0;
        for(Ingredient ingredient : contents){
            totalStrength += ingredient.getStrength();
            totalIntellect += ingredient.getIntellect();
            totalEnergy += ingredient.getEnergy();
            totalDexterity += ingredient.getDexterity();
            totalHealing += ingredient.getHealing();
        }
        int resultingEnergy = (int) totalEnergy / contents.size();
        int resultingStrength = (int) totalStrength / contents.size();
        int resultingIntellect = (int) totalIntellect / contents.size();
        int resultingDexterity = (int) totalDexterity / contents.size();
        int resultingHealing = (int) totalHealing / contents.size();

        System.out.println("je hebt een potion met de volgende stats");
        System.out.println("energy: " + resultingEnergy);
        System.out.println("strength: " + resultingStrength);
        System.out.println("intellect: " + resultingIntellect);
        System.out.println("intellect: " + resultingDexterity);
        System.out.println("intellect: " + resultingHealing);

        String reply = shopScreen.getCurrentCustomer().tellAboutPotion(new Potion(resultingEnergy, resultingStrength, resultingIntellect, resultingDexterity, resultingHealing));
        shopScreen.getChatBox().setText(reply);

        empty();
    }
}
