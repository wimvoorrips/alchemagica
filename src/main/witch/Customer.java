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
        String requestAttribute = request.getAttribute();
        int requestValue = request.getValue();
        int potionValue = 0;

        try {
            Class potionClass = potion.getClass();
            Field field = potionClass.getDeclaredField(requestAttribute);
            //field.setAccessible(true);
            potionValue = (int) field.get(potion);
        } catch (Throwable e){
            return false;
        }

        if(potionValue >= requestValue){
            return true;
        }
        return false;
    }
}
