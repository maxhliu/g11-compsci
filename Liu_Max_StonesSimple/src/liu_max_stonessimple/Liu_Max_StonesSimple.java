/*
 * Max Liu
 * November 14, 2012
 * Liu_Max_Stones
 * ICS3U
 * Mister Lim
 */
package liu_max_stonessimple;

import java.util.Scanner;

/**
 *
 * @author Max
 */
public class Liu_Max_StonesSimple {

    /**
     * This program is a version of stones where the player always goes first.
     * It is played on a 5x5 grid of 25 stones, where both the player and the 
     * computer can take 1-3 stones. In this program, I tried to make the code
     * as simple and efficient as possible while still implementing an anti-cheat
     * system and avoiding break statements.
     */
    public static void main(String[] args) {
        
        //Create scanner for keyboard input.
        Scanner keyboard = new Scanner(System.in);
        
        //Declare pStones, the number of stones the player took in their turn,
        //and stones, the number of stones left.
        byte pStones, stones = 25;
        
        //Explain the rules and prompt the player to go first.
        System.out.println("Welcome to Stones. You may take 1-3 stones on a 5 x 5 grid of stones. The person who takes the last stone loses.");
        System.out.println("Since I am infinitely superior, you may go first.");
        
        //While there are stones left, play the game.
        while (stones > 0)
        
        {
            
            //The player has not taken any stones this turn.
            pStones = 0;
            
            //Display the number of stones left. By putting this at the beginning
            //of the loop, we conveniently avoid the question of negative stones.
            System.out.println("There are " + stones + " stones left.");
            
            //Check to see if the player has taken a valid number of stones.
            //Since pStones was set to 0, this will run at least once.
            //They will not be able to escape this loop until they enter a valid number.
            while (pStones > 3 || pStones < 1)
            
            {
                
                //Tell the player to take 1-3 stones.
                System.out.println("Take 1-3 stones.");
                
                //Set pStones to keyboard input.
                pStones = keyboard.nextByte();
                
            }
            //Since the computer always wins, and the sum of the player taken stones
            //and computer taken stones is 4, we can just subtract 4 stones.
            stones -= 4;
            
            //Display the computer making a move only when there are stones left.
            if (stones > 0)
            
            {
                
                //Show how many stones the computer took.
                System.out.println("I have made my move. I took " + (4 - pStones) + " stones.");
                
            }
        }
        
        //Assert cybernetic superiority.
        System.out.println("I win. In the end, it seems that computers are always better.");
    }
}
