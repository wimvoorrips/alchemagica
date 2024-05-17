package main.screens;

import main.GamePanel;
import main.StaticImage.Patroon;
import main.StaticImage.StaticImage;
import main.interfaces.GameEntity;
import main.items.Cauldron;
import main.items.ItemContainer;
import main.items.ingredients.Ingredient;
import main.witch.Customer;
import main.witch.Witch;

import java.awt.*;
import java.awt.event.MouseEvent;

public class ShopScreen extends Screen {

    private Customer currentCustomer;
    private TextBox chatBox;
    public ShopScreen(){
        super();
        addEntities();
    }

    private void addEntities(){
        Patroon achterwand = new Patroon("sprites/plankenmuurgroot.png",0,0, GamePanel.screenWidth, 800);// GamePanel.screenHeight);
        drawables.add(achterwand);

        Witch witch = new Witch(0,0);
        addEntity((GameEntity) witch);
        //this.drawables.add(witch);
        //this.clickables.add(witch);


        ItemContainer kast = new ItemContainer(witch, 0, 0);
        addEntity(kast);

        StaticImage cauldron = new StaticImage("sprites/cauldrongroot.png", 0,0);
        int startKnopX = (GamePanel.screenWidth / 2) - (cauldron.getWidth() / 2);
        int startKnopY = GamePanel.screenHeight - (cauldron.getHeight() + 100);
        cauldron.setX(startKnopX);
        cauldron.setY(startKnopY);
        addEntity((GameEntity) cauldron);
        Cauldron.shopScreen = this;

        chatBox = new TextBox(0,600, GamePanel.screenWidth, 200);
        addEntity(chatBox);

        currentCustomer = new Customer();
        currentCustomer.generateRequest();

        chatBox.setText(currentCustomer.makeText());


        //this.drawables.add(cauldron);

        //StaticImage testSprite = new StaticImage("sprites/witch.jpeg", 0, 0);

    }

    @Override
    public void onMouseClick(MouseEvent e) {
        super.onMouseClick(e);
        //System.out.println("er is geklikt in de shop");
    }

    @Override
    public void setIsHovered(boolean isHovered) {

    }

    @Override
    public void drawOverlay(Graphics2D g2) {

    }

    public Customer getCurrentCustomer(){
        return currentCustomer;
    }

    public TextBox getChatBox() {
        return chatBox;
    }
}
