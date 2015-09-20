/*
 * Max Liu
 * December 19, 2012
 * Liu_Max_NameBackwards
 * ICS3U
 * Mister Lim
 */
package Liu_Max;

import java.util.Scanner;

/**
 *
 * @author Max
 */
public class Liu_Max_NameBackwards {

    /**
     * I believe this to be my second shortest program after "Hello World".
     * It has only three lines and a scanner import.
     */
    public static void main(String[] args) {
        //prompt user for their name
        System.out.println("Enter your name: it will be displayed backwards.");
        //set up a new scanner
        Scanner myScanner = new Scanner(System.in);
        //\u202e is a unicode escape code. This character is used in other languages
        //where text is read from right to left, and it forces text to change direction.
        //this line prints out this special character and their input, causing it
        //to be displayed backwards.
        System.out.println("\u202e" + myScanner.nextLine());
    }
}