package liu_max_ccc_s1_2005;
import java.util.ArrayList;
import java.util.Scanner;
public class Liu_Max_CCC_S1_2005 {
 /*
 * Max Liu
 * October 15, 2013
 * Liu_Max_CCC_S1_2005
 * ICS4U
 * Mister Lim
 */
    public static void main(String[] args) {
        //S1 in 10 lines excluding punctuation and comments
        //has some of the worst formatting ever
        Scanner s = new Scanner(System.in);
        ArrayList <String> l = new ArrayList<String>();
        for (byte q = Byte.parseByte(s.nextLine()); q > 0; q--, l.add(s.nextLine().replace("-", "")));
        for (byte b = 0; b < l.size(); b++, System.out.println()) {
            char[] my= l.get(b).toUpperCase().toCharArray();
            for (byte i = 0; i < 10; System.out.print(my[i++])) {
                my[i] = (char)((my[i] == 'S' || my[i] == 'V' || my[i] == 'Y' || my[i] == 'Z') ? ((my[i]-1 <= 'Z' && my[i]-1 >= 'A') ? (my[i]-1-'A')/3 + '2' : my[i]-1) : ((my[i] <= 'Z' && my[i] >= 'A') ? (my[i]-'A')/3 + '2' : my[i]));
            //give up; I have spent too much time on this
                if (my[i] == ':') 
                    my[i] = '9';
                 if (i == 3 || i == 6)
                     System.out.print("-");
            }
        }        
    }
}
