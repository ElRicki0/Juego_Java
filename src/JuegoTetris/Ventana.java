 package JuegoTetris;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.awt.Graphics;
import javax.swing.JFrame;

public class Ventana {

    public static final int WIDTH = 317, HEIGHT = 640;

    private Pantalla pantalla;

    private JFrame ventana;

    public Ventana() {
        JFrame ventana = new JFrame("Hardcore Tetris");
        ventana.setSize(WIDTH, HEIGHT);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setResizable(false);
        ventana.setLocationRelativeTo(null);

        pantalla = new Pantalla();
        
        ventana.add(pantalla);
       
       ventana.addKeyListener(pantalla);
           
        ventana.setVisible(true);

        reproducirMusica("/Musica/Tetris.wav"); 
    }
    
    public static void main(String[] args) {
        new Ventana();
        
    }

    public void reproducirMusica(String archivo) {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(getClass().getResourceAsStream(archivo));
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
