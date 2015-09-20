/*
 * Max Liu 
 * September 5, 2013 
 * Liu_Max_Prismatic_Scintillation_V2
 * ICS4U-1 Mister
 * Lim.
 */
package Liu_Max;

import java.awt.Color;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import robocode.AdvancedRobot;
import robocode.ScannedRobotEvent;
import robocode.HitRobotEvent;
import robocode.util.Utils;

/**
 * Prismatic_Scintillation_V1.
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
public class Prismatic_Scintillation_V1 extends AdvancedRobot {

    static double direction = 1;
    double previousEnergy;
    static float h = 0;
    static double lastDistance = 0;
    Color a;
//    Enemy tracking;
//    ArrayList<Enemy> robots;

    public void changeColours() {
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
    }

    public void run() {

        setAdjustGunForRobotTurn(true);

//        tracking = new Enemy();
//        tracking.reset();
        //Keep on spinning the radar until you scan someone
        setTurnRadarRightRadians(Double.POSITIVE_INFINITY);
        //Keep a tab on all of the enemies
//        robots = new ArrayList<Enemy>();

    }

    @Override
    public void onScannedRobot(ScannedRobotEvent e) {
        double absoluteBearing = e.getBearingRadians() + getHeadingRadians();
        double goalDirection = absoluteBearing - Math.PI / 2 * direction;
        //The most important part of any robot
        /**//**//**//**//**//**//**//**/
        /**//**//**//**//**//**//**//**/
        /**//**/ changeColours();/**//**/
        /**//**//**//**//**//**//**//**/
        /**//**//**//**//**//**//**//**/

        //30% chance of changing directions
        boolean changeDirection = (int) (Math.random() * 100) < 30;
        if (changeDirection) {
            goalDirection *= 1;
        }

        if (e.getEnergy() - previousEnergy <= 3 && e.getEnergy() < previousEnergy && getOthers() < 6) {
            goalDirection *= 1;
        }

//        double test = 450-e.getBearing() + getHeadingRadians();
        double distance = e.getDistance();
//        Point2D testing = new Point2D.Double(getX() + Math.sin(e.getBearingRadians())*distance, getY() + Math.cos(e.getBearingRadians()));
//        robots.add(testing);


//        if (changeRect.contains(getX(), getY())) {


        Rectangle2D fieldRect = new Rectangle2D.Double(18, 18, getBattleFieldWidth() - 36,
                getBattleFieldHeight() - 36);
        while (!fieldRect.contains(getX() + Math.sin(goalDirection) * 120, getY()
                + Math.cos(goalDirection) * 120)) {
            goalDirection += direction * .1;	//turn a little toward enemy and try again
        }
        double turn = robocode.util.Utils.normalRelativeAngle(goalDirection - getHeadingRadians());
        if (Math.abs(turn) > Math.PI / 2) {
            turn = robocode.util.Utils.normalRelativeAngle(turn + Math.PI);
            setBack(100);
        } else {
            setAhead(100);
        }
        setTurnRightRadians(turn);
//        }


//        setTurnGunRightRadians(Utils.normalRelativeAngle(absoluteBearing - getGunHeadingRadians()));

//
//        if (getGunHeat() == 0 && Math.abs(getGunTurnRemaining()) < 10) {
//            setFireBullet(3 - Math.pow(distance, 0.25) + 3);
//
//        }
//        double bulletPower = Math.min((3-Math.pow(distance, 0.25) + 3), getEnergy()/7);
        double bulletPower = 3 - Math.pow(distance, 0.25) + 3;


        double headOnBearing = getHeadingRadians() + e.getBearingRadians();
        double linearBearing = headOnBearing + Math.asin(e.getVelocity() / (20 - (3 * bulletPower)) * Math.sin(e.getHeadingRadians() - headOnBearing));
        setTurnGunRightRadians(Utils.normalRelativeAngle(linearBearing - getGunHeadingRadians()));

        setFireBullet(bulletPower);
        setTurnRadarLeft(getRadarTurnRemaining());

//        System.out.println(tracking.getName() + tracking.getDistance());
//        previousEnergy = e.getEnergy();
    }

    @Override
    public void onHitRobot(HitRobotEvent e) {

        if (!(e.isMyFault())) {
            direction *= -1;
        }
    }
}
//
//class Enemy {
//
//    String name;
//    Double distance;
//    Double speed;
////
////    Enemy(String n, Double d) {
////        name = n;
////        distance = d;
////    }
//
//    void reset() {
//        distance = Double.POSITIVE_INFINITY;
//        speed = 0.0;
//    }
//
//    void rolling() {
//        distance *= 1.2;
//    }
//
//    void setSpeed(double s) {
//        speed = speed * 0.9 + 0.1 * s;
//    }
//
//    double getSpeed() {
//        return speed;
//    }
//
//    void setName(String n) {
//        name = n;
//    }
//
//    void setDistance(Double d) {
//        distance = d;
//    }
//
//    String getName() {
//        return name;
//    }
//
//    double getDistance() {
//        return distance;
//    }
//}
