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
public class j2 {

    public static void j2() {
        int[] s = new int[4];
        Scanner sc = new Scanner(System.in);
        for (int t = 0; t < 4; t++) {
            s[t] = sc.nextInt();
        }
        boolean fish;
        int d = 123;
        if (s[0] == s[1] && s[2] == s[3] && s[1] == s[2]) {
            d = 0;
        } else if (s[0] > s[1] && s[2] > s[3] && s[1] > s[2]) {
            d = 3;
        } else if (s[0] < s[1] && s[2] < s[3] && s[1] < s[2]) {
            d = -3;
        }
        switch (d) {
            case -3:
                System.out.println("Fish Rising");
                break;
            case 0:
                System.out.println("Constant Depth");
                break;
            case 3:
                System.out.println("Fish Diving");
                break;
            default:
                System.out.println("No Fish");
                break;
        }
    }
}
