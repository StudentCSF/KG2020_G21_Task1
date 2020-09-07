package ru.vsu.cs.valeev;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class DrawPanel extends JPanel {

    @Override
    public void paint(Graphics g) {
        Graphics2D gr = (Graphics2D) g;

        /*if (true) {
            gr.setColor(Color.RED);
            gr.fillArc(100, 100, 300, 900, 0, 180);
            return;
        }*/

        Dimension sSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = sSize.width;
        int height = sSize.height;

        Sky sky = new Sky(width, 350, new Color(135, 206, 235));
        sky.draw(gr);

        Sun sun = new Sun(50, 50, 50, 100, 50, Color.ORANGE);
        sun.draw(gr);


        Random rnd = new Random();
        for (int i = 0; i < 30; i++) {
            Cloud cloud = new Cloud(rnd.nextInt(width) + 150, rnd.nextInt(sky.y - 150) + 50, 100, 50, new Color(232, 232, 232));
            cloud.draw(gr);
        }

        Grass grass = new Grass(width, sky.y, height, new Color(0, 205, 0));
        grass.draw(gr);

        Home home = new Home(300, sky.y + 100, 700, 400, new Color(255, 211, 155), new Color(139, 69, 19), new Color(210, 105, 30), Color.WHITE);
        home.draw(gr);
    }
}