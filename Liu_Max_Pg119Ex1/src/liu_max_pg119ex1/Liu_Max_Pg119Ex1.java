/*
 * Max Liu
 * February 28, 2013
 * Liu_Max_Pg119Ex1
 * ICS3U
 * Mister Lim
 */
package liu_max_pg119ex1;

/**
 *
 * @author Max
 */
public class Liu_Max_Pg119Ex1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] number = new int[25];
        for (int i = 0; i < 25; i++) {
            number[i] = (int) (Math.random() * 100);
        }
        System.out.println("ODD:");
        for (int a : number) {
            if (a % 2 == 0) {
                System.out.print(a + " ");
            }
        }
        System.out.println("\r\nEVEN:");
        for (int a : number) {
            if (a % 2 != 0) {
                System.out.print(a + " ");
            }
        }
        System.out.println("");
    }
}
