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
    private Color [][] forma ={
        {Color.RED, Color.RED, Color.RED},
        {null, Color.RED, null}
        
    };
    
    private int x= 4, y=0;
    private int normal = 600;
    private int rapid= 50;
    private int TiempoDelayMovi = normal;
    private long InicTiempo;
    
    private int MovX=0;    
    private boolean Colicion=false;
    
    public Pantalla(){        
    ciclo = new Timer(Delay, new ActionListener() {
        int n = 0;
        @Override
        public void actionPerformed(ActionEvent arg0) {
            if(Colicion){
                return;
            }
            
            //Movimiento lateral (limites laterales)
            if(!(x+MovX+forma[0].length>10)&&!(x+MovX<0)){
            x+=MovX;}
            MovX=0;  
            if(System.currentTimeMillis()-InicTiempo>TiempoDelayMovi){
                if(!(y+1+forma.length>PantalaHeigth)){
                y++;}
            else{
                Colicion=true;
                }
                
                InicTiempo =System.currentTimeMillis();
            }
            
            repaint();
        }
    });          
       ciclo.start();
            
            }
            

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.black);
        g.fillRect(0, 0, getWidth(), getHeight());
        
        //dibujar formas
        for(int fil =0; fil<forma.length; fil++){
            for(int col=0; col<forma[0].length; col++){
                if(forma[fil][col]!=null){
                    g.setColor(forma[fil][col]);
                    g.fillRect(col*TamañoBloque+x*TamañoBloque, fil*TamañoBloque+y*TamañoBloque, TamañoBloque, TamañoBloque);
                }
                
            }
        }
        
        

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
            TiempoDelayMovi= rapid;
        }else if(e.getKeyCode()==KeyEvent.VK_RIGHT){
            MovX=1;
        }else if(e.getKeyCode()==KeyEvent.VK_LEFT){
            MovX=-1;
        }
    }
 
    @Override
    public void keyReleased(KeyEvent e ){
        if(e.getKeyCode()==KeyEvent.VK_DOWN){
            TiempoDelayMovi=normal;
        }
    }

    @Override
    public void keyTyped(KeyEvent arg0) {
        
    }

        
}
