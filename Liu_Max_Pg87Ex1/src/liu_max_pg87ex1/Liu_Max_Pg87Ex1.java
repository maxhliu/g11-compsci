/*
 * Max Liu
 * December 12, 2012
 * Liu_Max_Pg87Ex1
 * ICS3U
 * Mister Lim
 */
package liu_max_pg87ex1;

/**
 *
 * @author Max
 */
public class Liu_Max_Pg87Ex1 {

    static void addRoof() {
        //print out a roof
        System.out.println("   /\\   ");
        System.out.println("  /  \\  ");
        System.out.println(" /    \\ ");
        System.out.println("/______\\");
    }
    static void addBase() {
        //print out a base
        System.out.println("|      |");
        System.out.println("|      |");
        System.out.println("|      |");
        System.out.println("|______|");
    }
    static void addWalk() {
        //print out a walk
        System.out.println("   **");
        System.out.println("   ***************");
    }
    public static void main(String[] args) {
        //tell the program to run.
        addRoof();
        addBase();
        addWalk();
    }
}
