/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CCC2012;

import java.util.Scanner;

/**
 *
 * @author Max
 */
public class j3 {

    public static void j3() {
        Scanner s = new Scanner(System.in);
        int k = s.nextInt();
        char[][] p = {{'*', 'X', '*'}, {' ', 'X', 'X'}, {'*', ' ', '*'}};
//        char[][] g = new char[3 * k][3 * k];
        for (int a = 0; a < 3; a++) {
            for (int n = 0; n < k; n++) {
                for (int b = 0; b < 3; b++) {
                    for (int r = 0; r < k; r++) {
                        System.out.print(p[a][b]);
                    }
                }
                System.out.println("");
            }
        }
    }
}
