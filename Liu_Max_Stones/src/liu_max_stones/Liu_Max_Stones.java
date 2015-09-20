/*
 * Max Liu
 * November 14, 2012
 * Liu_Max_Stones
 * ICS3U
 * Mister Lim
 */
package liu_max_stones;

import java.util.Scanner;

/**
 *
 * @author Max
 */
public class Liu_Max_Stones {

    /**
     * @param args the command line arguments
     */
    static boolean yesNo(String e) {
        if (e.toLowerCase().startsWith("y") || e.toLowerCase().startsWith("k") || e.toLowerCase().startsWith("o")) {
            return true;
        } else {
            return false;
        }
    }

    static int number(String ice) {
        if (ice.toLowerCase().startsWith("one")) {
            return 1;
        } else if (ice.toLowerCase().startsWith("two")) {
            return 2;
        } else if (ice.toLowerCase().startsWith("three")) {
            return 3;
        } else if (ice.toLowerCase().startsWith("four")) {
            return 4;
        } else if (ice.toLowerCase().startsWith("five")) {
            return 5;
        } else if (ice.toLowerCase().startsWith("six")) {
            return 6;
        } else if (ice.toLowerCase().startsWith("seven")) {
            return 7;
        } else if (ice.toLowerCase().startsWith("eight")) {
            return 8;
        } else if (ice.toLowerCase().startsWith("nine")) {
            return 9;
        } else {
            return (Integer.parseInt(ice));
        }
    }

    static void display(char[][] t, int l, int w) {
        System.out.println("The current grid:");
        for (int r = 0; r < l; r++) {
            for (int c = 0; c < w; c++) {
                System.out.print(" " + t[r][c]);
            }
            System.out.println("");
        }
    }

    static int rand(int min, int max) {
        return (int) (Math.random() * (max - min + 1) + min);
    }

    static boolean pickStones(char u[][], int q) {
        int stonesPicked = 0;
        for (int s = 0; s < u.length; s++) {
            for (int d = 0; d < u[s].length; d++) {
                if (u[s][d] == '*' && stonesPicked <= q) {
                    u[s][d] = ' ';
                    stonesPicked++;
                }
            }
        }
        if (stonesPicked == q) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        String input, displayString = "";
        boolean playerFirst, gameOver = false, turnDone = false;
        int width, length, stones, x, y, count = 0, remainder, playerStones, sureWin, compStones;
        System.out.println("Welcome to Stones. You can choose to remove 1, 2, or 3 stones each turn. Would you like to go first?");
        input = myScanner.next();
        playerFirst = yesNo(input);
        if (!playerFirst) {
            System.out.println("Too bad, you have to.");
        } else {
            System.out.println("I am going second.");
        }
        System.out.println("What would you like the length to be?");
        input = myScanner.next();
        length = number(input);
        System.out.println("What would you like the width to be?");
        input = myScanner.next();
        width = number(input);
        char[][] grid = new char[length][width];
        for (int b = 0; b < length; b++) {
            for (int e = 0; e < width; e++) {
                grid[b][e] = '*';
            }
        }
        display(grid, length, width);
        remainder = (length * width) % 3;
        stones = length * width;
        sureWin = stones - remainder + 1;
        while (gameOver == false) {
            count = 0;
            do {
                System.out.println("Choose two co-ordinates or enter 0 to end your turn.");
                System.out.println("Give co-ordinates in the form x y, with x starting with 1 counting from the left, and y starting with 1 counting from the top.");
                x = number(myScanner.next());
                y = number(myScanner.next());
                while (turnDone = false) {
                    if (grid[y - 1][x - 1] != ' ') {
                        grid[y - 1][x - 1] = ' ';
                        stones--;
                        turnDone = true;
                    } else {
                        System.out.println("Enter valid co-ordinates.");
                    }
                }
                count++;
                playerStones = count;
                if (stones == 0) {
                    gameOver = true;
                }
            } while (x != 0 && count < 3 && gameOver == false);
            while (gameOver == false) {
                if (sureWin == length * width) {
                    compStones = 4 - playerStones;
                }
            }
        }
    }
}
