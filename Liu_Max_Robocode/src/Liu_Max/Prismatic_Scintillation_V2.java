/*
 * Max Liu 
 * September 5, 2013 
 * Liu_Max_Prismatic_Scintillation_V2
 * ICS4U-1
 * Mister Lim
 */
package Liu_Max;

import java.awt.Color;
import java.awt.geom.Rectangle2D;
import robocode.AdvancedRobot;
import robocode.HitRobotEvent;
import robocode.ScannedRobotEvent;
import robocode.util.Utils;

/**
 * Prismatic_Scintillation_V1. [WARNING: USES RADIANS]
 *
 * What's melee? Prismatic Scintillation is a 1-bot machine, which locks on to a
 * single robot. It circles this robot, avoiding the borders in the process. It
 * randomly changes direction, and also changes direction when the tracked robot
 * fires (sometimes). It uses linear shooting, and is generally pretty awesome.
 *
 * Name Origins Prismatic Scintillation got its name from its relatively stable
 * radar. When scan arcs are on, it projects a wonderful block of radar scan,
 * gliding smoothly along just like its ever-shifting colours. When you put
 * multiple copies of this bot together, you can see their criss-crossing scan
 * arcs forming effervescent crystals, morphing and changing like ephemeral
 * prisms. It is from this colour-changing light show that this robot gets its
 * name: Prismatic, for the radar movement, and Scintillation, for the graceful
 * shift in hue.
 */
public class Prismatic_Scintillation_V2 extends AdvancedRobot {
    //the direction which we are circling around a robot

    static double direction = 1;
    double previousEnergy;
    float h = 0;

    public void changeColours() {

        Color a;
        //Move the hue wavelength up a bit
        h += 0.005;
        //If it gets past the specturm, wrap it around back to red
        if (h > 1) {
            h--;
        }
        //Set the colours
        a = Color.getHSBColor(h, 0.8f, 0.7f);
        setBodyColor(a);
        setGunColor(a);
        setRadarColor(a);
        setScanColor(a);
        setBulletColor(a);
        System.out.println("SLDKF");
    }

    @Override
    public void run() {
        //make sure that the gun doesn't turn with the robot.
        setAdjustGunForRobotTurn(true);
        //Keep on spinning the radar until you scan someone
        setTurnRadarRightRadians(Double.POSITIVE_INFINITY);

    }

    @Override
    public void onScannedRobot(ScannedRobotEvent e) {
        //determine the absolute bearing. This is the clockwise relative to the map, not my robot
        //using this makes calculating things easier
        double absoluteBearing = e.getBearingRadians() + getHeadingRadians();
        //This is the direction we are aiming to turn to. If it were absolute bearing, we would turn directly at the enemy robot.
        //The offset is so that we go somewhat parallell, but get closer little by little
        double goalDirection = absoluteBearing - (Math.PI / 2 * direction);
        //The most important part of any robot
        /**//**//**//**//**//**//**//**/
        /**//**//**//**//**//**//**//**/
        /**//**/ changeColours();/**//**/
        /**//**//**//**//**//**//**//**/
        /**//**//**//**//**//**//**//**/

        //This adds a 3% chance of switching direction, messing up linear targeting algorithms
        boolean changeDirection = (int) (Math.random() * 100) < 3 && getOthers() >= 10; //3 out of 100 times I scan a robot I will change direction
        if (changeDirection) {
            direction *= -1;
        }

        //if we detect a drop in energy equal to that of a bullet being fired, change direction to avoid the bullet
        //this is really only effective when there are a small number of robots left
        if (e.getEnergy() - previousEnergy <= 3 && e.getEnergy() < previousEnergy && getOthers() < 10) {
            if ((int) (Math.random() * 3) < 1) {
                direction *= -1;
            }
        }

        //store the distance value so we don't get disabled
        double distance = e.getDistance();

        //wall smoothing code ahead

        //create a rectangle which we are allowed to be in
        //this gives us a 18 pixel margin, enough for us to travel along the wall
        Rectangle2D fieldRect = new Rectangle2D.Double(18, 18, getBattleFieldWidth() - 36, getBattleFieldHeight() - 36);
        //if the "safe" rectangle does not contain the point where we want to be at 15 turns later, then turn slightly towards the enemy
        //and try again to see if we are inside the safe zone until we are
        
        while (!fieldRect.contains(getX() + Math.sin(goalDirection) * 120, getY() + Math.cos(goalDirection) * 120)) {
            goalDirection += direction * .1;
        }
        //set our turn to the direction we need to go
        double turn = robocode.util.Utils.normalRelativeAngle(goalDirection - getHeadingRadians());
        //determine if we need to move backwards to move properly
        if (Math.abs(turn) > Math.PI / 2) {
            turn = robocode.util.Utils.normalRelativeAngle(turn + Math.PI);
            setAhead(-1000);
        } else {
            setAhead(1000);
        }
        //set the turn to the amount specified
        setTurnRightRadians(turn);

        //determine which firing power to use
        double bulletPower;
        //if there aren't a lot of robots left, save power
        if (getOthers() < 3) {
            bulletPower = Math.min((3 - Math.pow(distance, 0.25) + 3), getEnergy() / 5);
        } else {
            //if not, fire away
            bulletPower = 3 - Math.pow(distance, 0.25) + 3;
        }
        //determine the bullet's speed
        double bulletSpeed = 20 - (3 * bulletPower);
        //find the bearing to shoot at based on maximum escape angle
        double linearBearing = absoluteBearing + Math.asin(e.getVelocity() / bulletSpeed * Math.sin(e.getHeadingRadians() - absoluteBearing));
        //turn the gun right the bearing we need to hit their future location, and make sure that we take the
        //shortest path to that angle
        setTurnGunRightRadians(Utils.normalRelativeAngle(linearBearing - getGunHeadingRadians()));
        //fire
        setFireBullet(bulletPower);
        //go back the other direction (basically keeping it still on the scanned robot)
        setTurnRadarLeft(getRadarTurnRemaining());

        //record the energy, it will be used in the next onScannedRobot
        previousEnergy = e.getEnergy();
    }

    @Override
    public void onHitRobot(HitRobotEvent e) {
        //If it was our fault, go the other way
        if (!(e.isMyFault())) {
            direction *= -1;
        }
    }
}