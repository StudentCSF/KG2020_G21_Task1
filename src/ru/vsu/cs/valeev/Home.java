package ru.vsu.cs.valeev;

import java.awt.*;

public class Home implements Drawable {
    int x, y, width, wallHeight;
    Color wallColor, doorColor, roofColor, windowColor;
    Door door;
    WindowHome window;
    Roof roof;
    Chimney chim;
    StreetTable st;

    private class Door implements Drawable {
        int width, height;

        public Door(int width, int height) {
            this.width = width;
            this.height = height;
        }

        @Override
        public void draw(Graphics2D g) {
            g.setColor(Home.this.doorColor);
            int x = Home.this.x;
            int y = Home.this.y;
            int w = Home.this.width;
            int h = Home.this.wallHeight;
            g.fillArc(x + w * 2 / 3, y + h / 8, this.width, this.height, 0, 180);
            g.setColor(Color.BLACK);
            g.fillRect(x + w * 3 / 4 - this.width / 5, y + 5 * h / 8, 10, 3);
        }
    }

    private class WindowHome implements Drawable {
        int x, y, quarterSize, step;

        public WindowHome(int x, int y, int quarterSize, int step) {
            this.x = x;
            this.y = y;
            this.quarterSize = quarterSize;
            this.step = step;
        }

        @Override
        public void draw(Graphics2D g) {
            g.setColor(Home.this.windowColor);
            int x = this.x - this.step * 3 / 2 - this.quarterSize;
            int y = this.y - this.step * 3 / 2 - this.quarterSize;
            g.fillRect(x, y, 3 * this.step + 2 * this.quarterSize, 3 * this.step + 2 * this.quarterSize);
            g.setColor(new Color(175, 238, 238));
            g.fillRect(x + this.step, y + this.step, this.quarterSize, this.quarterSize);
            g.fillRect(x + this.step, y + this.quarterSize + 2 * this.step, this.quarterSize, this.quarterSize);
            g.fillRect(x + this.quarterSize + 2 * this.step, y + this.step, this.quarterSize, this.quarterSize);
            g.fillRect(x + this.quarterSize + 2 * this.step, y + this.quarterSize + 2 * this.step, this.quarterSize, this.quarterSize);
        }
    }

    private class Roof implements Drawable {
        int height;

        public Roof(int height) {
            this.height = height;
        }

        @Override
        public void draw(Graphics2D g) {
            g.setColor(Home.this.roofColor);

            int x = Home.this.x;
            int y = Home.this.y;
            int w = Home.this.width;
            int[] a1 = {x - w / 10, x + w / 2, x + w + w / 10};
            int[] a2 = {y, y - this.height, y};

            g.fillPolygon(a1, a2, 3);
            g.setColor(Color.BLACK);
            int step = 50;
            int x1 = x - w / 10;
            int x2 = x + w + w / 10;
            int y0 = y;
            for (int i = 0; i < height / step; i++) {
                g.drawLine(x1, y0, x2, y0);
                y0 -= step;
                x1 = x - w / 10 - (6 * w) * (y0 - y) / (10 * this.height);
                x2 = x + w + w / 10 + (6 * w) * (y0 - y) / (10 * this.height);
            }
        }
    }

    private class Chimney implements Drawable {

        @Override
        public void draw(Graphics2D g) {
            g.setColor(new Color(139, 0, 0));
            g.fillRect(Home.this.x + Home.this.width / 7, Home.this.y - Home.this.wallHeight / 10 - 300, 50, 300);
            drawBricks(g,Home.this.x + Home.this.width / 7, Home.this.y - Home.this.wallHeight / 10 - 300, 50, 20, 300 / 20, 50 / 50, Color.BLACK);
        }
    }

    private class StreetTable implements Drawable {
        int x, y, width, height;
        Color color;
        String name;

        public StreetTable(int x, int y, int width, int height, Color color, String name) {
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
            this.color = color;
            this.name = name;
        }

        @Override
        public void draw(Graphics2D g) {
            g.setColor(this.color);
            g.fillRect(this.x, this.y, this.width, this.height);
            g.setColor(Color.WHITE);
            g.setFont(new Font("name", 5, 20));
            char[] c = this.name.toCharArray();
            g.drawChars(c, 0, c.length, this.x + 5, this.y + this.height - 10);
        }
    }


    public Home(int x, int y, int width, int wallHeight, Color wallColor, Color roofColor, Color doorColor, Color windowColor) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.wallHeight = wallHeight;
        this.wallColor = wallColor;
        this.roofColor = roofColor;
        this.doorColor = doorColor;
        this.windowColor = windowColor;
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(this.wallColor);
        g.fillRect(this.x, this.y, this.width, this.wallHeight);

        drawBricks(g, this.x, this.y, 50, 20, this.wallHeight / 20, this.width / 50, new Color(131, 139, 131));

        this.roof = new Roof(this.wallHeight);
        roof.draw(g);

        this.chim = new Chimney();
        this.chim.draw(g);

        this.door = new Door(width / 4, wallHeight * 14 / 8);
        door.draw(g);

        this.window = new WindowHome(this.x + this.width / 5, this.y + this.wallHeight / 2, 80, 8);
        this.window.draw(g);

        this.st = new StreetTable(this.x + this.width / 20, this.y + this.wallHeight / 12, 150, 40, new Color(72, 118, 255), "Java Street, 1");
        this.st.draw(g);
    }

    private void drawBricks(Graphics2D g, int x, int y, int brickWidth, int brickHeight, int rowCount, int colCount, Color color) {
        g.setColor(color);

        int y1 = y;
        int x2 = x + colCount * brickWidth;
        for (int i = 0; i < rowCount; i++) {
            y1 += brickHeight;
            g.drawLine(x, y1, x2, y1);
        }
        int x1 = x;
        int y2 = y + rowCount * brickHeight;
        for (int i = 0; i < colCount; i++) {
            x1 += brickWidth;
            g.drawLine(x1, y, x1, y2);
        }
    }
}
