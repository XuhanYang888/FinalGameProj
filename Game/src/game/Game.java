/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;

public class Game extends JFrame {
    
    private GamePanel p;
    
    private static int width;
    private static int height;

    public Game() {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gd = ge.getDefaultScreenDevice();
        GraphicsConfiguration gc = gd.getDefaultConfiguration();

        // Get the physical screen resolution
        DisplayMode dm = gd.getDisplayMode();
        int physicalWidth = dm.getWidth();
        int physicalHeight = dm.getHeight();
        System.out.println("Physical Resolution: " + physicalWidth + " x " + physicalHeight);

        // Get the scaling factor
        AffineTransform transform = gc.getDefaultTransform();
        double scaleX = transform.getScaleX();
        double scaleY = transform.getScaleY();
        System.out.println("Scaling factor (X-axis): " + scaleX);
        System.out.println("Scaling factor (Y-axis): " + scaleY);

        // Calculate the scaled resolution (logical resolution)
        width = (int) (physicalWidth / scaleX);
        height = (int) (physicalHeight / scaleY);
        System.out.println("Scaled Resolution (Logical): " + width + " x " + height);
        
        // create frame
        setTitle("Game");
        setSize(width,height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        p = new GamePanel(width,height);
        add(p);
        
        // Make window focusable to receive key events
        setFocusable(true);
        
        Toolkit t = Toolkit.getDefaultToolkit();
        Image i = t.createImage(new byte[0]);
        Cursor c = t.createCustomCursor(i, new Point(0,0), "c");
        p.setCursor(c);
        
    }

    public static void main(String[] args) {
        Game g = new Game();
        g.setVisible(true);
    }
}
