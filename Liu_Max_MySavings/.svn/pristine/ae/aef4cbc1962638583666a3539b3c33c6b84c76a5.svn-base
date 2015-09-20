/*
 * Max Liu
 * April 3, 2013
 * Liu_Max_MySavings
 * ICS3U
 * Mister Lim
 */
package liu_max_mysavings;

/**
 *
 * @author Max
 */
public class PiggyBank {

    private int pennies, nickels, dimes, quarters;

    /**
     * Constructor for a PiggyBank. The bank starts off empty.
     */
    PiggyBank() {
        //Set all the coin values to 0.
        pennies = 0;
        nickels = 0;
        dimes = 0;
        quarters = 0;
    }

    /**
     * Shows the balance of the PiggyBank
     *
     * @param b The PiggyBank to show the balance of
     */
    public void showBalance(PiggyBank b) {
        //print out a dollar sign, leaving an empty line in front.
        System.out.print("\r\n$");
        //print out the balance accurate to 2 decimal places
        System.out.format("%.2f%n\r\n", b.getBalance(b));
    }

    /**
     * Retrieve and calculate the balance of the bank.
     *
     * @param p The PiggyBank to calculate the balance of.
     * @return The sum of the values of the coins.
     */
    public double getBalance(PiggyBank p) {
        //Add up all the coin values
        double sum = 0.01 * p.pennies;
        sum += 0.05 * p.nickels;
        sum += 0.1 * p.dimes;
        sum += 0.25 * p.quarters;
        return sum;
    }

    /**
     * Deposit one coin of either penny, nickel, dime, or quarter value.
     *
     * @param coin The type of coin to deposit.
     */
    public void deposit(String coin) {
        //use a switch statement to determine which variable to increment.
        switch (coin) {
            case "penny":
                pennies++;
                break;
            case "nickel":
                nickels++;
                break;
            case "dime":
                dimes++;
                break;
            case "quarter":
                quarters++;
                break;
            default:
                break;
        }
    }

    /**
     * Withdraw a certain quantity of one type of coin.
     *
     * @param coin The type of coin to withdraw.
     * @param q How many of that coin to withdraw.
     * @return The value of the coins that were withdrawn.
     */
    public double withdraw(String coin, int q) {
        //If there are still coins left to withdraw, this is true. This also ends the loop of retrieving coins.
        boolean coinsLeft = true;
        //This counts the total value of the withdrawn money.
        double amountWithdrawn = 0;
        //Start a count. This will be incremented each time the code runs, and when it reaches the number of coins needed to be withdrawn, the code will end.
        int count = 0;
        //while there are still coins left.
        while (coinsLeft) {
            //evaluate what type of coin to withdraw.
            switch (coin) {
                //if it's a penny
                case "penny":
                    //and there are still pennies left
                    if (pennies > 0) {
                        //take out a penny
                        pennies--;
                        //account for its value in the amount withdrawn
                        amountWithdrawn += 0.01;
                        //if there are no pennies left
                    } else {
                        //make it so that this withdrawal loop no longer runs
                        coinsLeft = false;
                    }
                    break;
                //if it's a nickel
                case "nickel":
                    //and there are still nickels left
                    if (nickels > 0) {
                        //take out a nickel
                        nickels--;
                        //account for its value in the amount withdrawn
                        amountWithdrawn += 0.01;
                        //if there are no nickels left
                    } else {
                        //make it so that this withdrawal loop no longer runs
                        coinsLeft = false;
                    }
                    break;
                //if it's a dime
                case "dime":
                    //and there are still dimes left
                    if (dimes > 0) {
                        //take out a dime
                        dimes--;
                        //account for its value in the amount withdrawn
                        amountWithdrawn += 0.01;
                        //if there are no dimes left
                    } else {
                        //make it so that this withdrawal loop no longer runs
                        coinsLeft = false;
                    }
                    break;
                //if it's a quarter
                case "quarter":
                    //and there are still quarters left
                    if (quarters > 0) {
                        //take out a quarter
                        quarters--;
                        //account for its value in the amount withdrawn
                        amountWithdrawn += 0.01;
                        //if there are no quarters left
                    } else {
                        //make it so that this withdrawal loop no longer runs
                        coinsLeft = false;
                    }
                    break;
                //If it's neither
                default:
                    //Prompt for a valid coin name.
                    System.out.println("Please enter a valid coin name.");
                    //and end the loop.
                    coinsLeft = false;
                    break;
            }
            //Since it has run once, increment the count
            count++;
            //if enough coins have been withdrawn, end the loop
            if (count >= q) {
                coinsLeft = false;
            }
        }
        //return the amount withdrawn
        return amountWithdrawn;
    }

    /**
     * Get the number of pennies left in the bank.
     *
     * @return The number of pennies.
     */
    public int getPennies() {
        return pennies;
    }

    /**
     * Get the number of nickels left in the bank.
     *
     * @return The number of nickels.
     */
    public int getNickels() {
        return nickels;
    }

    /**
     * Get the number of dimes left in the bank.
     *
     * @return The number of dimes.
     */
    public int getDimes() {
        return dimes;
    }

    /**
     * Get the number of quarters left in the bank.
     *
     * @return The number of quarters.
     */
    public int getQuarters() {
        return quarters;
    }
}
