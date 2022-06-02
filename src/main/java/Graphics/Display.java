package Graphics;

import GameObjects.Player;
import GameObjects.UFO;
import GameState.STATE;
import GameState.STATES.*;
import Input.Keyboard;
import Input.Mouse;
import GameObjects.Energy;


import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Display  {

    private Canvas canvas;
    private JFrame jFrame;
    private Keyboard keyboard;
    private Mouse mouse;

    private Player player;
    private ImageLoader imageLoader;

    private BufferedImage imageOfPlayer;
    private ArrayList<GameObjects.UFO> UFOs;
    private STATE gameState;
    private Energy energy;
    private MENU menu;
    private START start;
    private LVL1 lvl1;
    private LVL2 lvl2;

    private GAMEOVER gameover;
    private END end;
    private int numberOfLoops = 1;
    private int score = 0;

    public Display(int width, int height, Player player, ArrayList<UFO> ufos) {
    jFrame = new JFrame();
    canvas = new Canvas();
    menu = new MENU();
    start = new START();
    lvl1 = new LVL1();
    lvl2 = new LVL2();
    gameover = new GAMEOVER();
    end = new END();
    energy = new Energy();

    this.player = player;
    keyboard = new Keyboard(player, energy);
    gameState = gameState.MENU;
    imageLoader = new ImageLoader();
    this.UFOs = ufos;
    jFrame.setTitle("test");
    canvas.addMouseListener(new Mouse(this, gameState));
    canvas.addKeyListener(keyboard);
    jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    canvas.setPreferredSize(new Dimension(width,height));
    jFrame.add(canvas);
    jFrame.pack();

    jFrame.setResizable(false);
    jFrame.setLocationRelativeTo(null);
    canvas.createBufferStrategy(2);
    jFrame.setVisible(true);
    imageOfPlayer = imageLoader.load("dron.png");

    }

    public void render() throws InterruptedException {
        BufferStrategy strategy = canvas.getBufferStrategy();
        Graphics graphics = strategy.getDrawGraphics();
        double lastPositionX = player.getPosition().getX();
        double lastPositionY = player.getPosition().getY();

        if(gameState == STATE.MENU){
            menu.render(graphics, score);
        }
        if(gameState== STATE.START){
            start.render(graphics, imageOfPlayer, player, energy ,this);
        }
        if(gameState== STATE.LVL1){
            lvl1.render(graphics, energy, imageOfPlayer, player, numberOfLoops, lastPositionX, lastPositionY, this);
        }
        if(gameState== STATE.LVL2){
            lvl2.render(graphics, canvas, imageOfPlayer, player,numberOfLoops, lastPositionX, lastPositionY, UFOs, this);
        }
        if(gameState== STATE.END){
            end.render(graphics, canvas);
        }
        if(gameState== STATE.GAMEOVER) {
            gameover.render(graphics,canvas, player, this);
        }
        graphics.dispose();
        strategy.show();
    }

    public void setGameState(STATE gameState) {
        this.gameState = gameState;
    }

    public STATE getGameState() {
        return gameState;
    }

    public void setNumberOfLoops(int numberOfLoops) {
        this.numberOfLoops = numberOfLoops;
    }
}
