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
public class CCC2013S1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int startYear = s.nextInt() + 1;
        String startString = (startYear + "");
        boolean unique = true;
        for (int i = 0; i < startString.length() - 1; i++) {
            char thisChar = startString.charAt(i);
            if (startString.indexOf(thisChar) != startString.lastIndexOf(thisChar)) {
                unique = false;
                i = startString.length();
                
            
            }
        }
    }
}
