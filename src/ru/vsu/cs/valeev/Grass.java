package ru.vsu.cs.valeev;

import java.awt.*;
import java.util.Random;

public class Grass {
    int x, y1, y2;
    Color color;

    public Grass(int x, int y1, int y2, Color color) {
        this.x = x;
        this.y1 = y1;
        this.y2 = y2;
        this.color = color;
    }

    public void draw(Graphics2D g) {
        g.setColor(this.color);
        g.fillRect(0, this.y1, this.x, y2 - y1);

        Random rnd = new Random();
        for(int i = 0; i < 2000; i++) {
            drawBladeOfGrass(g, rnd.nextInt(this.x), rnd.nextInt(this.y2 - this.y1) + y1 + 1, new Color(34, 139, 34));
        }
    }

    private void drawBladeOfGrass(Graphics2D g, int x, int y, Color color) {
        g.setColor(color);
        g.drawLine(x, y, x - 3, y + 7);
        g.drawLine(x, y, x + 3, y + 7);
    }
}
