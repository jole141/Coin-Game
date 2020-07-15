package com.jole141.Game;

import javax.swing.*;
import java.awt.*;

public class Game {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        Gameplay gamePlay = new Gameplay();

        frame.setSize(1016, 739);
        frame.setTitle("Coins");
        frame.setResizable(false);
        frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);
        frame.add(gamePlay);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

