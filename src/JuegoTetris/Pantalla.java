package JuegoTetris;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author rnmel
 */
public class Pantalla extends JPanel implements KeyListener{
    
    private static int FPS=60;
    private static int Delay=FPS/1000;
    
    public static final int PantalaWidht=10;
    public static final int PantalaHeigth=20;
    public static final int TamañoBloque=30;
    private Timer ciclo;
    private Color [][] pantalla = new Color[PantalaWidht][PantalaHeigth];
    
    private int [][] forma1 ={
        {1, 1, 1},
        {0, 1, 0}
        
    };
    
    private Formas formas= new Formas(forma1);
    
    public Pantalla(){        
    ciclo = new Timer(Delay, new ActionListener() {
        int n = 0;
        @Override
        public void actionPerformed(ActionEvent arg0) {
            Actualizar();
            repaint();
        }
    });          
       ciclo.start();
            
            }
    private void Actualizar(){
        formas.Actualizar();
    }
            

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.black);
        g.fillRect(0, 0, getWidth(), getHeight());
        
        formas.Generar(g);

//dibujar cuadricula
       
        g.setColor(Color.white);
        for(int fil = 0; fil<PantalaHeigth; fil++){
            
            g.drawLine(0, TamañoBloque *fil, TamañoBloque* PantalaWidht, TamañoBloque*fil);
        }
        for(int col =0; col<PantalaWidht+1;col++){
        g.drawLine(col*TamañoBloque, 0, col*TamañoBloque, TamañoBloque * PantalaHeigth);
        }
               
    }
    
    
    @Override
    public void keyPressed(KeyEvent e ){
        if(e.getKeyCode()==KeyEvent.VK_DOWN){
            formas.Rapido(); 
        }else if(e.getKeyCode()==KeyEvent.VK_RIGHT){
            formas.MovDerecha();
        }else if(e.getKeyCode()==KeyEvent.VK_LEFT){
            formas.MovIzquierda();
        }
    }
 
    @Override
    public void keyReleased(KeyEvent e ){
        if(e.getKeyCode()==KeyEvent.VK_DOWN){
            formas.Normal();
        }
    }

    @Override
    public void keyTyped(KeyEvent arg0) {
        
    }

        
}
