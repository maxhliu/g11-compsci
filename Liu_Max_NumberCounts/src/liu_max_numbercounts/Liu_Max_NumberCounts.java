/*
 * Max Liu
 * December 18, 2012
 * Liu_Max_NumberCounts
 * ICS3U
 * Mister Lim
 */
package liu_max_numbercounts;

import java.util.Scanner;

/**
 *
 * @author Max
 */
public class Liu_Max_NumberCounts {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //record the number
        System.out.println("Enter an natural number to have its digits counted.");
        Scanner myScanner = new Scanner(System.in);
        long number = myScanner.nextLong();
        //Create an array with the same number of elements as the number has digits.
        //This is basically converting the number into an array of ints.
        int[] uber = new int[(int) Math.log10(number) + 1];
        //fill the array will the correct digits.
        for (int b = 0; b < uber.length; b++) {
            uber[b] = (int) (number % 10);
            number /= 10;
        }
        //create a digit frequency array.
        int[] freq = new int[10];
        //start a for loop to check for each one of the digits
        for (int i = 0; i < 10; i++) {
            //in this for loop, check each digit
            for (int b = 0; b < uber.length; b++) {
                //check if i (each digit from 0-9) is equal to b (each of the number's digits)
                if (i == uber[b]) {
                    //if so, add one onto the frequency
                    freq[i]++;
                }
            }
            //print out the result, since we are done with this digit, and move onto the next digit.
            System.out.println(i + ": " + freq[i]);
        }
    }
}
