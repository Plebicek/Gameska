package Graphics;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class LoadImage {

    public LoadImage() {
    }

    public static BufferedImage loadImage(String filename) {
        try{
            return ImageIO.read(Display.class.getResource("/"+filename));
        } catch (IOException e) {
            System.out.println("Nenalezena cesta");
        }
        return null;
    }
}
