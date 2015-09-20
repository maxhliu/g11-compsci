/*
 * Max Liu
 * November 2, 2012
 * Liu_Max_Pg68Ex5
 * ICS3U
 * Mister Lim
 */
package liu_max_pg68ex5;

import javax.swing.JOptionPane;

/**
 *
 * @author Max
 */
public class Liu_Max_Pg68Ex5 {

    /**
     * This program forces the user to enter a positive integer until they do.
     * It then shows their input, and how many times they tried. It uses JOptionPanes.
     */
    public static void main(String[] args) {
        //initialize intermediate string. It is used to store the input of the
        //JOptionPane.
        String intermediate = "";
        //Input is intermediate parsed into an integer.
        long input = 0;
        //Count is how many times the user has tried to enter a positive integer.
        int count = 0;
        //loop while input is not valid
        while (input <= 0) {
            try {
                //prompt to enter a positive integer, then store it
                intermediate = JOptionPane.showInputDialog("Input an integer greater than 0.");
                //parse it into an integer, and store it into input. If it is not an integer,
                //Integer.parseInt will throw a NumberFormatException.
                input = Long.parseLong(intermediate);
                //If it is not positive, also throw a NumberFormatException.
                if (input <= 0) {
                    throw new NumberFormatException();
                }
                //catch the exception. If it was thrown, then the input was not a positive integer.
            } catch (NumberFormatException e) {
                //Inform the user of their failure
                JOptionPane.showConfirmDialog(null, "You are an Ignoramus.");
            }
            //add one to tried count
            count++;
        }
        //display the input they entered
        JOptionPane.showMessageDialog(null, "Good job. You entered: " + input);
        //show how many times they tried.
        JOptionPane.showMessageDialog(null, "You tried " + count + " times to enter a positive integer.");
    }
}
