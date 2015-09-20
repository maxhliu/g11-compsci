/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package backwards.text;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import javax.swing.JOptionPane;

/**
 *
 * @author Max
 */
public class BackwardsText {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String theString = "\u202e";
        StringSelection selection = new StringSelection(theString);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(selection, selection);
        JOptionPane.showMessageDialog(null, "Paste into a text box on a website, and your text is now backwards!");
    }
}
