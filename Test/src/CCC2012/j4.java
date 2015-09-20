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
public class j4 {

    static int k;

    public static char shift(char c, int k) {
        c += k;
        while (c < 65) {
            c += 26;
        }
        return c;
    }

    public static int position(char c) {
        return c - 64;
    }

    public static char decode(char ch, int p) {
        ch = shift(ch, -k);
        ch = shift(ch, -3 * p);
        return ch;
    }

    public static void j4() {
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt();
        String s = sc.next();
        char m[] = s.toCharArray();
        for (int i = 0; i < m.length; i++) {
            System.out.print(decode(m[i], i + 1));
        }
        System.out.println("");
    }
}
