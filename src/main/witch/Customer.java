package main.witch;

import main.items.AttributeList;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Customer {
    //private List<PotionRequest> requestList = new ArrayList<PotionRequest>();
    private Request request;
    public void generateRequest(){
        //requestList.add(new PotionRequest("energy", (int) Math.floor(Math.random() * 50)));
        //requestList.add(new PotionRequest("strength", (int) Math.floor(Math.random() * 50)));

        //request.setAttributeValue("strength", 40);
        //request.setAttributeValue("energy", 20);
        request = new Request();
        AttributeList lowerBounds = request.getLowerBounds();
        lowerBounds.setAttributeValue(AttributeList.attributes.STRENGTH, 40);
        lowerBounds.setAttributeValue(AttributeList.attributes.ENERGY, 20);
    }


    public ArrayList<String> makeText(){
        return request.makeRequestText();
        /*
        String text = "Hello, i need the following: ";

        for (PotionRequest request : requestList){
            text += request.makeText();
        }
        return text;
         */
    }

    /*
    public String tellAboutPotion(Potion potion){
        if (checkPotionAgainstRequests(potion)){
            return "Thanks, this is exactly what i needed!";
        }
        return "Yuck! You are a horrible witch!";
    }*/

    public ArrayList<String> tellAboutPotion(AttributeList attributeList){
        ArrayList<String> reply = new ArrayList<String>();
        if(request.validateAttributeList(attributeList)){
            reply.add("Thanks, this is exactly what i needed!");
        } else {
            reply.add("Yuck! You are a horrible witch!");
        }
        return reply;
    }

    /*
    public boolean checkPotionAgainstRequests(Potion potion){
        for(PotionRequest request : requestList){
            boolean attributeCorrect = checkPotionAgainstRequest(potion, request);
            if (! attributeCorrect ){
                return false;
            }
        }
        return true;
    }

    private boolean checkPotionAgainstRequest(Potion potion, PotionRequest request) {
        System.out.println("checkagainstrequest");

        String requestAttribute = request.getAttribute();
        int requestValue = request.getValue();
        int potionValue = 0;

        System.out.println(requestAttribute);
        System.out.println(requestValue);

        try {
            Class potionClass = potion.getClass();
            System.out.println(potionClass);
            Field field = potionClass.getDeclaredField(requestAttribute);
            System.out.println(field);
            field.setAccessible(true);
            double doublePotionValue = (double) field.get(potion);
            System.out.println(doublePotionValue);
            potionValue = (int) Math.round(doublePotionValue);
        } catch (Throwable e){
            System.out.println(e);
            return false;
        }

        if(potionValue >= requestValue){
            return true;
        }
        return false;
    }*/
}
