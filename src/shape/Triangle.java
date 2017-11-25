/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shape;

/**
 *
 * @author seanz
 */
public class Triangle extends Polygon {
    /**
     * Constructor for the triangle class
     * @param p the 2D point where the triangle originates from.
     */
    public Triangle(Point[] p) {
        super(p, 3);
    }
    
    /**
     * Constructor for the triangle class where the creation of the three points were done with the given variables
     * @param x the x value of the 2D point of the top left corner of the triangle "hitbox"
     * @param y the y value of the 2D point of the top left corner of the triangle "hitbox"
     * @param width the width of the base of the triangle
     * @param height the height of the triangle
     */
    public Triangle(int x, int y, int width, int height) {
        super(x,y,width,height);
    }

    /**
     * Gets the area of the triangle
     * @return returns the area of the triangle
     */
    @Override
    public double area() {
        //distance between point 0 and 2 were found, then multiplied by the distance from the line to point 1
        return ((p[0].distance(p[2]))*Math.abs((p[1].getX()-p[0].getX())*((p[2].getY()-p[0].getY())-(p[1].getY()-p[0].getY())*(p[2].getX()-p[0].getX()))/(p[0].distance(p[2]))));
    }

    /**
     * Gets the width of the base of the triangle
     * @return returns the base value of the triangle
     */
    public int getWidth() {
        return (int)(p[0].distance(p[2]));
    }

    /**
     * Gets the height of the triangle from the base.
     * @return the height of the triangle
     */
    public int getHeight() {
        return (int)Math.abs((p[1].getX()-p[0].getX())*((p[2].getY()-p[0].getY())-(p[1].getY()-p[0].getY())*(p[2].getX()-p[0].getX()))/(p[0].distance(p[2])));
    }
    
}
