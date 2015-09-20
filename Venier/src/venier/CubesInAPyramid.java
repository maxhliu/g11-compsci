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
public class CubesInAPyramid {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        double base = s.nextDouble();
        double height = s.nextDouble();
        int volume = (int)(base * base * height / 3 + 1);
        System.out.println((int)(base * base * height / 3 + 1));
    }
}
