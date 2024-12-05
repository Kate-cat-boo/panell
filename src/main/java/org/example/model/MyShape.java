package org.example.model;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RectangularShape;

//класс фигуры
public class MyShape {
    RectangularShape shape; //объект прямоугольника
    Color color; //цвет
    FillBih fillBehavior;


    // конструктор по умолчанию
    public MyShape() {
        public Color colorDefault = Color.pink;
        shape = new Rectangle2D.Double(); //фигура - прямоугольник
        color = Color.red; //цвет обводки
        fillBehavior = FillBih.FILL;
    }

    public MyShape(RectangularShape shape, Color color) {
        this.shape = shape;
        this.color = color;
    }

    public MyShape(Rectangle2D.Double aDouble) {
    }

    public MyShape(Ellipse2D.Double aDouble) {
    }

    //геттер фигуры
    public RectangularShape getShape() {
        return shape;
    }

    //создание фигуры по точкам
    public void createShape(Point2D[] point) {
        shape.setFrameFromDiagonal(point[0], point[1]);
    }

    // Добавляем рисовку фигуры
    public void draw(Graphics2D g) {
        Paint p= g.getPaint();
        g.setColor(color);
        g.draw(shape);
        g.fill(shape);
        g.setPaint(p);
    }


    //метод клонирования
    public MyShape clone(){
        MyShape s = new MyShape(); //создаем новую фигуру

        //ставим все характеристики прошлой
        s.color = this.color;
        s.shape = (RectangularShape) shape.clone();
        s.fillBehavior = this.fillBehavior;

        //возвращаем готовую копию
        return s;
    }

    public void setShape(RectangularShape shape) {
        this.shape = shape;
        this.color = colorDefault;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setFillBehavior(FillBih fillBehavior) {
        this.fillBehavior = fillBehavior;
    }

    public FillBih getFillBehavior() {
        return fillBehavior;
    }

    public void addShape(Point2D[] points) {
    }
}