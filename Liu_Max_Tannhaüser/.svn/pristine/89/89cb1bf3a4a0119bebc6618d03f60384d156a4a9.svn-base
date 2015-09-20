package Tannhaüser;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.JPanel;
import sun.awt.image.ToolkitImage;

public class Panels extends JPanel implements KeyListener, MouseListener {

    //create all the image objects for the images
    Image bkg;
    Image no;
    Image title;
    Image plat;
    Image lose;
    Image win;
    //create a MediaTracker so that images aren't used before they're loaded
    MediaTracker mt;
    //initialize background position variables
    int bgX = 0, bgY = 0;
    //create an offscreen graphics for double buffering
    Graphics ofsg;
    //create an image to paint to the panel
    Image ofsi;
    //set the co-ordinates to spawn at. This is roughly the centre of the field.
    int mainX = 588;
    int mainY = 310;
    //initialize speed variables for the avatar
    double speedX = 0;
    double speedY = 0;
    //initialize title screen, lose screen, and win screen co-ordinates
    double titleX = Constants.STAGE_WIDTH;
    double loseX = Constants.STAGE_WIDTH;
    double winX = Constants.STAGE_WIDTH;
    //initialize boolean variables for movement
    boolean moveDown = false, moveLeft = false, moveRight = false;
    //initialize variables for title screen movement
    //when this is true, the title screen will move
    boolean gameStarted = false;
    //when this is true, the game will display
    boolean beginStart = false;
    int startLength = 1;
    //when this is true, the lose screen will display and move
    boolean beginLose = false;
    //when this is true, the win screen will display and move
    boolean beginWin = false;
    //when this is true, the game will not scroll left
    boolean tooLeft = true;
    //when this is true, the game will not scroll right
    boolean tooRight = false;
    //create AudioClips to store music
    AudioClip bgm;
    AudioClip jump;
    AudioClip lsm;
    AudioClip wsm;
    //create an ArrayList of platforms
    ArrayList<Platform> activePlatforms = new ArrayList();
    //create a variable to store the number of pixels the screen scrolls
    int moveAmount = 0;
    //initialize a variable to detect whether or not to be able to jump and to apply gravity
    boolean onPlatform = false;
    //initialize a variable to change the rotation
    double rotation = 3;
    //initialize a variable to see if we are cheating
    boolean cheating = false;

    Panels() {
        //intialize the MediaTracker
        mt = new MediaTracker(this);
        //create a URL object
        URL iURL;
        //point the URL to the background file
        iURL = getClass().getResource("Level 1.png");
        //set the background image as this file
        bkg = Toolkit.getDefaultToolkit().getImage(iURL);
        //do the same for all the other images
        iURL = getClass().getResource("Real Ball.png");
        no = Toolkit.getDefaultToolkit().getImage(iURL);
        iURL = getClass().getResource("Title Screen.png");
        title = Toolkit.getDefaultToolkit().getImage(iURL);
        iURL = getClass().getResource("Real Platform.png");
        plat = Toolkit.getDefaultToolkit().getImage(iURL);
        iURL = getClass().getResource("You Lose.png");
        lose = Toolkit.getDefaultToolkit().getImage(iURL);
        iURL = getClass().getResource("Real You Win.png");
        win = Toolkit.getDefaultToolkit().getImage(iURL);
        //add these images to the mediaTracker
        mt.addImage(bkg, 0);
        mt.addImage(no, 0);
        mt.addImage(title, 0);
        mt.addImage(plat, 0);
        mt.addImage(lose, 0);
        mt.addImage(win, 0);
        //set the URL to the background music file
        iURL = getClass().getResource("El Nath.wav");
        //set the bgm AudioClip as this file
        bgm = Applet.newAudioClip(iURL);
        //do the same for the other music files
        iURL = getClass().getResource("Jump.wav");
        jump = Applet.newAudioClip(iURL);
        iURL = getClass().getResource("Sad Romance.wav");
        lsm = Applet.newAudioClip(iURL);
        iURL = getClass().getResource("Vishnu.wav");
        wsm = Applet.newAudioClip(iURL);

        //make sure the images are loaded before they are accessed
        try {
            mt.waitForID(0);
        } catch (InterruptedException e) {
            System.out.println("Interrupted Image");
        }
        //add the KeyListeners and MouseListeners
        addKeyListener(this);
        addMouseListener(this);
        //set the size of the panel to fill the JFrame
        setSize(Constants.STAGE_WIDTH, Constants.STAGE_HEIGHT);
        //make it visible
        setVisible(true);
        //make it so that the mouse and keyboard can have the focus
        setFocusable(true);
        //get the focus
        requestFocus();
        //paint the panel again
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        //if nothing is stored in the offscreen graphics, store the image ofsi.
        if (ofsg == null) {
            ofsi = createImage(getSize().width, getSize().height);
            ofsg = ofsi.getGraphics();
        }
        //If the game is starting
        if (beginStart) {
            //draw the background
            ofsg.drawImage(bkg, bgX, bgY, this);
            //draw the platforms
            for (Platform thePlatform : activePlatforms) {
                ofsg.drawImage(plat, thePlatform.x, thePlatform.y, this);
            }
            //create a rotation AffineTransform
            AffineTransform tx = AffineTransform.getRotateInstance(this.rotation, Constants.MAIN_WIDTH / 2, Constants.MAIN_HEIGHT / 2);
            //set the scaling as bicubic and create an AffineTransformOp
            AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BICUBIC);
            //now draw the rotated image
            ofsg.drawImage(op.filter(((ToolkitImage) no).getBufferedImage(), null), mainX, mainY, this);
        }

