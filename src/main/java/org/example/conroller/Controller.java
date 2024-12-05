package org.example.conroller;
import org.example.conroller.action.ActionDraw;
import org.example.view.MyFrame;
import org.example.view.MyPanel;
import org.example.model.Model;
import org.example.model.MyShape;
import java.awt.*;
import java.awt.geom.Point2D;
import java.util.Collection;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import org.example.conroller.action.ActionInterface;
public class Controller {
    MyPanel panel;
    MyFrame frame;
    Model model;
    ActionInterface  actionInterface;
    Point2D[] p;

    public Controller() {
        model = Model.getInstance();
        model.setCurrentShape(new MyShape());
        panel = new MyPanel(this);
        frame = new MyFrame(panel, this);
        actionInterface =  new ActionDraw(model);

    }
    public void setActionInterface(ActionInterface actionInterface) {
        this.actionInterface = actionInterface;
        actionInterface.setModel(model);
    }
    public void mousePressed (Point point){
        actionInterface.mousePressed(point);
    }

    public void mouseDragged (Point point){
        actionInterface.mouseDragget(point);
    }

    public Collection<MyShape> translate () {
        return model.getList();
    }
    public void setRectangle() {
        actionInterface.setSampleShape(new MyShape(new Rectangle2D.Double(), Color.BLUE));
    }

    public void setEllipse() {
        actionInterface.setSampleShape(new MyShape(new Ellipse2D.Double(), Color.red));
    }
}