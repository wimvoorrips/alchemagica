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
        AttributeList attributeList = new AttributeList();

        //alles optellen
        for(Ingredient ingredient : contents){
            for(AttributeList.attributes attribute : ingredient.getAttributeList().getAttributeList()){
                int newValue = attributeList.getAttributeValue(attribute) + ingredient.getAttributeList().getAttributeValue(attribute);
                attributeList.setAttributeValue(attribute, newValue);
            }
        }

        //gemiddelde nemen
        for(AttributeList.attributes attribute : attributeList.getAttributeList()){
            int averageValue = attributeList.getAttributeValue(attribute) / contents.size();
            attributeList.setAttributeValue(attribute, averageValue);
            System.out.println(attribute + ": " + attributeList.getAttributeValue(attribute));
        }

        ArrayList<String> reply = shopScreen.getCurrentCustomer().tellAboutPotion(attributeList);//new Potion(attributeList));
        shopScreen.getChatBox().setText(reply);

        empty();
    }
}
