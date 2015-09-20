/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//package ccc2014;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Max
 */
public class S2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
       // if (n % 2 == 0) {
            String as[] = new String[n];
            String bs[] = new String[n];
            for (int i = 0; i < n; i++) {
                as[i] = s.next();
            }
            for (int i = 0; i < n; i++) {
                bs[i] = s.next();
            }
            ArrayList<String> ps = new ArrayList<>(0);
            boolean valid = true;
            for (int i = 0; i < n; i++) {
                String added = "";
                if (as[i].compareTo(bs[i]) < 0) {
                    added = as[i] + " " + bs[i];
                } else if (as[i].compareTo(bs[i]) > 0) {
                    added = bs[i] + " " + as[i];
                } else {
                    valid = false;
                }
                ps.add(added);
            }
            if (valid) {
                for (int i = 0; i < n / 2; i++) {
                    String partners = ps.remove(0);
                    if (!ps.remove(partners)) {
                        valid = false;
                    }
                }
            }
            if (valid) {
                System.out.println("good");
            } else {
                System.out.println("bad");
            }
    //    } else {
         //   System.out.println("bad");
   //     }
    }
}
