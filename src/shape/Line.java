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
public class Line implements Shape{
    private Point p1;
    private Point p2;
    
    /**
     * Constructor for Line class
     * @param p1 first point of the line
     * @param p2 second point of the line
     */
    public Line(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
        
    }
    
    /**
     * Constructor for Line Class
     * @param x1 the x value of the first 2D point in the line
     * @param y1 the y value of the first 2D point in the line
     * @param x2 the x value of the second 2D point in the line
     * @param y2 the y value of the second 2D point in the line
     */
    public Line(int x1, int y1, int x2, int y2) {
        p1 = new Point(x1,y1);
        p2 = new Point(x2,y2);
    }
    
    /**
     * Scales the line from the origin
     * @param w the scaling factor
     */
    @Override
    public void scale(double w) {
        p1.scale(w);
        p2.scale(w);
    }

    /**
     * Scales the line from a specified point.
     * @param w the scaling factor
     * @param xOrig the x value of the 2D point that the line is scaling from
     * @param yOrig the y value of the 2D point that the line is scaling from
     */
    @Override
    public void scale(double w, double xOrig, double yOrig) {
        p1.scale(w, xOrig, yOrig);
        p2.scale(w, xOrig, yOrig);
    }

    /**
     * Shifts the line by a certain amount in the two directions
     * @param xShift how much the line will shift horizontally
     * @param yShift how much the line will shift vertically
     */
    @Override
    public void translate(int xShift, int yShift) {
        p1.translate(xShift, yShift);
        p2.translate(xShift, yShift);
    }

    /**
     * Rotates the line around the origin by a certain amount 
     * @param rad the amount in radians that the user wants to rotate the line
     */
    @Override
    public void rotate(double rad) {
        p1.rotate(rad);
        p2.rotate(rad);
    }

    /**
     * Rotates the line around a specified point by a certain amount
     * @param rad the amount in radians that the user wants to rotate the line
     * @param xOrig the x value of the 2D point that the line is rotating from
     * @param yOrig the y value of the 2D point that the line is rotating from
     */
    @Override
    public void rotate(double rad, double xOrig, double yOrig) {
        p1.rotate(rad, xOrig, yOrig);
        p2.rotate(rad, xOrig, yOrig);
    }

    /**
     * Gives the area of the line. 
     * @return returns zero, since lines do not have an area.
     */
    @Override
    public double area() {
        return 0;
    }

    /**
     * Reflects the line over an axis depending on the enum
     * @param AXIS 
     */
    @Override
    public void reflect(AXIS AXIS) {
        p1.reflect(AXIS);
        p2.reflect(AXIS);
    }

    /**
     * Gets the first point on the line
     * @return returns the first point
     */
    public Point getPoint() {
        return p1;
    }
    
    /**
     * Sets the first point on the line
     * @param p1 the point that the line will start on
     */
    public void setP1(Point p1) {
        this.p1 = p1;
    }

    /**
     * Gets the second point on the line
     * @return returns the second point
     */
    public Point getP2() {
        return p2;
    }
    
    /**
     * Sets the second point on the line
     * @param p2 the point that the line will end on
     */
    public void setP2(Point p2) {
        this.p2 = p2;
    }

    /**
     * Draws the object to the canvas.
     * @param g the graphical component
     * @param c the color of the line.
     */
    @Override
    public void draw(Graphics g, Color c) {
        g.setColor(c);
        g.drawLine((int)p1.getX(), (int)p1.getY(), (int)p2.getX(), (int)p2.getY());
    }
    
    /**
     * Returns true or false if the current object contains the argument object
     * @param o the argument object
     * @return true or false depending if it is contained or not.
     */
    @Override
    public boolean contains(Object o) {
        //these are the bounds of the line "hit box"
        int minX,maxX,minY,maxY;
        
        //finds the bounds of the line
        if(p1.getX() > p2.getX()) {
            minX = (int)p2.getX();
            maxX = (int)p1.getX();
        } else {
            maxX = (int)p2.getX();
            minX = (int)p1.getX();
        }
        if(p1.getY() > p2.getY()) {
            minY = (int)p2.getY();
            maxY = (int)p1.getY();
        } else {
            maxY = (int)p2.getY();
            minY = (int)p1.getY();
        }
        
        //checks if it is within the "hitbox"
        if(((Point)o).getX() < maxX && ((Point)o).getX() >minX && ((Point)o).getY() < maxY && ((Point)o).getX() > minY) {
            return true;
        } else {
            return false;
        }
    }
    
}
