/*
 * Max Liu
 * December 10, 2012
 * Liu_Max_Pg88Ex6
 * ICS3U
 * Mister Lim
 */
package liu_max_pg88ex6;

/**
 *
 * @author Max
 */
public class Liu_Max_Pg88Ex6 {

    static void perfectSquare() {
        int a, b;
        double c;
        //Have two for loops, this will create all possibilities of a and b less than 100.
        for (a = 1; a < 100; a++) {
            for (b = 1; b < 100; b++) {
                //c is equal to the square root of the sum of the two numbers. If a² + b² was an integer, so will c.
                c = Math.sqrt(a * a + b * b);
                //if c is an int, then (int)c will equal to c.
                if (c == (int) c) {
                    //print out their values.
                    System.out.format("%-2s² + %-2s² = %-3s²\r\n", a, b, (int)c);
                }
            }
        }

    }

    public static void main(String[] args) {
        //run the program
        perfectSquare();
    }
}
