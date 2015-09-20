/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package helloworldgameedition;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.net.URL;
import javax.swing.JPanel;

/**
 *
 * @author slim
 */
public class HelloPanel extends JPanel{
    
    Graphics offScreenGraphicsCtx;
    Image offScreenImage;
  
    Image backgroundImage;
    int bgX = 0, bgY = 0;
    
    MediaTracker mediaTracker;
    
    HelloPanel()
    {
        mediaTracker = new MediaTracker(this);
        
        URL imgURL;
        
        imgURL = getClass().getResource("background.png");
        backgroundImage = Toolkit.getDefaultToolkit().getImage(imgURL);
        
        mediaTracker.addImage(backgroundImage, 0);
        
        try {
            mediaTracker.waitForID(0);
        } catch (InterruptedException e)
        {
            System.out.println(e);
        }
        
        int width = backgroundImage.getWidth(this);
        int height = backgroundImage.getHeight(this);
        
        setSize(width, height);
        setVisible(true);
        
        repaint();
    }
    
    public void paintComponent(Graphics g)
    {
        if (offScreenGraphicsCtx == null)
        {
            offScreenImage = createImage(getSize().width, getSize().height);
            offScreenGraphicsCtx = offScreenImage.getGraphics();
        }
        
        // draw two backgrounds, one on top of the other
        offScreenGraphicsCtx.drawImage(backgroundImage, bgX, bgY
                - backgroundImage.getHeight(this), this);
        offScreenGraphicsCtx.drawImage(backgroundImage, bgX, bgY, this);
        
        if (offScreenImage != null)
        {
            g.drawImage(offScreenImage, 0, 0, this);
        }
    }
}
