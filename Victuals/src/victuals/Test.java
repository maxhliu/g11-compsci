package victuals;

import java.util.Scanner;

public class Test {

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        System.out.println("Press 1 to add at the beginning.");
        System.out.println("Press 2 to add at the end.");
        System.out.println("Press 3 to delete at the beginning.");
        System.out.println("Press 4 to delete at the end.");
        System.out.println("Press 5 to print the list.");
        System.out.println("Press 0 to exit.");
        LinkedList myList = new LinkedList();
        int d1 = 0;
        double d2 = 0;
        while (true) {
            switch (s.nextInt()) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    System.out.print("Enter an integer: ");
                    d1 = s.nextInt();
                    System.out.print("Enter a double: ");
                    d2 = s.nextDouble();
                    myList.addFirst(d1, d2);
                    break;
                case 2:
                    System.out.print("Enter an integer: ");
                    d1 = s.nextInt();
                    System.out.print("Enter a double: ");
                    d2 = s.nextDouble();
                    myList.addLast(d1, d2);
                    break;
                case 3:
                    myList.deleteFirst();
                    break;
                case 4:
                    myList.deleteLast();
                    break;
                case 5:
                    myList.printList();
                    break;
                default:
                    System.out.println("Ignoramus. Enter a valid input.");
                    break;
            }
        }
    }
}
