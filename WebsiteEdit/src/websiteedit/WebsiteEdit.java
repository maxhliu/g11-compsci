/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package websiteedit;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import javax.swing.JOptionPane;

/**
 *
 * @author Max
 */
public class WebsiteEdit {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String theString = "javascript:document.body.contentEditable='true'; document.designMode='on'; void 0";
        StringSelection selection = new StringSelection(theString);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(selection, selection);
        JOptionPane.showMessageDialog(null, "Paste into the address bar of a website, add javascript: to the beginning, and edit it!");
    }
}
