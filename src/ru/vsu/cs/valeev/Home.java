package ru.vsu.cs.valeev;

import java.awt.*;

public class Home implements Drawable {
    private int x, y, width, wallHeight, foundY;
    private Color wallColor, doorColor, roofColor, windowColor;
    private Door door;
    private WindowHome window;
    private Roof roof;
    private StreetTable st;

    private class Door implements Drawable {
        int x ,y,
                width, height;

        public Door(int x, int y, int width, int height) {
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
        }

        @Override
        public void draw(Graphics2D g) {
            g.setColor(Home.this.doorColor);
            g.fillArc(this.x, this.y, this.width, this.height, 0, 180);
            g.setColor(Color.BLACK);
            g.fillRect(this.x + this.width / 10, this.y + this.height / 7 * 2, this.width / 10, 3);
            drawDoorstep(g, x, foundY, width, Home.this.getY() + Home.this.getWallHeight() - Home.this.foundY, height / 200, new Color(255, 99, 71));
        }

        private void drawDoorstep(Graphics2D g, int x, int y, int width, int height, int count, Color color) {
            g.setColor(color);
            g.fillRect(x, y, width, height);
            g.setColor(Color.BLACK);
            for (int i = 1; i <= count; i++) {
                g.fillRect(x, y + i * height / count - height / (5 + count - i), width, height / (5 + count - i));
            }
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
        Chimney ch;

        private class Chimney implements Drawable {

            @Override
            public void draw(Graphics2D g) {
                g.setColor(new Color(139, 0, 0));
                g.fillRect(Home.this.x + Home.this.width / 7, Home.this.y - height / 6 * 5, Home.this.width / 10, height / 3 * 2);
                drawBricks(g,Home.this.x + Home.this.width / 7, Home.this.y - height / 6 * 5, Home.this.width / 10, Home.this.width / 64 * 3, Home.this.wallHeight / 3 * 2 / (Home.this.width / 64 * 3), 1, Color.BLACK);
            }
        }

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
            this.ch = new Chimney();
            this.ch.draw(g);
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
            g.setFont(new Font("name", 5, this.width / 7));
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

    public int getX() {
        return x;
    }

    public int getWidth() {
        return width;
    }

    public int getY() {
        return y;
    }

    public int getWallHeight() {
        return wallHeight;
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(this.wallColor);
        g.fillRect(this.x, this.y, this.width, this.wallHeight);

        int bWidth = this.width / 8;
        this.foundY =  drawBricks(g, this.x, this.y, bWidth, bWidth / 8 * 3, this.wallHeight / bWidth * 8 / 3, this.width / bWidth, new Color(131, 139, 131));
        g.setColor(new Color(131, 139, 131));
        g.fillRect(this.x, foundY, this.width, this.wallHeight - foundY + y);

        this.roof = new Roof(this.wallHeight);
        roof.draw(g);

        this.door = new Door((this.x + this.width) * 3 / 4, this.y + this.wallHeight / 8, this.width / 4, 2 * foundY - 2 * (this.y + this.wallHeight / 8));
        door.draw(g);

        int qSize = Math.min(this.width, this.wallHeight) / 5;
        this.window = new WindowHome(this.x + this.width / 5, this.y + this.wallHeight / 2, qSize, qSize / 10);
        this.window.draw(g);

        this.st = new StreetTable(this.x + this.width / 20, this.y + this.wallHeight / 12, this.width * 3 / 16, this.wallHeight / 10, new Color(72, 118, 255), "Java Street, 1");
        this.st.draw(g);
    }

    private int drawBricks(Graphics2D g, int x, int y, int brickWidth, int brickHeight, int rowCount, int colCount, Color color) {
        g.setColor(color);

        int y1 = y;
        int x2 = x + colCount * brickWidth;
        for (int i = 0; i < rowCount; i++) {
            y1 += brickHeight;
            g.drawLine(x, y1, x2, y1);
        }
        int x1 = x;
        x2 = x + brickWidth / 2;
        int actX;
        y1 = y;
        int foundY = 0;
        for (int i = 0; i < rowCount; i++) {
            actX = i % 2 == 0 ? x1 : x2;
            for (int j = 0; j < colCount; j++, actX += brickWidth) {
                g.drawLine(actX, y1 + i * brickHeight, actX, foundY = y1 + brickHeight * (i + 1));
            }
        }
        return foundY;
    }
}
