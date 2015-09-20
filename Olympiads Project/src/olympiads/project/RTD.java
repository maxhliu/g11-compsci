package olympiads.project;

import java.util.Scanner;

public class RTD {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter m:");
        int n = s.nextInt();
        System.out.print("Enter n:");
        int m = s.nextInt();
        int count = 0;
        for (int i = 1; i <= n; i++) {
            for (int b = 1; b <= m; b++) {
                if (i + b == 10) {
                    ++count;
                }
            }
        }
        if (count == 1) {
            System.out.println("There is 1 way to get the sum 10.");
        } else {
            System.out.println("There are " + count + " ways to get the sum 10.");
        }
    }
}
