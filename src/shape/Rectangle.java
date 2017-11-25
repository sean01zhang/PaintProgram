/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shape;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author seanz
 */
public class Rectangle extends Polygon {
    
    /**
     * Constructor for rectangle class
     *
     * @param x the x coordinate for where the top left corner point of the
     * rectangle is.
     * @param y the y coordinate for where the top left corner point of the
     * rectangle is.
     * @param w the width of the rectangle
     * @param h the height of the rectangle.
     */
    public Rectangle(double x, double y, double w, double h) {
        super(x,y,w,h);
    }
    
    /**
     * Constructor for rectangle class
     * @param p - the 2D point for where the top left corner point of the rectangle is.
     * @param w - the width of the rectangle
     * @param h - the height of the rectangle
     */
    public Rectangle(Point p, double w, double h) {
        super(p.getX(),p.getY(),w,h);
    }

    /**
     * Gets the width of the rectangle
     *
     * @return returns the width of the rectangle
     */
    public int getWidth() {
        return (int)p[0].distance(p[1]);
    }

    /**
     * Gets the height of the rectangle
     *
     * @return returns the height of the rectangle
     */
    public int getHeight() {
        return (int)p[0].distance(p[2]);
    }
    
    /**
     * Gets the area of a rectangle
     * @return returns the width and height of a rectangle
     */
    @Override
    public double area() {
        return getWidth()*getHeight();
    }
    
    /**
     * Gets the y value of the 2D point at the top left of the rectangle
     * @return returns the y value of the 2D point at the top left of the rectangle
     */
    public int getX() {
        return (int)p[0].getX();
    }
    
    /**
     * Gets the x value of the 2D point at the top left of the rectangle
     * @return returns the x value of the 2D point at the top left of the rectangle
     */
    public int getY() {
        return (int) p[0].getY();
    }
    
    /**
     * This sets the width, height, and position of the rectangle
     * @param x the x value of the 2D point at the top left of the rectangle
     * @param y the y value of the 2D point at the top left of the rectangle
     * @param w the new width of the rectangle
     * @param h the new height of the rectangle
     */
    public void setPosition(int x, int y, int w, int h) {
        p=new Point[4];
        p[1] = new Point(x, y);
        p[2] = new Point(x + w, y);
        p[0] = new Point(x, y - h);
        p[3] = new Point(x + w, y - h);
    }


}
