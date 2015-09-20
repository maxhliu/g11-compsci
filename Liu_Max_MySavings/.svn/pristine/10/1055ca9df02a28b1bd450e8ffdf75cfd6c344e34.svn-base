/*
 * Max Liu
 * April 3, 2013
 * Liu_Max_MySavings
 * ICS3U
 * Mister Lim
 */
package liu_max_mysavings;

import java.util.Scanner;

/**
 * This program creates a virtual Piggy Bank, where a user can deposit pennies, nickels, dimes, or quarters.
 */
public class Liu_Max_MySavings {

    public static void main(String[] args) {
        //Initialize the quit variable to false, so the code actually runs
        boolean quit = false;
        //set up a scanner
        Scanner sc = new Scanner(System.in);
        //create a new instance of PiggyBank called bank. This is the PiggyBank that transactions will be made to.
        PiggyBank bank = new PiggyBank();
        //while quitting is not necessary
        while (!quit) {
            //prompt the user with instructions
            System.out.print("1. Show total in bank\r\n2. Add a penny.\r\n3. Add a nickel.\r\n4. Add a dime.\r\n5. Add a quarter\r\n6. Take money out of bank.\r\nEnter 0 to quit\r\nEnter your choice: ");
            //run code depending on the user's input
            switch (sc.nextInt()) {
                //show the balance of the bank
                case 1:
                    bank.showBalance(bank);
                    break;
                //deposit a penny, then show the balance of the bank
                case 2:
                    bank.deposit("penny");
                     bank.showBalance(bank);
                    break;
                 //deposit a nickel, then show the balance of the bank
                case 3:
                    bank.deposit("nickel");
                     bank.showBalance(bank);
                    break;
                //deposit a dime, then show the balance of the bank
                case 4:
                    bank.deposit("dime");
                    bank.showBalance(bank);
                    break;
                //deposit a quarter, then show the balance of the bank
                case 5:
                    bank.deposit("quarter");
                    bank.showBalance(bank);
                    break;
                //withdraw a certain amount of a coin, then show the amount withdrawn and updated balance
                case 6:
                    //show number of each coin in the bank
                    System.out.println("\r\nYou have: " + bank.getPennies() + " pennies, " + bank.getNickels() + " nickels, " + bank.getDimes() + " dimes, and " + bank.getQuarters() + " quarters left in the bank.");
                    System.out.println("Enter: \"<coin name> <quantity of coin to withdraw>\"");
                    //record the coin
                    String coin = sc.next();
                    //record the quantity of the coin
                    int quantity = sc.nextInt();
                    //display how much was withdrawn, doing it at the same time.
                    System.out.println("\r\nYou have withdrawn: ");
                    System.out.format("$%.2f%n", bank.withdraw(coin, quantity));
                    //display the remaining balance
                    System.out.print("Your balance is: ");
                    bank.showBalance(bank);
                    break;
                //quit
                case 0:
                    quit = true;
                    break;
                //if a valid input is not entered, prompt the user to do so
                default:
                    System.out.println("Enter a valid input.");
                    break;
            }
        }
        //farewell
        System.out.println("Goodbye.");
    }
}
