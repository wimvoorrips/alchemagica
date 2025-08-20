package main.items;

import main.items.ingredients.Ingredient;
import main.screens.ShopScreen;

import java.util.*;
import java.util.stream.Collectors;

public class Cauldron {
    private static List<Ingredient> contents = new ArrayList<Ingredient>();
    private static int size = 3;
    public static ShopScreen shopScreen;

    public static void addIngredient(Ingredient ingredient){
        shopScreen.getChatBox().addText("Ingredient " + ingredient.getName() + " toegevoegd");
        if(! isFull()){
            System.out.println("toegevoegd aan cauldron");
            contents.add(ingredient);
            if( isFull() ){
                createPotion();
                empty();
            }
        }
    }

    public static boolean isFull(){
        return (contents.size() >= size);
    }

    public static void empty(){
        shopScreen.getChatBox().addText("cauldron emptied");
        contents.clear();
    }

    public static List<Ingredient> getContents(){
        return contents;
    }

    private static void createPotion(){
        ArrayList<Tags.effectTag> allTags = new ArrayList<Tags.effectTag>();
        for(Ingredient ingredient : contents){
            allTags.addAll(ingredient.getTagList());
        }
        System.out.println(allTags);

        Tags.effectTag firstTag = Tags.effectTag.NOTHINGNESS;
        int firstTagValue = 0;

        for( int i = 0; i < allTags.size(); i++ ){
            Tags.effectTag tag = allTags.get(i);
            int amount = Collections.frequency(allTags, tag);
            if(amount > firstTagValue){
                firstTag = tag;
                firstTagValue = amount;
            }
        }

        Tags.effectTag lastTag = Tags.effectTag.NOTHINGNESS;
        int lastTagValue = 0;

        for( int i = allTags.size() - 1; i >= 0; i-- ){
            Tags.effectTag tag = allTags.get(i);
            if(tag != firstTag) {
                int amount = Collections.frequency(allTags, tag);
                if (amount > lastTagValue) {
                    lastTag = tag;
                    lastTagValue = amount;
                }
            }
        }

        Map<Tags.effectTag, Long> occurrences =
                allTags.stream().collect(Collectors.groupingBy(w -> w, Collectors.counting()));
        System.out.println(occurrences);

        System.out.println("eerste van meestvoorkomend: " + firstTag + " " + firstTagValue);
        System.out.println("laatste van meestvoorkomend: " + lastTag + " " + lastTagValue);

        String potionName = createPotionName(firstTag, lastTag);
        System.out.println(potionName);
        shopScreen.getChatBox().addText(potionName + " gemaakt!");


        ArrayList<String> reply = new ArrayList<>();
        reply.add("You have created the following: " + potionName);
        shopScreen.getChatBox().setText(reply);


        /*

        Map<Tags.tag, Long> occurrences =
                allTags.stream().collect(Collectors.groupingBy(w -> w, Collectors.counting()));

        System.out.println("test");
        System.out.println(occurrences);

        Tags.tag meestVoorkomend = Collections.max(occurrences.entrySet(), Map.Entry.comparingByValue()).getKey();
        System.out.println("meest voorkomend: " + meestVoorkomend);

         */
    }

    private static String createPotionName(Tags.effectTag firstTag, Tags.effectTag lastTag){
        String potionName = "";
        if(firstTag != Tags.effectTag.NOTHINGNESS && lastTag != Tags.effectTag.NOTHINGNESS){

            switch (lastTag){
                case ENERGY:
                    potionName += "Energetic";
                    break;
                case LIFE:
                    potionName += "Living";
                    break;
                case SENSATION:
                    potionName += "Sensitive";
                    break;
                case GROWTH:
                    potionName += "Growing";
                    break;
                case DISEASE:
                    potionName += "Diseased";
                    break;
                case DEATH:
                    potionName += "Deathly";
                    break;
                case PERISHING:
                    potionName += "Perishing";
                    break;
                case ATTRACTION:
                    potionName += "Attractive";
                    break;
                case NUMBNESS:
                    potionName += "Numbing";
                    break;
                case WEAKNESS:
                    potionName += "Weakening";
                    break;
            }
            if(potionName != ""){
                potionName += " ";
            }
        }

        if (firstTag != Tags.effectTag.NOTHINGNESS){
            potionName += capitalize(firstTag.name());
        }

        if(potionName == ""){
            potionName = "Nothingness";
        }
        return "Potion of " + potionName;
    }

    private static String capitalize(String word){
        return word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
    }
    /*
    private static void createPotion2(){
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
    }*/
}
