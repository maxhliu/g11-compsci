/*
 * Max Liu
 * May 23, 2013
 * Liu_Max_Tannhaüser
 * ICS3U
 * Mister Lim
 */
package Tannhaüser;

import java.util.Iterator;
import java.util.Scanner;
import javax.swing.JFrame;

/**
 * This game is a side-scrolling platform game with a twist: there are no
 * enemies, but you have to make your own platforms. Smooth animations and
 * movement, as well as the avatar's appearance of rolling complement the blurry
 * multicoloured landscape to create a game: Tannhaüser.
 *
 * @author Max
 */
public class Main {

    static Iterator itr;
    static Platform thePlatform;
    static Panels bckd;

    /**
     * This function decelerates the avatar.
     *
     * @param x The constant to decrease the speed by. This will let me control
     * how fast the avatar decelerates.
     * @param b The Panels object which is the JPanel the game operates on.
     */
    public static void decelerate(double x, Panels b) {
        //if the speed is positive
        if (b.speedX > 0) {
            //subtract the deceleration constant
            b.speedX -= x;
            //if not,
        } else if (b.speedX < 0) {
            //add it to the speed, which is negative
            b.speedX += x;
        }
    }

    /**
     * This function accelerates the avatar.
     *
     * @param x The constant to increase the speed by. This will let me control
     * how fast the avatar accelerates.
     * @param b The Panels object which is the JPanel the game operates on.
     */
    public static void accelerate(double x, Panels b) {
        //if the avatar is accelerating left, subtract the acceleration constant.
        if (b.moveLeft) {
            b.speedX -= x;
            //if it's accelerating right, add the acceleration constant.
        } else if (b.moveRight) {
            b.speedX += x;
        }
    }

    /**
     * This function changes the mainX and mainY values (the location which the
     * avatar is drawn at) according to the speed, scrolls the game, rotates the
     * avatar, and detects losing or winning.
     *
     * @param x The constant to divide the horizontal speed by. This will let me
     * control how fast things move.
     * @param y The constant to divide the vertical speed by. This will let me
     * control how fast things move.
     * @param b The Panels object which is the JPanel the game operates on.
     */
    public static void move(double x, double y, Panels b) {
        //if the game is still going; in that we haven't won nor lost, run the movement code
        if (!b.beginWin && !b.beginLose) {
            //move right a certain number of pixels of the speed
            //the avatar will move left if the speed is negative
            b.mainX += (int) b.speedX / x;
            //move downright a certain number of pixels of the speed
            //the avatar will move up if the speed is negative
            b.mainY += (int) b.speedY / y;

            //rotate the avatar depending on how fast the avatar is moving.
            b.rotation += Constants.ROTATION_CONSTANT * b.speedX / x;

            //if the speed is higher than the speed cap going right, then keep it at the speed cap
            if (b.speedX > Constants.SPEED_CAP && b.speedX > 0) {
                b.speedX = Constants.SPEED_CAP;
                //if the speed is higher than the speed cap going left, then keep it at the speed cap
            } else if (b.speedX < -Constants.SPEED_CAP && b.speedX < 0) {
                b.speedX = -Constants.SPEED_CAP;
            }

            //If the camera wants to scroll past the left limit of the background image
            if (b.bgX >= 0) {
                //then set tooLeft to true, and tooRight to false. These variables are used later on in the "move" method.
                b.tooLeft = true;
                b.tooRight = false;
            } else if (b.bgX <= -Constants.LEVEL_WIDTH + Constants.STAGE_WIDTH) {
                //if the camera wants to scroll past hte right limit of the background image, set tooLeft to false and tooRight to true;
                b.tooLeft = false;
                b.tooRight = true;
            } else {
                //if the background has not reached the limits, both variables are false
                b.tooLeft = false;
                b.tooRight = false;
            }

            //make sure the avatar cannot move past the left limit; there is nothing to see past there!
            //moving past the right limit, however, will win the game.
            if (b.tooLeft && b.mainX <= 0) {
                b.mainX = 0;
            }

            //set the amount we need to move as a fraction of the difference between the current position and the ideal position (middle of the screen)
            b.moveAmount = (int) (Constants.STAGE_SPEED * (b.mainX - (Constants.STAGE_WIDTH - Constants.MAIN_WIDTH) / 2.0));
            //if tooLeft is true, then don't move the camera left anymore, but allow rightwards movement
            if (b.tooLeft) {
                b.moveAmount = Math.max(b.moveAmount, 0);
                //if tooRIght is true, then don't move the camera right anymore, but allow leftwards movement
            } else if (b.tooRight) {
                b.moveAmount = Math.min(b.moveAmount, 0);
                //if we've moved past the right limits of the stage, and the camera isn't moving, then we have won the game.
                if (b.mainX >= Constants.STAGE_WIDTH + 10) {
                    b.bgm.stop();
                    //play celebration music
                    b.wsm.play();
                    //make sure that we stop operating the game logic, or else we will keep on winning after we have won (not that that's a bad thing)
                    //also, this will display the win screen.
                    b.beginWin = true;
                }
            }

            //if we have fallen underneath the stage then lose the game, stop the background music, and play the sad lose screen music
            if (b.mainY > Constants.STAGE_HEIGHT + Constants.MAIN_HEIGHT) {
                //unless you're cheating, of course.
                if (b.cheating) {
                    //if you are cheating, then just stay on the ground
                    b.mainY = Constants.STAGE_HEIGHT - Constants.MAIN_HEIGHT;
                    b.speedY = 0;
                } else if (!b.beginLose) {
                    b.bgm.stop();
                    //play sad violin music
                    b.lsm.play();
                }
                //make sure that we stop operating the game logic, or else we will keep on losing after we have lost
                //also, this will display the lose screen
                b.beginLose = true;
            }

            //scroll everything except the platforms by the move amount (platforms are moved in the platforms method
            b.bgX -= b.moveAmount;
            b.mainX -= b.moveAmount;
            //don't move the screen when tooLeft or tooRight is true
            if (b.moveAmount == 0) {
                if (b.tooLeft) {
                    b.bgX = 0;
                } else if (b.tooRight) {
                    b.bgX = -Constants.LEVEL_WIDTH + Constants.STAGE_WIDTH;
                }
            }
        }
    }

