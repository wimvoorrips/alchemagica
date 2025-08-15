package main.nieuwepoging;

import main.nieuwepoging.enums.Attributes;
import main.nieuwepoging.enums.IngredientNames;
import main.nieuwepoging.enums.Tags;
import main.nieuwepoging.enums.Themes;

import java.util.ArrayList;

public abstract class Ingredient {
    protected AttributeSet attributes = new AttributeSet();

    protected ArrayList<Tags> tags = new ArrayList<Tags>();
    protected Themes theme;
    public final IngredientNames name;

    Ingredient(IngredientNames initialName){
        name = initialName;
    }

    Ingredient(IngredientNames initialName, ArrayList<Attributes> initialAttributes, ArrayList<Tags> initialTags, Themes initialTheme){
        name = initialName;

        for( Attributes attribute : initialAttributes ){
            attributes.increaseAttribute(attribute);
        }

        tags = initialTags;
        theme = initialTheme;
    }

    public void addAttribute(Attributes attribute){
        attributes.increaseAttribute(attribute);
    }

    public void addTag(Tags tag){
        tags.add(tag);
    }

    public void setTheme(Themes newTheme){
        theme = newTheme;
    }

    public IngredientNames getName(){
        return name;
    }

    public AttributeSet getAttributes() {
        return attributes;
    }

    public void onAddedTo(){
        System.out.println("ingredient added");
    }
}
