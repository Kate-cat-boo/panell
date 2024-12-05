package org.example.model;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Collection;
public class Model {
    MyShape currentShape;
    Collection <MyShape> list;
    private static Model model = null;
    public Model(){
        list = new ArrayList<>(); //создаем коллекцию фигур
    }

    //конструктор синглтона
    public static Model getInstance(){
        if (model == null){
            model = new Model();
        }
        return model;
    }

    public void addShape(MyShape p){
        currentShape = currentShape.clone() ;
        list.add(currentShape);
    }
    public void setCurrentShape(MyShape currentShape) {

        this.currentShape = currentShape;
    }
    public MyShape getCurrentShape() {

        return currentShape;
    }

    public Collection<MyShape> getList() {

        return list;
    }


    public void setFrame(Point2D[] p) {
        currentShape.addShape(p);
    }
}