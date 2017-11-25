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
public interface Shape {
    public void scale(double w);
    public void scale(double w, double xOrig, double yOrig);
    public void translate(int xShift, int yShift);
    public void rotate(double rad);
    public void rotate(double rad, double xOrig, double yOrig);
    public boolean equals(Object o);
    public double area();
    public void reflect(AXIS AXIS);
    public String toString();
    public void draw(Graphics g, Color c);
    public Point getPoint();
    public boolean contains(Object o);
}
