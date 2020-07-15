package com.jole141.Game;

import javax.swing.*;
import java.awt.*;

public class Coin extends JPanel {

    private int width = 50;
    private int height = 50;
    private int positionX =(int)(Math.random() * (700-width));
    private int positionY =(int)(Math.random() * (350 -height));

    public void paint(Graphics g) {
        ImageIcon img = new ImageIcon(".\\sprites\\coin.png");
        img.paintIcon(this, g, positionX, positionY);
    }

    //Getters and setters
    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
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

}

