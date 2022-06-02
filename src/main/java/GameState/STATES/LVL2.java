package GameState.STATES;

import GameObjects.Player;
import GameObjects.UFO;
import GameState.STATE;
import Graphics.Display;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class LVL2 {

    public LVL2() {
    }

    public void render(Graphics graphics, Canvas canvas, BufferedImage imageOfPlayer, Player player, int numberOfLoops, double lastPositionX, double lastPositionY, ArrayList<UFO> UFOs, Display display) {
        if(numberOfLoops==2){
            player.getPosition().setX((int)lastPositionX);
            player.getPosition().setY((int)lastPositionY+560);
            graphics.drawImage(imageOfPlayer,player.getPosition().getX(), player.getPosition().getY(), null);
            display.setNumberOfLoops(1);
        } else {
            graphics.setColor(Color.BLACK);
            graphics.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
            graphics.drawImage(imageOfPlayer, player.getPosition().getX(), player.getPosition().getY(), null);
            graphics.setColor(Color.BLUE);
            graphics.fillRect(200, 200, 80, 80);
        }

        graphics.setColor(Color.BLACK);
        graphics.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

        UFOs.forEach(UFO -> UFO.draw(graphics, UFO));

        graphics.drawImage(imageOfPlayer, player.getPosition().getX(), player.getPosition().getY(), null);
        if(display.getGameState() == STATE.LVL2 && player.getPosition().getY()<0 ){
            display.setGameState(STATE.END);
        }
    }
}