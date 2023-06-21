package JuegoTetris;

import java.awt.Graphics;
import javax.swing.JFrame;

public class Ventana {
    
    public static final int WIDTH =445, HEIGHT = 629;  
    
    private Pantalla pantalla;
    private JFrame ventana;
            
    public Ventana(){
        JFrame ventana = new JFrame("Tetris RN");
        ventana.setSize(WIDTH, HEIGHT);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setResizable(false);
        ventana.setLocationRelativeTo(null);
        
        pantalla = new Pantalla();
        ventana.add(pantalla);
        ventana.setVisible(true);
    }        
    
    public static void main(String[] args) {
        new  Ventana();
}
}
