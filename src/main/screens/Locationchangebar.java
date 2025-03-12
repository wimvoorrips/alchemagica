package main.screens;

import main.GamePanel;
import main.StaticImage.GameStateChangeButton;
import main.StaticImage.Patroon;
import main.StaticImage.StaticImage;

public class Locationchangebar extends Pane {
    public Locationchangebar(int x, int y, int width, int height) {

        super(x, y, width, height);
        //width = GamePanel.screenWidth;
        this.width = GamePanel.screenWidth;
        Patroon achterwand = new Patroon("sprites/plankenmuurgroot.png",x,y, GamePanel.screenWidth, height);
        addEntity(achterwand);

        addLocationButtons();
    }

    private void addLocationButtons(){
        GameStateChangeButton menuButton = new GameStateChangeButton("sprites/stopbuttongroot.png", 20,20, GamePanel.GameState.MENU);
        GameStateChangeButton shopButton = new GameStateChangeButton("sprites/shopbuttongroot.png", 120,20, GamePanel.GameState.SHOP);
        GameStateChangeButton gardenButton = new GameStateChangeButton("sprites/gardenbuttongroot.png", 220,20, GamePanel.GameState.GARDEN);

        addEntity(menuButton);
        addEntity(shopButton);
        addEntity(gardenButton);
    }
}
