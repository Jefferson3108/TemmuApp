// Author: Jefferson David Rico Ruiz

package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.logging.Logger;

import Controller.Profile;

/**
 * This class represents the login window for the TEMMU application.
 * Users can enter their email and password to log in as a customer or seller.
 */
public class Loginvw extends JFrame {

    private static final Logger logger = Logger.getLogger(Loginvw.class.getName());

    private JTextField emailField;
    private JPasswordField passwordField;
    private JButton loginButton;

    /**
     * Constructor initializes the login frame.
     */
    public Loginvw() {
        setTitle("Login - TEMMU");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);

        initComponents();
    }

    /**
     * Initializes and arranges all GUI components.
     */
    private void initComponents() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        // Logo image
        JLabel logo = new JLabel(new ImageIcon(getClass().getResource("/images/temu_80x80.png")), JLabel.CENTER);
        logo.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Title and subtitle
        JLabel title = new JLabel("WELCOME TO TEMMU");
        title.setFont(new Font("Tahoma", Font.BOLD, 24));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel subtitle = new JLabel("Log in with your TEMMU account to continue");
        subtitle.setFont(new Font("Tahoma", Font.PLAIN, 12));
        subtitle.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Email field
        JLabel emailLabel = new JLabel("Email Address");
        emailLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
        emailField = new JTextField(20);
        emailField.setMaximumSize(new Dimension(250, 30));
        emailField.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Password field
        JLabel passLabel = new JLabel("Password");
        passLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
        passwordField = new JPasswordField(20);
        passwordField.setMaximumSize(new Dimension(250, 30));
        passwordField.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Login button
        loginButton = new JButton("LOGIN");
        loginButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        loginButton.addActionListener(this::onLogin);

        // Add components to panel
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

    /**
     * Gets the email entered by the user.
     * @return Email as string.
     */
    public String getFieldEmail() {
        return emailField.getText();
    }

    /**
     * Gets the password entered by the user.
     * @return Password as character array.
     */
    public char[] getFieldPassword() {
        return passwordField.getPassword();
    }

    /**
     * Handles login button click.
     * Authenticates user using Profile class and opens the appropriate view.
     */
    private void onLogin(ActionEvent evt) {
        Profile prof = new Profile(getFieldEmail(), getFieldPassword());

        if (prof.ValidateLogin()) {
            // If seller login is valid
            if (prof.ValidateEmailSeller() && prof.ValidatePasswordSeller()) {
                SwingUtilities.invokeLater(() -> new MainSellervw().setVisible(true));
                dispose();
            }
            // If customer login is valid
            else if (prof.ValidateEmailCustomer() && prof.ValidatePasswordCustomer()) {
                Profile.savecurrentcustomer();
                SwingUtilities.invokeLater(() -> new MainCustomervw().setVisible(true));
                dispose();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Error, incorrect username or password.");
        }
    }
}