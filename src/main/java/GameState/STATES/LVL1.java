package GameState.STATES;

import GameObjects.Energy;
import GameObjects.Player;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import GameState.STATE;
import Graphics.Display;
import Graphics.ImageLoader;

public class LVL1 {
    private BufferedImage background;
    public LVL1() {
        ImageLoader imageLoader = new ImageLoader();
        background = imageLoader.load("LVL1.jpg");
    }


    public void render(Graphics graphics, Energy energy, BufferedImage imageOfPlayer, Player player, int numberOfLoops, double lastPositionX, double lastPositionY, Display display) {
        if(numberOfLoops==1){
            player.getPosition().setX((int)lastPositionX);
            player.getPosition().setY((int)lastPositionY+570);
            graphics.drawImage(imageOfPlayer,player.getPosition().getX(), player.getPosition().getY(), null);
            display.setNumberOfLoops(2);
        } else {
            graphics.drawImage(background, 0,0,null);
            energy.drawEnergy(graphics);
            energy.drawEnergyAmount(graphics);
            graphics.drawImage(imageOfPlayer, player.getPosition().getX(), player.getPosition().getY(), null);
        }
        if(player.getPosition().getY()<0){
            display.setGameState(STATE.LVL2);
        }
    }
}
