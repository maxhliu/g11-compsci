/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package liu_max_circle;

/**
 *
 * @author Max
 */
public class Liu_Max_Circle {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Circle spot = new Circle(3);
        System.out.println("Circle radius = " + spot.getRadius());
        System.out.println("Circle circumference = " + spot.circumference());
        Circle.displayAreaFormula();
        
        Coin nickel = new Coin();
        nickel.flipCoin();
        if (nickel.showFace() == 1) {
            System.out.println("Heads up!");
        } else {
            System.out.println("Tails up!");
        }
        
        Rectangle normal = new Rectangle();
        Rectangle box = new Rectangle(6,6);
        normal.setLength(2);
        System.out.println(normal.area());
        System.out.println(box.perimeter());
        Rectangle.displayAreaFormula();
    }
}
