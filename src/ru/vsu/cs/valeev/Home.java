package ru.vsu.cs.valeev;

import java.awt.*;

public class Home {
    int x, y, width, wallHeight;
    Color wallColor, doorColor, roofColor, windowColor;
    Door door;
    WindowHome window;
    Roof roof;
    Chimnei chim;

    private class Door {
        int width, height;

        public Door(int width, int height) {
            this.width = width;
            this.height = height;
        }

        public void draw(Graphics2D g) {
            g.setColor(Home.this.doorColor);
            int x = Home.this.x;
            int y = Home.this.y;
            int w = Home.this.width;
            int h = Home.this.wallHeight;
            g.fillArc(x + w * 2 / 3, y + h / 8, this.width, this.height, 0 ,180);
            g.setColor(Color.BLACK);
            g.fillRect(x + w * 3 / 4 - this.width / 5, y + 5 * h / 8, 10, 3);
        }
    }

    private class WindowHome {
        int x, y, quarterSize, step;

        public WindowHome(int x, int y, int quarterSize, int step) {
            this.x = x;
            this.y = y;
            this.quarterSize = quarterSize;
            this.step = step;
        }

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

    private class Roof {
       int height;

       public Roof(int height) {
           this.height = height;
       }

       public void draw(Graphics2D g) {
           g.setColor(Home.this.roofColor);

           int x = Home.this.x;
           int y = Home.this.y;
           int w = Home.this.width;
           int[] a1 = {x - w / 10, x + w / 2, x + w + w / 10};
           int[] a2 = {y, y - this.height, y};

           g.fillPolygon(a1, a2, 3);

       }
    }

    private class Chimnei {

        public void draw(Graphics2D g) {
            g.setColor(Home.this.roofColor);
            g.fillRect(Home.this.x + Home.this.width / 7, Home.this.y - Home.this.wallHeight / 10 - 300, 50, 300);
           // g.fillRect();
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

    public void draw(Graphics2D g) {
        g.setColor(this.wallColor);
        g.fillRect(this.x, this.y, this.width, this.wallHeight);

        this.roof = new Roof(this.wallHeight);
        roof.draw(g);

        this.chim = new Chimnei();
        this.chim.draw(g);

        this.door = new Door(width / 4, wallHeight  * 14 / 8);
        door.draw(g);

        this.window = new WindowHome(this.x + this.width / 5, this.y + this.wallHeight / 2, 80, 8);
        this.window.draw(g);
    }
}
