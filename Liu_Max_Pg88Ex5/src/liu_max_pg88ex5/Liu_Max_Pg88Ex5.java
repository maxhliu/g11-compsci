/*
 * Max Liu
 * December 10, 2012
 * Liu_Max_Pg88Ex5
 * ICS3U
 * Mister Lim
 */
package liu_max_pg88ex5;

import java.util.Scanner;

/**
 *
 * @author Max
 */
public class Liu_Max_Pg88Ex5 {

    static String getDollarAmount(int q, int d, int n, int p) {
        //add up the values of the coins
        double sum = 0.25 * q + 0.1 * d + 0.05 * n + 0.01 * p;
        //return a string to be printed.
        return "\r\nTotal: $" + sum;
    }

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        int q, d, n, p;
        //start recording values for each coin.
        System.out.println("Enter your total coins:\r\n");
        System.out.print("Quarters:");
        q = myScanner.nextInt();
        System.out.print("Dimes:");
        d = myScanner.nextInt();
        System.out.print("Nickels:");
        n = myScanner.nextInt();
        System.out.print("Pennies:");
        p = myScanner.nextInt();
        //print the string which was returned.
        System.out.println(getDollarAmount(q, d, n, p));
    }
}
