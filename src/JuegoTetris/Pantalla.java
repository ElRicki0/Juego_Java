package JuegoTetris;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author rnmel
 */
public class Pantalla extends JPanel implements KeyListener, MouseListener, MouseMotionListener {
    public static int EstadoJuegoJugando= 0;
    public static int EstadoJuegoPausa= 1;
    public static int EstadoJuegoFinal= 2;
    
    private int Estado = EstadoJuegoJugando;

    private static final long identificadorSerialUID = 1L;
    
    private BufferedImage pausa, reiniciar; 
    
    private static int FPS=60;
    private static int Delay=FPS/1000;
    
    public static final int PantalaWidht=10;
    public static final int PantalaHeigth=20;
    public static final int TamañoBloque=30;
    private Timer ciclo;
    private Color [][] pantalla = new Color[PantalaHeigth][PantalaWidht];
    private Color[] colors = {Color.decode("#ed1c24"), Color.decode("#ff7f27"), Color.decode("#fff200"), 
        Color.decode("#22b14c"), Color.decode("#00a2e8"), Color.decode("#a349a4"), Color.decode("#3f48cc")};
    
    private Formas[] formas = new Formas[7];
    private static Formas FormaActual, SiguienteForma;
    private Random random;
    
    private Timer Lapso = new Timer(300, new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            Lapso.stop();
        }
    });

    
    private int mouseX, mouseY;
    private boolean leftClick = false;
    private Rectangle pararLim, actualizarLim;

    private boolean gamePaused = false;

    private boolean gameOver = false;
    
     private int score = 0;
     
    public Pantalla(){        
        random = new Random();
        
        pausa = Image.loadImage("/pause.png");
        reiniciar = Image.loadImage("/refresh.png");

        mouseX = 0;
        mouseY = 0;

        pararLim = new Rectangle(350, 500, pausa.getWidth(), pausa.getHeight() + pausa.getHeight() / 2);
        actualizarLim = new Rectangle(350, 500 - reiniciar.getHeight() - 20, reiniciar.getWidth(),
                reiniciar.getHeight() + reiniciar.getHeight() / 2);        
        
        formas[0] = new Formas(new int[][]{
            {1, 1, 1, 1} // Forma I 
        }, this, colors[0]);

        formas[1] = new Formas(new int[][]{
            {1, 1, 1},
            {0, 1, 0}, // forma T
        }, this, colors[1]);

        formas[2] = new Formas(new int[][]{
            {1, 1, 1},
            {1, 0, 0}, // Forma L 
        }, this, colors[2]);

        formas[3] = new Formas(new int[][]{
            {1, 1, 1},
            {0, 0, 1}, // Forma J 
        }, this, colors[3]);

        formas[4] = new Formas(new int[][]{
            {0, 1, 1},
            {1, 1, 0}, // Forma S
        }, this, colors[4]);

        formas[5] = new Formas(new int[][]{
            {1, 1, 0},
            {0, 1, 1}, // Forma Z
        }, this, colors[5]);

        formas[6] = new Formas(new int[][]{
            {1, 1},
            {1, 1}, // Forma O 
        }, this, colors[6]);
        
        FormaActual = formas[0];
        
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
          if (pararLim.contains(mouseX, mouseY) && leftClick && !Lapso.isRunning() && !gameOver) {
            Lapso.start();
            gamePaused = !gamePaused;
        }

        if (actualizarLim.contains(mouseX, mouseY) && leftClick) {
            startGame();
        }

        if (gamePaused || gameOver) {
            return;
        }
        if(Estado==EstadoJuegoJugando){
            FormaActual.Actualizar();
        }
            
    }
    
   
    public void SiguienteForma(){
        FormaActual = formas[random.nextInt(formas.length)];
        FormaActual.Reset();
        RevisarGmOv();
    }
    private void RevisarGmOv(){
        int[][]Coords= FormaActual.TenerCoords();
        for(int fila=0; fila<Coords.length;fila++){
            for(int col=0; col<Coords[0].length;col++){
            if(Coords[fila][col]!=0){
                if(pantalla[fila+FormaActual.SetY()][col+FormaActual.SetX()] !=null){
                    Estado=EstadoJuegoFinal;
                }
            }
        }
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.white);
        g.fillRect(0, 0, getWidth(), getHeight());
        
        FormaActual.Generar(g);

//dibujar cuadricula
       
        for(int fila=0; fila<pantalla.length;fila++){
                for(int col=0;col<pantalla[0].length;col ++){
                    if(pantalla[fila][col] != null){
                        g.setColor(pantalla[fila][col]);
                        g.fillRect(col*TamañoBloque, fila*TamañoBloque, TamañoBloque, TamañoBloque );
                    }
                    
                                        
                }
            }
        
        g.setColor(Color.lightGray);
        for(int fil = 0; fil<PantalaHeigth; fil++){
            
            g.drawLine(0, TamañoBloque *fil, TamañoBloque* PantalaWidht, TamañoBloque*fil);
        }
        for(int col =0; col<PantalaWidht+1;col++){
        g.drawLine(col*TamañoBloque, 0, col*TamañoBloque, TamañoBloque * PantalaHeigth);
        }
        if(Estado==EstadoJuegoFinal){            
        g.setColor(Color.RED);
        g.drawString("Fin Del Juego", 200, 200);
        }
        if(Estado==EstadoJuegoPausa){  
        g.setColor(Color.black);
        g.drawString("Juego Pausado", 200, 200);
        }
    }
    
    public Color[][]getPantalla(){
        return pantalla;
    }
    
    @Override
    public void keyPressed(KeyEvent e ){
        if(e.getKeyCode()==KeyEvent.VK_DOWN){
            FormaActual.Rapido(); 
        }
        if(e.getKeyCode()==KeyEvent.VK_RIGHT){
            FormaActual.MovDerecha();
        }
        if(e.getKeyCode()==KeyEvent.VK_LEFT){
            FormaActual.MovIzquierda();
        }
        if(e.getKeyCode()==KeyEvent.VK_UP){
            FormaActual.Rotar();
        }
                 
        
        
        if (Estado==EstadoJuegoFinal                ){
            if(e.getKeyCode()==KeyEvent.VK_SPACE){
                for(int fila=0; fila<pantalla.length;fila++){
                    for(int col=0;col<pantalla[fila].length;col ++){
                        pantalla[fila][col]=null;
                                        
                }
            }
                SiguienteForma();
                Estado=EstadoJuegoJugando;
            }
        }
        if(e.getKeyCode()==KeyEvent.VK_ESCAPE){
           if(Estado==EstadoJuegoJugando){
            Estado=EstadoJuegoPausa;
            }else if(Estado==EstadoJuegoPausa){
                Estado=EstadoJuegoJugando;  
            }                
        }
    }
 
   
    @Override
    public void keyReleased(KeyEvent e ){
        if(e.getKeyCode()==KeyEvent.VK_DOWN){
            FormaActual.Normal();
        }
    }

    @Override
    public void keyTyped(KeyEvent arg0) {
        
    }
    
       public void startGame() {
        stopGame();
        SiguienteForma();
        RevisarGmOv();
        gameOver = false;
        ciclo.start();

    }

    public  void stopGame() {
        score = 0;

        for (int row = 0; row < pantalla.length; row++) {
            for (int col = 0; col < pantalla[row].length; col++) {
                pantalla[row][col] = null;
            }
        }
        ciclo.stop();
    }
    
        class GameLooper implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Actualizar();
            repaint();
        }

    }

     @Override
    public void mouseDragged(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            leftClick = true;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            leftClick = false;
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

        public void addScore() {
        score++;
    }        
}