        //draw the title screen if the game hasn't started
        if (!gameStarted) {
            ofsg.drawImage(title, (int) (titleX - startLength * Constants.STAGE_WIDTH), 0, this);
        }
        
        //if the game is starting, multiply the titleX value by 0.9. This creates a smooth moving animation
        if (beginStart) {
            this.titleX *= 0.9;
        }
        //if it is almost finished, remove that ugly border at the side
        if (titleX <= 2 && titleX >= 2) {
            gameStarted = true;
        }
        //if the game is lost, stop refreshing the image and make a smooth animation lose screen similar to the title screen
        if (beginLose) {
            gameStarted = false;
            beginStart = false;
            ofsg.drawImage(lose, (int) loseX, 0, this);
            this.loseX *= 0.95;
        }
        //do the same thing with the win screen
        if (beginWin && !beginLose) {
            gameStarted = false;
            beginStart = false;
            ofsg.drawImage(win, (int) winX, 0, this);
            this.winX *= 0.95;
        }
        //if ofsi already has an image, draw the new image.
        if (ofsi != null) {
            g.drawImage(ofsi, 0, 0, this);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

        switch (e.getKeyCode()) {
            //start cheating if the C key is pressed.
            case KeyEvent.VK_C:
                cheating = true;
                break;
             //start moving a certain direction when the corresponding key is pressed
            case KeyEvent.VK_A:
            case KeyEvent.VK_LEFT:
                moveLeft = true;
                break;
            case KeyEvent.VK_S:
            case KeyEvent.VK_DOWN:
                moveDown = true;
                break;
            case KeyEvent.VK_D:
            case KeyEvent.VK_RIGHT:
                moveRight = true;
                break;
                //when the space key is pressed, the game is running, and we are either on a platform or cheating, play the 
                //jump sound and add upwards speed
            case KeyEvent.VK_SPACE:
                if ((onPlatform || cheating) && !(beginLose || beginWin)) {
                    speedY = Constants.JUMP_SPEED;
                    jump.play();
                }
                break;
                //escape when the escape key is pressed
            case KeyEvent.VK_ESCAPE:
                System.exit(0);
                break;
                //start the game is it hsan't already started
            case KeyEvent.VK_ENTER:
                if (!beginLose && !beginWin) {
                    beginStart = true;
                }
                break;
                //add a platform when the shift key is pressed
            case KeyEvent.VK_SHIFT:
                Main.addPlatform();
            default:
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

        switch (e.getKeyCode()) {
            //when the corresponding movement key is released, stop moving that direction
            case KeyEvent.VK_A:
            case KeyEvent.VK_LEFT:
                moveLeft = false;
                break;
            case KeyEvent.VK_S:
            case KeyEvent.VK_DOWN:
                moveDown = false;
                break;
            case KeyEvent.VK_D:
            case KeyEvent.VK_RIGHT:
                moveRight = false;
                break;
            default:
                break;

        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //add a platform at the location of the click
        Main.addPlatform(e.getX(), e.getY());
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
