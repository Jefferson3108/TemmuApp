package View;

import java.awt.Color;
import javax.swing.JPanel;

public class Panel extends Frame {
	private static final long serialVersionUID = 1L;
	public JPanel panel1;
	public Panel() {
		// TODO Auto-generated constructor stub
			panel1= new JPanel();
			panel1.setLayout(null);
			panel1.setBackground(Color.WHITE);
			this.getContentPane().add(panel1);	
}
}
