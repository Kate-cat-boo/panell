package org.example.conroller.action;

import org.example.model.Model;
import org.example.model.MyShape;

import java.awt.*;

public interface ActionInterface {
    void mousePressed(Point point);

    void mouseDragget(Point point);

    void setModel(Model m);

    void setSampleShape(MyShape myShape);
}