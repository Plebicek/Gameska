package Graphics;

import GameObjects.Player;
import GameObjects.UFO;
import GameState.STATE;
import GameState.STATES.MENU;
import Input.Keyboard;


import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Display extends JFrame {

    private Canvas canvas;
    private Keyboard keyboard;

    private Player player;
    private LoadImage imageLoader;

    private BufferedImage imageOfPlayer;
    private ArrayList<GameObjects.UFO> UFOs;
    private STATE gameState;
    private MENU menu;
    public Display(int width, int height, Player player, ArrayList<UFO> ufos) {
    gameState = gameState.MENU;
    this.player = player;
    this.UFOs = ufos;
    imageLoader = new LoadImage();
    setTitle("test");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    canvas = new Canvas();
    canvas.setPreferredSize(new Dimension(width,height));
    add(canvas);
    pack();
    keyboard = new Keyboard(player);
    addKeyListener(keyboard);
    setResizable(false);
    setLocationRelativeTo(null);
    canvas.createBufferStrategy(3);
    setVisible(true);
    imageOfPlayer = imageLoader.loadImage("dron.png");

    }

    public void render() {
        BufferStrategy strategy = canvas.getBufferStrategy();
        Graphics graphics = strategy.getDrawGraphics();

        if(gameState== STATE.MENU){
//            menu.render(graphics);
        }
        if(gameState== STATE.START){}
        if(gameState== STATE.LVL1){}
        if(gameState== STATE.LVL2){}
        if(gameState== STATE.LVL3){}
        if(gameState== STATE.END){}
        if(gameState== STATE.GAMEOVER){}

        graphics.setColor(Color.BLACK);
        graphics.fillRect(0,0,canvas.getWidth(), canvas.getHeight());

        graphics.drawImage(imageOfPlayer,player.getPosition().getX(), player.getPosition().getY(),null);


        //zde jen vykreslování (objektů), v update pohyb a nastavování pozice
        UFOs.forEach(UFO->UFO.draw(graphics,UFO));
//        graphics.drawImage(GameObjects.UFO,UFO_positionX, ufo.getPosition().getY(),null);

        graphics.dispose();
        strategy.show();
    }

}
