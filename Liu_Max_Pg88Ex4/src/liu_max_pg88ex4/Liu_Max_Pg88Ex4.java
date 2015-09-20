/*
 * Max Liu
 * December 10, 2012
 * Liu_Max_Pg88Ex4
 * ICS3U
 * Mister Lim
 */
package liu_max_pg88ex4;

import java.util.Scanner;

/**
 *
 * @author Max
 */
public class Liu_Max_Pg88Ex4 {

    //draw a bar of asterices of length l.
    static void drawBar(int l) {
        for (int i = 0; i < l; i++) {
            System.out.print("*");
        }
    }

    //draw a bar of spaces of length l.
    static void addSpaces(int l) {
        for (int i = 0; i < l; i++) {
            System.out.print(" ");
        }
    }
    
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Enter the height.");
        //store the height.
        int height = myScanner.nextInt();
        //run this a number of times equal to the height.
        for (int i = 1; i <= height; i++) {
            //add spaces equal to height minus the current value of i. The value
            //of i will be the width of the rectangle consisting of the centre
            //of the triangle and everything to the left of it.
            addSpaces(height-i);
            //draw the row of asterices.
            drawBar(i);
            //draw the rest of the triangle.
            drawBar(i-1);
            //move on to the next line.
            System.out.println("");
        }
    }
}
