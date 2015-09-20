/*
 * Max Liu
 * December 19, 2012
 * Liu_Max_CountLetters
 * ICS3U
 * Mister Lim
 */
package liu_max_countletters;

import java.util.Scanner;

/**
 *
 * @author Max
 */
public class Liu_Max_CountLetters {

    /**
     * This program takes a phrase then counts the frequency of each letter.
     */
    public static void main(String[] args) {
        System.out.println("Enter a phrase to be analyzed.");
        //Create a scanner
        Scanner myScanner = new Scanner(System.in);
        //Take the input of the scanner (the phrase) and convert it to upper case
        String input = myScanner.nextLine().toUpperCase();
        //Create a frequency array of each letter
        int[] freq = new int[26];
        //Create a character array of the phrase
        char[] phrase = input.toCharArray();
        for (char i : phrase) {
            //Take each character from the character array, then see if it's a letter.
            if (65 <= i && i <= 90) {
                //If it is, add one to the appropriate slot in the frequency array.
                freq[i-65]++;
            }
        }
        for (int b = 0; b < freq.length; b++) {
            //For each of the frequencies, print out he letter, then the requency of the letter.
            System.out.println((char)(b + 65) + ": " + freq[b]);
        }
    }
}
