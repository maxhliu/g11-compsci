/*
 * Max Liu
 * March 25, 2013
 * Liu_Max_Bubble
 * ICS3U
 * Mister Lim
 */
package liu_max_bubble;

import java.util.Scanner;

/**
 *
 * @author Max
 */
public class Liu_Max_Bubble {

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
        //run the sort length times so all of the numbers are sorted.
        for (int e = 0; e < length; e++) {
            for (int a = length - 1; a > 0; a--) {
                //compare the two numbers to see if they need to be switched
                if (list[a - 1] > list[a]) {
                    //switch the numbers
                    temp = list[a];
                    list[a] = list[a - 1];
                    list[a - 1] = temp;
                }
            }
        }
        //print out the numbers
        for (double c : list) {
            System.out.print(c + " ");
        }
        System.out.println("");
    }
}
