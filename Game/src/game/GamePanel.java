/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game;

import javax.swing.*;
import apphelper.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author Xuhan
 */
public class GamePanel extends JPanel implements KeyListener {

    private Sprite bg = new Sprite(-500, -500, "imgs/bg.png");

    private Sprite[] zombie = {
        new Sprite(0, 0, "imgs/zombie/zombie0.png", 360, 380),
        new Sprite(0, 0, "imgs/zombie/zombie1.png", 360, 380),
        new Sprite(0, 0, "imgs/zombie/zombie2.png", 360, 380),
        new Sprite(0, 0, "imgs/zombie/zombie3.png", 360, 380),
        new Sprite(0, 0, "imgs/zombie/zombie4.png", 360, 380),};

    private int recoil = 0;

    private int width;
    private int height;

    private int curFrame = 0;

    private Robot robot;
    private Point centerPoint;
    private boolean isTracking = true;
    private static int deltaX;
    private static int deltaY;

    public GamePanel(int width, int height) {
        this.width = width;
        this.height = height;
        bg.resize((int) (width * 2.5), (int) (height * 2.5));

        addKeyListener(this);
        setFocusable(true);
        requestFocusInWindow();

        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                // Get the center point of the window
                centerPoint = new Point(width / 2, height / 2);
                Point locationOnScreen = getLocationOnScreen();
                centerPoint.translate(locationOnScreen.x, locationOnScreen.y);

                // Calculate the mouse movement delta
                deltaX = e.getXOnScreen() - centerPoint.x;
                deltaY = e.getYOnScreen() - centerPoint.y;

                // Move mouse back to center
                robot.mouseMove(centerPoint.x, centerPoint.y);
            }
        });

        Timer t = new Timer(7, e -> {

            curFrame++;
            curFrame = curFrame % 5;

            bg.setX(bg.getX() - 2 * deltaX);
            bg.setY(bg.getY() - 2 * deltaY);

            repaint();
        });
        t.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // draw background
        bg.draw(g);

        zombie[curFrame].moveOneStepX();
        zombie[curFrame].draw(g);

        // draw weapon upgrade module
        //g.
        // draw crosshair
        g.setColor(Color.YELLOW);
        g.fillRect(width / 2 - 20 - recoil, height / 2 - 2, 15, 4);
        g.fillRect(width / 2 + 5 + recoil, height / 2 - 2, 15, 4);
        g.fillRect(width / 2 - 2, height / 2 - 20 - recoil, 4, 15);
        g.fillRect(width / 2 - 2, height / 2 + 5 + recoil, 4, 15);

        g.drawString(deltaX + ", " + deltaY, 10, 10);
    }

    //all keys
    @Override
    public void keyPressed(KeyEvent e) {
    }

    //all keys
    @Override
    public void keyReleased(KeyEvent e) {
    }

    //this only happens for visible keys
    @Override
    public void keyTyped(KeyEvent e) {
    }
}
