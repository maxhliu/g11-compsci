/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ccc2014;

import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author Max
 */
public class S3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for (int i = 0; i < t; i++) {
            int n = s.nextInt();
            Stack <Integer> branch = new Stack<>();
            Stack <Integer> mountain = new Stack<>();
            Stack <Integer> lake = new Stack<>();
            for (int a = 0; a < n; a++) {
                mountain.push(s.nextInt());
            }
            int currentCar = 1;
            while(!mountain.isEmpty()) {
                if (mountain.peek() == currentCar) {
                    lake.push(mountain.pop());
                    currentCar++;
                } else if (!branch.isEmpty() && branch.peek() == currentCar){
                    lake.push(branch.pop());
                    currentCar++;
                } else {
                    branch.push(mountain.pop());
                }
            }
            while(!branch.isEmpty()) {
                lake.push(branch.pop());
            }
            boolean valourous = true;
            for (int b = 1; b < lake.size(); b++) {
                if (!(lake.get(b) > lake.get(b-1))) {
                    valourous = false;
                }
            }
            if (valourous) {
                System.out.println("Y");
            } else {
                System.out.println("N");
            }
        }
    }
}