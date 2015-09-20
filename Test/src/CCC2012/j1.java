/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CCC2012;

import java.util.Scanner;

/**
 *
 * @author Max
 */
public class j1 {
    
    public static void j1() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the speed limit:\t");
        int sLimit = sc.nextInt();
        System.out.print("Enter the recorded speed of the car:\t");
        int speed = sc.nextInt();
        if (speed <= sLimit) {
            System.out.println("Congratulations, you are within the speed limit!");
        } else if (speed <= sLimit + 20) {
            System.out.println("You are speeding and your fine is $100.");
        } else if (speed <= sLimit + 30) {
            System.out.println("You are speeding and your fine is $270.");
        } else {
            System.out.println("You are speeding and your fine is $500.");
        }
    }
}
