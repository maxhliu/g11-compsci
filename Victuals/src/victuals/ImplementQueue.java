package victuals;

import java.util.Scanner;

public class ImplementQueue {

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        AQueue q = new AQueue(s.nextInt());
        while (true) {
            switch (s.nextInt()) {
                case 1:
                    q.push(s.nextInt());
                    q.print();
                    break;
                case 2:
                    q.pop();
                    q.print();
                default:
            }
        }



//        System.out.println(q.isEmpty());
//        q.push(s.nextInt());
//        q.push(s.nextInt());
//        q.push(s.nextInt());
//        System.out.println(q.isEmpty());
//        System.out.println(q.pop());
//        System.out.println(q.pop());
//        System.out.println(q.size());
//        q.push(s.nextInt());
//        System.out.println(q.front());
//        System.out.println(q.back());
//        System.out.println(q.pop());
//        System.out.println(q.pop());
//        System.out.println(q.isEmpty());
    }
}
