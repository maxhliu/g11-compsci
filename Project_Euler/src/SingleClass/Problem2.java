/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SingleClass;

/**
 *
 * @author Max
 */
public class Problem2 {
    Problem2() {
        int limit = 4000000;
        int evenSum = 0, term1 = 1, term2 = 2, temp;
        while (term2 < limit) {
            if (term2%2 == 0) {
                evenSum += term2;
            }
            temp = term2;
            term2 = term1 + term2;
            term1 = temp;
        }
        System.out.println(evenSum);
    }
}
