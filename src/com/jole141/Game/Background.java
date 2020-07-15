package com.jole141.Game;

import javax.swing.*;
import java.awt.*;

public class Background extends JPanel {

    public void paint(Graphics g) {
        ImageIcon img = new ImageIcon(".\\sprites\\Map.png");
        img.paintIcon(this,g,0,0);
    }
}
