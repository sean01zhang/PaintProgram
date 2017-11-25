/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shape;

import java.awt.Color;
import java.awt.Graphics;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 *
 * @author seanz
 */
public class Point implements Shape {
    
    private double x,y;

    /**
     * Point constructor. If no arguments are given, it will initialize the
     * point in the origin
     */
    public Point() {
        x = 0;
        y = 0;
    }

    /**
     * Point constructor. Creates a 2D point.
     *
     * @param x the x value of the 2D point.
     * @param y the y value of the 2D point.
     */
    public Point(double x, double y) {
        //asssigns x and y arguments to the x and y varaibles in the instance of this class.
        this.x = x;
        this.y = y;
    }

    /**
     * Scales the point away from the origin.
     *
     * @param w the scaling factor.
     */
    @Override
    public void scale(double w) {
        x *= w;
        y *= w;
    }
    
    /**
     * Scales the point away from the specified point.
     * @param w the scaling factor.
     * @param xOrig the x value of the 2D point
     * @param yOrig the y value of the 2D point.
     */
    @Override
    public void scale(double w, double xOrig, double yOrig) {
        double tx = x - xOrig;
        double ty = y - yOrig;
        x = tx * w + xOrig;
        y = ty * w + yOrig;
    }

    /**
     * Shifts the point by a certain x value and y value.
     *
     * @param xShift The shifting factor on the x value
     * @param yShift The shifting factor on the y value
     */
    @Override
    public void translate(int xShift, int yShift) {
        x += xShift;
        y += yShift;
    }

    /**
     * Rotates a point around a certain point.
     *
     * @param rad The radians that it will rotate by
     * @param xOrig The X value of where the point will rotate around
     * @param yOrig The Y value of where the point will rotate around
     */
    @Override
    public void rotate(double rad, double xOrig, double yOrig) {
        double tx = x - xOrig;
        double ty = y - yOrig;
        x = (tx * Math.cos(rad)) - (ty * Math.sin(rad)) + xOrig;
        y = (ty * Math.cos(rad)) + (tx * Math.sin(rad)) + yOrig;
    }

    /**
     * Rotates a point around the origin.
     *
     * @param rad The radians that it will rotate by
     */
    @Override
    public void rotate(double rad) {
        x = (x * Math.cos(rad)) - (y * Math.sin(rad));
        y = (y * Math.cos(rad)) + (x * Math.sin(rad));
        
        

    }

    /**
     * Returns if the object is equal to this object in terms of points.
     *
     * @param o The object that is taken in
     * @return Returns true if the object is equal to this point.
     */
    @Override
    public boolean equals(Object o) {
        Point p = (Point) o;
        if (x == p.x && y == p.y) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * OBSOLETE: A point cannot have an area.
     *
     * @return Returns zero, since points have no area
     */
    @Override
    public double area() {
        return 0;
    }

    /**
     * This reflects in the x or y axis based on the enum.
     */
    @Override
    public void reflect(AXIS AXIS) {
        switch (AXIS) {
            case XAXIS:
                this.x = -x;
                break;
            case YAXIS:
                this.y = -y;
                break;
        }

    }
    
    /**
     * Gets the x value of the 2D point
     * @return returns the x value of the 2D point
     */
    public double getX() {
        return x;
    }

    /**
     * Sets the x value of the 2D point
     * @param x the value you want to set the x value of the 2D point to.
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * Gets the y value of the 2D point
     * @return returns y the value of the 2D point
     */
    public double getY() {
        return y;
    }

    /**
     * Sets the y value of the 2D point
     * @param y the value you want to set the y value of the 2D point to.
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * Adds a point to the point
     * @param p the point that will be set in this instance of this class
     */
    public void add(Point p) {
        x=p.getX();
        y=p.getY();
    }
    
    /**
     * Gets the distance of the point from a specific point.
     * @param p the point where the distance ends
     * @return returns the distance in decimal
     */
    public double distance(Point p) {
        return (Math.sqrt(Math.pow((x-p.getX()), 2)+Math.pow(y-p.getY(),2)));
    }
    
    /**
     * Gets the distance of the point from a specific point.
     * @param x2 determines the x value of the 2D point
     * @param y2 determines the y value of the 2D point
     * @return returns the distance in decimal
     */
    public double distance(int x2, int y2) {
        return (Math.sqrt(Math.pow((x-x2), 2)+Math.pow(y-y2,2)));
    }
    
    /*
    public Point extrapolate(Point p1, Point p2, int distance) {
        //finds the slope of p1 and p2
        double slope = (p1.getY()-p2.getY())/(p1.getX()-p2.getX());
        ;
    }
    */
    
    /**
     * Returns the distance of the point to the origin
     * @return returns the distance of the point from the origin.
     */
    public double length() {
        return distance(0, 0);
    }
    
    /**
     * Converts the instance of the class into a string whenever it is needed to be printed.
     * @return returns the string coordinates.
     */
    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("0");
        df.setRoundingMode(RoundingMode.HALF_UP);
        return ("("+df.format(x) + "," + df.format(y)+")");
    }

    /**
     * Draws the point to the canvas
     * @param g the graphics parameter
     * @param c the color of the point
     */
    @Override
    public void draw(Graphics g, Color c) {
        g.setColor(c);
        g.fillOval((int)x, (int)y, 2, 2);
    }
    
    /**
     * Gets itself and returns it
     * @return returns the current instance of the object.
     */
    @Override
    public Point getPoint() {
        return this;
    }
    
    /**
     * Checks if the object contains the argument object
     * @param o the argument object
     * @return either true or false if it contains it or not.
     */
    @Override
    public boolean contains(Object o) {
        if(o.equals(this)) {
            return true;
        } else {
            return false;
        }
    }
    
    
    
}
