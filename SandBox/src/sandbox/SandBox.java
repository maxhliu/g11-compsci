/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sandbox;

public class SandBox {

    public static void main(String[] args) {
        int pot = 1;
        int money = 20000;
        for (int i = 0; i < 200000; i++) {
           money-= 11;
            while (true) {
                if (Math.random() > 0.5) {
                    pot *= 2;
                } else {
                    money += pot;
                    pot = 1;
                    break;
                }
            }
            System.out.println(money);
        }
    }
}
