package olympiads.project;

import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.Stack;

public class StackPracticeOne {

    static char opposite(char c) {
        if (c == ')') {
            return (char) (c - 1);
        }
        return (char) (c - 2);
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Stack brackets = new Stack();
        while (true) {
            char[] input = s.nextLine().toCharArray();
            boolean isValid = true;
            for (char c : input) {

                if (c == '(' || c == '[' || c == '{') {
                    brackets.push(c);
                } else if (c == ')' || c == ']' || c == '}') {
                    try {
                        while (brackets.peek() != opposite(c)) {
                            brackets.pop();
                        }
                        brackets.pop();
                    } catch (EmptyStackException e) {
                        isValid = false;
                    }
                }
            }
            if (!(brackets.isEmpty())) {
                isValid = false;
            }
            if (isValid) {
                System.out.println("Balance");
            } else {
                System.out.println("Unbalance");
            }
        }
    }
}
