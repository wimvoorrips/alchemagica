package main.screens;

import main.GamePanel;
import main.StaticImage.ScreenChangeButton;
import main.StaticImage.StaticImage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

public class MenuScreen extends Screen {
    public MenuScreen(){
        System.out.println("menuScreen is aangemaakt");

        addEntities();
    }

    private void addEntities(){
        //StaticImage startKnop = new StaticImage("sprites/startknopgroot.png", 0, 0);
        ScreenChangeButton startKnop = new ScreenChangeButton("sprites/startknopgroot.png", 0, 0, GamePanel.GameState.SHOP);
        int startKnopX = (GamePanel.screenWidth / 2) - (startKnop.getWidth() / 2);
        int startKnopY = GamePanel.screenHeight - (startKnop.getHeight() + 10);
        startKnop.setX(startKnopX);
        startKnop.setY(startKnopY);
        this.drawables.add(startKnop);
        this.clickables.add(startKnop);
    }

    @Override
    public void onMouseClick(MouseEvent e) {
        super.onMouseClick(e);
        System.out.println("er is geklikt in het menu");

        //GamePanel.setGameState(GamePanel.GameState.SHOP);
    }
}
