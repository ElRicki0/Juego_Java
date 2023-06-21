package JuegoTetris;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author rnmel
 */
public class Pantalla extends JPanel{
    
    private Timer ciclo;
    
    public Pantalla(){
        
    ciclo = new Timer(500, new ActionListener() {
        int n = 0;
        @Override
        public void actionPerformed(ActionEvent arg0) {
            System.out.println(n++);
        }
    });          
       ciclo.start();
            
            }
            

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawRect(10, 10, 200, 200);
        
    }
        
}
