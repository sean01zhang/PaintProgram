/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shape;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Arrays;

/**
 *
 * @author seanz
 */
public class Polygon implements Shape{    
    protected Point[] p;

    
    /**
     * Constructor for polygon class
     *
     * @param p the points that are in the polygon
     * @param numOfVertex
     */
    public Polygon(Point[] p,int numOfVertex) {
        this.p= new Point[numOfVertex];
        for(int i=0;i<p.length;i++) {
            this.p[i] = new Point();
            this.p[i].add(p[i]);
        }
    }
    
    /**
     * Constructor for the polygon class, specifically for the triangle shape.
     * @param x the x coordinate for where the top left corner point of the triangle is.
     * @param y the y coordinate for where the top left corner point of the triangle is.
     * @param width the width of the triangle.
     * @param height the height of the triangle.
     */
    public Polygon(int x, int y, int width, int height) {
        p=new Point[3];
        
        p[0] = new Point(x+(width/2),y);
        p[1] = new Point(x, y+height);
        p[2] = new Point(x+width, y+height);
    }
    
    /**
     * Constructor for quadrilaterals
     * 
     * @param x the x coordinate for where the top left corner point of the rectangle is.
     * @param y the y coordinate for where the top left corner point of the rectangle is.
     * @param w the width of the rectangle
     * @param h the height of the rectangle.
     */
    public Polygon(double x, double y, double w, double h) {
        p=new Point[4];
        p[1] = new Point(x, y);
        p[2] = new Point(x + w, y);
        p[0] = new Point(x, y - h);
        p[3] = new Point(x + w, y - h);
    }

    /**
     * Translates the polygon's points by a certain amount.
     *
     * @param xShift the distance the user wants to shift the polygon
     * horizontally
     * @param yShift the distance the user wants to shift the polygon
     * vertically.
     */
    @Override
    public void translate(int xShift, int yShift) {
        for (int i = 0; i < p.length; i++) {
            p[i].translate(xShift, yShift);
        }
    }

    /**
     * Rotates the polygon around the origin
     *
     * @param rad the amount you want to rotate the polygon in radians.
     */
    @Override
    public void rotate(double rad) {
        for (int i = 0; i < p.length; i++) {
            p[i].rotate(rad);
        }
    }

    /**
     * Scales the polygon by a factor of w from the origin
     *
     * @param w the scale factor.
     */
    @Override
    public void scale(double w) {
        for (int i = 0; i < p.length; i++) {
            p[i].scale(w);
        }
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
        for (int i = 0; i < p.length; i++) {
            p[i].scale(w, xOrig, yOrig);
        }
    }

    /**
     * Rotates the polygon around a specified point
     *
     * @param rad the amount that the polygon is being rotated by in radians
     * @param xOrig the x value of the 2D point
     * @param yOrig the y value of the 2D point
     */
    @Override
    public void rotate(double rad, double xOrig, double yOrig) {
        for (int i = 0; i < p.length; i++) {
            p[i].rotate(rad, xOrig, yOrig);
        }
    }

    /**
     * Reflects the polygon off a specific axis based on the enum.
     *
     * @param AXIS
     */
    @Override
    public void reflect(AXIS AXIS) {
        for (int i = 0; i < p.length; i++) {
            p[i].reflect(AXIS);
        }
    }

    /**
     * Gets the array of points in the polygon
     *
     * @return the array of points
     */
    public Point[] getPoints() {
        return p;
    }

    /**
     * Prints the coordinates of the polygon
     * @return returns the string of the polygon's 4 points
     */
    @Override
    public String toString() {
        return Arrays.toString(p);
    }
    
    /**
     * Returns an array of integers for all the x values of the polygon.
     * @return an array of integers for all the x values of the polygon
     */
    public int[] toIntXArray() {
        //creates a temporary int array for all the stored x values.
        int[] x = new int[p.length];
        //loops through all the points in the point array and assigns the x value of the point to 
        //the corresponding index in the temporary int array.
        for(int i=0;i<p.length;i++) {
            x[i] = (int)p[i].getX();
        }
        //returns the integer array.
        return x;
    }

    /**
     * Gives all the y values of the 2D points in the polygon
     * @return an array of integers for all the y values of the polygon.
     */
    public int[] toIntYArray() {
        //creates a temporary int array for all the stored y values.
        int[] y = new int[p.length];
        //loops through all the points in the point array and assigns the x value of the point to
        //the corresponding index of the temporary int array.
        for(int i=0;i<p.length;i++) {
            y[i] = (int)p[i].getY();
        }
        //returns the temporary integer array.
        return y;
    }

    /**
     * Area method. Returns zero. Has not been implemented yet.
     * @return zero, has not been implemented yet in polygon class.
     */
    @Override
    public double area() {
        return 0;
    }
    
    /**
     * Gets a point from the polygon
     * @return the point at p[1]
     */
    @Override
    public Point getPoint() {
        return p[1];
    }

    /**
     * Draws the polygon
     * @param g the graphical component
     * @param c the color of the polygon.
     */
    @Override
    public void draw(Graphics g, Color c) {
        g.setColor(c);
        g.fillPolygon(toIntXArray(), toIntYArray(),p.length);
    }

    /**
     * Returns true or false if the current object contained the argument object.
     * @param o the argument object
     * @return true or false if it is contained
     */
    @Override
    public boolean contains(Object o) {
        int maxX=-1000,maxY=-1000,minX=1000,minY=1000;
        //find maxY and maxX and mixX and minY
        for(int i=0;i<p.length;i++) {
            if(p[i].getX()>maxX) {
                maxX = (int)p[i].getX();
            } else if(p[i].getX()<minX) {
                minX = (int)p[i].getX();
            }
            
            if(p[i].getY()>maxY) {
                maxY = (int)p[i].getY();
            } else if(p[i].getY()<minY) {
                minY = (int)p[i].getY();
            }
            
        }
        
        //see if the point is within these bounds:
        if(((Point)o).getX() < maxX && ((Point)o).getX() > minX && ((Point)o).getY() < maxY && ((Point)o).getY() > minY) {
            return true;
        } else {
            return false;
        }
    }
    
}
