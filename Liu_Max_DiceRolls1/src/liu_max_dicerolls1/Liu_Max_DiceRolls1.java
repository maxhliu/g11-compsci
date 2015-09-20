/*
 * Max Liu
 * December 16, 2012
 * Liu_Max_DiceRolls1
 * ICS3U
 * Mister Lim
 */
package liu_max_dicerolls1;

//import java.util.Arrays;
import java.util.Scanner;

/**
 * This program has the functionality of both DiceRolls 1 and DiceRolls2, but is
 * collectively called DiceRolls1. It also has the additional feature of providing
 * a graph of asterisks for a visual representation of the distribution. 
 */
public class Liu_Max_DiceRolls1 {

    static int diceRoll(int dice, int sides) {
        //initialize the sum as zero
        int sum = 0;
        //this is run a number of times equal to the number of dice.
        for (int i = 0; i < dice; i++) {
            //add to the sum, one java standard issue random dice roll.
            sum += (int) (Math.random() * sides + 1);
        }
        //return the sum.
        return sum;
    }

    static void graph(int freq[], double vstep) {
        //initialize both the mininum value and maximum value as the first element
        //in the frequency array. This will always work.
        int min = freq[0], max = min;
        //using a for:each loop, find both the maximum and minimum values of the array.
        for (int i : freq) {
            min = Math.min(i, min);
            max = Math.max(i, max);
        }
        //find the "step", basically what interval a single asterisk represents.
        double step = (max - min) / vstep;
        for (int i = 0; i < freq.length; i++) {
            for (int a = 0; a < freq[i] / step; a++) {
                System.out.print("*");
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        //record the number of sides on the die, the number of dice, and how many
        //dice rolls are made.
        Scanner myScanner = new Scanner(System.in);
        System.out.println("How many sides?");
        int sides = myScanner.nextInt();
        System.out.println("How many dice?");
        int dice = myScanner.nextInt();
        System.out.println("How many dice rolls?");
        int rolls = myScanner.nextInt();
        //the length of the frequency array is dictated by how many dice and their
        //sides. The minimum would be the number of dice (dice start at 1), and
        //the maxiumum would be dice*sides(each rolls the maximum). Since our
        //array starts at 0, the length is dice*sides - sides + 1, which, factored,
        //is dice*(sides-1) + 1.
        int[] frequency = new int[dice * (sides - 1) + 1];
        
        for (int i = 1; i <= rolls; i++) {
            frequency[diceRoll(dice, sides) - dice]++;
        }
        for (int i = 0; i < frequency.length; i++) {
            System.out.println((i + dice) + "\t" + frequency[i]);
        }
        System.out.println("How wide is the graph?");
        double vstep = myScanner.nextDouble();
        graph(frequency, vstep);
    }
}
