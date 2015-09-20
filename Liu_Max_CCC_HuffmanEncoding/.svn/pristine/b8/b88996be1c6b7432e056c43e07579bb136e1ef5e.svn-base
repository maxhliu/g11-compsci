/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package liu_max_ccc_huffmanencoding;

/**
 *
 * @author Max
 */
public class Node {

    public Node zero;
    public Node one;
    public char name;

    Node(char c) {
        zero = null;
        one = null;
        name = c;
    }

    boolean hasNode() {
        return !(zero == null && one == null);
    }
    boolean hasNode(int i) {
        if (i == 0) {
            return !(zero == null);
        } else {
            return !(one == null);
        }
    }

    void extendBranch(boolean b, char c) {
        if (b) {
            if (one == null) {
                one = new Node(c);
            } else {
                one.extendBranch(b, c);
            }
        } else {
            if (zero == null) {
                zero = new Node(c);
            } else {
                zero.extendBranch(b, c);
            }
        }
    }
}
