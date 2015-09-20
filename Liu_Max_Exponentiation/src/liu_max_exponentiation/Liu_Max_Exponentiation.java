/*
 * Max Liu
 * December 10, 2012
 * Liu_Max_Exponentiation
 * ICS3U
 * Mister Lim
 */
package liu_max_exponentiation;

import java.util.Scanner;

/**
 *
 * @author Max
 */
public class Liu_Max_Exponentiation {

    static double powerOf(int f, int p){
        //multiply f by f p times.
        int result = f;
        for (int i = 1; i < p; i++) {
            result *= f;
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        int first, power;
        //Store values of numbers
        System.out.println("Enter the number to be exponentiated.");
        first = myScanner.nextInt();
        System.out.println("Enter the power you wish to raise your number to.");
        power = myScanner.nextInt();
        //print out the results
        System.out.println("Your result is: " + powerOf(first, power));
    }
}
