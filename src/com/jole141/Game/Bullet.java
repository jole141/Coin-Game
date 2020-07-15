package com.jole141.Game;

import java.awt.*;

public class Bullet {

    private int speed;
    private int positionX = -10;
    private int positionY = -10;
    private int width = 11 ;
    private int height = 11;

    public void paint(Graphics g, int x, int y, int width, int height) {

        g.setColor(Color.ORANGE);
        g.fillOval(x, y, width, height);
        g.setColor(Color.black);
        g.drawOval(x, y, width, height);
    }

    //Getters and setters
    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

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
