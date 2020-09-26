package ru.vsu.cs.valeev;

import java.awt.*;

public class Sun implements Drawable {
    private int x, y, r, R, rayCount;
    private Color color;

    public Sun(int x, int y, int r, int R, int rayCount, Color color) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.R = R;
        this.rayCount = rayCount;
        this.color = color;
    }

    public int getX() {
        return x;
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(color);
        g.fillOval(x - r, y - r, 2 * r, 2 * r);
        double da = 2 * Math.PI / rayCount;
        double dx, dy;
        for (int i = 0; i < rayCount; i++) {
            dx = Math.sin(da * i) * R;
            dy = Math.cos(da * i) * R;
            g.drawLine(x, y, x + (int) dx, y + (int) dy);
        }
    }
}
