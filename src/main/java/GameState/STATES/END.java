package GameState.STATES;

import java.awt.*;
import java.awt.image.BufferedImage;
import Graphics.ImageLoader;
public class END {

    private BufferedImage background;
    private ImageLoader loader;

    public END() {
    }

    public void render(Graphics graphics, Canvas canvas) {
        Graphics2D graphics2D = (Graphics2D) graphics;

        graphics.setColor(Color.BLACK);
        graphics.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());


        graphics.setColor(Color.BLUE);
        graphics.fillRect(340,180,120,55);
        graphics.setColor(Color.RED);
        graphics.drawString("THE End", 340,200);


        graphics.dispose();
    }

}
