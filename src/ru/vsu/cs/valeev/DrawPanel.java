package ru.vsu.cs.valeev;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class DrawPanel extends JPanel {

    @Override
    public void paint(Graphics g) {
        Graphics2D gr = (Graphics2D) g;

        Sky sky = new Sky(getWidth(), getHeight() / 3, new Color(135, 206, 235));
        sky.draw(gr);


        int x = getWidth() / 32;
        int y = getHeight() / 15;
        int r = Math.min(getWidth() / 32, getHeight() / 15);
        int R = 2 * r;
        Sun sun = new Sun(x, y, r, R, 50, Color.ORANGE);
        sun.draw(gr);


        Random rnd = new Random();
        for (int i = 0; i < 30; i++) {
            Cloud cloud = new Cloud(rnd.nextInt(getWidth() - getWidth() / 10) + getWidth() / 20, rnd.nextInt(sky.getY() - 150) + 50, getWidth() / 20, getWidth() / 40, new Color(232, 232, 232));
            cloud.draw(gr);
        }

        Grass grass = new Grass(getWidth(), sky.getY(), getHeight(), new Color(0, 205, 0));
        grass.draw(gr);

        Home home = new Home(getWidth() / 6, sky.getY() + getHeight() / 10, 2 * getWidth() / 5, 2 * getHeight() / 5, new Color(255, 211, 155), new Color(139, 69, 19), new Color(210, 105, 30), Color.WHITE);
        home.draw(gr);

        Tree tree = new Tree(getWidth() / 9 * 8, sky.getY() * 9 / 10, getWidth() / 30, getHeight() / 2, new Color(50, 205, 50), new Color(205, 133, 63));
        tree.draw(gr);
    }
}