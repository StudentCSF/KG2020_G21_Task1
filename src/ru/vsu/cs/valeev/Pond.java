package ru.vsu.cs.valeev;

import java.awt.*;

public class Pond implements Drawable {
    private int x, y,
            a, b;
    private Color c;

    public Pond(int x, int y, int a, int b, Color c) {
        this.x = x;
        this.y = y;
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(c);
        g.fillOval(this.x, this.y, this.a, this.b);
    }
}
