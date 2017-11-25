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
public class Square extends Rectangle {
    /**
     * The constructor for the square class
     * @param x the x value of the top left point in the square
     * @param y the y value of the top left point in the square
     * @param w the width of the square divided by 2
     */
    public Square(double x, double y, double w) {
        super(x-w, y, w*2, w*2);
    }
}
