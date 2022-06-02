import GameState.Game;

public class Launcher {
    public static void main(String[] args) {
    new Thread(new ProcessingLoop(new Game(800,600))).start();
    }
}
