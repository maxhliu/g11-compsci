/*
 * Max Liu
 * October 14, 2012
 * Liu_Max_Pg38Ex12
 * ICS3U
 * Mister Lim
 */
package liu_max_pg38ex12;

/**
 *
 * @author Max
 */

import java.util.Scanner;
public class Liu_Max_Pg38Ex12 {

    /**
     * This program converts a bearing into a plane number.
     */
    public static void main(String[] args) {
        //prompt for a bearing
        System.out.println("Enter a bearing from 0 to 360.");
        Scanner keyboard = new Scanner(System.in);
        //record the input
        String input = keyboard.next();
        //change it into an integer
        int bearing = Integer.parseInt(input);
        //create a long which is the plane number, and round any decimals
        long planeNumber = Math.round(bearing / 10.0);
        //print out the plane number
        System.out.println(planeNumber);
        
    }
}
