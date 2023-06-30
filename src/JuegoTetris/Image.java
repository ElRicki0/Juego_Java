package JuegoTetris;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Image {

    // Método para cargar una imagen desde un archivo
    public static BufferedImage loadImage(String path) {
        try {
            // Intenta leer la imagen desde el archivo especificado en la ruta "data" + path
            return ImageIO.read(new File("data" + path));

        } catch (IOException e) {
            // Si ocurre una excepción de E/S (por ejemplo, archivo no encontrado), imprime la traza de error
            e.printStackTrace();
            
            // Sale del programa con un código de error
            System.exit(1);
        }
        
        // Si no se puede cargar la imagen, devuelve null
        return null;
    }
}
