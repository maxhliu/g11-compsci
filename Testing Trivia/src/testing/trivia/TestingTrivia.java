/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testing.trivia;

import java.util.Scanner;

/**
 *
 * @author Max
 */
public class TestingTrivia {

    static String[] questions = {
        "Monkeys bathe in their own urine.",
        "During your lifetime, you'll eat about 60 000 pounds of food.",
        "A spudologist is an expert on potatoes.",
        "Lying makes your nose run.",
        "A woman once gave birth to a baby with naturally blue hair.",
        "The grass grows 3 inches a day.",
        "Burps are contagious.",
        "Albert Einstein couldn't speak fluently until he was nine. His parents thought he might be retarded.",
        "In Los Angeles, there are fewer people than there are automobiles.",
        "Ancient Egyptians slept on pillows made of stone.",
        "An average person laughs about 15 times a day.",
        "Chapstick has the same nutritional value as butter.",
        "There have been 4 separate occaisions of people finding a pot of gold at the end of a rainbow.",
        "A cow produces 200 times more gas a day than a person.",
        "A hippo can open its mouth wide enough to fit a 4 foot tall child inside.",
        "Cat's urine glows under a blacklight.",
        "315 entries in Webster's Dictionary will be misspelled.",
        "Camels have three eyelids to protect themselves from blowing sand.",
        "Air conditioners prevent global warming because they cool the earth.",
        "A 10-gallon hat barely holds 6 pints."
    };
    static boolean[] answers = {
        false,
        true,
        false,
        false,
        false,
        false,
        false,
        true,
        true,
        true,
        true,
        false,
        false,
        true,
        true,
        true,
        true,
        true,
        false,
        true
    };

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Trivia[] triviaList = new Trivia[20];
        for (int i = 0; i < 20; i++) {
            triviaList[i] = new Trivia(questions[i], answers[i]);
        }
        int triviaQuestion = (int)(Math.random()*20);
        System.out.println(questions[triviaQuestion]);
        if (s.nextBoolean() == answers[triviaQuestion]) {
            System.out.println("RIGHT");
        } else {
            System.out.println("WRONG");
        }
    }
}
