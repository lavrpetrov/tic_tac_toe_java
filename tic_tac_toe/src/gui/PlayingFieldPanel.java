package gui;

import gui.Painter;
import logic.Control;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
//1-крестики  0-нолики
public class PlayingFieldPanel extends JPanel {
    private gui.Painter painter;
    private Thread thread;
    private JPanel playingField;
    private JLabel name;
    private JLabel text;
    private Control control;
    public PlayingFieldPanel(Control control){
        this.control=control;
        initComponents();
    }

    public void startThread() {
        thread=new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    System.out.println(painter.getWhoseTurn());
                    painter.repaint();

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ignored) {}

                    if (painter.getWhoseTurn()==false){
                        painter.setWhoseTurn(true);
                        System.out.println("Ход компьютера-PFP33");
                        painter.computersResponse();
                        System.out.println("Ход компьютера завершен-PFP36");

                    }

                }

            }
        }
        );

        thread.start();

    }
    private void initComponents() {
        playingField=new JPanel();
        painter=new Painter(control);
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

        //---- painter ----
        painter.setBackground(new Color(148, 204, 227));
        painter.setLayout(null);
        playingField.add(painter, "cell 1 2 3 6");




    }
    public JPanel getPlayingField(){
        painter.setWhoseTurn();
        return playingField;

    }

}
