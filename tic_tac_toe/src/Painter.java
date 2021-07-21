import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Painter extends JPanel {
    //координаты линий игрального поля
    private Integer w1=Main.mainFrame.getWidth()/10*4;
    private Integer w2=Main.mainFrame.getWidth()/10*5;
    private Integer w3=Main.mainFrame.getWidth()/10*6;
    private Integer w4=Main.mainFrame.getWidth()/10*7;
    private Integer h1=Main.mainFrame.getWidth()/10+115;
    private Integer h2=2*Main.mainFrame.getWidth()/10+115;
    private Integer h3=3*Main.mainFrame.getWidth()/10+115;
    private Integer h4=4*Main.mainFrame.getWidth()/10+115;
    public Painter(){
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                checkForClick(e);
            }
        });

    }
    //Проверяем, куда тыкнул пользователь
    private void checkForClick(MouseEvent e) {


    }
    //Рисуем поле
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.drawLine(w1,h1,w1,h4);
        g2.drawLine(w2,h1,w2,h4);
        g2.drawLine(w3,h1,w3,h4);
        g2.drawLine(w4,h1,w4,h4);
        g2.drawLine(w1,h1,w4,h1);
        g2.drawLine(w1,h2,w4,h2);
        g2.drawLine(w1,h3,w4,h3);
        g2.drawLine(w1,h4,w4,h4);




    }
}
