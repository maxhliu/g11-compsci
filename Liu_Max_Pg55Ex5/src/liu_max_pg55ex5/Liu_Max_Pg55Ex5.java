/*
 * October 27, 2012
 * Liu_Max_Pg55Ex5
 * ICS3U
 * Mister Lim
 */
package liu_max_pg55ex5;

import javax.swing.JOptionPane;

/**
 *
 * @author Max
 */
public class Liu_Max_Pg55Ex5 {

    /**
     * This program prompts for the date, then display it in standard format (October 27, 2012).
     */
    public static void main(String[] args) {
        //prompt and store for the year
        String input;
        input = JOptionPane.showInputDialog("Enter year.", "Please use all digits of the year.");
        int year = Integer.parseInt(input);
        //prompt and store for the month
        input = JOptionPane.showInputDialog("Enter month.", "Please use the month number.");
        int month = Integer.parseInt(input);
        //prompt and store for the day
        input = JOptionPane.showInputDialog("Enter day.", "Please use the day number in that month.");
        int day = Integer.parseInt(input);
        //use a switch statement to choose which month it is
        String monthWord;
        switch (month) {
            case 1:
                monthWord = "January";
                break;
            case 2:
                monthWord = "February";
                break;
            case 3:
                monthWord = "March";
                break;
            case 4:
                monthWord = "April";
                break;
            case 5:
                monthWord = "May";
                break;
            case 6:
                monthWord = "June";
                break;
            case 7:
                monthWord = "July";
                break;
            case 8:
                monthWord = "August";
                break;
            case 9:
                monthWord = "September";
                break;
            case 10:
                monthWord = "October";
                break;
            case 11:
                monthWord = "November";
                break;
            case 12:
                monthWord = "December";
                break;
            default:
                monthWord = "not a proper month";
                break;
        }
        //display the date.
        JOptionPane.showMessageDialog(null, "The Date is: " + monthWord + " " + day + ", " + year);
    }
}
