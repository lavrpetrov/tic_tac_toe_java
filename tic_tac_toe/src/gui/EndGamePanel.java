package gui;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

public class EndGamePanel extends JPanel {
    private JPanel endGamePanel;
    private JLabel name;
    private JLabel result;
    private JLabel question;
    private JButton yesButton;
    private JButton noButton;

    public EndGamePanel(){
        initComponents();

    }
    public void setResult(String result){
        this.result.setText(result);
    }

    private void initComponents(){
        endGamePanel=new JPanel();
        name = new JLabel();
        result = new JLabel();
        question = new JLabel();
        yesButton=new JButton();
        noButton=new JButton();
        endGamePanel.setBackground(new Color(148, 204, 227));
        endGamePanel.setLayout(new MigLayout(
                "insets 0,hidemode 3",
                // columns
                "[fill]" +
                        "[fill]" +
                        "[fill]" +
                        "[fill]" +
                        "[grow,fill]" +
                        "[fill]" +
                        "[fill]" +
                        "[fill]" +
                        "[fill]",
                // rows
                "[214,grow,fill]" +
                        "[]" +
                        "[48]" +
                        "[]" +
                        "[]" +
                        "[214,grow,fill]" +
                        "[]" +
                        "[]"

        ));

        //---- name ----
        name.setText("TIC TAC TOE");
        name.setHorizontalAlignment(SwingConstants.CENTER);
        name.setFont(new Font("Arial",Font.BOLD, 70));
        name.setBackground(new Color(194, 103, 160));
        name.setForeground(new Color(194, 103, 160));
        endGamePanel.add(name, "cell 4 0,align center center,grow 0 0");

        //---- result ----
        result.setText("Здесь будет результат игры");
        result.setHorizontalAlignment(SwingConstants.CENTER);
        result.setFont(new Font("Arial",Font.BOLD, 20));
        result.setBackground(new Color(194, 103, 160));
        result.setForeground(new Color(194, 103, 160));
        endGamePanel.add(result, "cell 4 1,align center center,grow 0 0");

        //---- question ----
        question.setText("Хотите сыграть еще раз?");
        question.setHorizontalAlignment(SwingConstants.CENTER);
        question.setFont(new Font("Arial",Font.BOLD, 20));
        question.setBackground(new Color(194, 103, 160));
        question.setForeground(new Color(194, 103, 160));
        endGamePanel.add(question, "cell 4 2,align center center,grow 0 0");
        //---- yesButton ----
        yesButton.setText("Да");
        yesButton.setFont(new Font("Arial", Font.PLAIN, 20));
        yesButton.setBackground(new Color(148, 201, 242));
        yesButton.setForeground(new Color(40, 61, 82));
        endGamePanel.add(yesButton, "cell 5 5,align center center,grow 0 0,width 100:150:250,height 30:35:45");

        //---- noButton ----
        noButton.setText("Нет");
        noButton.setFont(new Font("Arial", Font.PLAIN, 20));
        noButton.setBackground(new Color(148, 201, 242));
        noButton.setForeground(new Color(40, 61, 82));
        //endGamePanel.add(noButton, "cell 4 5,align center center,grow 0 0,width 100:150:250,height 30:35:45");


    }
    public JPanel getEndGamePanel(){
        return endGamePanel;
    }
}
