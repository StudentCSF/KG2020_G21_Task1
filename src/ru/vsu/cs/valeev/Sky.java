package ru.vsu.cs.valeev;

import java.awt.*;

public class Sky implements Drawable {
    int x, y;
    Color color;

    public Sky(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(this.color);
        g.fillRect(0, 0, this.x, this.y);
    }
}
