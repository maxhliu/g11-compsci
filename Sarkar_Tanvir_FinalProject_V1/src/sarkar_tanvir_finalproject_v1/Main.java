/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*Tanvir Sarkar
 * Mr.Lim
 * ICS4UP
 * June 11, 2010
 * InterGalactic Defense
 */
package sarkar_tanvir_finalproject_v1;

import java.awt.*;
import java.awt.event.*;
import java.net.*;
import javax.swing.*;
import java.util.*;
import java.math.*;
import java.util.Random;

/**
 *
 *
 *
 * @author 321525800
 */
public class Main extends JPanel implements MouseMotionListener, KeyListener {

    /**
     * @param args the command line arguments
     */
    //player's bullets
    ArrayList<Bullet> arrBullets = new ArrayList<Bullet>();
    //player's bombs
    ArrayList<Bomb> arrBombs = new ArrayList<Bomb>();
    //the enemies
    ArrayList<Enemy> arrEnemies = new ArrayList<Enemy>();
    //enemies bullets
    ArrayList<EnemyBullet> arrEnemyBullets = new ArrayList<EnemyBullet>();
    //powerUps
    ArrayList<PowerUp> arrPowerUp = new ArrayList<PowerUp>();
    //PlayerStuff
    //instruction screen
    Image openingScreen;
    Image win;                  //win
    Image lose;                 //lose
    Image backgroundImage;      //space background
    Image ship;                 //player's ship sprite
    Image shipAfterImage;       //opaque ship
    Image playerBullet;         //regular bullet
    Image redPlayerBullet;      //bullet type 1
    Image redHollowBullet;      //bullet type 2
    Image blueHollowBullet;     //bullet type 3
    Image redBlast;             //bullet type 4
    Image blueBlast;            //bullet type 5
    Image bombExplosion;        //player's bomb explosion
    Image powerUp;              //weapon upgrade crate
    Image healthUp;             //replenish health
    Image playerBomb;           //the player's bomb
    Image health;               //health sysmbol (shield shape)
    Image hpInside;             //player's outer hp bar
    Image hpOutside;            //player's inner hp bar
    Image ammo1;                //displays bulletType 1 ammo at the bottom
    Image ammo2;                //displays bulletType 2 ammo at the bottom
    Image ammo3;                //displays bulletType 3 ammo at the bottom
    Image ammo4;                //displays bulletType 4 ammo at the bottom
    Image ammo5;                //displays bulletType 5 ammo at the bottom
    //EnemyStuff
    Image enemy1;               //image of enemy 1
    Image enemy2;               //image of enemy 2
    Image enemy3;               //image of enemy 3
    Image boss;                 //image of boss
    Image bossHpInside;         //boss's outer hp bar
    Image bossHpOutside;        //boss's inner hp bar
    Image laser;                //boss's laser (red)
    Image laserFlip;            //boss's laser (blue)
    Image bossMissile;          //boss's missiles
    Image explosion;            //explosion when enemies die
    Image blueBullet;           //enemy's blue bullets
    Image greenBullet;          //enemy's green bullets
    Image whiteBullet;          //enemy's white bullets
    Image enemyMine;            //enemy's heatseeking bombs/mines
    MediaTracker mediaTracker;          //create the mediatracker
    Image offScreenImage;               //off screen Image variable for drawing
    Graphics offScreenGraphicsCtx;      //off screen graphics context
    //starting screen
    boolean introScreen = true;
    //mouse co-ords
    int mouseX;
    int mouseY;
    //ship co-ords and health
    int shipX, shipY, shipHealth = 20;
    //The player's bullet Type
    int bulletType = 1;
    //The player's bullet speed (pixels travelled per frame)
    int bulletSpeed = 15;
    //for player's heatseeking bombs
    double angleToEnemy;
    //variable for player firing delay
    long timeAtMyShot = System.currentTimeMillis();
    long timeAtMyBombShot = System.currentTimeMillis();
    //the coordinates of the player's hp bars and their widths (used in calculations
    //for decreasing the bar)
    int hpOutsideX = 30, hpOutsideY = 0;
    int hpInsideX = hpOutsideX + 6, hpInsideY = hpOutsideY + 4, hpInsideWidthOriginal = 188, hpInsideWidthChange = 188;
    //background co-ords
    int bgX = 0;
    int bgY = 0;
    //The enemy's bullet speed
    int enemyBulletSpeed = 10;
    int enemiesDown = 0; //num enemies you killed
    int numEnemies = 0; //num enemies onscreen right now
    int enemyType = 0; //the type of the enemy 1,2,3, or 4(boss)
    //if 1, the enemy summon Y is 100 pixels above the screen
    //if 2, the enemy summon Y is 100 pixels below the screen
    boolean createPowerUps = true;
    int randomY = 0;
    int theEnemyY = 0;
    int randomPowerUpY = 0;
    int thePowerUpY = 0;
    int powerUpCreator = 0;
    //when the boss spawns, bossMode is true but goes back to false to not spawn
    //more than 1 boss. this extra boolean is used for displaying the boss's health bars
    //when he appears
    boolean showBossHealth = false;
    //the coordinates of the boss's hp bars and their widths (used in calculations
    //for decreasing the bar)
    int bossHpOutsideX = 760, bossHpOutsideY = 0;
    int bossHpInsideX = bossHpOutsideX + 6, bossHpInsideY = bossHpOutsideY + 4, bossHealth = 1000;
    int bossHpInsideWidthChange = 188;
    //when hit, the ship is invincible for a short period
    boolean damagable = true;       //the ship is not invincible
    boolean shipFlicker = false;    //it's not flickering
    long flickerTimer = System.currentTimeMillis(); //setup the flicker timer
    int invincibleCounter = 20;    //this counter is decreased every frame, at 0, ship is damagable
    //for the boss multi shot
    boolean multiShot = false; //used for the attack where he shoots 4 green bullets
    long timeAtMultiShot = System.currentTimeMillis(); //setup the multishot timer
    int numShots = 0;  //it's at 0 but the boss will fire 4 so it increases
    long laserTimer = System.currentTimeMillis();  //setup the laser timer
    boolean flipLaser;   //false: red laser, true: blue laser
//   int laserCounter=1;
    int enemiesNeededDead = 30; //kill 40 enemies to spawn boss
    boolean bossMode = false; //for the end, try to do code where theres no shooting delay
    int gameOver = 0; //1 = win, 2 = lose
    int gameOverCounter = 210; //gameover image lasts for 3 1/2 seconds and then game closes

