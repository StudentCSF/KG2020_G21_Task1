package ru.vsu.cs.valeev;

import java.awt.*;

public class Tree implements Drawable {
    private int x, y, width, height;
    private Color leafColor, trunkColor;

    public Tree(int x, int y, int width, int height, Color leafColor, Color trunkColor) {
        this.x = x;
        this.y  =y;
        this.width = width;
        this.height = height;
        this.leafColor = leafColor;
        this.trunkColor = trunkColor;
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(this.trunkColor);
        g.fillRect(this.x, this.y, this.width, this.height);
        g.setColor(this.leafColor);
        g.fillArc(this.x - this.width * 3 / 2, this.y - this.height / 2, this.width * 4, this.height, 0,180);
    }

    public int getX() {
        return x;
    }
}
