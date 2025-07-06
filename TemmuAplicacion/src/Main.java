
import javax.swing.SwingUtilities;

import View.AddProductvw;
import View.Selectvw;

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	 public static void main(String[] args) {
		 SwingUtilities.invokeLater(() -> new AddProductvw().setVisible(true));
		 
	    }
	 
	 

}
