/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paintprogram;

import java.util.Scanner;
import shape.Line;
import shape.Point;
import shape.Rectangle;

/**
 *
 * @author seanz
 */
public class testing {
    public static void main(String[]args) {
        Scanner input = new Scanner(System.in);
        
        int x1=input.nextInt();
        int y1 = input.nextInt();
        
        int x2 = input.nextInt();
        int y2 = input.nextInt();
        
        Point p=new Point(x1,y1);
        Point p1=new Point(x2,y2);
        Rectangle r = new Rectangle(0,0,10,-10);
        
        
        
        System.out.println(r.contains(p));
    }
}
