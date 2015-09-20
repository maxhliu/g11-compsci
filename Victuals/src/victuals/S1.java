package victuals;

import java.util.Arrays;
import java.util.Scanner;

public class S1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Computer best = new Computer();
        Computer best2 = new Computer();
        Computer[] pool = new Computer[sc.nextInt()];

        int indexToRemove = -1;
        int count = 0;
        for (int i = 0; i < pool.length; i++) {
            pool[i] = new Computer();
//            pool[i].setName(sc.next());
            pool[i].name = sc.next();
            pool[i].setStats(sc.nextInt(), sc.nextInt(), sc.nextInt());
            if (pool[i].getValue() >= best.getValue()) {
                best = pool[i];
                indexToRemove = count;
            }
            ++count;
        }
        pool[indexToRemove] = best2;

        for (int i = 0; i < pool.length; i++) {
            if (pool[i].getValue() >= best2.getValue()) {
                best2 = pool[i];
            }
        }

        String names[] = {best.name, best2.name};
        if (best.getValue() == best2.getValue()) {
            Arrays.sort(names);
        }
        System.out.println(names[0]);
        System.out.println(names[1]);
    }
}
