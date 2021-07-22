import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartGamePanel extends JPanel {
    private JPanel startGamePanel;
    private JLabel name;
    private JLabel text;
    private JLabel text2;
    private JComboBox<String> chooseXor0;
    private JButton startButton;
    public StartGamePanel(){
        initComponents();
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ((chooseXor0.getItemAt(chooseXor0.getSelectedIndex())).equals("Крестики")){
                    Control.player=1;
                    Control.computer=0;
                }
                else{
                    Control.player=0;
                    Control.computer=1;
                }
                Main.mainFrame.setContentPane(Main.playingField.getPlayingField());
                Main.mainFrame.validate();
                Main.playingField.startThread();
            }
        });

    }
    private void initComponents() {
        name = new JLabel();
        text =new JLabel();
        text2 =new JLabel();
        startGamePanel=new JPanel();
        chooseXor0=new JComboBox<>();
        startButton=new JButton();

        startGamePanel.setBackground(new Color(148, 204, 227));
        startGamePanel.setLayout(new MigLayout(
                "insets 0,hidemode 3",
                // columns
                "[fill]" +
                        "[fill]" +
                        "[fill]" +
                        "[fill]" +
                        "[fill]" +
                        "[fill]" +
                        "[fill]" ,
                // rows
                "[150,grow,fill]" +
                        "[]" +
                        "[48]" +
                        "[]" +
                        "[]" +
                        "[150,grow,fill]" +
                        "[]" +
                        "[]" +
                        "[]"));

        //---- name ----
        name.setText("TIC TAC TOE");
        name.setHorizontalAlignment(SwingConstants.CENTER);
        name.setFont(new Font("Arial",Font.BOLD, 25));
        name.setBackground(new Color(194, 103, 160));
        name.setForeground(new Color(194, 103, 160));
        startGamePanel.add(name, "cell 4 0 2 1,align center center,grow 0 0");
        //---- text ----
        text.setText("Вы хотите играть крестиками или но ликами?");
        text.setHorizontalAlignment(SwingConstants.CENTER);
        text.setFont(new Font("Arial",Font.BOLD, 18));
        text.setBackground(new Color(194, 103, 160));
        text.setForeground(new Color(194, 103, 160));
        startGamePanel.add(text, "cell 4 2 2 1,align center center,grow 0 0");
        //---- text2 ----
        text2.setText("(пссс...Начинают крестики)");
        text2.setHorizontalAlignment(SwingConstants.CENTER);
        text2.setFont(new Font("Arial",Font.BOLD, 10));
        text2.setBackground(new Color(194, 103, 160));
        text2.setForeground(new Color(194, 103, 160));
        startGamePanel.add(text2, "cell 4 3 2 1,align center center,grow 0 0");
        //---- chooseXor0 ----
        chooseXor0.setModel(new DefaultComboBoxModel<>(new String[] {
                "Крестики",
                "Нолики",
        }));
        chooseXor0.setBackground(new Color(207, 176, 193));
        chooseXor0.setForeground(new Color(40, 61, 82));
        chooseXor0.setFont(new Font("Arial", Font.PLAIN, 18));
        //chooseXor0.setBorder(new RoundedBorder(10,new Color(161, 35, 106)));
        startGamePanel.add(chooseXor0, "cell 4 5,align center center,grow 0 0,width 100:150:250,height 30:35:45");
        //---- startButton ----
        startButton.setText("Начать игру");
        startButton.setFont(new Font("Arial", Font.PLAIN, 18));
        startButton.setBackground(new Color(196, 116, 161));
        startButton.setForeground(new Color(40, 61, 82));
        //startButton.setBorder(new RoundedBorder(10,new Color(161, 35, 106)));
        startGamePanel.add(startButton, "cell 5 5,align center center,grow 0 0,width 100:150:250,height 30:35:45");


    }
    public JPanel getStartGamePanel(){
        return startGamePanel;

    }
}
