
package victuals;

import java.util.Scanner;

public class EvaluatePostfix {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        AStack myStack = new AStack();
        String input;
        while (true) {
            input = s.next();
            switch(input) {
                case "+":
                    myStack.push(myStack.pop() + myStack.pop());
                    break;
                case "-":
                    myStack.push(-(myStack.pop() - myStack.pop()));
                    break;
                case "/":
                    int first = myStack.pop();
                    int second = myStack.pop();
                    myStack.push(second/first);
                    break;
                case "*":
                    myStack.push(myStack.pop() * myStack.pop());
                    break;
                case "^":
                    int index = myStack.pop();
                    int sendin = myStack.pop();
                    int original = sendin;
                    for (int i = 0; i < index-1; i++) {
                        sendin *= original;
                    }
                    myStack.push(sendin);
                    break;
                default:
                    myStack.push(Integer.parseInt(input));
                    break;
            }
            System.out.println("The last value is: " + myStack.last());
        }
        //52
        //-49
    }
}