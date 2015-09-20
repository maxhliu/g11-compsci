/*
 * Stack s;
 * while(not end of input) {
 *   c = next input character;
 *   if (c is an operand) {
 *    add c to postfix string;
 *   } else {
 *  while (
 */
package victuals;

import java.util.Scanner;
import java.util.Stack;

public class InfixToPostfix {

    static char[] operator = {'(', '(', '^', '^', '*', '/', '+', '-', ')'};
//    static List <Character> operators = Arrays.asList('(', '(', '^', '^', '*', '/', '+', '-', ')');

    static int find(char e, char[] array) {
        int index = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == e) {
                index = i;
            }
        }
        return index;
    }

    static boolean isOperand(char e) {
//        return !(Arrays.binarySearch(operators, e) >= 0);
        return !(find(e, operator) >= 0);
    }

    static boolean precedence(char first, char second) {
        int a = find(first, operator);
        int b = find(second, operator);
        return a < b;
    }

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        String postFix = "";
        Stack<Character> operators = new <Character> Stack();
        String input = s.nextLine();
        input = input.replaceAll("\\s", "");
        char[] inputArray = input.toCharArray();
        char c;
        for (int i = 0; i < inputArray.length; i++) {
            c = inputArray[i];
            if (isOperand(c)) {
                postFix += c;
                if (!(isOperand(inputArray[i+1]))) {
                    postFix += " ";
                }
            } else if (operators.isEmpty() || precedence(c, operators.peek())) {
                operators.push(c);
            } else if (c == ')') {
                while (operators.peek() != '(') { //EmptyStackException
                    postFix += operators.pop() + " ";
                }
                operators.pop();
            } else {
                postFix += operators.pop() + " ";
                operators.push(c);
            }
        }
        while (!(operators.isEmpty())) {
            postFix += operators.pop() + " ";
        }
        System.out.println(postFix);

//        System.out.println(isOperand('/'));
    }
}
