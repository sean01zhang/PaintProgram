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
 * @author seanzhang
 */
public class Circle extends Polygon{
    //the radius of the circle
    private int radius;

    /**
     * Constructor for circle
     * @param x the x value of the 2D point where the circle originates from
     * @param y the y value of the 2D point where the circle originates from
     * @param r the radius of the circle.
     */
    public Circle(double x, double y, double r) {
        super(x-r, y, r, r);
        this.radius = (int)r;
    }
    
    /**
     * Constructor for circle
     * @param p the 2D point where the circle originates from
     * @param r the radius of the circle
     */
    public Circle(Point p, double r) {
        super(p.getX(),p.getY(),r,r);
    }

    /**
     * Scales the circle by a factor of w from the origin
     *
     * @param w the scale factor.
     */
    @Override
    public void scale(double w) {
        p[0].scale(w);
        radius= (int)(radius*w);
        System.out.println(w);
    }
    
    /**
     * Scales the polygon by a factor of w from the specified point.
     *
     * @param w the scale factor
     * @param xOrig the x value of the 2D point
     * @param yOrig the y value of the 2D point
     */
    @Override
    public void scale(double w, double xOrig, double yOrig) {
        p[0].scale(w, xOrig, yOrig);
        radius= (int)(radius*w);
    }
    
    /**
     * Gets the area of the circle
     * @return returns the area of the circle using the circle formula. 
     */
    @Override
    public double area() {
        return Math.PI*radius*radius;
    }

    /**
     * Gets the radius of the given instance of the circle
     * @return the radius of the current circle
     */
    public int getRadius() {
        return radius;
    }

    /**
     * Sets the radius to the argument in the method.
     * @param radius the radius that the user wants to set.
     */
    public void setRadius(int radius) {
        this.radius = radius;
    }

    /**
     * Draws the circle starting from the center of the circle, expanding by r (radius)
     * @param g the graphical component
     * @param c the color of the circle
     */
    @Override
    public void draw(Graphics g, Color c) {
        g.setColor(c);
        g.fillOval((int)p[0].getX(), (int)p[0].getY(), radius*2, radius*2);
    }
    
}
