/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game;

import javax.swing.*;
import apphelper.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

/**
 *
 * @author MikeRD
 */
public class GamePanel extends JPanel implements MouseListener, KeyListener, MouseMotionListener {

    private Sprite bg = new Sprite(0, 0, "imgs/bg.png", 5400, 2700);

    private int[] mouse = {0, 0};

    private int recoil = 0;

    public final int HEIGHT = 1080;
    public final int WIDTH = 1920;

    public GamePanel() {
        addMouseListener(this);
        addKeyListener(this);
        addMouseMotionListener(this);
        setFocusable(true);
        requestFocusInWindow();

        Timer t = new Timer(7, e -> {
            bg.setX((int) (-mouse[0] * (5400.0 / WIDTH - 1)));
            bg.setY((int) (-mouse[1] * (2700.0 / HEIGHT - 1)));
            repaint();
        });
        t.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // draw background
        bg.draw(g);

        // draw weapon upgrade module
        //g.
        // draw crosshair
        g.setColor(Color.YELLOW);
        g.fillRect(WIDTH / 2 - 20 - recoil, HEIGHT / 2 - 2, 15, 4);
        g.fillRect(WIDTH / 2 + 5 + recoil, HEIGHT / 2 - 2, 15, 4);
        g.fillRect(WIDTH / 2 - 2, HEIGHT / 2 - 20 - recoil, 4, 15);
        g.fillRect(WIDTH / 2 - 2, HEIGHT / 2 + 5 + recoil, 4, 15);

        g.drawString(Arrays.toString(mouse), 10, 10);
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

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        recoil = 2;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        recoil = 0;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // Update var with mouse coordinates
        mouse = new int[]{e.getX(), e.getY()};
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        // Update var with mouse coordinates
        mouse = new int[]{e.getX(), e.getY()};
    }

}
