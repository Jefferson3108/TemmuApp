import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import Controller.Register;
import Model.data;
import View.RgSellervw;
import View.Selectvw;

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	 public static void main(String[] args) {
	        SwingUtilities.invokeLater(() -> {
	            new Selectvw().setVisible(true);
	        });
	     
  
	    }
	 
	 

}
