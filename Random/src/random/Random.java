/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package random;

import java.util.Scanner;

/**
 *
 * @author Max
 */
public class Random {

    /**
     * @param args the command line arguments
     */
    static void graph(int l, int w) {
        for (int i = 0; i < l; i++) {
            for (int b = 0; b < w; b++) {
                if (Math.random() >= 0.5) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println("");
        }
    }
    static void trip(int l, int w) {
        for (int i = 0; i < l; i++) {
            for (int b = 0; b < w; b++) {
                System.out.print((char)(Math.random()*94+34));
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Enter length.");
        int length = myScanner.nextInt();
        System.out.println("Enter width.");
        int width = myScanner.nextInt();
        trip(length, width);
    }
}
