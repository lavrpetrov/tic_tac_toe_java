package logic;

import gui.EndGamePanel;
import gui.PlayingFieldPanel;
import gui.StartGamePanel;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

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
    public static void start(){
        Control control=new Control();
        playingField=new PlayingFieldPanel(control);
    }
}
