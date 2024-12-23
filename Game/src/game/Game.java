/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author Xuhan
 */
public class Game {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // create and setup frame
        JFrame f = new JFrame("Game");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(1920, 1080);
        //f.setLocation(0, 0);

        // create and setup panel
        GamePanel p = new GamePanel();

        // Create a transparent cursor
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image transparentImage = toolkit.createImage(new byte[0]);
        Cursor invisibleCursor = toolkit.createCustomCursor(transparentImage, new Point(0, 0), "InvisibleCursor");

        // Set the custom cursor for the panel
        p.setCursor(invisibleCursor);

        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        f.setResizable(false); // Optional: prevent resizing
        f.setUndecorated(true);
        gd.setFullScreenWindow(f);

        // add panel to the frame
        f.add(p);
        // make visible
        f.setVisible(true);

    }

}