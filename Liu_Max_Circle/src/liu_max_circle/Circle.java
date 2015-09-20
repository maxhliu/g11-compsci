/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package liu_max_circle;

/**
 *
 * @author Max
 */
public class Circle {
    
    private static final double PI = 3.141592654;
    private double radius;
    public Circle (double r) {
        radius = r;        
    }
    public Circle() {
        radius = 1;
    }
    public double getRadius() {
        return radius;
    }
    public void setRadius(double r) {
        radius = r;
    }
    public double circumference(){
        return 2*PI*radius;
    }
    public static void displayAreaFormula() {
        System.out.println("The formula for the area of a circle is A = PI * r * r.");
    }
}
