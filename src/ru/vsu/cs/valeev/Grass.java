package ru.vsu.cs.valeev;

import java.awt.*;

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
    }
}
