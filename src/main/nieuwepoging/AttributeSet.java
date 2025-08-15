package main.nieuwepoging;

import main.nieuwepoging.enums.Attributes;

import java.util.EnumMap;

public class AttributeSet {

    private final EnumMap<Attributes, Integer> attributes;

    /**
     * create the attributelist, set all values to 0
     */
    AttributeSet(){
        attributes = new EnumMap<>(Attributes.class);
        for (Attributes attribute : Attributes.values()) {
            attributes.put(attribute, 0);
        }
    }

    /**
     * add new attributes to current attributes
     * @param newAttributeSet set of attributes to be added
     */
    public void add(AttributeSet newAttributeSet){
        EnumMap<Attributes, Integer> newAttributes = newAttributeSet.getAttributes();
        for (Attributes attribute : Attributes.values()) {
            int currentValue = attributes.get(attribute);
            int addedValue = newAttributes.get(attribute);
            attributes.put(attribute, currentValue + addedValue);
        }
    }

    public EnumMap<Attributes, Integer> getAttributes() {
        return attributes;
    }

    public void increaseAttribute(Attributes attribute){
        int currentValue = attributes.get(attribute);
        attributes.put(attribute, currentValue + 1);
    }

}
