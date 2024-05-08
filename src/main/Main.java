package main;

import javax.swing.*;

public class Main {
    static JFrame window;
    static GamePanel gamePanel;

    public static void main(String[] args){
        System.out.println("starten");

        window = createWindow();
        addGamePanel();

        gamePanel.startGameThread();

        System.out.println("klaar");
    }

    private static JFrame createWindow(){
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("alchemagica");
        window.setLocationRelativeTo(null);
        window.setVisible(true);

        return window;
    }

    private static void addGamePanel(){
        gamePanel = new GamePanel();
        window.add(gamePanel);
        window.pack();
    }
}
