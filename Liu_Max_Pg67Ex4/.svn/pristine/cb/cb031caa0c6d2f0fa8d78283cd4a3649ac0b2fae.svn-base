/*
 * Max Liu
 * November 1, 2012
 * Liu_Max_Pg67Ex4
 * ICS3U
 * Mister Lim
 */
package liu_max_pg67ex4;

import java.util.Scanner;

/**
 *
 * @author Max
 */
public class Liu_Max_Pg67Ex4 {

    /**
     * This program displays the smallest power of two that is less than or
     * equal to a given number.
     */
    public static void main(String[] args) {
        //scan for the number
        Scanner myScanner = new Scanner(System.in);
        String input = myScanner.next();
        //parse the number into a double
        double number = Double.parseDouble(input);
        //round down the base 2 logarithm of the number and store it
        double power2 = Math.ceil(Math.log(number)/Math.log(2));
        //display the message
        System.out.println("The smallest power of 2 is: " + power2 + ". 2^" + power2 + " = " + Math.pow(2, power2) + " >= " + number);
        //display x where 2^x = number
        System.out.println(Math.log(number)/Math.log(2));
    }
}
