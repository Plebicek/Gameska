package GameObjects;

import Graphics.ImageLoader;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Energy {
    private int amountOfEnergy = 100;
    private BufferedImage energyImage;

    public Energy() {
        ImageLoader imageLoader = new ImageLoader();
        energyImage = imageLoader.load("energy.png");
    }

    public void costFuel(int i) {
        amountOfEnergy -=i;
    }

    public int getAmmountOfEnergy() {
        return amountOfEnergy;
    }

    public BufferedImage getEnergyImage() {
        return energyImage;
    }

    public void drawEnergyAmount(Graphics graphics) {
        graphics.drawImage(getEnergyImage(),752,200,null);
        graphics.setColor(Color.yellow);
        graphics.fillRect(740,230,50,getAmmountOfEnergy());
    }

    public void drawEnergy(Graphics graphics) {
        //random generated energy
        graphics.drawImage(energyImage, 350, 400, null);
    }

}
