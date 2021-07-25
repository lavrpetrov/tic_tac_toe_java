package logic;

import gui.EndGamePanel;
import gui.PlayingFieldPanel;
import gui.StartGamePanel;

import javax.swing.*;

public class Main {
    public static JFrame mainFrame;
    public static PlayingFieldPanel playingField;
    public static StartGamePanel startGamePanel;
    public static EndGamePanel endGamePanel;
    public static void main(String[] args) {
        Control control=new Control();
        mainFrame=new JFrame();
        playingField=new PlayingFieldPanel(control);
        startGamePanel=new StartGamePanel();
        endGamePanel=new EndGamePanel();
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(700, 500);
        mainFrame.setLocation(300,150);
        mainFrame.setContentPane(startGamePanel.getStartGamePanel());
        mainFrame.setVisible(true);


    }
}
