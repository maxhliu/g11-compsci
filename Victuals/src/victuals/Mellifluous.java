package victuals;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Mellifluous {

    static int numReq(char a) {
        if (a < 115) {
            return ((a - 'a') / 3) + 2;
        } else if (a == 's') {
            return 7;
        } else if (a < 'w') {
            return 8;
        }
        return 9;
    }

    static int numPresses(char a) {
        char key[] = {'\0', '\0', 'a', 'd', 'g', 'j', 'm', 'p', 't', 'w'};
        return a - key[numReq(a)] + 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> inputs = new ArrayList<>();
        String input = "";
        while (!(input.equals("halt"))) {
            input = sc.next();
            inputs.add(input);
        }
        inputs.remove(inputs.size() - 1);
        int seconds[] = new int[inputs.size()];
        for (int i = 0; i < inputs.size(); i++) {
            char[] word = inputs.get(i).toCharArray();
            for (int b = 0; b < word.length - 1; b++) {
                seconds[i] += numPresses(word[b]);
                if (numReq(word[b]) == numReq(word[b + 1])) {
                    seconds[i] += 2;
                }
            }
            seconds[i] += numPresses(word[word.length - 1]);
        }
        for (int c : seconds) {
            System.out.println(c);
        }
    }
}
