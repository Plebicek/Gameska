import GameState.Game;

public class ProcessingLoop implements Runnable {

    private boolean running;
    private Game game;
    private long nextStatsTime;
    private int fps,ups;
    final double refreshRate = 1.0d/60.0d;
    public ProcessingLoop(Game game) {
        this.game = game;
    }

    @Override
    public void run() {
        running = true;
        long currentTime, started = System.currentTimeMillis();
        double timeDifferences = 0;
        nextStatsTime = System.currentTimeMillis() + 1000;

        while (running) {
            currentTime = System.currentTimeMillis();
            double timeRendering = (currentTime - started) / 1000d;
            timeDifferences += timeRendering;
            started = currentTime;

            if(timeDifferences >= refreshRate){
                while(timeDifferences >= refreshRate){
                    gameUpdate();
                    timeDifferences -= refreshRate;
                }
                gameRender();
                isColision();
            }
            gameStats();
        }
    }
    private void gameStats() {
        if(System.currentTimeMillis() >= nextStatsTime) {
            System.out.println(String.format("FPS %d UPS %d", fps, ups));
            fps = 0;
            ups = 0;
            nextStatsTime = System.currentTimeMillis() + 1000;
        }
    }
    private void gameUpdate() {
        game.updateGame();
        ups++;
    }
    private void gameRender() {
        game.renderGame();
        fps++;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    private void isColision(){
        game.Colision();
    }

    }
