package gui;

import forms.Circle;
import forms.Lines;
import logic.Control;
import logic.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;


public class Painter extends JPanel {
    private ArrayList<Lines> drawLines;
    private ArrayList<Circle> drawCircles;
    //координаты линий игрального поля
    private Integer w1;
    private Integer w2;
    private Integer w3;
    private Integer w4;
    private Integer h1;
    private Integer h2;
    private Integer h3;
    private Integer h4;
    private int[] computerChoice;
    private boolean whoseTurn;
    private int length;
    private Control control;
    private PlayingFieldPanel playingFieldPanel;
    public Painter(Control control,PlayingFieldPanel playingFieldPanel){
        this.playingFieldPanel=playingFieldPanel;
        this.control=control;
        drawLines=new ArrayList<>();
        drawCircles=new ArrayList<>();
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                checkForClick(e);
            }
        });
    }
    public boolean getWhoseTurn(){
        return whoseTurn;
    }
    public void setWhoseTurn(boolean bool){
        whoseTurn=bool;
    }
    public void setWhoseTurn(){
        if (Control.player==1){
            whoseTurn=true;
        }else{
            whoseTurn=false;
        }
    }
    public boolean computersResponse(){
        boolean returnn=false;
        if (control.checkWinner(Control.player)){
            //выиграл пользователь
            returnn=true;
            playingFieldPanel.setPlay(false);
            Main.endGamePanel.setResult("Вы выиграли!!!");

        }else {
            if (control.emptyCell()){
                //ничья
                returnn=true;
                playingFieldPanel.setPlay(false);
                Main.endGamePanel.setResult("Ничья");
            }

        }
        this.repaint();
        try {
            Thread.sleep(500);
        } catch (InterruptedException ignored) {}
        if (returnn==false) {
            computerChoice = control.computerChoice();
            if (computerChoice[0] == -1 && computerChoice[0] == -1) {
                returnn = true;
                Main.endGamePanel.setResult("Ничья");
            } else {
                if (computerChoice[0] == 0 && computerChoice[1] == 0) {
                    drawXOR0(w1, h1, Control.computer);
                }
                if (computerChoice[0] == 0 && computerChoice[1] == 1) {
                    drawXOR0(w2, h1, Control.computer);
                }
                if (computerChoice[0] == 0 && computerChoice[1] == 2) {
                    drawXOR0(w3, h1, Control.computer);
                }
                if (computerChoice[0] == 1 && computerChoice[1] == 0) {
                    drawXOR0(w1, h2, Control.computer);
                }
                if (computerChoice[0] == 1 && computerChoice[1] == 1) {
                    drawXOR0(w2, h2, Control.computer);
                }
                if (computerChoice[0] == 1 && computerChoice[1] == 2) {
                    drawXOR0(w3, h2, Control.computer);
                }
                if (computerChoice[0] == 2 && computerChoice[1] == 0) {
                    drawXOR0(w1, h3, Control.computer);
                }
                if (computerChoice[0] == 2 && computerChoice[1] == 1) {
                    drawXOR0(w2, h3, Control.computer);
                }
                if (computerChoice[0] == 2 && computerChoice[1] == 2) {
                    drawXOR0(w3, h3, Control.computer);
                }
                this.repaint();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ignored) {}
                if (control.checkWinner(Control.computer)) {
                    //выиграл комп
                    returnn=true;
                    playingFieldPanel.setPlay(false);
                    Main.endGamePanel.setResult("Вы проиграли((( компьютер вас обыграл");

                }else{
                    if (control.emptyCell()){
                        //ничья
                        returnn=true;
                        playingFieldPanel.setPlay(false);
                        Main.endGamePanel.setResult("Ничья");
                    }
                }
            }
        }
        return returnn;
    }
    //Проверяем, куда тыкнул пользователь
    private void checkForClick(MouseEvent e) {
        if (whoseTurn==true){
            if (e.getX()>w1&&e.getX()<w2&&e.getY()>h1&&e.getY()<h2){
                //1 клеточка
                if (control.checkSquare(0,0, Control.player)){
                    drawXOR0(w1,h1, Control.player);
                    whoseTurn=false;
                }
            }
            if (e.getX()>w2&&e.getX()<w3&&e.getY()>h1&&e.getY()<h2){
                //2 клеточка
                if (control.checkSquare(0,1, Control.player)){
                    drawXOR0(w2,h1, Control.player);
                    whoseTurn=false;
                }

            }
            if (e.getX()>w3&&e.getX()<w4&&e.getY()>h1&&e.getY()<h2){
                //3 клеточка
                if (control.checkSquare(0,2, Control.player)){
                    drawXOR0(w3,h1, Control.player);
                    whoseTurn=false;
                }
            }
            if (e.getX()>w1&&e.getX()<w2&&e.getY()>h2&&e.getY()<h3){
                //4 клеточка
                if (control.checkSquare(1,0, Control.player)){
                    drawXOR0(w1,h2, Control.player);
                    whoseTurn=false;
                }
            }
            if (e.getX()>w1&&e.getX()<w2&&e.getY()>h3&&e.getY()<h4){
                //7 клеточка
                if (control.checkSquare(2,0, Control.player)){
                    drawXOR0(w1,h3, Control.player);
                    whoseTurn=false;
                }
            }
            if (e.getX()>w2&&e.getX()<w3&&e.getY()>h2&&e.getY()<h3){
                //5 клеточка
                if (control.checkSquare(1,1, Control.player)){
                    drawXOR0(w2,h2, Control.player);
                    whoseTurn=false;
                }
            }
            if (e.getX()>w3&&e.getX()<w4&&e.getY()>h2&&e.getY()<h3){
                //6 клеточка
                if (control.checkSquare(1,2, Control.player)){
                    drawXOR0(w3,h2, Control.player);
                    whoseTurn=false;
                }
            }
            if (e.getX()>w2&&e.getX()<w3&&e.getY()>h3&&e.getY()<h4){
                //8 клеточка
                if (control.checkSquare(2,1, Control.player)){
                    drawXOR0(w2,h3, Control.player);
                    whoseTurn=false;
                }
            }
            if (e.getX()>w3&&e.getX()<w4&&e.getY()>h3&&e.getY()<h4){
                //9 клеточка
                if (control.checkSquare(2,2, Control.player)){
                    drawXOR0(w3,h3, Control.player);
                    whoseTurn=false;
                }

            }



        }

    }
    private void drawXOR0(int x,int y,int xOr0){
        if (xOr0==1){
            //рисуем крестик
            drawLines.add(new Lines(x,y,x+length,y+length));
            drawLines.add(new Lines(x+length,y,x,y+length));
        }
        else{
            //рисуем нолик
            drawCircles.add(new Circle(x,y));
        }
    }

    //Рисуем поле
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setFont(new Font("Arial", Font.PLAIN, 16));
        g2.setColor(Color.BLACK);
        if (w1==null){
            int x=this.getWidth();
            length=x/10;
            int y=this.getHeight()/5;
            w1=x/10*4;
            w2=x/10*5;
            w3=x/10*6;
            w4=x/10*7;
            h1=y;
            h2=y+x/10;
            h3=y+2*x/10;
            h4=y+3*x/10;
            drawLines.add(new Lines(w1,h1,w1,h4));
            drawLines.add(new Lines(w2,h1,w2,h4));
            drawLines.add(new Lines(w3,h1,w3,h4));
            drawLines.add(new Lines(w4,h1,w4,h4));
            drawLines.add(new Lines(w1,h1,w4,h1));
            drawLines.add(new Lines(w1,h2,w4,h2));
            drawLines.add(new Lines(w1,h3,w4,h3));
            drawLines.add(new Lines(w1,h4,w4,h4));}
        for (Lines line: drawLines){
            g2.drawLine(line.getX1(),line.getY1(),line.getX2(),line.getY2());
        }
        for (Circle circle: drawCircles){
            g2.drawOval(circle.getX()+2,circle.getY()+2,length-4,length-4);
        }

    }
}
