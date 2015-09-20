/*
 * Max Liu
 * December 2, 2012
 * Liu_Max_TimeConverter
 * ICS3U
 * Mister Lim
 */
package liu_max_timeconverter;

import java.util.Scanner;

/**
 * This is a generic time converter, usable from seconds to years, excluding
 * months, since the length of a month changes. First, it asks the user to input
 * a first number, then their first unit, then their second unit. The user can
 * input their units as strings, and the program will convert it for them. Using
 * an array of unit sizes, it uses a for loop to convert the number, in the
 * first unit, into the second unit.
 */
public class Liu_Max_TimeConverter {

    // The number of said units in the next higher unit. 0 is seconds, 5 is years.
    static double[] units = {
        60, // sec 
        60, // min
        24, // hour
        7, // day
        (365.0 / 7) // week
    };

    // This translates the user's string representing a unit into a number. If it
    // doesn't match, it will return -1.
    static int translate(String text) {
        switch (text) {
            case "seconds":
                return 0;
            case "minutes":
                return 1;
            case "hours":
                return 2;
            case "days":
                return 3;
            case "weeks":
                return 4;
            case "years":
                return 5;
            default:
                return -1;
        }
    }

    // Convert the units given the first number, unit, and second unit.
    static double convert(double n1, int u1, int u2) {

        //If the first unit is equal to the second unit, no conversion is necesary.
        if (u1 == u2) {
            return n1;
        }

        double r = n1;

        //Convert to seconds. The i-- is in the loop because the for loop checks
        //the condition the first time it runs.
        for (int i = u1; i >= 1;) {
            i--;
            r *= units[i];
        }

        //Convert to the second unit.
        for (int j = 0; j < u2; j++) {
            r /= units[j];
        }
        //Return the result.
        return r;
    }

    public static void main(String[] args) {
        
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Enter your first number.");
        
        //Initialize variables.
        double num1;
        int unit1, unit2;
        String firstUnit, secondUnit;
        
        // If the first number is not positive, force the user to enter it again.
        do {
            System.out.println("Please enter a positive number.");
            num1 = myScanner.nextDouble();
        } while (num1 <= 0);

        // If the first unit is not valid, force the user to enter it again.
        do {
            System.out.println("Enter a valid first unit.");
            firstUnit = myScanner.next().toLowerCase();
            unit1 = translate(firstUnit);
        } while (unit1 == -1);

        // If the second unit is not valid, force the user to enter it again.
        do {
            System.out.println("Enter a valid second unit.");
            secondUnit = myScanner.next().toLowerCase();
            unit2 = translate(secondUnit);
        } while (unit2 == -1);

        // Display the converted numbers.
        System.out.println(num1 + " " + firstUnit + "(s) equals " + convert(num1, unit1, unit2) + " " + secondUnit + "(s).");

    }
}
