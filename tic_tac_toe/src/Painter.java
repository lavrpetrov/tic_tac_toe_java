import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Painter extends JPanel {
    //координаты линий игрального поля
    private ArrayList<Lines> draw;
    private Integer w1;
    private Integer w2;
    private Integer w3;
    private Integer w4;
    private Integer h1;
    private Integer h2;
    private Integer h3;
    private Integer h4;
    private int length;
    private int counter=0;
    private Control control=new Control();
    public Painter(){
        draw=new ArrayList<>();
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                checkForClick(e);
            }
        });
    }
    //Проверяем, куда тыкнул пользователь
    private void checkForClick(MouseEvent e) {
        if (e.getX()>=w1&&e.getX()<=w2&&e.getY()>=h1&&e.getY()<=h2){
            //1 клеточка
            if (control.checkSquare(0,0,Control.player)){
                drawXOR0(w1,h1,Control.player);
            }
        }
        if (e.getX()>=w2&&e.getX()<=w3&&e.getY()>=h1&&e.getY()<=h2){
            //2 клеточка
            if (control.checkSquare(0,1,Control.player)){
                drawXOR0(w2,h1,Control.player);
            }

        }
        if (e.getX()>=w3&&e.getX()<=w4&&e.getY()>=h1&&e.getY()<=h2){
            //3 клеточка
            if (control.checkSquare(0,2,Control.player)){
                drawXOR0(w3,h1,Control.player);
            }
        }
        if (e.getX()>=w1&&e.getX()<=w2&&e.getY()>=h2&&e.getY()<=h3){
            //4 клеточка
            if (control.checkSquare(1,0,Control.player)){
                drawXOR0(w1,h2,Control.player);
            }
        }
        if (e.getX()>=w1&&e.getX()<=w2&&e.getY()>=h3&&e.getY()<=h4){
            //7 клеточка
            if (control.checkSquare(2,0,Control.player)){
                drawXOR0(w1,h3,Control.player);
            }
        }
        if (e.getX()>=w2&&e.getX()<=w3&&e.getY()>=h2&&e.getY()<=h3){
            //5 клеточка
            if (control.checkSquare(1,1,Control.player)){
                drawXOR0(w2,h2,Control.player);
            }
        }
        if (e.getX()>=w3&&e.getX()<=w4&&e.getY()>=h2&&e.getY()<=h3){
            //6 клеточка
            if (control.checkSquare(1,2,Control.player)){
                drawXOR0(w3,h2,Control.player);
            }
        }
        if (e.getX()>=w2&&e.getX()<=w3&&e.getY()>=h3&&e.getY()<=h4){
            //8 клеточка
            if (control.checkSquare(2,1,Control.player)){
                drawXOR0(w2,h3,Control.player);
            }
        }
        if (e.getX()>=w3&&e.getX()<=w4&&e.getY()>=h3&&e.getY()<=h4){
            //9 клеточка
            if (control.checkSquare(2,2,Control.player)){
                drawXOR0(w3,h3,Control.player);
            }
        }

    }
    private void drawXOR0(int x,int y,int xOr0){
        if (xOr0==1){
            //рисуем крестик
            draw.add(new Lines(x,y,x+length,y+length));
            draw.add(new Lines(x+length,y,x,y+length));
        }
        else{
            //рисуем нолик

        }
    }

    //Рисуем поле
    @Override
    public void paintComponent(Graphics g) {
        counter+=1;
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setFont(new Font("Arial", Font.PLAIN, 16));
        g2.setColor(Color.BLACK);
        if (counter==1){int x=this.getWidth();
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
            draw.add(new Lines(w1,h1,w1,h4));
            draw.add(new Lines(w2,h1,w2,h4));
            draw.add(new Lines(w3,h1,w3,h4));
            draw.add(new Lines(w4,h1,w4,h4));
            draw.add(new Lines(w1,h1,w4,h1));
            draw.add(new Lines(w1,h2,w4,h2));
            draw.add(new Lines(w1,h3,w4,h3));
            draw.add(new Lines(w1,h4,w4,h4));}
        for (Lines line: draw){
            g2.drawLine(line.getX1(),line.getY1(),line.getX2(),line.getY2());
        }

    }
}
