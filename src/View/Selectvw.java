package View;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JButton;

public class Selectvw extends Panel {
	private static final long serialVersionUID = 1L;
	
	public Selectvw() {
		showdat();
	// TODO Auto-generated constructor stub	
	}
	private void showdat() {
		Labels();
		Buttons();
	}
	private void Labels() {
		JLabel tlt=new JLabel("Bienvenidos a Temmu");
		JLabel stxt=new JLabel("Seleccione su rol");
		ImageIcon img= new ImageIcon("media/unnamed.png");
		JLabel Img= new JLabel(img);
		Img.setBounds(160, 70, 175, 175);
		Img.setIcon(new ImageIcon(img.getImage().getScaledInstance(Img.getWidth(), Img.getHeight(),Image.SCALE_SMOOTH)));
		tlt.setForeground(Color.BLACK);
		stxt.setForeground(Color.BLACK);
		tlt.setBounds(80, 10, 400, 30);
		stxt.setBounds(30, 250, 200, 30);
		tlt.setFont(new Font(null,0,35));
		stxt.setFont(new Font(null,0,25));
		panel1.add(tlt);
		panel1.add(stxt);
		panel1.add(Img);
	}
	private void Buttons() {
		
		JButton btsll=new JButton("Seller");
		btsll.setBounds(30, 300, 150, 100);
		JButton btcs=new JButton("Customer");
		btcs.setBounds(300, 300, 150, 100);
		btsll.setFont(new Font(null,0,25));
		btcs.setFont(new Font(null,0,25));
		Color clbts= new Color(255,109,0);
		btcs.setBackground(clbts);
		btsll.setBackground(clbts);
		btcs.setForeground(Color.WHITE);
		btsll.setForeground(Color.WHITE);
		panel1.add(btsll);
		panel1.add(btcs);
	}
	
	

	

}
