package main.witch;

public class PotionRequest {
    private int value;
    private String attribute;

    public PotionRequest(String attribute, int value){
        this.attribute = attribute;
        this.value = value;
    }

    public String makeText(){
        return "the " + attribute + "-value must be at least " + value + ". ";
    }

    public int getValue() {
        return value;
    }

    public String getAttribute() {
        return attribute;
    }
}
