package org.example.view;

import javax.swing.*;
import org.example.conroller.Controller;
import org.example.conroller.action.ActionDraw;
import org.example.conroller.action.ActionMove;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MyFrame extends JFrame {
    MyPanel panel;
    Controller controller;

    public void setController(Controller controller) {
        this.controller = controller;
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
    }

    public MyFrame(MyPanel panel, Controller controller) throws HeadlessException  {
        /////////////////////////////// menu /////////////////////
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        JMenu action = new JMenu("Action");
        JMenuItem draw = new JMenuItem("Draw");
        JMenuItem move = new JMenuItem("Move");
        action.add(draw);
        action.add(move);
        menuBar.add(action);
        draw.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.setActionInterface(new ActionDraw());
            }
        });
        move.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.setActionInterface(new ActionMove());
            }
        });


        JMenu menuShape = new JMenu("shape");
        menuBar.add(menuShape);
        JMenuItem itemRec = new JMenuItem("rectangle");
        JMenuItem itemEll = new JMenuItem("ellipse");
        menuShape.add(itemRec);
        menuShape.add(itemEll);
        itemRec.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.setRectangle();
            }
        });
        itemEll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.setEllipse();
            }
        });


        setVisible(true); //видимость
        setResizable(false); //запрет изменения размера окна
        setSize(500,500); //размер окна
        add(panel); //добавление панели
        setDefaultCloseOperation(EXIT_ON_CLOSE); //кнопка закрытия
    }
}
