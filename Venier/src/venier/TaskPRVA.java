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
public class TaskPRVA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String no = s.next();
        char[] input = no.toCharArray();
        int r = input.length/2;
        for (;;r--) {
            if (input.length %r == 0)
                break;
        }
        int c = input.length/r;
        char[][] matrix = new char[r][c];
        int index = 0;
        for (int i = 0; i < r; i++) {
            for (int a = 0; a < c; a++) {
                matrix[i][a] = input[index];
            }
        }
        System.out.println(matrix);
    }
}
