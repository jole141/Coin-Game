package com.jole141.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Gameplay extends JPanel implements KeyListener, ActionListener {

    private boolean[] direction = {false, false, false, false};
    private boolean play = true;
    private boolean showContorls = false;
    private boolean[] shot = {false, false};

    private Timer timer;
    private int delay = 10;

    //elements
    Player player = new Player();
    Coin coin1 = new Coin();
    Coin coin2 = new Coin();
    Coin coin3 = new Coin();
    Coin coin4 = new Coin();
    Coin coin5 = new Coin();
    Coin coin6 = new Coin();
    Coin coin7 = new Coin();
    Background background = new Background();


    public Gameplay () {
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer = new Timer(delay, this);
        timer.start();
    }

    public void paint(Graphics g) {

        background.paint(g);
        if(shot[0]) {
            player.bullet.paint(g, player.bullet.getPositionX(), player.bullet.getPositionY(),
                    player.bullet.getWidth(), player.bullet.getHeight());
        }
        if(shot[1]) {
            player.bullet2.paint(g, player.bullet2.getPositionX(), player.bullet2.getPositionY(),
                    player.bullet2.getWidth(), player.bullet2.getHeight());
        }
        coin1.paint(g);
        coin2.paint(g);
        coin3.paint(g);
        coin4.paint(g);
        coin5.paint(g);
        coin6.paint(g);
        coin7.paint(g);

        player.paint(g);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Game Over", Font.PLAIN,130));
        g.drawString("Score: "+ player.getScore(), 750, 80);
        if(!play) {
            ImageIcon img = new ImageIcon(".\\sprites\\Pause.png");
            img.paintIcon(this,g,0,0);
        }
        if(showContorls) {
            ImageIcon img = new ImageIcon(".\\sprites\\controls.png");
            img.paintIcon(this,g,0,0);
        }
        g.dispose();
    }



    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        if(play) {
            if (direction[0] && player.getPositionY()!=420) { //UP
                player.moveUp();
            }
            if (direction[1] && player.getPositionX()!=710 - player.getWidth()) { //RIGHT
                player.moveRight();
            }
            if (direction[2] && player.getPositionY()!=700 - player.getHeight()) { //DOWN
                player.moveDown();
            }
            if (direction[3] && player.getPositionX()!=-10) { //LEFT
                player.moveLeft();
            }

            player.hit(coin1);
            player.hit(coin2);
            player.hit(coin3);
            player.hit(coin4);
            player.hit(coin5);
            player.hit(coin6);
            player.hit(coin7);


            if(shot[0]) {
                player.bullet.setPositionY(player.bullet.getPositionY() -3);
            }
            if(shot[1]) {
                player.bullet2.setPositionY(player.bullet2.getPositionY() -3);
            }
        }

        repaint();
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) { }
    @Override
    public void keyReleased(KeyEvent keyEvent) {
        if(keyEvent.getKeyCode() == KeyEvent.VK_W) {
            if(play) {
                direction[0] = false;
            }
        }
        if(keyEvent.getKeyCode() == KeyEvent.VK_A){
            if(play) {
                direction[3] = false;
            }
        }
        if(keyEvent.getKeyCode() == KeyEvent.VK_S) {
            if(play) {
                direction[2] = false;
            }
        }
        if(keyEvent.getKeyCode() == KeyEvent.VK_D) {
            if(play) {
                direction[1] = false;
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        if(keyEvent.getKeyCode() == KeyEvent.VK_W) {
            if(play) {
                direction[0] = true;
            }
        }
        if(keyEvent.getKeyCode() == KeyEvent.VK_D) {
            if(play) {
                direction[1] = true;
            }
        }
        if(keyEvent.getKeyCode() == KeyEvent.VK_S) {
            if (play) {
                direction[2] = true;
            }
        }
        if(keyEvent.getKeyCode() == KeyEvent.VK_A) {
            if(play) {
                direction[3] = true;
            }
        }

        if(keyEvent.getKeyCode() == KeyEvent.VK_ENTER) {
            play = !play;
            setDirFalse();
        }
        if(keyEvent.getKeyCode() == KeyEvent.VK_R) {
            restart();
        }
        if(keyEvent.getKeyCode() == KeyEvent.VK_I) {
            showControls();
        }
        if(keyEvent.getKeyCode() == KeyEvent.VK_K) {
            if (player.bullet.getPositionY() < 0) {
                shotBullet(true);
            }
        }
        if(keyEvent.getKeyCode() == KeyEvent.VK_L) {
            if (player.bullet2.getPositionY() < 0) {
                shotBullet1(true);
            }
        }
    }

    public void setDirFalse() {
        for (int i = 0; i < 4 ; ++i) {
            direction[i] = false;
        }
    }

    public void restart(){
        player.setPositionX(300);
        player.setPositionY(500);
        player.setScore(0);
        setDirFalse();
    }
    public void showControls() {
        showContorls = !showContorls;
    }

    public void shotBullet( boolean x) {
        shot[0] = x;
        player.bullet.setPositionX(player.getPositionX() + player.getWidth()/2 - 5);
        player.bullet.setPositionY(player.getPositionY() + player.getHeight()/2 - 5);
    }
    public void shotBullet1( boolean x) {
        shot[1] = x;
        player.bullet2.setPositionX(player.getPositionX() + player.getWidth()/2 - 5);
        player.bullet2.setPositionY(player.getPositionY() + player.getHeight()/2 - 5);
    }
}
