package main.screens;

import main.GamePanel;
import main.StaticImage.Patroon;
import main.StaticImage.StaticImage;
import main.interfaces.GameEntity;
import main.items.Cauldron;
import main.items.ItemContainer;
import main.screens.screencomponents.Locationchangebar;
import main.screens.screencomponents.TextBox;
import main.witch.Customer;
import main.witch.Witch;

import java.awt.*;

public class ShopScreen extends Screen {

    private Customer currentCustomer;
    private TextBox chatBox;
    public ShopScreen(Witch witch){
        super();
        addEntities(witch);
    }

    private void addEntities(Witch witch){
        Patroon achterwand = new Patroon("sprites/plankenmuurgroot.png",0,0, GamePanel.screenWidth, 800);// GamePanel.screenHeight);
        drawables.add(achterwand);

        addEntity((GameEntity) witch);

        Locationchangebar locationchangebar = new Locationchangebar(0,0, this.width, 100);
        addEntity(locationchangebar);

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
