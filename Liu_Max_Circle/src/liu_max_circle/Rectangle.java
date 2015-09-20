/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package liu_max_circle;

/**
 *
 * @author Max
 */
public class Rectangle {

    private int length;
    private int width;

    Rectangle() {
        length = 5;
        width = 10;
    }

    Rectangle(int l, int w) {
        length = l;
        width = w;
    }

    public void setWidth(int w) {
        width = w;
    }

    public void setLength(int l) {
        length = l;
    }

    public int getWidth() {
        return width;
    }

    public int getLength() {
        return length;
    }

    public int area() {
        return length * width;
    }

    public int perimeter() {
        return 2 * (length + width);
    }
    public static void displayAreaFormula(){
        System.out.println("The formula for the area of a rectangle is A = l * w.");
    }
}
