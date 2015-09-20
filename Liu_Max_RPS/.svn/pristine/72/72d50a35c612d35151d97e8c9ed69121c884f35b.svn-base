/*
 * Max Liu
 * November 12, 2012
 * Liu_Max_RPS
 * ICS3U
 * Mister Lim
 */
package liu_max_rps;

import java.util.Scanner;

/**
 * This is a version of Rock Paper Scissors that incorporates the RoShamBo
 * game mechanic, where a player beats his/her/its opponent three times in a row
 * with the same throw. In this version, the player continues to play until they
 * throw SPOCK. The universe then proceeds to end, along with the current game.
 * There is a statistics table at the end, where they can see their statistics.
 * NOTE: A RoShamBo is considered as a win, and throwing SPOCK counts as a game,
 * but not as a win, tie, loss, or RoShamBo. Also, four consecutive wins counts
 * as two RoShamBos, five consecutive wins as three RoShamBos, and so on.
 */
public class Liu_Max_RPS {

    /**
     * This method checks if a RoShamBo has been performed, but not who 
     * performed it. It does this by checking if the Player's last three throws
     * are the same, and if the computer's last three throws are the same. Then,
     * it only checks to see that there is not a tie. If there is not a tie,
     * then a RoShamBo has been performed, and it returns a value of true.
     */
    static boolean roShamBo(int i, int ii, int iii, int ci, int cii, int ciii) {
        if ((i == ii && ii == iii) && (ci == cii && cii == ciii)) {
            if (i == ci) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }
    /**
     * This method chooses a random throw for the computer by generating a
     * random number from 1 to 3.
     */
    static int number() {
        return (int) (Math.random() * 3 + 1);
    }
    /**
     * This method converts a throw number into the actual word which it 
     * represents. It does this with a switch statement.
     */
    static String symbol(int t) {
        switch (t) {
            case 1:
                return "ROCK";
            case 2:
                return "PAPER";
            case 3:
                return "SCISSORS";
            default:
                return "SPOCK";
        }
    }
    /**
     * This method converts a result number into the actual phrase which it
     * represents. It does this with a switch statement.
     */
    static String give(int i) {
        switch (i) {
            case 1:
                return "wins";
            case 2:
                return "loses";
            case 3:
                return "ties with Computer";
            case 4:
                return "RoShamBos Computer";
            case 5:
                return "has been RoShamBoed by Computer";
            default:
                return "has destroyed the universe";
        }
    }
    //This is the main method.
    public static void main(String[] args) {
        //Create a keyboard Scanner.
        Scanner myScanner = new Scanner(System.in);
        /**
         * Initialize a whole bunch of variables. These are the last three
         * throws for the computer and player, the number of games played, the
         * number of games the player has lost, the number of games tied, the
         * number of times the player has RoShamBoed the computer and vice versa,
         * the computer and player's throw numbers, and the result number.
         */
        int I = 0, II = 0, III = 0, cI = 0, cII = 0, cIII = 0, count = 0, input = 0, computer = 0, wins = 0, losses = 0, ties = 0, rPlayer = 0, rComputer = 0, result = 0;
        System.out.println("Welcome to RPS: RoShamBo.");
        do {
            System.out.print("Please enter your throw (0=Quit, 1=Rock, 2=Paper, 3=Scissors):");
            /**
             * The program shifts the values of I, II, and III so that I is the
             * current throw, II the last throw, and III the throw before that.
             * It does the same with the computer throw values. It also sets the
             * next value for computer and input.
             */
            input = myScanner.nextInt();
            III = II;
            II = I;
            I = input;
            computer = number();
            cIII = cII;
            cII = cI;
            cI = computer;
            System.out.println("Player throws " + symbol(input));
            System.out.println("Computer throws " + symbol(computer));
            /**
             * Here, a switch statement and a nested if statement determine if
             * the player has won, lost, or tied the match.
             */
            switch (input) {
                case 1:
                    if (computer == 3) {
                        result = 1;
                    } else if (computer == 2) {
                        result = 2;
                    } else {
                        result = 3;
                    }
                    break;
                case 2:
                    if (computer == 1) {
                        result = 1;
                    } else if (computer == 3) {
                        result = 2;
                    } else {
                        result = 3;
                    }
                    break;
                case 3:
                    if (computer == 2) {
                        result = 1;
                    } else if (computer == 1) {
                        result = 2;
                    } else {
                        result = 3;
                    }
                    break;
                default:
                    result = 0;
            }
            /**
             * Only after the result of the current match is determined is the
             * RoShamBo determined. This is so that it only has to check if there
             * is a RoShamBo, and who won the current match to determine who won
             * a RoShamBo.
             */
            if (roShamBo(I, II, III, cI, cII, cIII)) {
                if (result == 1) {
                    result = 4;
                } else {
                    result = 5;
                }
            }
            /**
             * In this switch statement, the program adds to the statistical
             * variables, if applicable.
             */
            switch (result) {
                case 1:
                    wins++;
                    break;
                case 2:
                    losses++;
                    break;
                case 3:
                    ties++;
                    break;
                case 4:
                    rPlayer++;
                    break;
                case 5:
                    rComputer++;
                    break;
                default:
                    break;
            }
            System.out.println("Player " + give(result) + ".");
            //One game has been played, add one to the game counter.
            count++;
            /**
             * A Do While loop is used here so that the condition, input, can
             * can start uninitialized and be assigned values during the loop.
             */
        } while (input >= 1 && input <= 3);
        
        //Display endgame messages and statistics table.
        System.out.println("While reality collapses, enjoy your playing statistics.\n");
        System.out.format("%-20s %10s %10s %1s", "Stat", "Player", "Computer", "\n");
        System.out.format("%-20s %10s %10s %1s", "Wins", wins + rPlayer, count - wins - ties - rPlayer - 1, "\n");
        System.out.format("%-20s %10s %10s %1s", "Losses", losses + rComputer, count - losses - ties - rComputer - 1, "\n");
        System.out.format("%-20s %10s %10s %1s", "RoShamBos Performed", rPlayer, rComputer, "\n");
        System.out.format("%-20s %10s %10s %1s", "Ties", ties, ties, "\n");
        System.out.format("%-20s %10s %10s %1s", "Games Played", count, count, "\n");
        System.out.println("\nThank you for playing RPS: RoShamBo.");
    }
}
