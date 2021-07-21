import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
//1-крестики  0-нолики
public class PlayingFieldPanel extends JPanel {
    private Integer player=1;
    private Integer computer=0;
    private JPanel playingField;
    private JLabel name;
    private JLabel text;
    public PlayingFieldPanel(){
        initComponents();
    }
    public void setPlayer(Integer ticOrToe){
        player=ticOrToe;
        computer=Math.abs(ticOrToe-1);

    }
    private void initComponents() {
        playingField=new JPanel();
        name = new JLabel();
        text =new JLabel();
        playingField.setBackground(new Color(148, 204, 227));
        playingField.setLayout(new MigLayout(
                "insets 0,hidemode 3",
                // columns
                "[60,grow,fill]" +
                        "[60,grow,fill]" +
                        "[grow,fill]" +
                        "[60,grow,fill]" +
                        "[60,grow,fill]",
                // rows
                "[80,grow,fill]" +
                        "[35,grow,fill]" +
                        "[35,grow,fill]" +
                        "[35,grow,fill]" +
                        "[35,grow,fill]" +
                        "[35,fill]" +
                        "[35,grow,fill]" +
                        "[35,grow,fill]" +
                        "[50,grow,fill]"));
        //---- name ----
        name.setText("TIC TAC TOE");
        name.setHorizontalAlignment(SwingConstants.CENTER);
        name.setFont(new Font("Arial",Font.PLAIN, 50));
        name.setBackground(new Color(255, 102, 102));
        name.setForeground(new Color(194, 103, 160));
        playingField.add(name, "cell 3 0,align center center,grow 0 0");
        //---- text ----
        text.setText("Чтобы сделать ход, нажмите на пустую клетку");
        text.setHorizontalAlignment(SwingConstants.CENTER);
        text.setFont(new Font("Arial",Font.BOLD, 18));
        text.setBackground(new Color(194, 103, 160));
        text.setForeground(new Color(194, 103, 160));
        playingField.add(text, "cell 3 1,align center center,grow 0 0");


    }
    public JPanel getPlayingField(){
        return playingField;
    }

}
