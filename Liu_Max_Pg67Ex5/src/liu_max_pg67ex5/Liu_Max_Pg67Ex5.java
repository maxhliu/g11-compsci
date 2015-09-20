/*
 * Max Liu
 * November 1, 2012
 * Liu_Max_Pg67Ex4
 * ICS3U
 * Mister Lim
 */
package liu_max_pg67ex5;

import java.util.Scanner;

/**
 *
 * @author Max
 */
public class Liu_Max_Pg67Ex5 {

    /**
     * This program counts the number of times when two consecutive numbers
     * are typed into the program. When zero is typed, the program ends.
     */
    public static void main(String[] args) {
        //set up a scanner and initialize variables
        Scanner myScanner = new Scanner(System.in);
        int number = myScanner.nextInt();
        int consecutive = 0, previous = 0, current = 1;
        //as long as the current number is not zero, shift the current number to the
        //previous number slot then compare them. If they are the same, then
        //add one to the consecutive number count.
        while (number != 0) {
            number = myScanner.nextInt();
            previous = current;
            current = number;
            if (previous == current) {
                consecutive++;
            }
        }
        //display the number of times there were two consecutive numbers
        System.out.println("There were " + consecutive + " times when there were two consecutive numbers.");
    }
}
