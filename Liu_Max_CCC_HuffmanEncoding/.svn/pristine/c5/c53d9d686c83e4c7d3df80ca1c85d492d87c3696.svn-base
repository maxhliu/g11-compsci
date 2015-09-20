/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package liu_max_ccc_huffmanencoding;

import java.util.Scanner;

/**
 *
 * @author Max
 */
public class Liu_Max_CCC_HuffmanEncoding {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int codes = s.nextInt();
        Node baiyys = new Node('9');
        Node n = baiyys;
        for (int i = 0; i < codes; i++) {
            n = baiyys;
            char name = s.next().toCharArray()[0];
            char[] code = s.next().toCharArray();
            for (int ice = 0; ice < code.length - 1; ice++) {
                if (code[ice] == '0') {
                    if (n.hasNode(0)) {
                        n = n.zero;
                    } else {
                        n.zero = new Node('?');
                        n = n.zero;
                    }
                } else {
                    if (n.hasNode(1)) {
                        n = n.one;
                    } else {
                        n.one = new Node('?');
                        n = n.one;
                    }
                }
            }
            if (code[code.length - 1] == '0') {
                n.zero = new Node(name);
            } else {
                n.one = new Node(name);
            }
        }
        char[] decode = s.next().toCharArray();
        n = baiyys;
        for (char c : decode) {
            if (c == '0') {
                if (n.hasNode(0)) {
                    n = n.zero;
                } else {
                    System.out.print(n.name);
                    n = baiyys;
                }
            } else {
                if (n.hasNode(1)) {
                    n = n.one;
                } else {
                    System.out.print(n.name);
                    n = baiyys;
                }
            }
            if (!(n.hasNode())) {
                System.out.print(n.name);
                n = baiyys;
            }
        }
    }
}
