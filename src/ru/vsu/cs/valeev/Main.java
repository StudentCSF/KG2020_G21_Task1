package ru.vsu.cs.valeev;


import java.awt.*;

public class Main {

    public static void main(String[] args) {
        MainFrame mf = new MainFrame();
        mf.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        Dimension sSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = sSize.width;
        int height = sSize.height;
        mf.setSize(width, height);
        mf.setVisible(true);
    }
}
