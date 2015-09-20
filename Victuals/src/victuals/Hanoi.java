/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package victuals;

/**
 *
 * @author Max
 */
public class Hanoi {
    int[][] towers;
    Hanoi(int n) {
        towers = new int[3][n];
        for (int i = 0; i < n; i++) {
            towers[1][i] = n-i;
        }
    }
//    void move(int a, int b) 
    
}
