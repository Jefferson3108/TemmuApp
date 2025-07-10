// Author: Jefferson David Rico Ruiz

import javax.swing.SwingUtilities;
import View.Selectvw;

/**
 * Main class of the program.
 *
 * This class contains the main method, which serves as the entry point
 * for the execution of the application. It uses SwingUtilities.invokeLater
 * to ensure that the graphical user interface (GUI) is created and updated
 * on the AWT Event Dispatch Thread, which is a best practice in Swing applications.
 */
public class Main {
    
    public static void main(String[] args) {
        
        // Runs the GUI code on the Event Dispatch Thread (EDT)
        SwingUtilities.invokeLater(() -> new Selectvw().setVisible(true));
        
        // new Selectvw().setVisible(true):
        // Creates an instance of the 'Selectvw' view and makes it visible.
        // This is likely the main menu or initial screen of the application.
    }
}
