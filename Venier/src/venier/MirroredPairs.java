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
public class MirroredPairs {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Ready");
        String input = s.nextLine();

        while (!"  ".equals(input)) {
            boolean is = false;
            char[] my = input.toCharArray();
            switch (my[0]) {
                case 'p':
                    is = my[1] == 'q';
                    break;
                case 'q':
                    is = my[1] == 'p';
                    break;
                case 'd':
                    is = my[1] == 'b';
                    break;
                case 'b':
                    is = my[1] == 'd';
                    break;
                default:
                    is = false;
            }
            String output = is? "Mirrored pair" : "Ordinary pair";
            System.out.println(output);
            input = s.nextLine();
        }
    }
}
