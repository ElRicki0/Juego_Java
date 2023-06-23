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
    private int [][]Coords;
    
    public Formas(int [][]Coords){
         this.Coords=Coords;
    }
    
    public void Actualizar(){
        if(Colicion){
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
