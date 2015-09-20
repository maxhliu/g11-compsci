package victuals;

import java.util.Arrays;
import java.util.Scanner;

public class TowersOfHanoi {

    //UNFINISHED: USE ARRAYLIST FOR INDIVIDUAL HANOI TOWER OBJECTS
    static int hanoi(int n, int a, int b, int c, int[][] t) {
        //acb
        //bac
        if (n == 1) {
        }
        return 0;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rings:");
        int n = sc.nextInt();
        int[][] towers = new int[3][n];
        hanoi(n, 1, 2, 3, towers);
    }
}
