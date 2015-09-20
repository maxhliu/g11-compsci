/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package victuals;

/**
 *
 * @author Max
 */
public class Computer {

    int r, s, d;
    String name;

    Computer() {
        name = "";
        r = 0;
        s = 0;
        d = 0;
    }

    int getValue() {
        return 2 * r + 3 * s + d;
    }

    void setName(String n) {
        name = n;
    }

    void setStats(int a, int b, int c) {
        r = a;
        s = b;
        d = c;
    }
}
