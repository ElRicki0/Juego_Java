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
                CompletarLn();
                pantalla.SiguienteForma();  
                        
                return;
            }
            
            //Movimiento lateral (limites laterales)
            boolean movX = true;
            if(!(x+MovX+Coords[0].length>10)&&!(x+MovX<0)){
            
            for(int fil=0;fil<Coords.length; fil++){
                for(int col=0;col<Coords[fil].length; col++){
                    if(Coords[fil][col]!=0  ){
                        if (pantalla.getPantalla()[y+fil][x+MovX+col]!=null) {                        
                        movX=false;
                        }
                      
                    }
                }
            }
            if(movX){
                x+=MovX;                
            }
       }
            
            MovX=0;  
            
            if(System.currentTimeMillis()-InicTiempo>TiempoDelayMovi) {
                
                if(!(y+1+Coords.length>PantalaHeigth)){
                    for (int Fil= 0;Fil<Coords.length;Fil++){
                        for(int Col=0; Col<Coords[Fil]. length;Col++){
                            if(Coords[Fil][Col]!=0){
                                if(pantalla.getPantalla()[y+1+Fil][x+MovX+Col]!=null){
                                    Colicion=true;
                                }
                            }
                        }
                    }if(!Colicion){
                        y++;
                    }
                }
            else{
                Colicion=true;
                }
                
                InicTiempo =System.currentTimeMillis();
            }
    }
    public void CompletarLn(){
        int FinalLn = pantalla.getPantalla().length-1;
        for(int InicioLn= pantalla.getPantalla().length-1;InicioLn>0;InicioLn--){
            int Contador = 0;
            for(int col =0 ;col<pantalla.getPantalla()[0].length;col++){
                if(pantalla.getPantalla()[InicioLn][col]!=null){
                    Contador++;
                }
                pantalla.getPantalla()[FinalLn][col]=pantalla.getPantalla()[InicioLn][col];
            }
            if(Contador<pantalla.getPantalla()[0].length){
                FinalLn--;
            }
        }
    }
    
    public void Rotar(){
        int[][]Rotar=CambiarMX(Coords);
        FilaInversa(Rotar);
        
        //verificacion de rotacion con borde
        if((x+Rotar[0].length>Pantalla.PantalaWidht)||(y+Rotar.length>20)){
            return;
        }
        for(int fila=0;fila<Rotar.length;fila++){
            for(int col=0;col<Rotar[fila].length;col++){
                if(Rotar[fila][col]!=0){
                    if(pantalla.getPantalla()[y+fila][x+col]!=null){
                        return;
                    }
                }
            }
        }
        Coords = Rotar;
    }
    
    public int [][] CambiarMX(int [][]Matriz){
        int [][] Modelo = new int [Matriz[0].length][Matriz.length];
        for(int fila=0;fila<Matriz.length;fila++){
            for(int col=0;col<Matriz[0].length;col++){
                Modelo[col][fila]=Matriz[fila][col];
            }
        }
        return Modelo;
    }
    
    public void FilaInversa(int [][]matriz){
        int mitad = matriz.length/2;
        for(int fila=0; fila<(mitad);fila++){
            int[] Modelo =matriz[fila];
            matriz[fila]=matriz[matriz.length-fila-1];
            matriz[matriz.length-fila-1]=Modelo;
        }
    }    
    public void Generar(Graphics g){
        //dibujar formas
        for(int fil =0; fil<Coords.length; fil++){
            for(int col=0; col<Coords[0].length; col++){
                if(Coords[fil][col]!=0){
                    g.setColor(color);
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
