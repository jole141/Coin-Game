package com.jole141.Game;

import javax.swing.*;
import java.awt.*;

public class Player extends JPanel {

    private int score = 0;
    private int positionX = 300;
    private int positionY = 500;
    private int width = 70;
    private int height = 70;

    Bullet bullet = new Bullet();
    Bullet bullet2 = new Bullet();
    Bullet[] bullets = {bullet,bullet2};

    public void paint(Graphics g) {
        ImageIcon img = new ImageIcon(".\\sprites\\player.png");
        img.paintIcon(this,g,positionX,positionY);
    }

    public void moveRight() {
        this.positionX += 2;
    }

    public void moveLeft() {
        this.positionX -= 2;
    }

    public void moveDown() {
        this.positionY += 2;
    }

    public void moveUp() {
        this.positionY -= 2;

    }

    public void hit(Coin coin) {
        for (int i = 0; i < 2; i++) {
            if (new Rectangle(coin.getPositionX() + coin.getWidth() / 2, coin.getPositionY() + coin.getHeight() / 2, 1, 1)
                    .intersects(new Rectangle(positionX, positionY, width, height)) || new Rectangle(coin.getPositionX(), coin.getPositionY(),
                    coin.getWidth(), coin.getHeight()).intersects(new Rectangle(bullets[i].getPositionX(), bullets[i].getPositionY(), bullets[i].getWidth(),
                    bullets[i].getHeight()))) {

                coin.setPositionX((int) (Math.random() * (700 - 2* coin.getWidth())));
                coin.setPositionY((int) (Math.random() * (350 - 2* coin.getHeight())));
                score++;
            }
        }
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

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
