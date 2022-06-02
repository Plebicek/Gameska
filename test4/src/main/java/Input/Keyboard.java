package Input;

import GameObjects.Player;
import GameState.Game;
import Graphics.Display;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener {

    private Game game;
    private Display display;
    private Player player;
    public Keyboard(Player player){
        this.player = player;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_UP){
            player.move(0,-10);
        }
        if(e.getKeyCode()==KeyEvent.VK_DOWN){
            player.move(0,10);
        }
        if(e.getKeyCode()==KeyEvent.VK_LEFT){
            player.move(-10,0);
        }
        if(e.getKeyCode()==KeyEvent.VK_RIGHT){
            player.move(10,0);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
