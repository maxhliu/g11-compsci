/*
 * Max Liu
 * December 12, 2012
 * Liu_Max_Pg87Ex2
 * ICS3U
 * Mister Lim
 */
package liu_max_pg87ex2;

import java.util.Scanner;

/**
 *
 * @author Max
 */
public class Liu_Max_Pg87Ex2 {

    //Create an array of converter constants. These are the number you must
    //multiply or divide by to convert.
    static double[] units = {
        2.54, // inch centi
        30, // feet centi
        0.91, // yard metre
        1.6, // mile kilo
    };

    static double convert(double n, int u) {
        //k, the number we are multiplying or dividing by, is a certain value in
        //the array.
        double k = units[(int) (u % 4 - 1)];
        //return the correct value. All choices from 5 are just 1-4 but reversed.
        if (u >= 5) {
            return n / k;
        } else {
            return n * k;
        }
    }

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.print("Enter a number:");
        //record the number
        double number = myScanner.nextDouble();
        //print out instructions
        System.out.println("\r\nConvert:");
        System.out.println("1. Inches to Centimeters\t5. Centimeters to Inches");
        System.out.println("2. Feet to Centimeters   \t6. Centimeters to Feet");
        System.out.println("3. Yards to Meters        \t7. Meters to Yards");
        System.out.println("4. Miles to Kilometers     \t8. Kilometers to Miles\r\n");
        System.out.print("Enter your Choice: ");
        //record the unit conversion
        int unit = myScanner.nextInt();
        //print out the result
        System.out.println("\r\n" + number + " inches equals " + convert(number, unit) + " centimeters.");
    }
}
