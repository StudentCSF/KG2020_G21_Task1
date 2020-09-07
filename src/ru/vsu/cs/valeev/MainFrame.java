package ru.vsu.cs.valeev;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    public MainFrame() throws HeadlessException {
        DrawPanel dp = new DrawPanel();
        this.add(dp);
    }
}
