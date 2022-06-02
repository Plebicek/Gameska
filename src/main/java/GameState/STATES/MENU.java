package GameState.STATES;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

import Graphics.ImageLoader;


public class MENU extends JFrame {

    private JFrame frame;
    private JButton startButton;
    private BufferedImage background;
    private BufferedImage background2;
    private BufferedImage background3;
    private int scene = 0;


    public MENU() {
        ImageLoader imageLoader = new ImageLoader();
        background = imageLoader.load("Menu1.jpg");
        background2 = imageLoader.load("Menu2.jpg");
        background3 = imageLoader.load("Menu3.jpg");

    }

    public void render(Graphics graphics, int score) throws InterruptedException {
        Graphics2D graphics2D = (Graphics2D) graphics;
        if(scene == 0){
            graphics.drawImage(background, 0,0,null);
            scene++;
            Thread.sleep(100);
        } else if (scene == 1) {
            graphics.drawImage(background2, 0,0,null);
            scene++;
            Thread.sleep(100);
        } else if (scene == 2) {
            graphics.drawImage(background3, 0,0,null);
            scene++;
            Thread.sleep(100);
        }else if (scene == 3) {
            graphics.drawImage(background2, 0,0,null);
            scene++;
            Thread.sleep(100);
        }else if (scene == 4) {
            graphics.drawImage(background, 0,0,null);
            scene = 0;
            Thread.sleep(100);
        }
        graphics.setColor(Color.RED);
        graphics.setFont(new Font("TimesRoman", Font.PLAIN, 45));
        if(score < 100){
            graphics.drawString(String.valueOf(score), 415,320);
        } else  {
            graphics.drawString(String.valueOf(score), 320,320);
        }
        graphics.dispose();
    }
}
