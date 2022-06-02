package GameState.STATES;

import GameObjects.Energy;
import GameObjects.Player;
import GameState.STATE;
import Graphics.Display;
import Graphics.ImageLoader;


import java.awt.*;
import java.awt.image.BufferedImage;

public class START {
    private BufferedImage background;


    public START() {
        ImageLoader imageLoader = new ImageLoader();
        background = imageLoader.load("Start.jpg");

    }

    public void render(Graphics graphics, BufferedImage imageOfPlayer, Player player, Energy energy, Display display) {
        graphics.drawImage(background, 0, 0, null);

        energy.drawEnergyAmount(graphics);

        graphics.drawImage(imageOfPlayer, player.getPosition().getX(), player.getPosition().getY(), null);
        if(player.getPosition().getY()<0){
            display.setGameState(STATE.LVL1);
        }

    }

}
