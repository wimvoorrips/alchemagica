package main.witch;

import main.items.AttributeList;

import java.util.ArrayList;

public class Request {
    private AttributeList lowerBounds;
    private AttributeList upperBounds;

    public Request(){
        lowerBounds = new AttributeList(-100);
        upperBounds = new AttributeList(100);

        lowerBounds.setAttributeValue(AttributeList.attributes.STRENGTH, 40);
        lowerBounds.setAttributeValue(AttributeList.attributes.ENERGY, 20);
    }

    public boolean validateAttributeList( AttributeList attributeList ){
        boolean isCorrect = true;

        //eerst de lowerbounds
        for(AttributeList.attributes attribute : lowerBounds.getAttributeList()){
            int lowerBound = lowerBounds.getAttributeValue(attribute);
            int attributeValue = attributeList.getAttributeValue(attribute);
            if(lowerBound > attributeValue){
                isCorrect = false;
            }
        }

        //dan upperbound
        for(AttributeList.attributes attribute : upperBounds.getAttributeList()){
            int upperBound = upperBounds.getAttributeValue(attribute);
            int attributeValue = attributeList.getAttributeValue(attribute);
            if(upperBound < attributeValue){
                isCorrect = false;
            }
        }

        return isCorrect;
    }

    public ArrayList<String> makeRequestText(){
        ArrayList<String> messageList = new ArrayList<String>();
        messageList.add("Hello, i need the following: ");
        for(AttributeList.attributes attribute : lowerBounds.getAttributeList()) {
            int lowerBound = lowerBounds.getAttributeValue(attribute);
            if(lowerBound != -100){
                messageList.add("the " + attribute + "-value must be at least " + lowerBound + ". ");
            }
        }
        return messageList;
    }

    public AttributeList getLowerBounds() {
        return lowerBounds;
    }

    public AttributeList getUpperBounds() {
        return upperBounds;
    }
}
