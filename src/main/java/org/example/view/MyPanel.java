package org.example.view;
import org.example.conroller.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.Collection;

import org.example.model.MyShape;

public class MyPanel extends JPanel {
    private final Controller controller;

    public MyPanel(Controller controller) {
        this.controller = controller;


        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {

                super.mousePressed(e);
                controller.mousePressed(e.getPoint());

            }
        });
        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e);
                controller.mouseDragged(e.getPoint());
                repaint();
            }
        });
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        Collection<MyShape> myShapes = controller.translate();
        for (MyShape myShape : myShapes) {
            myShape.draw(g2); // Отрисовка каждой фигуры
        }
    }
}