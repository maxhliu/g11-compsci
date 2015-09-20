/*
 * Max Liu
 * December 4, 2012
 * Liu_Max_DisplayBox1
 * ICS3U
 * Mister Lim
 */
package liu_max_displaybox1;

import java.util.Scanner;

/**
 *
 * @author Max
 */
public class Liu_Max_DisplayBox1 {

    /**
     * This program draws an empty box of asterices.It supports widths and lengths of 1.
     */
    
    //This method draws a bar. It takes a single int parameter, which determines
    //its length. It uses a for loop.
    static void drawBar(int l) {
        for (int i = 0; i < l; i++) {
            System.out.print("*");
        }
        System.out.println("");
    }
    //This method, drawBox, makes calls to drawBar.
    static void drawBox(int h, int w) {
        
        //Draw a bar. All boxes starting from 1x1 have this first bar. 1 is
        //subtracted from the h value to represent that one line has already been drawn.
        //A new int variable, l, is introduced to be a changing value of width.
        int l;
        drawBar(w);
        h--;
        for (int i = 0; i < h-1; i++) {
            //set length (l) to be width(w)
            l = w;
            //There is always at least one asterix
            System.out.print("*");
            l--;
            //Subtract one from length, but not width, since we need to reset
            //length for every row.
            for (int b = 0; b < w-2; b++) {
                //These are the spaces in the middle. They are printed out a number
                //of times equal to two less than the length. (equal to the width
                //minus the two borders)
                System.out.print(" ");
                //subtract one from l each time a space is printed.
                l--;                
            }
            //The for loop does not necessarily run. This happens when the width
            //is 1. In this case, no second border is needed.
            if (l > 0) {
                System.out.print("*");
            }
            //go onto the next line.
            System.out.println("");
        }
        // draw the bottom border unless the height is zero.
        if (h > 0) {
            drawBar(w);
        }
    }

    public static void main(String[] args) {
        //prompt for the height and set up a scanner
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Enter the heigth of the Box.");
        int num1 = myScanner.nextInt();
        //prompt for the width
        System.out.println("Enter the width of the Box");
        int num2 = myScanner.nextInt();
        //call drawBox method
        drawBox(num1, num2);
    }
}
