package main.StaticImage;

import main.GamePanel;

import java.awt.event.MouseEvent;

public class ScreenChangeButton extends ImageButton {

    GamePanel.GameState gameState;
    public ScreenChangeButton(String imageString, int x, int y, GamePanel.GameState gameState) {
        super(imageString, x, y);
        this.gameState = gameState;
    }
    @Override
    public void onMouseClick(MouseEvent e) {
        System.out.println("er is op een knop geklikt");
        GamePanel.setGameState(gameState);
    }
}