    Main() {


        //create mediaTracker to wait for the images to load
        mediaTracker = new MediaTracker(this);

        //instructions
        URL imgURL = getClass().getResource("openingScreenEdit.png");
        openingScreen = Toolkit.getDefaultToolkit().getImage(imgURL);

        //win sign
        imgURL = getClass().getResource("Win.png");
        win = Toolkit.getDefaultToolkit().getImage(imgURL);

        //lose sign
        imgURL = getClass().getResource("Lose.png");
        lose = Toolkit.getDefaultToolkit().getImage(imgURL);

        //background image
        imgURL = getClass().getResource("starsBGround.jpg");
        backgroundImage = Toolkit.getDefaultToolkit().getImage(imgURL);

        //the character's spaceship
        imgURL = getClass().getResource("shipSprite.png");
        ship = Toolkit.getDefaultToolkit().getImage(imgURL);

        //the character's spaceship's flickering image
        imgURL = getClass().getResource("shipSpriteOpaque.png");
        shipAfterImage = Toolkit.getDefaultToolkit().getImage(imgURL);

        //the player's bullet
        imgURL = getClass().getResource("FireBullet.png");
        playerBullet = Toolkit.getDefaultToolkit().getImage(imgURL);

        //the player's bullet for type 2
        imgURL = getClass().getResource("RedPlayerBullet.png");
        redPlayerBullet = Toolkit.getDefaultToolkit().getImage(imgURL);

        //the player's bullet for type 3
        imgURL = getClass().getResource("RedHollowBullet.png");
        redHollowBullet = Toolkit.getDefaultToolkit().getImage(imgURL);

        //the player's bullet for type 4
        imgURL = getClass().getResource("RedBlast.png");
        redBlast = Toolkit.getDefaultToolkit().getImage(imgURL);

        //the player's bullet for type 5
        imgURL = getClass().getResource("BlueHollowBullet.png");
        blueHollowBullet = Toolkit.getDefaultToolkit().getImage(imgURL);

        //the player's bullet for type 5
        imgURL = getClass().getResource("BlueBlast.png");
        blueBlast = Toolkit.getDefaultToolkit().getImage(imgURL);

        //the player's bombs
        imgURL = getClass().getResource("playerBombEdit.png");
        playerBomb = Toolkit.getDefaultToolkit().getImage(imgURL);

        //the player's bomb's explosion (electric ring)
        imgURL = getClass().getResource("playerBombExplosion.png");
        bombExplosion = Toolkit.getDefaultToolkit().getImage(imgURL);

        //PowerUpCrate
        imgURL = getClass().getResource("Upgrade.jpg");
        powerUp = Toolkit.getDefaultToolkit().getImage(imgURL);

        //HealthUpCrate
        imgURL = getClass().getResource("Health.jpg");
        healthUp = Toolkit.getDefaultToolkit().getImage(imgURL);

        //health symbol
        imgURL = getClass().getResource("healthEdit.png");
        health = Toolkit.getDefaultToolkit().getImage(imgURL);

        //hp inside bar for player
        imgURL = getClass().getResource("hpInsideResizedSmall.png");
        hpInside = Toolkit.getDefaultToolkit().getImage(imgURL);

        //hp outside bar for player
        imgURL = getClass().getResource("hpOutsideSmall.png");
        hpOutside = Toolkit.getDefaultToolkit().getImage(imgURL);

        //ammo1
        imgURL = getClass().getResource("BT1.png");
        ammo1 = Toolkit.getDefaultToolkit().getImage(imgURL);

        //ammo2
        imgURL = getClass().getResource("BT2.png");
        ammo2 = Toolkit.getDefaultToolkit().getImage(imgURL);

        //ammo3
        imgURL = getClass().getResource("BT3.png");
        ammo3 = Toolkit.getDefaultToolkit().getImage(imgURL);

        //ammo4
        imgURL = getClass().getResource("BT4.png");
        ammo4 = Toolkit.getDefaultToolkit().getImage(imgURL);

        //ammo5
        imgURL = getClass().getResource("BT5.png");
        ammo5 = Toolkit.getDefaultToolkit().getImage(imgURL);

        ////////////////////ENEMY STUFF
        //enemy 1
        imgURL = getClass().getResource("EShip1.png");
        enemy1 = Toolkit.getDefaultToolkit().getImage(imgURL);

        //enemy 2
        imgURL = getClass().getResource("EShip2.png");
        enemy2 = Toolkit.getDefaultToolkit().getImage(imgURL);

        //enemy 3
        imgURL = getClass().getResource("EShip3.png");
        enemy3 = Toolkit.getDefaultToolkit().getImage(imgURL);

        //boss
        imgURL = getClass().getResource("bossPic2.png");
        boss = Toolkit.getDefaultToolkit().getImage(imgURL);

        //hp inside bar for boss
        imgURL = getClass().getResource("hpInsideBoss.png");
        bossHpInside = Toolkit.getDefaultToolkit().getImage(imgURL);

        //hp outside bar for boss
        imgURL = getClass().getResource("hpOutsideBoss.png");
        bossHpOutside = Toolkit.getDefaultToolkit().getImage(imgURL);

        //laser: red
        imgURL = getClass().getResource("bossLaser.png");
        laser = Toolkit.getDefaultToolkit().getImage(imgURL);

        //laser upside down: blue
        imgURL = getClass().getResource("bossLaserBlue.png");
        laserFlip = Toolkit.getDefaultToolkit().getImage(imgURL);

        //boss's missile
        imgURL = getClass().getResource("smallBossMissile.png");
        bossMissile = Toolkit.getDefaultToolkit().getImage(imgURL);

        //explosion
        imgURL = getClass().getResource("explosion.png");
        explosion = Toolkit.getDefaultToolkit().getImage(imgURL);

        //enemy bullet type 1
        imgURL = getClass().getResource("BlueBulletSmall.gif");
        blueBullet = Toolkit.getDefaultToolkit().getImage(imgURL);

        //enemy bullet type 2
        imgURL = getClass().getResource("GreenFireBulletSmall.png");
        greenBullet = Toolkit.getDefaultToolkit().getImage(imgURL);

        //enemy bullet type 3
        imgURL = getClass().getResource("WhiteBulletSmall.png");
        whiteBullet = Toolkit.getDefaultToolkit().getImage(imgURL);

        //enemy Mines
        imgURL = getClass().getResource("EMine.png");
        enemyMine = Toolkit.getDefaultToolkit().getImage(imgURL);

        //add the images to the mediaTracker
        mediaTracker.addImage(openingScreen, 0);
        mediaTracker.addImage(backgroundImage, 0);
        mediaTracker.addImage(ship, 0);
        mediaTracker.addImage(shipAfterImage, 0);
        //mediaTracker.addImage(shipBright,0);
        mediaTracker.addImage(playerBullet, 0);
        mediaTracker.addImage(redPlayerBullet, 0);
        mediaTracker.addImage(redHollowBullet, 0);
        mediaTracker.addImage(blueHollowBullet, 0);
        mediaTracker.addImage(redBlast, 0);
        mediaTracker.addImage(blueBlast, 0);
        mediaTracker.addImage(bombExplosion, 0);
        mediaTracker.addImage(playerBomb, 0);
        mediaTracker.addImage(powerUp, 0);
        mediaTracker.addImage(healthUp, 0);
        mediaTracker.addImage(health, 0);
        mediaTracker.addImage(hpInside, 0);
        mediaTracker.addImage(hpOutside, 0);
        mediaTracker.addImage(ammo1, 0);
        mediaTracker.addImage(ammo2, 0);
        mediaTracker.addImage(ammo3, 0);
        mediaTracker.addImage(ammo4, 0);
        mediaTracker.addImage(ammo5, 0);
        //enemy stuff
        mediaTracker.addImage(enemy1, 0);
        mediaTracker.addImage(enemy2, 0);
        mediaTracker.addImage(enemy3, 0);
        mediaTracker.addImage(boss, 0);
        mediaTracker.addImage(bossHpInside, 0);
        mediaTracker.addImage(bossHpOutside, 0);
        mediaTracker.addImage(laser, 0);
        mediaTracker.addImage(laserFlip, 0);
        mediaTracker.addImage(bossMissile, 0);
        mediaTracker.addImage(explosion, 0);
        mediaTracker.addImage(blueBullet, 0);
        mediaTracker.addImage(greenBullet, 0);
        mediaTracker.addImage(whiteBullet, 0);
        mediaTracker.addImage(enemyMine, 0);

        try {
            mediaTracker.waitForID(0);
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        //create the variables for width and height
        int width = backgroundImage.getWidth(this);
        int height = backgroundImage.getHeight(this);

        //setup the panel
        setSize(width, height);
        setVisible(true);
        addMouseMotionListener(this);
        addKeyListener(this);

    }

    public static void main(String[] args) {
        // TODO code application logic here
        //create the frame
        JFrame myFrame = new JFrame();

        //crate the Main
        Main myMain = new Main();
        //get the content pane
        myFrame.setContentPane(myMain);
        //set the close operation
        myFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //set the title and width,height and make it un resizable and visible
        myFrame.setTitle("InterGalactic Defense");
        myFrame.setSize(myMain.getWidth(), myMain.getHeight());
        myFrame.setResizable(false);
        myFrame.setVisible(true);

        //focus must be set for use of keyListener
        myMain.setFocusable(true);
        myMain.requestFocus();

        //variable for the time
        long timeMillis = System.currentTimeMillis();

        while (true) //infinite loop in which all the work gets done
        {
            //only do all of the game stuff if the player presses space at the intro
            //screen to start the game, else, it will jsut display the intro screen
            if (myMain.introScreen == false) {

                //if the player has killed the neccesary amount of enemies
                if (myMain.enemiesDown == myMain.enemiesNeededDead) {
                    //this will stop enemy spawns and spawn the boss
                    myMain.bossMode = true;
                }
                //if there are less than 4 enemies on screen, summon more
                if (myMain.bossMode == false) {
                    //This is checking to see if new enemies need to be spawned
                    //&& myMain.enemiesDown < [(# of enemies needed to kill)-1]
                    //this is because the boss will be spawned with another enemy as well
                    if (myMain.numEnemies < 2 && myMain.enemiesDown < (myMain.enemiesNeededDead - 1)) {
                        //create new enemies
                        //whether enemies will appear above or below screen
                        myMain.randomY = (int) Math.floor(Math.random() * 2);
                        //chooser for the enemy type (percentage)
                        int enemyTypeChooser = (int) Math.floor(Math.random() * 1001);
                        int enemyMovementChooser = (int) Math.floor(Math.random() * 1001);

                        //chooses the enemy type
                        if (enemyTypeChooser <= 325) {
                            myMain.enemyType = 1;
                        } else if (enemyTypeChooser > 325 && enemyTypeChooser < 650) {
                            myMain.enemyType = 2;
                        } else {
                            myMain.enemyType = 3;
                        }

                        //chooses the spawning Y
                        if (myMain.randomY == 1) {
                            myMain.theEnemyY = -100;
                        } else {
                            myMain.theEnemyY = myMain.backgroundImage.getHeight(myFrame) + 100;
                        }

                        //makes the enemies
                        if (myMain.enemyType == 1) {
                            //create a new enemy called nextEnemy
                            Enemy nextEnemy = new Enemy((int) (Math.random() * 310 + 600), myMain.theEnemyY, 4, 8, myMain.enemy1, myMain.blueBullet, myMain.enemyType, 1);
                            myMain.arrEnemies.add(nextEnemy); //add next enemy
                            myMain.numEnemies++; //number of enemies on screen increases
                        } else if (myMain.enemyType == 2) {
                            //if it is 1, the enemey moves vertically, if it is 2, it is horizontal
                            int moveType = (int) Math.floor(Math.random() * 2 + 1);

                            if (moveType == 1) {
                                //create a new enemy called nextEnemy
                                Enemy nextEnemy = new Enemy((int) (Math.random() * 410 + 500), myMain.theEnemyY, 6, 8, myMain.enemy2, myMain.greenBullet, myMain.enemyType, 1);
                                myMain.arrEnemies.add(nextEnemy);
                                myMain.numEnemies++; //number of enemies on screen increases
                            } else if (moveType == 2) {
                                //create a new enemy called nextEnemy
                                Enemy nextEnemy = new Enemy(1100, (int) (Math.random() * 450 + 100), 6, 8, myMain.enemy2, myMain.greenBullet, myMain.enemyType, 2);
                                myMain.arrEnemies.add(nextEnemy);
                                myMain.numEnemies++; //number of enemies on screen increases
                            }
                        } else {
                            int moveType = (int) Math.floor(Math.random() * 2 + 1);
                            if (moveType == 1) {
                                //create a new enemy called nextEnemy
                                Enemy nextEnemy = new Enemy((int) (Math.random() * 260 + 650), myMain.theEnemyY, 8, 8, myMain.enemy3, myMain.whiteBullet, myMain.enemyType, 1);
                                myMain.arrEnemies.add(nextEnemy);
                                myMain.numEnemies++; //number of enemies on screen increases
                            } else if (moveType == 2) {
                                //create a new enemy called nextEnemy
                                Enemy nextEnemy = new Enemy(1100, (int) (Math.random() * 450 + 100), 8, 8, myMain.enemy3, myMain.whiteBullet, myMain.enemyType, 2);
                                myMain.arrEnemies.add(nextEnemy);
                                myMain.numEnemies++; //number of enemies on screen increases
                            }
                        }
                    }
                } else //spawn the boss
                {
                    //create a new enemy called nextEnemy (this one is the boss)
                    Enemy nextEnemy = new Enemy(775, myMain.theEnemyY, 1000, 8, myMain.boss, myMain.blueBullet, 4, 1);
                    myMain.arrEnemies.add(nextEnemy);
                    myMain.numEnemies = 10000; //just a number to not spawn any regulars
                    myMain.enemiesDown = 10000; //just a number to not spawn any regulars
                    myMain.showBossHealth = true;
                    myMain.bossMode = false;
                    //if i keep it as bossMode = true, it will nonstop spawn more and more bosses
                }

                //creating the powerUps for health or weapons upgrades
                if (myMain.createPowerUps == true) {
                    //this # chooses whether a powerup will produced this frame
                    myMain.powerUpCreator = (int) Math.floor(Math.random() * 1001);

                    //if it is a specific #, create powerUps (seems like low chance but produces a decent flow of powerUps)
                    if (myMain.powerUpCreator >= 996) {
                        int powerUpChooser = (int) Math.floor(Math.random() * 1001);
                        {
                            myMain.randomPowerUpY = (int) Math.floor(Math.random() * 2);

                            //creating the new PowerUps

                            //Create a health Up
                            if (powerUpChooser <= 450) {
                                //chooses the spawning Y
                                if (myMain.randomPowerUpY == 1) {
                                    myMain.thePowerUpY = -30; //top of the screen

                                    //create a new PowerUp called nextPowerUp
                                    PowerUp nextPowerUp = new PowerUp((int) (Math.random() * 410 + 500), myMain.thePowerUpY, 5, 1, myMain.healthUp, true);
                                    myMain.arrPowerUp.add(nextPowerUp);
                                } else {
                                    myMain.thePowerUpY = myMain.backgroundImage.getHeight(myFrame) + 30;//top of the screen

                                    //create a new PowerUp called nextPowerUp
                                    PowerUp nextPowerUp = new PowerUp((int) (Math.random() * 410 + 500), myMain.thePowerUpY, 5, 1, myMain.healthUp, false);
                                    myMain.arrPowerUp.add(nextPowerUp);
                                }

                            } //Create an upgrade
                            else {
                                if (myMain.randomPowerUpY == 1) {
                                    //top of the screen
                                    myMain.thePowerUpY = -30;

                                    //create a new PowerUp called nextPowerUp
                                    PowerUp nextPowerUp = new PowerUp((int) (Math.random() * 410 + 500), myMain.thePowerUpY, 5, 2, myMain.powerUp, true);
                                    myMain.arrPowerUp.add(nextPowerUp);
                                } else {
                                    //bottom of the screen
                                    myMain.thePowerUpY = myMain.backgroundImage.getHeight(myFrame) + 30;

                                    //create a new PowerUp called nextPowerUp
                                    PowerUp nextPowerUp = new PowerUp((int) (Math.random() * 410 + 500), myMain.thePowerUpY, 5, 2, myMain.powerUp, false);
                                    myMain.arrPowerUp.add(nextPowerUp);
                                }
                            }

                        }
                    }
                }

                //scroll bg left
                myMain.bgX -= 3;

                //if the 1st bg pic reaches the left end
                if (myMain.bgX < (myMain.backgroundImage.getWidth(myFrame)) * -1) {
                    myMain.bgX = 0;
                }

                //Enemies
                try {
                    //for each enemy loop
                    for (Enemy curEnemy : myMain.arrEnemies) {

                        //check if the enemy is dead
                        if (curEnemy.enemyHP <= 0) {
                            //if the enemy is not a boss, change their pic into the explosion image
                            //make the variables for the image width and height deacrease and decrease the
                            //explosion timer each time

                            // if the enemy is a boss, make his health bar emepty and make
                            //the gameover variable setup for the win screen
                            if (curEnemy.enemyType == 4) {
                                myMain.bossHpInsideWidthChange = 0;
                                myMain.gameOver = 1; //player wins
                            }
                            curEnemy.explosionTimer--;
                            curEnemy.imgWidth -= 2; //the image shrinks
                            curEnemy.imgHeight -= 2; //the image shrinks

                            //delete the enemy completely when the timer reaches 0
                            if (curEnemy.explosionTimer == 0) {
                                myMain.arrEnemies.remove(curEnemy);
                                myMain.numEnemies--;
                                myMain.enemiesDown++;
                            }
                        } else //all the code for when the enemy is alive
                        {
                            //The weakest enemy
                            if (curEnemy.enemyType == 1) {

                                //This code makes the enemy move down continuously until it hits the bottom of screen
                                if ((curEnemy.enemyY < myMain.backgroundImage.getHeight(myFrame) - curEnemy.enemyImage.getHeight(myFrame)) && curEnemy.moveUpEnemy1 == false) {
                                    //dodging bullets
                                    try {
                                        for (Bullet curBullet : myMain.arrBullets) {
                                            //if the bullet is within the enemy's height and the bullet is 60 pixels or closer
                                            //speed up the enemy's speed to attempt bullet dodging
                                            if (curEnemy.enemyX - curBullet.bulletX <= 60) {
                                                if ((((curBullet.bulletY >= curEnemy.enemyY) && (curBullet.bulletY <= curEnemy.enemyY + curEnemy.enemyImage.getHeight(myFrame))) || ((curBullet.bulletY + curBullet.imgBullet.getHeight(myFrame) <= curEnemy.enemyY + curEnemy.enemyImage.getHeight(myFrame) && curBullet.bulletY + curBullet.imgBullet.getHeight(myFrame) >= curEnemy.enemyY)))) {
                                                    curEnemy.enemyY += curEnemy.enemySpeed * 2.5;
                                                }
                                            }
                                        }
                                    } catch (java.util.ConcurrentModificationException e) {
                                    }

                                    //as long as the enemy is moving down, the variable moveUpEnemy1 is always false
                                    curEnemy.moveUpEnemy1 = false;
                                    curEnemy.enemyY += curEnemy.enemySpeed;
                                } else {
                                    //This code makes the enemy move up continuously until it hits the top of screen
                                    try {
                                        for (Bullet curBullet : myMain.arrBullets) {
                                            //if the bullet is within the enemy's height and the bullet is 60 pixels or closer
                                            //speed up the enemy's speed to attempt bullet dodging
                                            if (curEnemy.enemyX - curBullet.bulletX <= 60) {
                                                if ((((curBullet.bulletY >= curEnemy.enemyY) && (curBullet.bulletY <= curEnemy.enemyY + curEnemy.enemyImage.getHeight(myFrame))) || ((curBullet.bulletY + curBullet.imgBullet.getHeight(myFrame) <= curEnemy.enemyY + curEnemy.enemyImage.getHeight(myFrame) && curBullet.bulletY + curBullet.imgBullet.getHeight(myFrame) >= curEnemy.enemyY)))) {
                                                    curEnemy.enemyY -= curEnemy.enemySpeed * 2.5;
                                                }
                                            }
                                        }
                                    } catch (java.util.ConcurrentModificationException e) {
                                    }

                                    //as long as the enemy is moving up, the variable moveUpEnemy1 is always true
                                    curEnemy.moveUpEnemy1 = true;
                                    curEnemy.enemyY -= curEnemy.enemySpeed;
                                    if (curEnemy.enemyY < 0) {
                                        curEnemy.moveUpEnemy1 = false;
                                        //myMain.enemyY[0] += 8;
                                    }
                                }

                                //this checks if the enemy "sees" the player taking Y's and Heights into account
                                if ((((curEnemy.enemyY >= myMain.mouseY) && (curEnemy.enemyY <= myMain.mouseY + myMain.ship.getHeight(myFrame) - 20)) || ((curEnemy.enemyY + curEnemy.enemyImage.getHeight(myFrame) <= myMain.mouseY + myMain.ship.getHeight(myFrame) && curEnemy.enemyY + myMain.enemy1.getHeight(myFrame) >= myMain.mouseY + 20))) && System.currentTimeMillis() - curEnemy.timeAtShot > 150) {

                                    //determines whether it will be a regular shot or a heatseeker
                                    int enemyBulletType = (int) Math.floor(Math.random() * 1001);

                                    //Create a heatseeking bullet
                                    if (enemyBulletType <= 200) {
                                        EnemyBullet nextEnemyBullet = new EnemyBullet(curEnemy.enemyX, curEnemy.enemyY + curEnemy.enemyImage.getHeight(myFrame), myMain.enemyMine, 2);
                                        myMain.arrEnemyBullets.add(nextEnemyBullet);
                                    } //Creat a regular bullet (shot straight forwards)
                                    else {
                                        EnemyBullet nextEnemyBullet = new EnemyBullet(curEnemy.enemyX, curEnemy.enemyY + curEnemy.enemyImage.getHeight(myFrame), myMain.blueBullet, 1);
                                        myMain.arrEnemyBullets.add(nextEnemyBullet);
                                    }


                                    //timeAtShot is originally the current time.
                                    //before shooting, check if 60 milliseconds have passed
                                    //after shooting set the timeAtShot to be the current time
                                    //this is a way of making the enemy wait without freezing the game
                                    curEnemy.timeAtShot = System.currentTimeMillis();
                                }
                            } else if (curEnemy.enemyType == 2) {
                                //this is the diamond pattern moving style
                                if (curEnemy.moveStyle == 1) {
                                    //select the choices for the enemies movement pattern
                                    if (curEnemy.setupTheChoices == true) {
                                        //These are the points which make up the diamond

                                        curEnemy.topX = (int) (Math.random() * 200 + 600);
                                        curEnemy.topY = (int) (Math.random() * 100 + 10);

                                        curEnemy.leftX = (int) (Math.random() * 100 + 500);
                                        curEnemy.leftY = curEnemy.topY + 250;

                                        curEnemy.bottomX = curEnemy.topX;
                                        curEnemy.bottomY = (int) (Math.random() * 100 + 500);

                                        curEnemy.rightX = (int) (Math.random() * 150 + 800);
                                        curEnemy.rightY = curEnemy.leftY;

                                        //checks if the enemy was spawned from the top or
                                        //bottom of the screen and selects the appropriate variable
                                        //to start from (moveDownLeft if at the top),(moveUpRight if below)
                                        if (curEnemy.enemyY < curEnemy.topY) {
                                            curEnemy.startAtTop = true;
                                            curEnemy.moveDownLeft = true;
                                        }
                                        if (curEnemy.enemyY > curEnemy.bottomY) {
                                            curEnemy.startAtTop = false;
                                            curEnemy.moveUpRight = true;
                                        }

                                        curEnemy.setupTheChoices = false;
                                    }

                                    //move down left
                                    if (curEnemy.moveDownLeft == true) {
                                        //diagonal down left
                                        curEnemy.enemyY += curEnemy.enemySpeed;
                                        curEnemy.enemyX -= 3;

                                        //if it reaches the next positions coordinates, switch movement direction
                                        if (curEnemy.enemyY >= curEnemy.leftY || curEnemy.enemyX <= curEnemy.leftX) {
                                            curEnemy.moveDownLeft = false;
                                            curEnemy.moveDownRight = true;
                                        }

                                    } else if (curEnemy.moveDownRight == true) {
                                        //diagonal down right
                                        curEnemy.enemyY += curEnemy.enemySpeed;
                                        curEnemy.enemyX += 3;//curEnemy.enemySpeed;

                                        //if it reaches the next positions coordinates, switch movement direction
                                        if (curEnemy.enemyY >= curEnemy.bottomY || curEnemy.enemyX >= curEnemy.bottomX) {
                                            curEnemy.moveDownRight = false;
                                            curEnemy.moveUpRight = true;
                                        }
                                    } else if (curEnemy.moveUpRight == true) {
                                        //diagonal up right
                                        curEnemy.enemyY -= curEnemy.enemySpeed;
                                        curEnemy.enemyX += 3;

                                        //if it reaches the next positions coordinates, switch movement direction
                                        if (curEnemy.enemyY <= curEnemy.rightY || curEnemy.enemyX >= curEnemy.rightX) {
                                            curEnemy.moveUpRight = false;
                                            curEnemy.moveUpLeft = true;
                                        }
                                    } else if (curEnemy.moveUpLeft == true) {
                                        //diagonal up left
                                        curEnemy.enemyY -= curEnemy.enemySpeed;
                                        curEnemy.enemyX -= 3;

                                        //if it reaches the next positions coordinates, switch movement direction
                                        if (curEnemy.enemyY <= curEnemy.topY || curEnemy.enemyX <= curEnemy.topX) {
                                            curEnemy.moveUpLeft = false;
                                            curEnemy.moveDownLeft = true;
                                        }
                                    }
                                } else //This is just horizontal movement
                                {
                                    //if the enemy reaches the other end of the screen,reset it's
                                    //x to the front and give it a random Y to seem like it's coming
                                    //from somewhere else
                                    curEnemy.enemyX -= curEnemy.enemySpeed;
                                    if (curEnemy.enemyX <= -100) {
                                        curEnemy.enemyX = 1100;
                                        curEnemy.enemyY = (int) (Math.random() * 450 + 100);
                                    }
                                }

                                int fireRate; //how fast the enemy can fire

                                //different firing rates based on the moving styles
                                if (curEnemy.moveStyle == 1) {
                                    fireRate = 750;
                                } else {
                                    fireRate = 700;
                                }

                                //check if the appropriate amount of time has passed since last firing
                                if (System.currentTimeMillis() - curEnemy.timeAtShot > fireRate) {

                                    //decides whether it will shoot heatseeker or regular shots
                                    int enemyBulletType = (int) Math.floor(Math.random() * 1001);

                                    //heatseekers
                                    if (enemyBulletType <= 200) {
                                        EnemyBullet nextEnemyBullet = new EnemyBullet(curEnemy.enemyX, curEnemy.enemyY + curEnemy.enemyImage.getHeight(myFrame), myMain.enemyMine, 2);
                                        myMain.arrEnemyBullets.add(nextEnemyBullet);
                                    } //regulars
                                    else {
                                        EnemyBullet nextEnemyBullet = new EnemyBullet(curEnemy.enemyX, curEnemy.enemyY + curEnemy.enemyImage.getHeight(myFrame), myMain.greenBullet, 3);
                                        myMain.arrEnemyBullets.add(nextEnemyBullet);
                                    }

                                    //timeAtShot is originally the current time.
                                    //before shooting, check if 60 milliseconds have passed
                                    //after shooting set the timeAtShot to be the current time
                                    //this is a way of making the enemy wait without freezing the game
                                    curEnemy.timeAtShot = System.currentTimeMillis();
                                }
                            } else if (curEnemy.enemyType == 3) {
                                //this vertical movement is the same as enemy 1's
                                //This code makes the enemy move down continuously until it hits the bottom of screen
                                if (curEnemy.moveStyle == 1) {
                                    if ((curEnemy.enemyY < myMain.backgroundImage.getHeight(myFrame) - curEnemy.enemyImage.getHeight(myFrame)) && curEnemy.moveUpEnemy1 == false) {
                                        //dodging bullets
                                        //Same as for enemy1 above
                                        try {
                                            for (Bullet curBullet : myMain.arrBullets) {
                                                if (curEnemy.enemyX - curBullet.bulletX <= 60) {
                                                    if ((((curBullet.bulletY >= curEnemy.enemyY) && (curBullet.bulletY <= curEnemy.enemyY + curEnemy.enemyImage.getHeight(myFrame))) || ((curBullet.bulletY + curBullet.imgBullet.getHeight(myFrame) <= curEnemy.enemyY + curEnemy.enemyImage.getHeight(myFrame) && curBullet.bulletY + curBullet.imgBullet.getHeight(myFrame) >= curEnemy.enemyY)))) {
                                                        curEnemy.enemyY += curEnemy.enemySpeed * 2.5;
                                                    }
                                                }
                                            }
                                        } catch (java.util.ConcurrentModificationException e) {
                                        }

                                        //as long as the enemy is moving down, the variable moveUpEnemy1 is always false
                                        curEnemy.moveUpEnemy1 = false;
                                        curEnemy.enemyY += (curEnemy.enemySpeed + 2);
                                    } else {
                                        //dodging bullets
                                        //Same as for enemy1 above
                                        try {
                                            for (Bullet curBullet : myMain.arrBullets) {
                                                if (curEnemy.enemyX - curBullet.bulletX <= 60) {
                                                    if ((((curBullet.bulletY >= curEnemy.enemyY) && (curBullet.bulletY <= curEnemy.enemyY + curEnemy.enemyImage.getHeight(myFrame))) || ((curBullet.bulletY + curBullet.imgBullet.getHeight(myFrame) <= curEnemy.enemyY + curEnemy.enemyImage.getHeight(myFrame) && curBullet.bulletY + curBullet.imgBullet.getHeight(myFrame) >= curEnemy.enemyY)))) {
                                                        curEnemy.enemyY -= (curEnemy.enemySpeed * 2.5 + 2);
                                                    }
                                                }
                                            }
                                        } catch (java.util.ConcurrentModificationException e) {
                                        }

                                        //as long as the enemy is moving up, the variable moveUpEnemy1 is always true
                                        curEnemy.moveUpEnemy1 = true;
                                        curEnemy.enemyY -= curEnemy.enemySpeed;
                                        //if it hits the top of the screen
                                        if (curEnemy.enemyY < 0) {
                                            curEnemy.moveUpEnemy1 = false;
                                            //myMain.enemyY[0] += 8;
                                        }
                                    }
                                } else //This is horizontal movement (smae as enemy two's)
                                {
                                    curEnemy.enemyX -= (curEnemy.enemySpeed + 2);
                                    //if the enemy reaches the end, reset the x value to the front
                                    //and make a random Y
                                    if (curEnemy.enemyX <= -100) {
                                        curEnemy.enemyX = 1100;
                                        curEnemy.enemyY = (int) (Math.random() * 450 + 100);
                                    }
                                }

                                //different firingRates for the different movingStyles
                                int fireRate;
                                if (curEnemy.moveStyle == 1) {
                                    fireRate = 750;
                                } else {
                                    fireRate = 700;
                                }

                                //check if the appropriate amount of time has passed since last firing
                                if (System.currentTimeMillis() - curEnemy.timeAtShot > fireRate) {
                                    //decides whether they will be heatseekers or regular shots
                                    int enemyBulletType = (int) Math.floor(Math.random() * 1001);
                                    //heatseekers
                                    if (enemyBulletType <= 200) {
                                        EnemyBullet nextEnemyBullet = new EnemyBullet(curEnemy.enemyX, curEnemy.enemyY + curEnemy.enemyImage.getHeight(myFrame), myMain.enemyMine, 2);
                                        myMain.arrEnemyBullets.add(nextEnemyBullet);
                                    } //regular
                                    else {
                                        //Based on the movement Style, the enemies fire differently

                                        //fires a shot where it last saw you
                                        if (curEnemy.moveStyle == 1) {
                                            EnemyBullet nextEnemyBullet = new EnemyBullet(curEnemy.enemyX, curEnemy.enemyY + curEnemy.enemyImage.getHeight(myFrame), myMain.whiteBullet, 3);
                                            myMain.arrEnemyBullets.add(nextEnemyBullet);
                                        } //fires a shot where it last saw you and a backwards shot
                                        else if (curEnemy.moveStyle == 2) {
                                            EnemyBullet nextEnemyBullet = new EnemyBullet(curEnemy.enemyX, curEnemy.enemyY + curEnemy.enemyImage.getHeight(myFrame), myMain.whiteBullet, 3);
                                            myMain.arrEnemyBullets.add(nextEnemyBullet);
                                            nextEnemyBullet = new EnemyBullet(curEnemy.enemyX, curEnemy.enemyY + curEnemy.enemyImage.getHeight(myFrame), myMain.whiteBullet, 4);
                                            myMain.arrEnemyBullets.add(nextEnemyBullet);
                                        }
                                    }

                                    //timeAtShot is originally the current time.
                                    //before shooting, check if 60 milliseconds have passed
                                    //after shooting set the timeAtShot to be the current time
                                    //this is a way of making the enemy wait without freezing the game
                                    curEnemy.timeAtShot = System.currentTimeMillis();
                                }
                            } else if (curEnemy.enemyType == 4) //This is the boss
                            {

                                //All of this code is the same as for enemy1, the boss moves up and down (veritcally)

                                //Moving down
                                if ((curEnemy.enemyY < myMain.backgroundImage.getHeight(myFrame) - curEnemy.enemyImage.getHeight(myFrame)) && curEnemy.moveUpEnemy1 == false) {
                                    //dodging bullets
                                    //same as enemy1 except, it has better detection for dodging
                                    try {
                                        for (Bullet curBullet : myMain.arrBullets) {
                                            //Instead of 60 pixels, 80 pixels
                                            if (curEnemy.enemyX - curBullet.bulletX <= 80) {
                                                if ((((curBullet.bulletY >= curEnemy.enemyY) && (curBullet.bulletY <= curEnemy.enemyY + curEnemy.enemyImage.getHeight(myFrame))) || ((curBullet.bulletY + curBullet.imgBullet.getHeight(myFrame) <= curEnemy.enemyY + curEnemy.enemyImage.getHeight(myFrame) && curBullet.bulletY + curBullet.imgBullet.getHeight(myFrame) >= curEnemy.enemyY)))) {
                                                    curEnemy.enemyY += curEnemy.enemySpeed * 3.5;
                                                }
                                            }
                                        }
                                    } catch (java.util.ConcurrentModificationException e) {
                                    }
                                    //as long as the enemy is moving down, the variable moveUpEnemy1 is always false
                                    curEnemy.moveUpEnemy1 = false;
                                    curEnemy.enemyY += curEnemy.enemySpeed;
                                } //Moving Up
                                else {
                                    //dodging bullets
                                    //same as enemy1 except, it has better detection for dodging
                                    try {
                                        for (Bullet curBullet : myMain.arrBullets) {
                                            //Instead of 60 pixels, 80 pixels
                                            if (curEnemy.enemyX - curBullet.bulletX <= 80) {
                                                if ((((curBullet.bulletY >= curEnemy.enemyY) && (curBullet.bulletY <= curEnemy.enemyY + curEnemy.enemyImage.getHeight(myFrame))) || ((curBullet.bulletY + curBullet.imgBullet.getHeight(myFrame) <= curEnemy.enemyY + curEnemy.enemyImage.getHeight(myFrame) && curBullet.bulletY + curBullet.imgBullet.getHeight(myFrame) >= curEnemy.enemyY)))) {
                                                    curEnemy.enemyY -= curEnemy.enemySpeed * 3.5;
                                                }
                                            }
                                        }
                                    } catch (java.util.ConcurrentModificationException e) {
                                    }

                                    //as long as the enemy is moving up, the variable moveUpEnemy1 is always true
                                    curEnemy.moveUpEnemy1 = true;
                                    curEnemy.enemyY -= curEnemy.enemySpeed;
                                    if (curEnemy.enemyY < 0) {
                                        curEnemy.moveUpEnemy1 = false;
                                        //myMain.enemyY[0] += 8;
                                    }
                                }

                                //checks if 1/2 second has passed since last shooting
                                if (System.currentTimeMillis() - curEnemy.timeAtShot > 500) {

                                    //decides whether it will be a heatseeker or other
                                    int enemyBulletType = (int) Math.floor(Math.random() * 1001);
                                    //heatseeker
                                    if (enemyBulletType <= 200) {
                                        EnemyBullet nextEnemyBullet = new EnemyBullet(curEnemy.enemyX + curEnemy.enemyImage.getWidth(myFrame) / 2, curEnemy.enemyY + curEnemy.enemyImage.getHeight(myFrame) / 2, myMain.enemyMine, 2);
                                        myMain.arrEnemyBullets.add(nextEnemyBullet);
                                    } //creates various weapons. selection is based on the boss's health
                                    //lower health = stronger weapons
                                    else {
                                        //create the variable for the shootingType
                                        int shootingType = 0;
                                        //if the health is above 2/3
                                        if (curEnemy.enemyHP >= myMain.bossHealth / 3 * 2) {
                                            //types 1,2,3
                                            shootingType = (int) Math.floor(Math.random() * 3 + 1);
                                        } //if the health is above 1/3 and below 2/3
                                        else if (curEnemy.enemyHP < myMain.bossHealth / 3 * 2 && curEnemy.enemyHP >= myMain.bossHealth / 3) {
                                            //types 2,3,4
                                            shootingType = (int) Math.round(Math.random() * 2 + 2);
                                        } //if the health is below 1/3
                                        else if (curEnemy.enemyHP < myMain.bossHealth / 3) {
                                            //types 2,3,4,5
                                            shootingType = (int) Math.round(Math.random() * 3 + 2);
                                        }

                                        //one bullet which is shot at your last known position
                                        if (shootingType == 1) {
                                            EnemyBullet nextEnemyBullet = new EnemyBullet(curEnemy.enemyX + curEnemy.enemyImage.getWidth(myFrame) / 2, curEnemy.enemyY + curEnemy.enemyImage.getHeight(myFrame) / 2, myMain.whiteBullet, 3);
                                            myMain.arrEnemyBullets.add(nextEnemyBullet);
                                        } //The Boss's Missiles
                                        else if (shootingType == 2) {
                                            EnemyBullet nextEnemyBullet = new EnemyBullet(curEnemy.enemyX + curEnemy.enemyImage.getWidth(myFrame) / 2, curEnemy.enemyY, myMain.bossMissile, 10);
                                            myMain.arrEnemyBullets.add(nextEnemyBullet);
                                            nextEnemyBullet = new EnemyBullet(curEnemy.enemyX + curEnemy.enemyImage.getWidth(myFrame) / 2, curEnemy.enemyY + curEnemy.enemyImage.getHeight(myFrame), myMain.bossMissile, 10);
                                            myMain.arrEnemyBullets.add(nextEnemyBullet);
                                        } //5 bullets (one forwards, straight, the other 4 (2 diagonal Up and 2 diagonal Down)
                                        else if (shootingType == 3) {
                                            EnemyBullet nextEnemyBullet = new EnemyBullet(curEnemy.enemyX + curEnemy.enemyImage.getWidth(myFrame) / 2, curEnemy.enemyY + curEnemy.enemyImage.getHeight(myFrame) / 2, myMain.whiteBullet, 1);
                                            myMain.arrEnemyBullets.add(nextEnemyBullet);
                                            nextEnemyBullet = new EnemyBullet(curEnemy.enemyX + curEnemy.enemyImage.getWidth(myFrame) / 2, curEnemy.enemyY + curEnemy.enemyImage.getHeight(myFrame) / 2, myMain.blueBullet, 5);
                                            myMain.arrEnemyBullets.add(nextEnemyBullet);
                                            nextEnemyBullet = new EnemyBullet(curEnemy.enemyX + curEnemy.enemyImage.getWidth(myFrame) / 2, curEnemy.enemyY + curEnemy.enemyImage.getHeight(myFrame) / 2, myMain.whiteBullet, 6);
                                            myMain.arrEnemyBullets.add(nextEnemyBullet);
                                            nextEnemyBullet = new EnemyBullet(curEnemy.enemyX + curEnemy.enemyImage.getWidth(myFrame) / 2, curEnemy.enemyY + curEnemy.enemyImage.getHeight(myFrame) / 2, myMain.blueBullet, 7);
                                            myMain.arrEnemyBullets.add(nextEnemyBullet);
                                            nextEnemyBullet = new EnemyBullet(curEnemy.enemyX + curEnemy.enemyImage.getWidth(myFrame) / 2, curEnemy.enemyY + curEnemy.enemyImage.getHeight(myFrame) / 2, myMain.whiteBullet, 8);
                                            myMain.arrEnemyBullets.add(nextEnemyBullet);
                                        } //This lets him shoot 4 shots. each one is delayed after the other so it can't be
                                        //done inside here
                                        else if (shootingType == 4) {
                                            myMain.multiShot = true;
                                        } //The boss's laser
                                        else if (shootingType == 5) {
                                            EnemyBullet nextEnemyBullet = new EnemyBullet(curEnemy.enemyX + curEnemy.enemyImage.getWidth(myFrame) / 2, curEnemy.enemyY + curEnemy.enemyImage.getHeight(myFrame) / 2, myMain.laserFlip, 9);
                                            myMain.arrEnemyBullets.add(nextEnemyBullet);
                                        }
                                    }

                                    //timeAtShot is originally the current time.
                                    //before shooting, check if 60 milliseconds have passed
                                    //after shooting set the timeAtShot to be the current time
                                    //this is a way of making the enemy wait without freezing the game
                                    curEnemy.timeAtShot = System.currentTimeMillis();
                                }

                                //shooting multiple shots in a row
                                //Shoots 4 shots which are similar to the boss's type 1. they are shot at your last known location
                                if (myMain.multiShot == true && System.currentTimeMillis() - myMain.timeAtMultiShot > 200) {
                                    EnemyBullet nextEnemyBullet = new EnemyBullet(curEnemy.enemyX + curEnemy.enemyImage.getWidth(myFrame) / 2, curEnemy.enemyY + curEnemy.enemyImage.getHeight(myFrame) / 2, myMain.greenBullet, 3);
                                    myMain.arrEnemyBullets.add(nextEnemyBullet);
                                    myMain.timeAtMultiShot = System.currentTimeMillis();
                                    //increase the number of shot's he's taken
                                    myMain.numShots++;
                                    //if he's taken 4 shots, stop firing
                                    //make multiShot false and reset numShots to 0
                                    if (myMain.numShots == 4) {
                                        myMain.multiShot = false;
                                        myMain.numShots = 0;
                                    }
                                }
                            }

                        }
                    }
                } catch (java.util.ConcurrentModificationException e) {
                }
                //For the Enemies' bullets
                try {
                    for (EnemyBullet curEnemyBullet : myMain.arrEnemyBullets) {
                        //just a straight moving bullet
                        if (curEnemyBullet.travelMethod == 1) {
                            curEnemyBullet.enemyBulletX -= myMain.enemyBulletSpeed;
                        } //backwards shot
                        else if (curEnemyBullet.travelMethod == 4) {
                            curEnemyBullet.enemyBulletX += (myMain.enemyBulletSpeed - 2);
                        } //These are heatseeking bombs/mines
                        else if (curEnemyBullet.travelMethod == 2) {
                            //Calculate the angle to the player
                            curEnemyBullet.angleToPlayer = Math.atan2(myMain.mouseY + myMain.ship.getHeight(myFrame) / 2 - curEnemyBullet.enemyBulletY,
                                    myMain.mouseX + myMain.ship.getWidth(myFrame) / 2 - curEnemyBullet.enemyBulletX);

                            //Increase the X and Y positions of the bullet by the appropriate amount needed
                            curEnemyBullet.enemyBulletX += 9 * Math.cos((curEnemyBullet.angleToPlayer - 1));
                            curEnemyBullet.enemyBulletY += 9 * Math.sin((curEnemyBullet.angleToPlayer - 1));

                            //These bullets only last for 150 millis
                            curEnemyBullet.enemyMineTimer--;
                            //delete the bullet if the time is up
                            if (curEnemyBullet.enemyMineTimer == 0) {
                                myMain.arrEnemyBullets.remove(curEnemyBullet);
                            }

                        } //This shoots at the player's last known coordinates
                        else if (curEnemyBullet.travelMethod == 3) {
                            //calculate the angle to the player only once (dont do it every frame like in heatseek)
                            if (curEnemyBullet.getThePlayerCoordinates == true) {
                                curEnemyBullet.angleToPlayer = Math.atan2(myMain.mouseY + myMain.ship.getHeight(myFrame) / 2 - curEnemyBullet.enemyBulletY,
                                        myMain.mouseX + myMain.ship.getWidth(myFrame) / 2 - curEnemyBullet.enemyBulletX);
                                curEnemyBullet.getThePlayerCoordinates = false;
                            }
                            //Increase the X and Y values the appropriate amount for the proper direction
                            curEnemyBullet.enemyBulletX += 10 * Math.cos((curEnemyBullet.angleToPlayer));
                            curEnemyBullet.enemyBulletY += 10 * Math.sin((curEnemyBullet.angleToPlayer));
                        } //Diagonal Up
                        else if (curEnemyBullet.travelMethod == 5) {
                            curEnemyBullet.enemyBulletX -= myMain.enemyBulletSpeed;
                            curEnemyBullet.enemyBulletY -= 2;
                        } //Diagonal Up Big
                        else if (curEnemyBullet.travelMethod == 6) {
                            curEnemyBullet.enemyBulletX -= myMain.enemyBulletSpeed;
                            curEnemyBullet.enemyBulletY -= 5;
                        } //Diagonal Down
                        else if (curEnemyBullet.travelMethod == 7) {
                            curEnemyBullet.enemyBulletX -= myMain.enemyBulletSpeed;
                            curEnemyBullet.enemyBulletY += 2;
                        } //Diaonal Down Big
                        else if (curEnemyBullet.travelMethod == 8) {
                            curEnemyBullet.enemyBulletX -= myMain.enemyBulletSpeed;
                            curEnemyBullet.enemyBulletY += 5;
                        } //The laser
                        else if (curEnemyBullet.travelMethod == 9) // laser
                        {
                            //the laser just travels with the boss
                            for (Enemy curEnemy : myMain.arrEnemies) {
                                curEnemyBullet.enemyBulletX = curEnemy.enemyX - 650;
                                curEnemyBullet.enemyBulletY = curEnemy.enemyY + 5;
                            }

                            //the timer for the laser goes down
                            curEnemyBullet.enemyLaserTimer--;

                            //if the time for the laser is up, delete the laser
                            if (curEnemyBullet.enemyLaserTimer == 0) {
                                myMain.arrEnemyBullets.remove(curEnemyBullet);
                            }
                        } //This is for the Boss's missiles
                        else if (curEnemyBullet.travelMethod == 10) {
                            //They travel straight forwards but they start slow and get faster as they travel
                            curEnemyBullet.enemyBulletX -= curEnemyBullet.speedChanger;
                            //this makes it travel faster every time
                            curEnemyBullet.speedChanger++;
                        }
                        //collision detection
                        if ((curEnemyBullet.enemyBulletX + curEnemyBullet.imgEnemyBullet.getWidth(myFrame) >= myMain.mouseX) && (curEnemyBullet.enemyBulletX <= myMain.mouseX + myMain.ship.getWidth(myFrame)) && (curEnemyBullet.enemyBulletY + curEnemyBullet.imgEnemyBullet.getHeight(myFrame) >= myMain.mouseY) && (curEnemyBullet.enemyBulletY <= myMain.mouseY + myMain.ship.getHeight(myFrame))) {
                            //reset the bullet direction and remove the bullet
                            curEnemyBullet.enemyBDirection = Math.PI;
                            myMain.arrEnemyBullets.remove(curEnemyBullet);

                            //if ship wasn't recently attacked (since it has short invincibility)
                            //damage the player's ship
                            if (myMain.damagable == true) {
                                //if it is not the boss's laser
                                if (curEnemyBullet.travelMethod != 9) {
                                    myMain.shipHealth -= 1;
                                } else // if it is the boss's laser, do more damage
                                {
                                    myMain.shipHealth -= 2;
                                }
                                //change the hp Bar of the player and make him go into invincible mode
                                myMain.hpInsideWidthChange = (int) (myMain.shipHealth / 0.106);
                                myMain.damagable = false;
                                //power down the player's weapons if they're hit
                                if (myMain.bulletType > 1) {
                                    myMain.bulletType--;
                                }
                            } else if (myMain.damagable == false) {
                                //do nothing
                            }
                        } //if the bullets go off screen, delete them
                        else if (curEnemyBullet.enemyBulletX < -10 || curEnemyBullet.enemyBulletY < -10 || curEnemyBullet.enemyBulletX > myMain.backgroundImage.getWidth(myFrame) || curEnemyBullet.enemyBulletY > myMain.backgroundImage.getHeight(myFrame)) {
                            myMain.arrEnemyBullets.remove(curEnemyBullet);
                        }
                        if (myMain.shipHealth <= 0) //player lose
                        {
                            myMain.gameOver = 2; //the losing #
                        }
                    }
                } catch (java.util.ConcurrentModificationException e) {
                }

                //**********************************PLAYER SHOOTING BEGINS
                //Shooting bullet

                //bullets
                try {
                    //for each bullet, check the bullet's type to see how to determine their travelling styles
                    for (Bullet curBullet : myMain.arrBullets) {
                        //Just a straight moving bullet
                        if (myMain.bulletType == 1) {
                            curBullet.bulletX += myMain.bulletSpeed;
                        } //A straight moving bullet with two diagonal moving ones a little bit
                        //below and abov the the straight moving one
                        else if (myMain.bulletType == 2) {
                            if (curBullet.travelMethod == 1) {
                                curBullet.bulletX += myMain.bulletSpeed;
                            } else if (curBullet.travelMethod == 2) //diag Up
                            {
                                curBullet.bulletX += myMain.bulletSpeed;
                                curBullet.bulletY -= 10;
                            } else //diag Down
                            {
                                curBullet.bulletX += myMain.bulletSpeed;
                                curBullet.bulletY += 10;
                            }
                        } //the same as type 2 except with two more diagonal moving bullets
                        //even farther above and below the straight moving ones
                        //5 bullets in total
                        else if (myMain.bulletType == 3) {
                            if (curBullet.travelMethod == 1) {
                                curBullet.bulletX += myMain.bulletSpeed;
                            } else if (curBullet.travelMethod == 2) //diagonal Up
                            {
                                curBullet.bulletX += myMain.bulletSpeed;
                                curBullet.bulletY -= 10;
                            } else if (curBullet.travelMethod == 3) //diagonal Down
                            {
                                curBullet.bulletX += myMain.bulletSpeed;
                                curBullet.bulletY += 10;
                            } else if (curBullet.travelMethod == 4) //diagonal Up Big
                            {
                                curBullet.bulletX += myMain.bulletSpeed;
                                curBullet.bulletY -= myMain.bulletSpeed;
                            } else //diag Down Big
                            {
                                curBullet.bulletX += myMain.bulletSpeed;
                                curBullet.bulletY += myMain.bulletSpeed;
                            }
                        } //a straight moving, wide blast
                        else if (myMain.bulletType == 4) {
                            curBullet.bulletX += myMain.bulletSpeed;
                        } //a straight moving, wide blast with two bullets moving diagonally
                        //above and below the blast
                        else if (myMain.bulletType == 5) {
                            if (curBullet.travelMethod == 1) {
                                curBullet.bulletX += myMain.bulletSpeed;
                            } else if (curBullet.travelMethod == 4) //diagonal Up Big
                            {
                                curBullet.bulletX += myMain.bulletSpeed;
                                curBullet.bulletY -= myMain.bulletSpeed;
                            } else //diagonal Down Big
                            {
                                curBullet.bulletX += myMain.bulletSpeed;
                                curBullet.bulletY += myMain.bulletSpeed;
                            }
                        }

                        //enemy 1 collide
                        try {
                            for (Enemy curEnemy : myMain.arrEnemies) {
                                //collision detection
                                if ((curBullet.bulletX + myMain.playerBullet.getWidth(myFrame) >= curEnemy.enemyX) && (curBullet.bulletX <= curEnemy.enemyX + curEnemy.enemyImage.getWidth(myFrame)) && (curBullet.bulletY + myMain.playerBullet.getHeight(myFrame) >= curEnemy.enemyY) && (curBullet.bulletY <= curEnemy.enemyY + curEnemy.enemyImage.getHeight(myFrame))) {
                                    if (curEnemy.enemyType != 4) {
                                        //remove the bullet from the array
                                        myMain.arrBullets.remove(curBullet);
                                        //if the bullets arent the red or blue blasts (types 4 and 5) do 1 damage
                                        if (myMain.bulletType < 4) {
                                            curEnemy.enemyHP -= 2;
                                        } //else do double the damage
                                        else {
                                            curEnemy.enemyHP -= 3;
                                        }
                                    } else {
                                        //remove the bullet from the array
                                        myMain.arrBullets.remove(curBullet);
                                        //if the bullets arent the red or blue blasts (types 4 and 5) do 1 damage
                                        if (myMain.bulletType < 4) {
                                            curEnemy.enemyHP -= 2;
                                        } //else do double the damage
                                        else {
                                            curEnemy.enemyHP -= 3;
                                        }
                                        //resize the boss's hp bar
                                        myMain.bossHpInsideWidthChange = (int) (curEnemy.enemyHP / 5.32);
                                    }
                                } //if the player's bullets go off screen
                                else if (curBullet.bulletX < -10 || curBullet.bulletY < -10 || curBullet.bulletX > myMain.backgroundImage.getWidth(myFrame) || curBullet.bulletY > myMain.backgroundImage.getHeight(myFrame)) {
                                    //remove the player's bullet
                                    myMain.arrBullets.remove(curBullet);
                                }
                            }
                        } catch (java.util.ConcurrentModificationException e) {
                        }
                    }
                } catch (java.util.ConcurrentModificationException e) {
                }

                //Player's Bombs
                try {
                    for (Bomb curBomb : myMain.arrBombs) {
                        //If the bomb is going to collide for the first time,
                        //the picture is of the bomb when it travels and then when it
                        //collides, it becomes the picture of the electric ring

                        if (curBomb.collideBeforeExplosion == true) {
                            try {
                                for (Enemy curEnemy : myMain.arrEnemies) {
                                    //This is the same as the calculation for the the enemies heatseekers except switched to get the
                                    //angle to the enemy
                                    myMain.angleToEnemy = Math.atan2(curEnemy.enemyY + curEnemy.enemyImage.getHeight(myFrame) / 2 - curBomb.bombY,
                                            curEnemy.enemyX + curEnemy.enemyImage.getWidth(myFrame) / 2 - curBomb.bombX);
                                    curBomb.bombX += 10 * Math.cos((myMain.angleToEnemy));
                                    curBomb.bombY += 10 * Math.sin((myMain.angleToEnemy));

                                    //collision
                                    if ((curBomb.bombX + curBomb.imgBomb.getWidth(myFrame) >= curEnemy.enemyX) && (curBomb.bombX <= curEnemy.enemyX + curEnemy.enemyImage.getWidth(myFrame)) && (curBomb.bombY + curBomb.imgBomb.getHeight(myFrame) >= curEnemy.enemyY) && (curBomb.bombY <= curEnemy.enemyY + curEnemy.enemyImage.getHeight(myFrame))) {
                                        //make the boolean false (switching to the electric ring)
                                        if (curEnemy.enemyType != 4) {
                                            curBomb.collideBeforeExplosion = false;
                                        } //if the bomb collided with the boss, you have to take
                                        //off his hp in here instead of the following if statement
                                        //since the boss will be the only enemy onscreen he will be
                                        //damaged every single frame which would be very unfair
                                        else {

                                            curBomb.collideBeforeExplosion = false;
                                            curEnemy.enemyHP -= 30;
                                            //resizehis health bar
                                            myMain.bossHpInsideWidthChange = (int) (curEnemy.enemyHP / 5.32);
                                        }


                                    } //if the bomb reaches the end of the screen, it disappears
                                    else if (curBomb.bombX > myMain.backgroundImage.getWidth(myFrame) + 10) {
                                        myMain.arrBombs.remove(curBomb);
                                    }
                                }
                            } catch (java.util.ConcurrentModificationException e) {
                            }
                        } //If the bomb has collided, it will switch to the picture of the explosion,
                        //The bombExpTimer variable decides how long the explosion will last before it disappears
                        //The height and width variables in here increase to make it seem that the electric ring
                        //explosion is expanding every time that it's drawn
                        else if (curBomb.collideBeforeExplosion == false) {
                            curBomb.bombExpTimer--;
                            curBomb.bombExpWidth += 4;
                            curBomb.bombExpHeight += 4;
                            curBomb.bombX -= 1;
                            curBomb.bombY -= 1;

                            for (Enemy curEnemy : myMain.arrEnemies) {
                                //calculate the distance Squared between the bomb and the enemy
                                curBomb.distanceSquared = (Math.pow((curEnemy.enemyX + curEnemy.enemyImage.getWidth(myFrame) / 2) -
                                        (curBomb.bombX + curBomb.imgBomb.getWidth(myFrame) / 2), 2) +
                                        Math.pow((curEnemy.enemyY + curEnemy.enemyImage.getHeight(myMain) / 2) -
                                        (curBomb.bombY + curBomb.imgBomb.getHeight(myMain) / 2), 2));


                                if (((curBomb.bombX + curBomb.imgBomb.getWidth(myFrame) >= curEnemy.enemyX) && (curBomb.bombX <= curEnemy.enemyX + curEnemy.enemyImage.getWidth(myFrame)) && (curBomb.bombY + curBomb.imgBomb.getHeight(myFrame) >= curEnemy.enemyY) && (curBomb.bombY <= curEnemy.enemyY + curEnemy.enemyImage.getHeight(myFrame))) || curBomb.distanceSquared <= 20000) {
                                    //if it collides with regular enemy's, it will ont hit kill
                                    if (curEnemy.enemyType != 4) {
                                        curEnemy.enemyHP -= 10;
                                    } //if it collides with the boss, it will do nothing since the damage was done previously
                                    else {
                                    }
                                }
                            }

                            //remove the bomb after the timer hits 0
                            if (curBomb.bombExpTimer == 0) {
                                myMain.arrBombs.remove(curBomb);
                            }
                        }
                    }
                } catch (java.util.ConcurrentModificationException e) {
                }

                //PowerUps
                try {
                    for (PowerUp curPowerUp : myMain.arrPowerUp) {
                        //if the powerup is created above the screen, it will travel down
                        //if it was made below the screen, it will travel up
                        if (curPowerUp.startAtTop == true) {
                            curPowerUp.powerUpY += 2;
                            curPowerUp.powerUpX -= curPowerUp.powerUpSpeed;
                        } else if (curPowerUp.startAtTop == false) {
                            curPowerUp.powerUpY -= 2;
                            curPowerUp.powerUpX -= curPowerUp.powerUpSpeed;
                        }

                        //if the power up collides with the user, if it is a health up, increase the player's
                        //health as long as the player doesnt already have max health
                        //if it is a weapons upgrade, increase the player's bullet Type as long as it;s not
                        //the max bullet type
                        if ((curPowerUp.powerUpX + curPowerUp.powerImage.getWidth(myFrame) >= myMain.mouseX) && (curPowerUp.powerUpX <= myMain.mouseX + myMain.ship.getWidth(myFrame)) && (curPowerUp.powerUpY + curPowerUp.powerImage.getHeight(myFrame) >= myMain.mouseY) && (curPowerUp.powerUpY <= myMain.mouseY + myMain.ship.getHeight(myFrame))) {
                            if (curPowerUp.powerUpType == 1) {
                                if (myMain.shipHealth < 20) {
                                    myMain.shipHealth++;
                                    myMain.hpInsideWidthChange = (int) (myMain.shipHealth / 0.106);
                                    myMain.arrPowerUp.remove(curPowerUp);
                                }
                            } else {
                                if (myMain.bulletType < 5) {
                                    myMain.bulletType++;
                                    myMain.arrPowerUp.remove(curPowerUp);
                                }
                            }
                        } //if the power goes offscreen, remove it from the array
                        else if ((curPowerUp.powerUpX < -30) || (curPowerUp.powerUpY < -30 && curPowerUp.startAtTop == false) || curPowerUp.powerUpX > myMain.backgroundImage.getWidth(myFrame) || (curPowerUp.powerUpY > myMain.backgroundImage.getHeight(myFrame) + 30 && curPowerUp.startAtTop == true)) {
                            myMain.arrPowerUp.remove(curPowerUp);
                        }
                    }
                } catch (java.util.ConcurrentModificationException e) {
                }

                //Invincible Mode
                //every 10th of a second flicker the ship image
                //every 10th of a second the variable shipFlicker changes between true and false
                //and the in the paint component, it decides whether it will draw the regular ship
                //or the opaque ship (flicker effect)
                if (myMain.damagable == false) {
                    if (System.currentTimeMillis() - myMain.flickerTimer > 100 && myMain.shipFlicker == false) {
                        myMain.shipFlicker = true;
                        myMain.flickerTimer = System.currentTimeMillis();
                        myMain.invincibleCounter--;
                    } else if (System.currentTimeMillis() - myMain.flickerTimer > 100 && myMain.shipFlicker == true) {
                        myMain.shipFlicker = false;
                        myMain.flickerTimer = System.currentTimeMillis();
                        myMain.invincibleCounter--;
                    }
                }

                //invincibility lasts for one second after being hit
                //after that, make the damagable variable true and the shipFlicker variable false
                //also, reset the flickerTimer to current time and make the invincible counter reset to go back to 20
                if (myMain.invincibleCounter == 0) {
                    myMain.damagable = true;
                    myMain.flickerTimer = System.currentTimeMillis();
                    myMain.shipFlicker = false;
                    myMain.invincibleCounter = 20;
                }

                //for the boss. every 10th of a second, flip between red and blue lasers
                //the flipLaser variable being false or true determines whether the red or blue lase
                //will be drawn inside the paint component
                if (System.currentTimeMillis() - myMain.laserTimer > 100 && myMain.flipLaser == true) {
                    myMain.flipLaser = false;
                    myMain.laserTimer = System.currentTimeMillis();
                } else if (System.currentTimeMillis() - myMain.laserTimer > 100 && myMain.flipLaser == false) {
                    myMain.flipLaser = true;
                    myMain.laserTimer = System.currentTimeMillis();
                }

            } //opening screen boolean

            //if you win or lose, display the win or lose image for 3.5s
            //after that, exit the game
            if (myMain.gameOver == 1 || myMain.gameOver == 2) {
                myMain.gameOverCounter--;
            }
            if (myMain.gameOverCounter == 0) {
                System.exit(0);
            }

            //repaint myMain
            myMain.repaint();

            //makes the game work at roughly 60 frames per second
            try {
                timeMillis += 16;

                Thread.sleep(Math.max(0, timeMillis - System.currentTimeMillis()));
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        } //infinite loop close


    }

    public void paintComponent(Graphics g) {
        if (offScreenGraphicsCtx == null) {
            offScreenImage = createImage(getSize().width, getSize().height);
            offScreenGraphicsCtx = offScreenImage.getGraphics();
        }
        //do all the game stuff if the player closed the intro screen
        //else, display the intro screen
        if (introScreen == false) {
            //for bg Img 0,0 were replaced with bgX, bgY
            offScreenGraphicsCtx.drawImage(backgroundImage, bgX, bgY, this);
            //2nd image for bg
            offScreenGraphicsCtx.drawImage(backgroundImage, bgX + backgroundImage.getWidth(this), bgY, this);

            //Yur health the top is the outer bar and the bottom is the inside bar
            offScreenGraphicsCtx.drawImage(health, 0, 0, this); //health symbol
            offScreenGraphicsCtx.drawImage(hpOutside, hpOutsideX, hpOutsideY, this);
            offScreenGraphicsCtx.drawImage(hpInside, hpInsideX, hpInsideY, hpInsideWidthChange, 22, this);

            //The boss's health status
            if (showBossHealth == true) {
                offScreenGraphicsCtx.drawImage(health, 730, 0, this); //health symbol
                offScreenGraphicsCtx.drawImage(bossHpOutside, bossHpOutsideX, hpOutsideY, this);
                offScreenGraphicsCtx.drawImage(bossHpInside, bossHpInsideX, bossHpInsideY, bossHpInsideWidthChange, 22, this);
            }

            //if you didn't lose the game, display the ship and if it's been hit,
            //it flickers temporarily
            if (gameOver != 2) {
                if (shipFlicker == false) {
                    offScreenGraphicsCtx.drawImage(ship, mouseX - ship.getWidth(this) / 2, mouseY - ship.getHeight(this) / 2, this);
                } else if (shipFlicker == true) {
                    offScreenGraphicsCtx.drawImage(shipAfterImage, mouseX - ship.getWidth(this) / 2, mouseY - ship.getHeight(this) / 2, this);
                }
            } //if you lost, draw the ship outside the screen making it look like it disappeared
            else {
                offScreenGraphicsCtx.drawImage(ship, 0, -100, this);
            }

            //Drawing the enemies
            try {
                for (Enemy curEnemy : arrEnemies) {
                    if (curEnemy.enemyHP > 0) {
                        offScreenGraphicsCtx.drawImage(curEnemy.enemyImage, curEnemy.enemyX, curEnemy.enemyY, this);
                    } else {
                        offScreenGraphicsCtx.drawImage(explosion, curEnemy.enemyX, curEnemy.enemyY, curEnemy.imgWidth, curEnemy.imgHeight, this);
                    }
                }
            } catch (java.util.ConcurrentModificationException e) {
            }

            //********************DRAWING THE PLAYERS SHOTS
            //********************
            try {
                for (Bullet curBullet : arrBullets) {
                    offScreenGraphicsCtx.drawImage(curBullet.imgBullet, curBullet.bulletX, curBullet.bulletY, this);
                }
            } catch (java.util.ConcurrentModificationException e) {
            }

            //Drawing the player's bombs
            try {
                for (Bomb curBomb : arrBombs) {
                    //draw the bomb
                    if (curBomb.collideBeforeExplosion == true) {
                        offScreenGraphicsCtx.drawImage(playerBomb, curBomb.bombX, curBomb.bombY, this);
                    } //if its collided for the first time, change the bomb pic to the electric ring pic and
                    //use the height and width variables to show it expanding
                    else {
                        offScreenGraphicsCtx.drawImage(bombExplosion, curBomb.bombX, curBomb.bombY, curBomb.bombExpWidth, curBomb.bombExpHeight, this);
                    }
                }
            } catch (java.util.ConcurrentModificationException e) {
            }

            //*************Enemy's Bullet's
            try {
                for (EnemyBullet curEnemyBullet : arrEnemyBullets) {
                    //if the bullets are not the boss's laser or missiles, draw them regularly with a height/width of 10 and 10
                    if (curEnemyBullet.travelMethod < 9) {
                        offScreenGraphicsCtx.drawImage(curEnemyBullet.imgEnemyBullet, curEnemyBullet.enemyBulletX, curEnemyBullet.enemyBulletY, 10, 10, this);
                    } else //draw the laser and missiles with their appropriate widths and heights and,
                    //for the laser, draw the red or blue one based on whether flipLaser is true or false
                    {
                        if (curEnemyBullet.travelMethod == 9) {
                            //offScreenGraphicsCtx.drawImage(curEnemyBullet.imgEnemyBullet,curEnemyBullet.enemyBulletX,curEnemyBullet.enemyBulletY,this);
                            if (flipLaser == false) {
                                offScreenGraphicsCtx.drawImage(laser, curEnemyBullet.enemyBulletX, curEnemyBullet.enemyBulletY, this);
                            } else {
                                offScreenGraphicsCtx.drawImage(laserFlip, curEnemyBullet.enemyBulletX, curEnemyBullet.enemyBulletY, this);
                            }
                        } else if (curEnemyBullet.travelMethod == 10) {
                            offScreenGraphicsCtx.drawImage(curEnemyBullet.imgEnemyBullet, curEnemyBullet.enemyBulletX, curEnemyBullet.enemyBulletY, this);
                        }

                    }
                }
            } catch (java.util.ConcurrentModificationException e) {
            }

            //draw the powerUps
            try {
                for (PowerUp curPowerUp : arrPowerUp) {
                    offScreenGraphicsCtx.drawImage(curPowerUp.powerImage, curPowerUp.powerUpX, curPowerUp.powerUpY, this);
                }
            } catch (java.util.ConcurrentModificationException e) {
            }

            //based on the bulletTypes, draw the appropriate image which shows what type of ammo is being used
            switch (bulletType) {
                case 1:
                    offScreenGraphicsCtx.drawImage(ammo1, 0, backgroundImage.getHeight(this) - 80, this);
                    break;
                case 2:
                    offScreenGraphicsCtx.drawImage(ammo2, 0, backgroundImage.getHeight(this) - 80, this);
                    break;
                case 3:
                    offScreenGraphicsCtx.drawImage(ammo3, 0, backgroundImage.getHeight(this) - 80, this);
                    break;
                case 4:
                    offScreenGraphicsCtx.drawImage(ammo4, 0, backgroundImage.getHeight(this) - 80, this);
                    break;
                case 5:
                    offScreenGraphicsCtx.drawImage(ammo5, 0, backgroundImage.getHeight(this) - 80, this);
                    break;
            }

            //if you win, show the win screen
            if (gameOver == 1) {
                offScreenGraphicsCtx.drawImage(win, 100, 150, this);
            } //if you lose, show the lose screen
            else if (gameOver == 2) {
                offScreenGraphicsCtx.drawImage(lose, 100, 150, this);
            }
        } else {
            offScreenGraphicsCtx.drawImage(openingScreen, 0, 0, this);
        }

        if (offScreenImage != null) {
            g.drawImage(offScreenImage, 0, 0, this);
        }

    }

    public void mouseMoved(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();

    }

    public void mouseDragged(MouseEvent e) {
        mouseMoved(e);
    }

    public void keyReleased(KeyEvent e) {
    }

    public void keyPressed(KeyEvent e) {

        //put in if statements for various bullet types

        //if you press the c key, shoot your bullets
        //for the bullet type that youre using, check if the appropriate amount
        //of time has passed since you last shot your bullet
        //create the appropriate amount of bullets based on the bullet Type you're using
        //their descriptions are within the for loop for the bullets inside the static void main
        if (e.getKeyChar() == 99) {
            if (bulletType == 1 && System.currentTimeMillis() - timeAtMyShot > 200) {
                Bullet nextBullet = new Bullet(mouseX, mouseY, playerBullet, 1);
                arrBullets.add(nextBullet);
                //timeAtMyShot has to be in each one individually because
                //if its placed at the end of all the ifs,
                //it will change back to current time every time
                //and you wont be able to fire continuous shots if you hold down fire
                timeAtMyShot = System.currentTimeMillis();
            } else if (bulletType == 2 && System.currentTimeMillis() - timeAtMyShot > 300) {
                Bullet nextBullet = new Bullet(mouseX, mouseY, playerBullet, 1);
                arrBullets.add(nextBullet);
                nextBullet = new Bullet(mouseX, mouseY, redPlayerBullet, 2);
                arrBullets.add(nextBullet);
                nextBullet = new Bullet(mouseX, mouseY, redPlayerBullet, 3);
                arrBullets.add(nextBullet);
                //refresh timeAtMyShot for powerUp2
                timeAtMyShot = System.currentTimeMillis();
            } else if (bulletType == 3 && System.currentTimeMillis() - timeAtMyShot > 400) {
                Bullet nextBullet = new Bullet(mouseX, mouseY, playerBullet, 1);
                arrBullets.add(nextBullet);
                nextBullet = new Bullet(mouseX, mouseY, redPlayerBullet, 2);
                arrBullets.add(nextBullet);
                nextBullet = new Bullet(mouseX, mouseY, redPlayerBullet, 3);
                arrBullets.add(nextBullet);
                nextBullet = new Bullet(mouseX, mouseY, redHollowBullet, 4);
                arrBullets.add(nextBullet);
                nextBullet = new Bullet(mouseX, mouseY, redHollowBullet, 5);
                arrBullets.add(nextBullet);
                //refresh timeAtMyShot for powerUp3
                timeAtMyShot = System.currentTimeMillis();
            } else if (bulletType == 4 && System.currentTimeMillis() - timeAtMyShot > 250) {
                Bullet nextBullet = new Bullet(mouseX, mouseY - ship.getHeight(this) / 2, redBlast, 1);
                arrBullets.add(nextBullet);
                //refresh timeAtMyShot for powerUp4
                timeAtMyShot = System.currentTimeMillis();
            } else if (bulletType == 5 && System.currentTimeMillis() - timeAtMyShot > 400) {
                Bullet nextBullet = new Bullet(mouseX, mouseY - ship.getHeight(this) / 2, blueBlast, 1);
                arrBullets.add(nextBullet);
                nextBullet = new Bullet(mouseX, mouseY, blueHollowBullet, 4);
                arrBullets.add(nextBullet);
                nextBullet = new Bullet(mouseX, mouseY, blueHollowBullet, 5);
                arrBullets.add(nextBullet);
                //refresh timeAtMyShot for powerUp5
                timeAtMyShot = System.currentTimeMillis();
            }
        } //if you press x, shoot a heatseeking electrobomb, only one every 10s
        else if (e.getKeyChar() == 120 && System.currentTimeMillis() - timeAtMyBombShot > 10000) {
            //create a new bomb and add it into the arrBombs
            Bomb nextBomb = new Bomb(mouseX, mouseY, playerBomb);
            arrBombs.add(nextBomb);
            timeAtMyBombShot = System.currentTimeMillis(); //reset the timeAttMyBombShot's time
        }

        //the player closes the intro screen by pressing space
        if (e.getKeyCode() == 32) {
            if (introScreen == true) {
                introScreen = false;
            }
        }
    }

    public void keyTyped(KeyEvent e) {
    }
}

class Bullet {
    //setup the variables for the bullet's coordinates as well as
    //travelMethod and the image

    int bulletX;
    int bulletY;
    int travelMethod; //straight-1, diagUp-2, diagDown-3, diagUpBig-4, diagDownBig-5
    Image imgBullet;

    //the constructor for the class
    Bullet(int x, int y, Image Bullet, int travel) {
        //assign values for the variables created in the class
        bulletX = x;
        bulletY = y;
        imgBullet = Bullet;
        travelMethod = travel;
    }
}

class Bomb {
    //setup the variables for the bomb's coordinates as well as
    //it's image and the variable for distance squared

    int bombX;
    int bombY;
    Image imgBomb;
    double distanceSquared;
    //bomb explosion width and height
    int bombExpWidth = 170;
    int bombExpHeight = 151;
    int bombExpTimer = 30;
    boolean collideBeforeExplosion = true;
    //the constructor for the class

    Bomb(int x, int y, Image bomb) {
        //assign values for the variables created in the class
        bombX = x;
        bombY = y;
        imgBomb = bomb;
    }
}

class EnemyBullet {

    int enemyBulletX; //x coords
    int enemyBulletY; //y coords
    int travelMethod; //the moving style
    Image imgEnemyBullet; //the image
    //for the travel method that just shoots at where you are (location seekers)
    boolean getThePlayerCoordinates = true;
    double angleToPlayer; //for the heatseekers
    double enemyBDirection; //for the heatseekers and location seekers
    int enemyBulletSpeed; //the speed
    int enemyMineTimer = 150; //heatseekers disappear after 150 millis
    int enemyLaserTimer = 150; //boss laser disappear after 150 millis
    boolean flipLaser = false; //for changing the boss laser (red/blue)
    int speedChanger = 0; //for the boss missiles which speed up as they travel

    //the constructor
    EnemyBullet(int x, int y, Image enemyBullet, int travel) {
        //assign values for the variables created in the class
        enemyBulletX = x;
        enemyBulletY = y;
        imgEnemyBullet = enemyBullet;
        travelMethod = travel;
        enemyBDirection = (Math.PI);
    }
}

class Enemy {
    //x coords, y coords, hp, speed, which enemy(1/2/3), the moving style

    int enemyX, enemyY, enemyHP, enemySpeed, enemyType, moveStyle;
    Image enemyImage; //image
    Image bulletImage; //weapon image
    boolean moveUpEnemy1; //for vertical movement
    //for the type 2 and 3 enemies
    //for the location seeker weapons (get the coordinates only once)
    //unlike for the heatseekers which get the coordinates every frame
    boolean setupTheChoices = true;
    boolean startAtTop; //spawns above or below
    boolean moveForwards;
    //The next four are for enemy 2's diamond moveStyle
    boolean moveDownLeft;
    boolean moveDownRight;
    boolean moveUpRight;
    boolean moveUpLeft;
    //for enemy 2's diamond moving
    int topX, topY;
    int leftX, leftY;
    int bottomX, bottomY;
    int rightX, rightY;
    //variable for enemy firing delay
    long timeAtShot = System.currentTimeMillis();
    int explosionTimer = 30; //explosion image lasts for half a second
    //these two are the width and height of the explosion
    int imgWidth = 100;
    int imgHeight = 75;

    Enemy(int x, int y, int hp, int speed, Image imgEnemy, Image imgBullet, int typeOfEnemy, int movement) {
        //assign values for the variables created in the class
        enemyX = x;
        enemyY = y;
        enemyHP = hp;
        enemySpeed = speed;
        enemyImage = imgEnemy;
        bulletImage = imgBullet;
        enemyType = typeOfEnemy;
        moveStyle = movement;

    }
}

class PowerUp {
    //setup the variables for the powerUps' x,y,type(health or weapon) and the speed
    //it travels at. Also create the variables for the powerupImage (health or weapons power up image
    //based on the type)

    int powerUpX, powerUpY, powerUpType, powerUpSpeed;
    Image powerImage;
    boolean startAtTop; //true if created above the screen, false if below

    //the constructor for the class
    PowerUp(int x, int y, int speed, int type, Image powerUpImage, boolean atTop) {
        //assign values for the variables created in the class
        powerUpX = x;
        powerUpY = y;
        powerUpSpeed = speed;
        powerUpType = type;
        powerImage = powerUpImage;
        startAtTop = atTop;
    }
}

