/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package venier;

import java.util.Scanner;

/**
 *
 * @author Max
 */
public class TaskNOTE {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int difference = 0;
        int number = 0;
        int oldNumber = 0;
        for (int i = 0; i < 7; i++) {
            number = s.nextInt();
            switch (oldNumber - number) {
                case -1:
                case Integer.MAX_VALUE:
                    difference = Integer.MAX_VALUE;
                    break;
                case 1:
                case Integer.MIN_VALUE:
                    difference = Integer.MIN_VALUE;
                    break;
                default:
                    difference = 0;
                    break;
            }
            oldNumber = number;
        }
        if (difference == Integer.MAX_VALUE) {
            System.out.println("ascending");
        } else if (difference == Integer.MIN_VALUE) {
            System.out.println("descending");
        } else {
            System.out.println("mixed");
        }
    }
}
