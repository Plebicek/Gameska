package GameObjects;

import Movement.Position;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

public class Player {

    private Position position;
    private int height;
    private int width;

    public Player() {
        this.position = new Position(400,500);
        height = 40;
        width = 40;
    }

    public void move(int x, int y){
        position.x +=x;
        position.y +=y;
    }


    public Position getPosition() {
        return position;
    }
}
