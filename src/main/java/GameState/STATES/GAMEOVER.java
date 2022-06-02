package GameState.STATES;


import java.awt.*;
import java.awt.image.BufferedImage;

import GameObjects.Player;
import GameState.STATE;
import Graphics.ImageLoader;
import Graphics.Display;

public class GAMEOVER {
    private BufferedImage background;
    private ImageLoader loader;

    public GAMEOVER() {
        loader = new ImageLoader();
        background = loader.load("Kaneki.jpg");

    }


    public void render(Graphics graphics, Canvas canvas, Player player, Display display) {
        Graphics2D graphics2D = (Graphics2D) graphics;

        graphics.setColor(Color.BLACK);
        graphics.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

        graphics.setColor(Color.BLUE);
        graphics.fillRect(340,180,120,55);
        graphics.setColor(Color.RED);
        player.getPosition().setX(365);
        player.getPosition().setY(470);

        graphics.drawString("Konec hry", 340,200);
        graphics.drawString("Hrát znovu", 340,213);

        graphics.dispose();

    }
}
