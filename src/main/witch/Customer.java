package main.witch;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Customer {
    private List<PotionRequest> requestList = new ArrayList<PotionRequest>();
    public void generateRequest(){
        requestList.add(new PotionRequest("energy", (int) Math.floor(Math.random() * 50)));
        requestList.add(new PotionRequest("strength", (int) Math.floor(Math.random() * 50)));
    }

    public String makeText(){
        String text = "Hello, i need the following: ";
        for (PotionRequest request : requestList){
            text += request.makeText();
        }
        return text;
    }

    public String tellAboutPotion(Potion potion){
        if (checkPotionAgainstRequests(potion)){
            return "Thanks, this is exactly what i needed!";
        }
        return "Yuck! You are a horrible witch!";
    }

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
    }
}
