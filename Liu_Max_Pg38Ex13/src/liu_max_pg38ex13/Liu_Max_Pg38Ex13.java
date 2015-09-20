/*
 * Max Liu
 * October 14, 2012
 * Liu_Max_Pg38Ex13
 * ICS3U
 * Mister Lim
 */
package liu_max_pg38ex13;

import java.util.Scanner;

/**
 *
 * @author Max
 */
public class Liu_Max_Pg38Ex13 {

    /**
     * This program converts a decimal hour value and converts it into hours, 
     * minutes, and seconds.
     */
    public static void main(String[] args) {
        //prompt to enter the time and record the input
        System.out.println("Enter a time in hours.");
        Scanner keyboard = new Scanner(System.in);
        String input = keyboard.next();
        //parse it into a double
        double time = Double.parseDouble(input);
        //takes the most amount of hours without going over (time is in hours)
        int hours = (int) time;
        //takes the most amount of mine without going over
        int minutes = (int) ((time - hours) * 60);
        //round the seconds that are left
        long seconds = Math.round((time - hours - minutes / 60.0) * 3600);

        //if it rounds up to 60, change it into a minute
        if (seconds == 60) {
            seconds = 0;
            minutes++;
        }
        //if the minutes round up to 60, change it into an hour.
        if (minutes == 60) {
            minutes = 0;
            hours++;
        }

        //print out the final time value
        System.out.println(time + " hours = " + hours + " hours, " + minutes + " minutes, and " + seconds + " seconds.");

    }
}
