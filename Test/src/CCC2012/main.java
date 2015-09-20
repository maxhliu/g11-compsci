/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CCC2012;

import java.util.Scanner;

/**
 *
 * @author Max
 */
public class main {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Antennae quantity:");
        int antennae = sc.nextInt();
        System.out.println("Eye quantity:");
        int eyes = sc.nextInt();
        if (antennae >= 3 && eyes <= 4) {
            System.out.println("TroyMartian");
        }
        if (antennae <= 6 && eyes >= 2) {
            System.out.println("VladSaturnian");
        }
        if (antennae <= 2 && eyes <= 3) {
            System.out.println("GraemeMercurian");
        }
    }
}
