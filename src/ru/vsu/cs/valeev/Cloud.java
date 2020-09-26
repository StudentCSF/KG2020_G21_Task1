package ru.vsu.cs.valeev;

import java.awt.*;

public class Cloud implements Drawable {
    int x, y, r1, r2;
    Color color;


    public Cloud(int x, int y, int r1, int r2, Color color) {
        this.x = x;
        this.y = y;
        this.r1 = r1;
        this.r2 = r2;
        this.color = color;
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(this.color);
        g.fillOval(this.x - r1, this.y - r2, 2 * r1, 2 * r2);
    }
}
