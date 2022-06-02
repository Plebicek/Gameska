package Input;

import GameState.STATE;
import Graphics.Display;

import javax.swing.plaf.nimbus.State;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Mouse implements MouseListener {


    private Display display;
    private STATE state;

    public Mouse(Display display, STATE state) {
        this.display = display;
        this.state = state;

    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(display.getGameState() == state.MENU){
            System.out.println("x: "+e.getX());
            if(e.getX() > 348 && e.getX() < 529 && e.getY() > 182 && e.getY() < 242){
                System.out.println("clicked start");


                display.setGameState(STATE.START);
            }
        }
        if(display.getGameState()  == state.GAMEOVER){
            if(e.getX() > 340 && e.getX() < 460 && e.getY() > 180 && e.getY() < 235){
                System.out.println("clicked again");


                display.setGameState(STATE.MENU);
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
