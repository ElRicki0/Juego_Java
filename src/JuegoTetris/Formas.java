package JuegoTetris;

import static JuegoTetris.Pantalla.PantalaHeigth;
import static JuegoTetris.Pantalla.TamañoBloque;
import java.awt.Color;
import java.awt.Graphics;

public class Formas {
    private int x= 4, y=0;
    private int normal = 600;
    private int rapid= 50;
    private int TiempoDelayMovi = normal;
    private long InicTiempo;
    
    private int MovX=0;    
    private boolean Colicion=false; 
    
    private int [][] Coords;
    private Pantalla pantalla;
    private Color color;
    
    public Formas(int [][]Coords, Pantalla pantalla, Color color){
         this.Coords=Coords;
         this.pantalla=pantalla;
         this.color=color;
    }
    
    public void SetX(int x){
        this.x = x;
    }    
    public void Sety(int y){
        this.y = y;
    }
    public void Reset(){
        this.x=4;
        this.y=0;
        Colicion=false;
    }
    
    public void Actualizar(){
        if(Colicion){
            //llegan los colores de la pantalla 
            for(int fila=0; fila<Coords.length;fila++){
                for(int col=0;col<Coords[0].length;col ++){
                    if(Coords[fila][col] != 0){
                        pantalla.getPantalla()[y+fila][x+col]=color;
                    }
                    
                                        
                }
            }
                pantalla.SiguienteForma();  
                        
                return;
            }
            
            //Movimiento lateral (limites laterales)
            if(!(x+MovX+Coords[0].length>10)&&!(x+MovX<0)){
            x+=MovX;}
            MovX=0;  
            if(System.currentTimeMillis()-InicTiempo>TiempoDelayMovi){
                if(!(y+1+Coords.length>PantalaHeigth)){
                y++;}
            else{
                Colicion=true;
                }
                
                InicTiempo =System.currentTimeMillis();
            }
    }
    public void Generar(Graphics g){
        //dibujar formas
        for(int fil =0; fil<Coords.length; fil++){
            for(int col=0; col<Coords[0].length; col++){
                if(Coords[fil][col]!=0){
                    g.setColor(Color.red);
                    g.fillRect(col*TamañoBloque+x*TamañoBloque, fil*TamañoBloque+y*TamañoBloque, TamañoBloque, TamañoBloque);
                }
                
            }
        }
    }
    
    public void Rapido(){
        TiempoDelayMovi= rapid;
    }
    public void Normal(){
        TiempoDelayMovi=normal;
    }
    public void MovDerecha(){
        MovX=1;
    }
    public void MovIzquierda(){
    MovX=-1;
    }
}
