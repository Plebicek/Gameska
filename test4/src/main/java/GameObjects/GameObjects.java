package GameObjects;

import Movement.Position;

public abstract class GameObjects {

    private Position position;
    private int width;
    private int height;

    public GameObjects(Position position, int width, int height) {
        this.position = position;
        this.width = width;
        this.height = height;
    }
}
