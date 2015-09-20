/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package helloworldgameedition;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 *
 * @author slim
 */
public class HelloWorldGameEdition {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        // Setup JFrame
        JFrame myFrame = new JFrame();
        
        HelloPanel myPanel = new HelloPanel();
        
        myFrame.setContentPane(myPanel);
        
        myFrame.setTitle("Hello World Game Edition");
        myFrame.setSize(myPanel.getWidth(), myPanel.getHeight());
        myFrame.setResizable(false);
        myFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        myFrame.setVisible(true);
        
        long timeMillis = System.currentTimeMillis();
        
        while(true)
        {
            myPanel.bgY += 4;
            if (myPanel.bgY >= myPanel.backgroundImage.getHeight(myPanel))
            {
                myPanel.bgY = 0;
            }
            
            // redraw the screen
            myPanel.repaint();
            try {
                Thread.sleep(17);
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }
        }
        
    }
}
