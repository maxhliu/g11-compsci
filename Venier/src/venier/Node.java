/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package venier;

import java.util.ArrayList;

/**
 *
 * @author Max
 */
public class Node {

    Node a, b, c, d;
    int level;
    int value;
    ArrayList values;
    Node(int n, int v) {
        values = new ArrayList();
        level = n + 1;
        value = v;
        if (level < 4) {
            a = new Node(level, 0);
            b = new Node(level, 1);
            c = new Node(level, 2);
            d = new Node(level, 3);
        } else {
            
        }
    }
}
