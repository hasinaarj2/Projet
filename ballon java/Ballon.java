package ballon;

import java.awt.*;
import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;

public class Ballon extends JPanel{
    
    int x = 200,y = 300;
    int width = 50,height = 50;
    int dx = 1,dy = 1;
    
    static JFrame frame;
    
    Ballon(){
    
        frame = new JFrame();
        frame.setSize(600,400);
        frame.setVisible(true);
    
     setForeground(Color.red);
    
        Timer timer = new Timer();
        TimerTask tache = new TimerTask(){
            @Override
            public void run(){

                if(x < 0)
                    dx = 1;
                if(x >= getWidth()-45)
                    dx = -1;
                if(y < 0)
                    dy = 1;
                if(y >= getHeight()-45)
                    dy = -1;
                x += dx;
                y += dy;

                repaint();

            }
        };
        timer.scheduleAtFixedRate(tache, 1,4);
       
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
    };
    
    public void paint(Graphics g){
        
        super.paint(g);
       
        g.fillOval(x, y, width, height);
    
    }
    
    public static void main(String[] args) {
        
        Ballon ball = new Ballon();
        
        frame.add(ball);
        
    }
    
}
