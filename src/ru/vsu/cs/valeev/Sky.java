package ru.vsu.cs.valeev;

import java.awt.*;

public class Sky implements Drawable {
    private int x, y;
    private Color color;

    public Sky(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public int getY() {
        return y;
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(this.color);
        g.fillRect(0, 0, this.x, this.y);
    }
}
