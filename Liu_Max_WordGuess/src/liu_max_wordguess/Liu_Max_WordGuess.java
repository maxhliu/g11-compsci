/*
 * Max Liu
 * October 30, 2012
 * Liu_Max_WordGuess
 * ICS3U
 * Mister Lim
 */
package liu_max_wordguess;

import java.util.Scanner;

/**
 *
 * @author Max
 */
public class Liu_Max_WordGuess {

    /**
     * @param args the command line arguments
     */
    /**
     * This method is a custom method which checks which letter have been
     * guessed correctly, and prints dashes for the ones which have not.
     */
    static void output(boolean first, boolean second, boolean third, boolean fourth, boolean fifth) {

        if (first) {
            System.out.print("B");
        } else {
            System.out.print("-");
        }
        if (second) {
            System.out.print("R");
        } else {
            System.out.print("-");
        }
        if (third) {
            System.out.print("A");
        } else {
            System.out.print("-");
        }
        if (fourth) {
            System.out.print("I");
        } else {
            System.out.print("-");
        }
        if (fifth) {
            System.out.println("N");
        } else {
            System.out.println("-");
        }
    }

    public static void main(String[] args) {

        System.out.println("WordGuess Game.");

        /**
         * Initialize variables, such as whether the letters have been guessed,
         * if the game is over or won, the number of guesses, and the input from
         * the keyboard.
         */
        boolean b = false, r = false, a = false, i = false, n = false, gameOver = false, win = false;
        byte guesses = 0;
        String input;

        //Use custom guessed letters method.
        output(b, r, a, i, n);

        while (!gameOver) {

            System.out.print("Enter a letter (! to guess entire word): ");

            //Check whether the user wants to guess the whole word.
            Scanner keyboard = new Scanner(System.in);
            input = keyboard.next();

            if (input.equals("!")) {

                System.out.println("\n\nWhat is your guess?");
                input = keyboard.next();

                //If you guessed "brain", you win. If not, you lose.
                if (input.equalsIgnoreCase("brain")) {

                    gameOver = true;
                    win = true;

                } else {

                    gameOver = true;
                }

            } else {

                /**
                 * If you guess a letter in "brain", the corresponding variable
                 * is changed to be true. If all of them have been guessed
                 * correctly, you win the game.
                 */
                if (input.equalsIgnoreCase("b")) {

                    b = true;

                } else if (input.equalsIgnoreCase("r")) {

                    r = true;

                } else if (input.equalsIgnoreCase("a")) {

                    a = true;

                } else if (input.equalsIgnoreCase("i")) {

                    i = true;

                } else if (input.equalsIgnoreCase("n")) {

                    n = true;
                }

                guesses++;
                output(b, r, a, i, n);

                if (b && r && a && i && n) {

                    gameOver = true;
                    win = true;
                }
            }
        }
        
        //Display a winning or losing message, depending on whether the user has
        //won the game.
        if (win) {

            System.out.println("You won!\nThe secret word is BRAIN\nYou made " + guesses + " guesses.");

        } else {

            System.out.println("You lost!!\nThe secret word is BRAIN\nYou made " + guesses + " guesses.");
        }
    }
}
