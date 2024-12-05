package org.example.conroller.action;

import org.example.model.Model;
import org.example.model.MyShape;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.Collection;

public class ActionMove implements ActionInterface {
    MyShape shape;
    Point2D[] points;
    Model model;

    public ActionMove(Model model) {
        this.model = model;
        points = new Point2D[2];
    }

    public ActionMove() {

        points = new Point2D[2];
    }

    public void setModel(Model model) {
        this.model = model;
    }

    void findShape(Point point) {
        Point2D p1 =point;
        points[0] = p1;
        Collection<MyShape> list = model.getList();
        for (MyShape x : list) {
            if (x.getShape().contains(p1)) shape = x;
        }
    }

    @Override
    public void mousePressed(Point point) {
        findShape(point);
    }

    public void moveShape(Point point) {
        points[1] = point;
        if (shape != null) {
            double deltaX = points[1].getX() - points[0].getX();
            double deltaY = points[1].getY() - points[0].getY();
            double maxX = shape.getShape().getMaxX() + deltaX;
            double maxY = shape.getShape().getMaxY() + deltaY;
            double minX = shape.getShape().getMinX() + deltaX;
            double minY = shape.getShape().getMinY() + deltaY;
            shape.getShape().setFrameFromDiagonal(minX, minY, maxX, maxY);
            points[0] = points[1];
        }
    }

    @Override
    public void mouseDragget(Point point) {
        moveShape(point);

    }

    @Override
    public void setSampleShape(MyShape myShape) {

    }
}