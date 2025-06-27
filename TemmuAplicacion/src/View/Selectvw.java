package View;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * This class represents the selection window for the Temmu app.
 * The user can choose between registering as a Seller or a Customer.
 */
public class Selectvw extends JFrame {

    // Components
    private JPanel bg;
    private JButton sellerButton;
    private JButton customerButton;
    private JLabel titleLabel;
    private JLabel logoLabel;
    private JLabel orLabel;
    private JLabel instructionLabel;

    /**
     * Constructor that initializes and displays all UI components.
     */
    public Selectvw() {
        showComponents();
    }

    /**
     * Initializes and arranges all components in the window.
     */
    private void showComponents() {
        Frame();
        Panel();
        Labels();
        Buttons();
        getContentPane().add(bg);
    }

    /**
     * Sets up the main frame properties like title, size, and close operation.
     */
    private void Frame() {
        setTitle("Temmu app");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centers the window on screen
    }

    /**
     * Creates and configures the main background panel.
     */
    private void Panel() {
        bg = new JPanel();
        bg.setBackground(Color.WHITE);
        bg.setLayout(null); // Absolute positioning
    }

    /**
     * Adds labels such as the title, logo, and instructions to the panel.
     */
    private void Labels() {
        // Main title label
        titleLabel = new JLabel("CREATE YOUR TEMMU ACCOUNT");
        titleLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
        titleLabel.setBounds(190, 40, 500, 40);
        bg.add(titleLabel);

        // Logo label (make sure the image is located at src/images/temu_80x80.png)
        logoLabel = new JLabel();
        ImageIcon icon = new ImageIcon(getClass().getResource("/images/temu_80x80.png"));
        logoLabel.setIcon(icon);
        logoLabel.setBounds(100, 20, 80, 80);
        bg.add(logoLabel);

        // Instruction label
        instructionLabel = new JLabel("Select your role in the app");
        instructionLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        instructionLabel.setBounds(270, 150, 300, 30);
        bg.add(instructionLabel);

        // "OR" label between the buttons
        orLabel = new JLabel("OR");
        orLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        orLabel.setBounds(370, 250, 40, 20);
        bg.add(orLabel);
    }

    /**
     * Adds the Seller and Customer buttons and defines their actions.
     */
    private void Buttons() {
        // Seller button
        sellerButton = new JButton("Seller");
        sellerButton.setBounds(170, 220, 120, 70);
        sellerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                sellerButtonActionPerformed(evt);
            }
        });
        bg.add(sellerButton);

        // Customer button
        customerButton = new JButton("Customer");
        customerButton.setBounds(460, 220, 120, 70);
        customerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                customerButtonActionPerformed(evt);
            }
        });
        bg.add(customerButton);
    }

    /**
     * Action performed when the Seller button is clicked.
     * Opens the Seller registration window and closes this one.
     */
    private void sellerButtonActionPerformed(ActionEvent evt) {
        SwingUtilities.invokeLater(() -> new RgSellervw().setVisible(true));
        dispose(); // Close current window
    }

    /**
     * Action performed when the Customer button is clicked.
     * Opens the Customer registration window and closes this one.
     */
    private void customerButtonActionPerformed(ActionEvent evt) {
        SwingUtilities.invokeLater(() -> new RgCustomervw().setVisible(true));
        dispose(); // Close current window
    }

}