    /**
     * This method accelerates the avatar down as gravity.
     *
     * @param x The gravitational constant. Changing this will change how fast
     * things fall down.
     * @param b The Panels object which is the JPanel the game operates on.
     */
    public static void gravity(double x, Panels b) {
        //don't accelerate down when we are stationary on a platform
        if (!b.onPlatform) {
            b.speedY += x;
        }
        //but if we are cheating
        if (b.cheating) {
            //float
            b.mainY = 200;
        }
    }

    /**
     * This function determines collision with platforms and also scrolls
     * platforms.
     *
     * @param b The Panels object which is the JPanel the game operates on.
     */
    public static void platforms(Panels b) {
        //set the iterator
        itr = b.activePlatforms.iterator();
        //being on a platform is false if no platform collision is detected
        b.onPlatform = false;
        //while there are platforms left
        while (itr.hasNext()) {
            //set thePlatform as the next platform
            thePlatform = (Platform) itr.next();
            //if the avatar's x value is within the platform's x values
            if (b.mainX > thePlatform.x - Constants.MAIN_WIDTH / 2
                    && b.mainX < thePlatform.x + Constants.PLATFORM_WIDTH - Constants.MAIN_WIDTH / 2) {
                //and the avatar is touching the platform
                if (b.mainY > thePlatform.y - Constants.MAIN_HEIGHT
                        && b.mainY < thePlatform.y - Constants.MAIN_HEIGHT + Constants.PLATFORM_CATCH) {
                    //then stay on the top of the platform
                    b.mainY = thePlatform.y - Constants.MAIN_HEIGHT;
                    //you are now on a platform
                    b.onPlatform = true;
                }
            }
            //scroll the platforms
            thePlatform.x -= b.moveAmount;
        }
    }

    /**
     * This function adds a platform directly underneath the avatar. This
     * function is called when the shift key is pressed.
     */
    public static void addPlatform() {
        bckd.activePlatforms.add(new Platform(bckd.mainX + Constants.MAIN_WIDTH / 2 - Constants.PLATFORM_WIDTH / 2, bckd.mainY + Constants.MAIN_HEIGHT + 10));
    }

    /**
     * This function adds a platform directly underneath wherever the mouse was
     * clicked.
     *
     * @param x The x co-ordinate to place the platform
     * @param y The y co-ordinate to place the platform
     */
    public static void addPlatform(int x, int y) {
        bckd.activePlatforms.add(new Platform(x - Constants.PLATFORM_WIDTH / 2, y));
    }

    /**
     * This is the main function, and is called when the program first runs. The
     * instructions, JFrame initialization, the calling of other functions, and
     * the repaint loop.
     *
     * @param args
     */
    public static void main(String args[]) {
        //Initialize a scanner
        Scanner sc = new Scanner(System.in);
        //Display the instructions
        System.out.println("Welcome to the game Tannhaüser, by Max Liu.");
        System.out.println("Use the arrow keys or WASD to move.");
        System.out.println("Press space to jump.");
        System.out.println("Press esc to exit at any time.");
        System.out.println("Press shift to place a platform directly underneath you.");
        System.out.println("Alternatively, use your mouse and click to place a platform.");
        System.out.println("Move right to get to the end, and try not to fall off.");
        System.out.println("P.S. I heard that pressing C will allow you to float! Press space to float back up.");
        System.out.println("Type in \"I'm ready\" to begin.");
        String ready = sc.nextLine();
        //Check to see if they player is ready (if they have read the instructions)
        while (!ready.equals("I'm ready")) {
            System.out.println("You are not ready.");
            ready = sc.nextLine();
        }
        System.out.println("Press enter at the title screen.");
        System.out.println("Good luck!");

        //now start the actual game
        //create a new panel bckd
        bckd = new Panels();
        //create a JFrame to display the panel in
        JFrame frame = new JFrame("Colgate");
        //put the panel in
        frame.setContentPane(bckd);
        //remove the border
        frame.setUndecorated(true);
        //make sure the program ends when it closes
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //set the size
        frame.setSize(Constants.STAGE_WIDTH, Constants.STAGE_HEIGHT);
        //center it
        frame.setLocationRelativeTo(null);
        //don't make it resizable
        frame.setResizable(false);
        //now make it visible
        frame.setVisible(true);
        //add a platform to rest on
        addPlatform();
        //play background music
        bckd.bgm.loop();

        while (true) {

            //call the acceleration, deceleration, gravity, movement, and platform methods
            accelerate(Constants.ACCELERATION_CONSTANT, bckd);
            decelerate(Constants.DECELERATION_CONSTANT, bckd);
            gravity(Constants.GRAVITATIONAL_CONSTANT, bckd);
            move(Constants.MOVEX_CONSTANT, Constants.MOVEY_CONSTANT, bckd);
            platforms(bckd);

            //repaint the screen
            bckd.repaint();

            //put in a delay to run at a reduced framerate so it is not too taxing on computer resources and so that
            //there are less floating point errors (dividing the speed by a higher number will result in more errors)
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}
