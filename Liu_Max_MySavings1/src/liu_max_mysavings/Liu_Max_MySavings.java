/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package liu_max_mysavings;

import java.util.Scanner;

/**
 *
 * @author Max
 */
public class Liu_Max_MySavings {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean quit = false;
        while (!quit) {
            System.out.print("1. Show total in bank\r\n2. Add a penny.\r\n3. Add a nickel.\r\n4. Add a dime.\r\n5. Add a quarter\r\n6. Take money out of bank.\r\nEnter 0 to quit\r\nEnter your choice: ");
            Scanner sc = new Scanner(System.in);
            switch (sc.nextInt()) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 0:
                    quit = true;
                    break;
                default:
                    System.out.println("Enter a valid input.");
                    break;
            }
        }
        System.out.println("Goodbye.");
    }
}
