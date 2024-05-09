package main;

import main.screens.MenuScreen;
import main.screens.Screen;
import main.screens.ShopScreen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GamePanel extends JPanel implements Runnable {

    public static enum GameState {
        MENU, SHOP
    }
    private static GameState gameState = GameState.MENU;
    ShopScreen shopScreen;
    MenuScreen menuScreen;

    final public static int screenWidth = 1200;//maxScreenColumns * tileSize;
    final public static int screenHeight = 800;//maxScreenRows * tileSize;

    //fps
    int FPS = 60;

    Thread gameThread;

    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.setFocusable(true);

        addScreens();
        addListeners();

    }

    private void addListeners(){
        addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent e){
                mousePressExecution(e);
            }
        });

        addMouseMotionListener(new MouseAdapter() {
            public void mouseMoved(MouseEvent e){
                mouseMoveExecution(e);
            }
        });
    }

    private void mousePressExecution(MouseEvent e){
        Screen activeScreen = getActiveScreen();
        activeScreen.onMouseClick(e);
    }

    private void mouseMoveExecution(MouseEvent e){
        Screen activeScreen = getActiveScreen();
        activeScreen.onMouseMove(e);
    }

    private Screen getActiveScreen(){
        switch(gameState){
            case GameState.MENU:
                return menuScreen;
            case GameState.SHOP:
                return shopScreen;
        }
        return null;
    }

    private void addScreens(){
        shopScreen = new ShopScreen();
        menuScreen = new MenuScreen();
    }

    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    /**
     * Runs this operation.
     */
    @Override
    public void run() {
        double drawInterval = 1000000000/FPS;
        double nextDrawTime = System.nanoTime() + drawInterval;
        while(gameThread != null){
            long currentTime = System.nanoTime();


            //long currentTime2 = System.currentTimeMillis();
            //update information like character positions
            update();
            //draw the screen with updated information
            repaint(); //makes java call paintComponent


            //System.out.println("the game loop is running");
            try {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime / 1000000;

                if(remainingTime < 0){
                    remainingTime = 0;
                }
                Thread.sleep((long)remainingTime);

                nextDrawTime += drawInterval;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public void update(){
        Screen activeScreen = getActiveScreen();
        activeScreen.update();
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;
        Screen activeScreen = getActiveScreen();
        activeScreen.draw(g2);
    }

    public static void setGameState(GameState state){
        gameState = state;
    }


}
