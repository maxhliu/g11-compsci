/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SingleClass;

/**
 *
 * @author Max
 */
public class Problem1 {

    Problem1() {
        int sum = 0;
        for (int i = 0; i < 1000; i += 3) {
            sum += i;
        }
        for (int i = 0; i < 1000; i += 5) {
            if (i % 3 != 0) {
                sum += i;
            }
        }
        System.out.println(sum);
    }
}
