package View;

import javax.swing.*;

import Controller.Profile;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.logging.Logger;

public class Loginvw extends JFrame {

    private static final Logger logger = Logger.getLogger(Loginvw.class.getName());

    private JTextField emailField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public Loginvw() {
        setTitle("Login - TEMMU");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);

        initComponents();
    }

    private void initComponents() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        JLabel logo = new JLabel(new ImageIcon(getClass().getResource("/images/temu_80x80.png")), JLabel.CENTER);
        logo.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel title = new JLabel("WELCOME TO TEMMU");
        title.setFont(new Font("Tahoma", Font.BOLD, 24));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel subtitle = new JLabel("Log in with your temmu account to continue");
        subtitle.setFont(new Font("Tahoma", Font.PLAIN, 12));
        subtitle.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel emailLabel = new JLabel("Email Address");
        emailLabel.setFont(new Font("Tahoma", Font.BOLD, 12));

        emailField = new JTextField(20);
        emailField.setMaximumSize(new Dimension(250, 30));
        emailField.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel passLabel = new JLabel("Password");
        passLabel.setFont(new Font("Tahoma", Font.BOLD, 12));

        passwordField = new JPasswordField(20);
        passwordField.setMaximumSize(new Dimension(250, 30));
        passwordField.setAlignmentX(Component.CENTER_ALIGNMENT);

        loginButton = new JButton("LOGIN");
        loginButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        loginButton.addActionListener(this::onLogin);

        panel.add(logo);
        panel.add(Box.createVerticalStrut(10));
        panel.add(title);
        panel.add(Box.createVerticalStrut(5));
        panel.add(subtitle);
        panel.add(Box.createVerticalStrut(30));
        panel.add(emailLabel);
        panel.add(emailField);
        panel.add(Box.createVerticalStrut(15));
        panel.add(passLabel);
        panel.add(passwordField);
        panel.add(Box.createVerticalStrut(20));
        panel.add(loginButton);

        add(panel);
    }
    public String getFieldEmail() {
    	return emailField.getText();
    }

	public  char[] getFieldPassword() {
    	return passwordField.getPassword();
    }
    

    private void onLogin(ActionEvent evt) {
        // TODO: Agrega lógica de autenticación aquí
        Profile prof= new Profile(getFieldEmail(),getFieldPassword());
        if(prof.ValidateLogin()==true) {
        	if(prof.ValidateEmailSeller() && prof.ValidatePasswordSeller()== true) {
        		SwingUtilities.invokeLater(() -> new MainSellervw().setVisible(true));
        		dispose();
        		
        	}else if(prof.ValidateEmailCustomer() && prof.ValidatePasswordCustomer()== true) {
        		SwingUtilities.invokeLater(() -> new MainCustomervw().setVisible(true));
        		dispose();
        	}
        }else {
        	JOptionPane.showMessageDialog(this, "Error, incorrect username and password.");
        }
      
    }
}