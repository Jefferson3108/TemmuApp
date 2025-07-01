
import javax.swing.SwingUtilities;

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
