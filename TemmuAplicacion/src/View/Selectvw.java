// Author: Jefferson David Rico Ruiz

package View;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * This class represents the initial selection screen for the Temmu app.
 * It allows users to choose whether to register as a Seller or a Customer, or go directly to Log In.
 */
public class Selectvw extends JFrame {

    // ===================== UI Components =====================
    private JPanel bg;
    private JButton sellerButton;
    private JButton customerButton;
    private JButton loginButton;
    private JLabel titleLabel;
    private JLabel logoLabel;
    private JLabel orLabel;
    private JLabel instructionLabel;

    /**
     * Constructor that initializes and displays the selection screen.
     */
    public Selectvw() {
        showComponents();
    }

    /**
     * Initializes the full layout: frame setup, components, and adding to content pane.
     */
    private void showComponents() {
        Frame();
        Panel();
        Labels();
        Buttons();
        getContentPane().add(bg);
    }

    /**
     * Configures the frame properties (title, size, location, close operation).
     */
    private void Frame() {
        setTitle("Temmu app");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window
    }

    /**
     * Sets up the main background panel and layout.
     */
    private void Panel() {
        bg = new JPanel();
        bg.setBackground(Color.WHITE);
        bg.setLayout(null); // Absolute layout for manual positioning
    }

    /**
     * Adds all label components: title, logo, instruction, and separator.
     */
    private void Labels() {
        // Main title
        titleLabel = new JLabel("CREATE YOUR TEMMU ACCOUNT");
        titleLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
        titleLabel.setBounds(190, 40, 500, 40);
        bg.add(titleLabel);

        // Logo icon
        logoLabel = new JLabel();
        ImageIcon icon = new ImageIcon(getClass().getResource("/images/temu_80x80.png"));
        logoLabel.setIcon(icon);
        logoLabel.setBounds(100, 20, 80, 80);
        bg.add(logoLabel);

        // Role instruction
        instructionLabel = new JLabel("Select your role in the app");
        instructionLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        instructionLabel.setBounds(270, 150, 300, 30);
        bg.add(instructionLabel);

        // "OR" separator
        orLabel = new JLabel("OR");
        orLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        orLabel.setBounds(370, 250, 40, 20);
        bg.add(orLabel);
    }

    /**
     * Adds and configures the buttons for Seller, Customer, and Log In.
     */
    private void Buttons() {
        // Seller registration button
        sellerButton = new JButton("Seller");
        sellerButton.setBounds(170, 220, 120, 70);
        sellerButton.addActionListener(this::sellerButtonActionPerformed);
        bg.add(sellerButton);

        // Customer registration button
        customerButton = new JButton("Customer");
        customerButton.setBounds(460, 220, 120, 70);
        customerButton.addActionListener(this::customerButtonActionPerformed);
        bg.add(customerButton);

        // Log In button
        loginButton = new JButton("Log In");
        loginButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
        loginButton.setBounds(325, 330, 150, 50); // Centered below the role options
        loginButton.addActionListener(this::loginButtonActionPerformed);
        bg.add(loginButton);
    }

    /**
     * Action triggered when the Seller button is clicked.
     * Opens the seller registration window.
     */
    private void sellerButtonActionPerformed(ActionEvent evt) {
        SwingUtilities.invokeLater(() -> new RgSellervw().setVisible(true));
        dispose(); // Close current window
    }

    /**
     * Action triggered when the Customer button is clicked.
     * Opens the customer registration window.
     */
    private void customerButtonActionPerformed(ActionEvent evt) {
        SwingUtilities.invokeLater(() -> new RgCustomervw().setVisible(true));
        dispose();
    }

    /**
     * Action triggered when the Log In button is clicked.
     * Opens the login window.
     */
    private void loginButtonActionPerformed(ActionEvent evt) {
        SwingUtilities.invokeLater(() -> new Loginvw().setVisible(true));
        dispose();
    }
}