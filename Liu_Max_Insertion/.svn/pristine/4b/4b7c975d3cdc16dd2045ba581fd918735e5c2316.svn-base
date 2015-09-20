/*
 * Max Liu
 * March 25, 2013
 * Liu_Max_Insertion
 * ICS3U
 * Mister Lim
 */
package liu_max_insertion;

import java.util.Scanner;

/**
 *
 * @author Max
 */
public class Liu_Max_Insertion {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter in the number of numbers in the list.");
        //Enter in the length of the list
        int length = sc.nextInt();
        //Create a temporary variable for switching two values
        double temp;
        //create the list array
        double[] list = new double[length];
        //prompt them to enter their numbers
        for (int i = 0; i < length; i++) {
            System.out.println("Enter a number.");
            //record their number
            list[i] = sc.nextDouble();
        }
        //create variables for storong the biggest number and its index.
        int index;
        double biggest;
        
        //run the sort 1 time for each element of the array
        for (int unsorted = list.length; unsorted > 0; unsorted--) {
            //reset the index and biggest variables
            index = 0;
            biggest = list[0];
            //start from the beginning of the array, then move on to each unsorted element
            for (int i = 0; i < unsorted; i++){
                //if biggest is smaller than this element, biggest is now this element
                if (biggest < list[i]) {
                    //record the index for switching purposes
                    index = i;
                    biggest = list[i];
                }
            }
            //switch biggest element with the last element
            temp = list[unsorted-1];
            list[unsorted-1] = biggest;
            list[index] = temp;
        }
        
        //print out the numbers
        for (double c : list) {
            System.out.print(c + " ");
        }
        System.out.println("");
    } 
}
