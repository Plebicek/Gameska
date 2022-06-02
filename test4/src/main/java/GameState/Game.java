package GameState;

import GameObjects.Player;
import GameObjects.UFO;
import Graphics.Display;
import Input.Keyboard;

import java.util.ArrayList;

public class Game {

    private Display display;
    private Player player;
    private Keyboard keyboard;
    private ArrayList<Player> players;
    private ArrayList<UFO> UFOs;

    private UFO ufo1;
    private UFO ufo2;
    private UFO ufo3;

    public Game(int width, int height){
        height = height;
        width = width;
        ufo1 = new UFO(64,32,150,100,750,30);
        ufo2 = new GameObjects.UFO(64,32,90,200,750,30);
        ufo3 = new GameObjects.UFO(64,32,180,300,750,30);

        UFOs = new ArrayList<>();
        UFOs.add(ufo1);
        UFOs.add(ufo2);
        UFOs.add(ufo3);
        player = new Player();
        display = new Display(width, height,player,UFOs);
        keyboard = new Keyboard(player);
        players = new ArrayList<>();
        players.add(player);

    }

    public void updateGame() {
        UFOs.forEach(UFO->UFO.movement(UFO));
    }

    public void renderGame() {
        display.render();
    }

    public void Colision() {
        UFOs.forEach(UFO->UFO.isCollisionWithPlayer(player,this));
    }
}



