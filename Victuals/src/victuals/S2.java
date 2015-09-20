package victuals;

import java.util.Scanner;

public class S2 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String output = "";
        EncodedCharacter[] key = new EncodedCharacter[s.nextInt()];

        for (int i = 0; i < key.length; i++) {
            key[i] = new EncodedCharacter();
            key[i].character = s.next();
            key[i].code = s.next();
        }
        String bitString = s.next();

        while (bitString.length() > 0) {
            for (EncodedCharacter c : key) {
                if (bitString.startsWith(c.code)) {
                    bitString = bitString.substring(c.code.length());
                    output += c.character;
                    break;
                }
            }
        }
        System.out.println(output);
    }
}
