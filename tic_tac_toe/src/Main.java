import javax.swing.*;

public class Main {
    public static JFrame mainFrame;
    public static PlayingFieldPanel playingField;
    public static StartGamePanel startGamePanel;
    public static void main(String[] args) {
        mainFrame=new JFrame();
        playingField=new PlayingFieldPanel();
        startGamePanel=new StartGamePanel();
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(700, 500);
        mainFrame.setLocation(300,150);
        mainFrame.setContentPane(startGamePanel.getStartGamePanel());
        mainFrame.setVisible(true);


    }
}
