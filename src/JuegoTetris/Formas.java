package JuegoTetris;

import static JuegoTetris.Pantalla.PantalaHeigth;
import static JuegoTetris.Pantalla.TamañoBloque;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class Formas {
        
    // Posición x e y de la forma en el tablero
private int x = 4, y = 0;

// Valor de retardo normal para el movimiento descendente de la forma
private int normal = 300;

// Valor de retardo rápido para el movimiento descendente de la forma
private int rapid = 50;

// Tiempo de retardo actual para el movimiento descendente de la forma
private int TiempoDelayMovi = normal;

// Tiempo de inicio para el control del retardo del movimiento descendente
private long InicTiempo;

// Valor de movimiento en el eje x de la forma
private int MovX = 0;

// Indicador de colisión de la forma con otras piezas o límites del tablero
private boolean Colicion = false;

// Coordenadas de la forma en el tablero
private int[][] Coords;

// Referencia a la pantalla del juego
private Pantalla pantalla;

// Color de la forma
private Color color;

// Constructor de la clase Formas
public Formas(int[][] Coords, Pantalla pantalla, Color color) {
    this.Coords = Coords;
    this.pantalla = pantalla;
    this.color = color;
}

// Devuelve la posición x de la forma
public int SetX() {
    return x;
}

// Devuelve la posición y de la forma
public int SetY() {
    return y;
}

// Restablece la posición inicial de la forma y la colisión a falso
public void Reset() {
    this.x = 4;
    this.y = 0;
    Colicion = false;
}

   public void Actualizar() {
    if (Colicion) {
        // Se llegó a una colisión, se colocan los colores en la pantalla
        for (int fila = 0; fila < Coords.length; fila++) {
            for (int col = 0; col < Coords[0].length; col++) {
                if (Coords[fila][col] != 0) {
                    pantalla.getPantalla()[y + fila][x + col] = color;
                }
            }
        }

        // Se completa una línea si es necesario
        CompletarLn();

        // Se pasa a la siguiente forma en el juego
        pantalla.SiguienteForma();

        // Se termina la ejecución del método
        return;
    }

    // Movimiento lateral (límites laterales)
    boolean movX = true;
    if (!(x + MovX + Coords[0].length > 10) && !(x + MovX < 0)) {
        // Comprobación de colisión en el movimiento lateral
        for (int fil = 0; fil < Coords.length; fil++) {
            for (int col = 0; col < Coords[fil].length; col++) {
                if (Coords[fil][col] != 0) {
                    if (pantalla.getPantalla()[y + fil][x + MovX + col] != null) {
                        movX = false;
                    }
                }
            }
        }

        // Si no hay colisión, se actualiza la posición x
        if (movX) {
            x += MovX;
        }
    }

    MovX = 0;

    // Control del retardo del movimiento descendente
    if (System.currentTimeMillis() - InicTiempo > TiempoDelayMovi) {
        // Comprobación de colisión en el movimiento descendente
        if (!(y + 1 + Coords.length > PantalaHeigth)) {
            for (int Fil = 0; Fil < Coords.length; Fil++) {
                for (int Col = 0; Col < Coords[Fil].length; Col++) {
                    if (Coords[Fil][Col] != 0) {
                        if (pantalla.getPantalla()[y + 1 + Fil][x + MovX + Col] != null) {
                            Colicion = true;
                        }
                    }
                }
            }

            // Si no hay colisión, se actualiza la posición y
            if (!Colicion) {
                y++;
            }
        } else {
            Colicion = true;
        }

        InicTiempo = System.currentTimeMillis();
    }
}

public void CompletarLn() {
    int FinalLn = pantalla.getPantalla().length - 1;
    for (int InicioLn = pantalla.getPantalla().length - 1; InicioLn > 0; InicioLn--) {
        int Contador = 0;
        for (int col = 0; col < pantalla.getPantalla()[0].length; col++) {
            if (pantalla.getPantalla()[InicioLn][col] != null) {
                Contador++;
            }
            pantalla.getPantalla()[FinalLn][col] = pantalla.getPantalla()[InicioLn][col];
        }
        if (Contador < pantalla.getPantalla()[0].length) {
            FinalLn--;
        }
    }
}

public void Rotar() {
    int[][] Rotar = CambiarMX(Coords);
    FilaInversa(Rotar);

    // Verificación de rotación con borde
    if ((x + Rotar[0].length > Pantalla.PantalaWidht) || (y + Rotar.length > 20)) {
        return;
    }
    for (int fila = 0; fila < Rotar.length; fila++) {
        for (int col = 0; col < Rotar[fila].length; col++) {
            if (Rotar[fila][col] != 0) {
                if (pantalla.getPantalla()[y + fila][x + col] != null) {
                    return;
                }
            }
        }
    }
    Coords = Rotar;
}

public int[][] CambiarMX(int[][] Matriz) {
    int[][] Modelo = new int[Matriz[0].length][Matriz.length];
    for (int fila = 0; fila < Matriz.length; fila++) {
        for (int col = 0; col < Matriz[0].length; col++) {
            Modelo[col][fila] = Matriz[fila][col];
        }
    }
    return Modelo;
}

public void FilaInversa(int[][] matriz) {
    int mitad = matriz.length / 2;
    for (int fila = 0; fila < (mitad); fila++) {
        int[] Modelo = matriz[fila];
        matriz[fila] = matriz[matriz.length - fila - 1];
        matriz[matriz.length - fila - 1] = Modelo;
    }
}

public void Generar(Graphics g) {
    // Dibujar formas
    for (int fil = 0; fil < Coords.length; fil++) {
        for (int col = 0; col < Coords[0].length; col++) {
            if (Coords[fil][col] != 0) {
                g.setColor(color);
                g.fillRect(col * TamañoBloque + x * TamañoBloque, fil * TamañoBloque + y * TamañoBloque, TamañoBloque, TamañoBloque);
            }
        }
    }
}

public void Rapido() {
    TiempoDelayMovi = rapid;
}

public void Normal() {
    TiempoDelayMovi = normal;
}

public void MovDerecha() {
    MovX = 1;
}

public void MovIzquierda() {
    MovX = -1;
}

public int[][] TenerCoords() {
    return Coords;
}
}