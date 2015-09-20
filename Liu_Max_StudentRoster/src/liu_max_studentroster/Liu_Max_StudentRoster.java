/*
 * Max Liu
 * December 13, 2012
 * Liu_Max_StudentRoster
 * ICS3U
 * Mister Lim
 */
package liu_max_studentroster;

import java.util.Scanner;

/**
 *
 * @author Max
 */
public class Liu_Max_StudentRoster {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        //prompt user to enter the number of students
        System.out.println("Please enter the number of students in the class.");
        int number = myScanner.nextInt();
        String[] students = new String[number];
        //This line of code is useless. It is used because of some weird glitch
        //where the first myScanner.nextLine() returns a null value.
        students[0] = myScanner.nextLine();
        //Enter in all the names of the students
        for (int i = 0; i < number; i++) {
            System.out.println("Please enter the name of Student #" + (i + 1));
            students[i] = myScanner.nextLine();
        }
        //print out student roster, then the names of the students
        System.out.println("\r\nStudent Roster\r\n");
        for (int i = 0; i < number; i++) {
            System.out.println("Student #" + i + "\t:" + students[i]);
        }
    }
}
