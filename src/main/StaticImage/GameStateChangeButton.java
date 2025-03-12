package main.StaticImage;

import main.GamePanel;
import main.interfaces.Clickable;

import java.awt.event.MouseEvent;

public class GameStateChangeButton extends ImageButton {

    private final GamePanel.GameState gameState;
    public GameStateChangeButton(String imageString, int x, int y, GamePanel.GameState gameState) {
        super(imageString, x, y);
        this.gameState = gameState;
    }
    @Override
    public void onMouseClick(MouseEvent e) {
        System.out.println("er is op een knop geklikt");
        changeGameState();
    }

    private void changeGameState(){
        GamePanel.setGameState(gameState);
    }
}
