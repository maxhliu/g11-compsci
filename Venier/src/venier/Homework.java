package venier;

import java.util.Scanner;

public class Homework {

    int evaluate(int a, int b, int calc) {
        switch (calc) {
            case 1:
                return a + b;
            case 2:
                return a - b;
            case 3:
                return a * b;
            case 4:
                if (b > a && (b % a == 0)) {
                    return a / b;
                } else {
                    return -2211;
                }
        }
        return -12345;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
//        int hands = s.nextInt();
//        Hand[] set = new Hand[hands];
//        for (int i = 0; i < hands; i++) {
//            set[i] = new Hand(s.nextInt(), s.nextInt(), s.nextInt(), s.nextInt());
//        }
        for (int i = 0; i < s.nextInt(); i++) {
            int a = s.nextInt();
            int b = s.nextInt();
            int c = s.nextInt();
            int d = s.nextInt();
            int maxV = -1231;
            
        }
    }
}
