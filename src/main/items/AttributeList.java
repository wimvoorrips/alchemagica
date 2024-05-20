package main.items;

import java.sql.Array;

public class AttributeList {

    public enum attributes {
        STRENGTH,
        DEXTERITY,
        INTELLECT,
        HEALING,
        ENERGY,
    }



    /*
    private String[] attributeList = {
            "strength",
            "dexterity",
            "constitution",
            "charisma",
            "intellect",
            "healing",
            "energy"
    };

     */
    private int[] attributeValues = new int[attributes.values().length];//new int[attributeList.length];

    public AttributeList(int defaultValue){
        for(int i = 0; i < attributeValues.length; i++){
            attributeValues[i] = defaultValue;
        }
    }

    public AttributeList(){
        this(0);
    }



    private int getAttributeIndex(attributes attribute){
        int index = -1;
        attributes[] attributeList = attributes.values();
        for (int i = 0; i < attributes.values().length; i++){
            if( attributeList[i] == attribute){
                index = i;
            }
        }
        if (index >= 0 && index <= attributeValues.length){
            return index;
        }
        return -1;
    }

    public int getAttributeValue(int index){
        return attributeValues[index];
    }

    public int getAttributeValue(attributes attribute){
        int index = getAttributeIndex(attribute);
        if(index == -1){
            System.out.println("error in attributeList");
            System.out.println(attribute);
            System.out.println(attributes.values());
            return 0;
        }
        return getAttributeValue(index);
    }

    public int[] getAttributeValues(){
        return attributeValues;
    }

    public void setAttributeValue(int index, int value){
        attributeValues[index] = value;
    }

    public void setAttributeValue(attributes attribute, int value){
        int index = getAttributeIndex(attribute);
        if(index == -1){
            System.out.println("error in attributeList");
            System.out.println(attribute);
            System.out.println(attributes.values());
            return;
        }
        attributeValues[index] = value;
    }

    public attributes[] getAttributeList() {
        return attributes.values();
    }
}
