package main.witch;

import main.items.AttributeList;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Customer {
    private Request request;
    public void generateRequest(){
        request = new Request();
        AttributeList lowerBounds = request.getLowerBounds();
        lowerBounds.setAttributeValue(AttributeList.attributes.STRENGTH, 40);
        lowerBounds.setAttributeValue(AttributeList.attributes.INTELLECT, 20);
    }


    public ArrayList<String> makeText(){
        return request.makeRequestText();
    }

    public ArrayList<String> tellAboutPotion(AttributeList attributeList){
        ArrayList<String> reply = new ArrayList<String>();
        if(request.validateAttributeList(attributeList)){
            reply.add("Thanks, this is exactly what i needed!");
        } else {
            reply.add("Yuck! You are a horrible witch!");
        }
        return reply;
    }

}
