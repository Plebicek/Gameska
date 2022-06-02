package GameObjects;

import GameState.Game;
import Movement.Position;
import Graphics.LoadImage;

import java.awt.*;
import java.awt.image.BufferedImage;

public class UFO {
    private Position position;
    private int width;
    private int height;
    private LoadImage imageLoader;
    private BufferedImage UFOImage;

    //movement
    private boolean isMaxPosition;
    private int MAX_POSITION;
    private int MIN_POSITION;


    public UFO(int width, int height, int x, int y, int MAX_POSITION, int MIN_POSITION) {
        this.position = new Position(x,y);
        this.width = width;
        this.height = height;
        //draw
        imageLoader = new LoadImage();
        UFOImage = imageLoader.loadImage("UFO.png");
        //movement
        boolean isMaxPosition = false;
        this.MAX_POSITION = MAX_POSITION;
        this.MIN_POSITION = MIN_POSITION;

        //isCollisionWithPlayer
    }

    public Position getPosition() {
        return position;
    }
    public void isCollisionWithPlayer(Player player, Game game){
        if (this.getPosition().getX() < player.getPosition().getX()+63 && this.getPosition().getX()+63 > player.getPosition().getX() &&
                this.getPosition().getY() < player.getPosition().getY()+39 && this.getPosition().getY()+35 > player.getPosition().getY()) {

        }

    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void draw(Graphics graphics, UFO UFO) {
        graphics.drawImage(UFO.getImage(),UFO.getPosition().getX(),UFO.getPosition().getY(),null);
    }
    public void move(){
    }

    public void movement(UFO UFO){
        int currentPosition = UFO.getPosition().getX();
        if(!isMaxPosition){
            if(currentPosition < MAX_POSITION){
                currentPosition++;
            } else
            {
                isMaxPosition=true;
            }
        }
        if(isMaxPosition) {
            if(currentPosition > MIN_POSITION){
                currentPosition--;
            } else {
                isMaxPosition=false;
            }
        }
    position.setX(currentPosition);
    }

    private BufferedImage getImage() {
        return UFOImage;
    }

}
