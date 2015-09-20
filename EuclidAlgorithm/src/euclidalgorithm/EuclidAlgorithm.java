/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package euclidalgorithm;

import java.util.Scanner;

/**
 *
 * @author Max
 */
public class EuclidAlgorithm {

    /**
     * @param args the command line arguments
     */
    
    static int find(int m, int n) {
        if (n == 0) {
            return n;
        }
        int remainder = m%n;
        return find(n, remainder);
    }
    
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println(find(s.nextInt(), s.nextInt()));
    }
}
