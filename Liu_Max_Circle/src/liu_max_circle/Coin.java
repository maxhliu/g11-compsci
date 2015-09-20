/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package liu_max_circle;

/**
 *
 * @author Max
 */
public class Coin {

    int faceUp;

    public int showFace() {
        return faceUp;
    }

    public void flipCoin() {
        faceUp = (int) (Math.random() * 2);
    }
}
