package View;

import javax.swing.*;

import Controller.Register;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.logging.Logger;

/**
 * This class represents the registration window for a Customer in the Temmu application.
 * It allows the user to input personal and contact information to create a profile.
 */
public class RgCustomervw extends JFrame {

    // Logger for debugging if needed
    private static final Logger logger = Logger.getLogger(RgCustomervw.class.getName());

    // Form components
    private JTextField fieldName, fieldEmail, fieldPhone, fieldAddress, fieldPassword, fieldAge;
    private JComboBox<String> countryCombo;
    private JPanel panel; // Main panel to hold all components

    /**
     * Constructor that initializes the customer registration window.
     */
    public RgCustomervw() {
        showComponents();
    }

    /**
     * Initializes and arranges all UI components in the frame.
     */
    public void showComponents() {
        setTitle("Customer Profile");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 600);
        setLocationRelativeTo(null); // Center the window

        // Initialize main panel
        panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setLayout(null); // Using absolute layout

        // Logo with text
        JLabel temuLogo = new JLabel(
                "TEMMU", 
                new ImageIcon(getClass().getResource("/images/temu_80x80.png")), 
                JLabel.LEFT
        );
        temuLogo.setFont(new Font("Tahoma", Font.BOLD, 24));
        temuLogo.setBounds(26, 10, 300, 80);
        panel.add(temuLogo);

        // Title label
        JLabel title = new JLabel("Customer Profile");
        title.setFont(new Font("Tahoma", Font.BOLD, 24));
        title.setBounds(150, 90, 250, 30);
        panel.add(title);

        // Form labels and input fields
        addLabel(panel, "Full Name", 30, 130);
        fieldName = addTextField(panel, 30, 150);

        addLabel(panel, "Phone Number", 260, 130);
        fieldPhone = addTextField(panel, 260, 150);

        addLabel(panel, "Email Address", 30, 200);
        fieldEmail = addTextField(panel, 30, 220);

        addLabel(panel, "Country", 260, 200);
        countryCombo = new JComboBox<>(new String[]{"Colombia", "Mexico", "Argentina", "Brazil"});
        countryCombo.setBounds(260, 220, 190, 34);
        panel.add(countryCombo);

        addLabel(panel, "Age", 30, 270);
        fieldAge = addTextField(panel, 30, 290);

        addLabel(panel, "Resident Address", 260, 270);
        fieldAddress = addTextField(panel, 260, 290);

        addLabel(panel, "Password", 30, 340);
        fieldPassword = addTextField(panel, 30, 360);

        // Back button
        JButton backButton = new JButton("Back");
        backButton.setBounds(30, 420, 117, 40);
        backButton.addActionListener(this::onBack);
        panel.add(backButton);

        // Next button
        JButton nextButton = new JButton("Next");
        nextButton.setBounds(330, 420, 117, 40);
        nextButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        nextButton.addActionListener(this::onNext);
        panel.add(nextButton);

        // Add panel to frame
        add(panel);
        setVisible(true);
    }

    // ================= Getter methods for input fields ==================

    /**
     * Gets the full name from the input field.
     * @return Full name as String
     */
    public String getFieldName() {
        return fieldName.getText();
    }

    /**
     * Gets the age from the input field.
     * @return Age as String
     */
    public String getFieldAge() {
        return fieldAge.getText();
    }

    /**
     * Gets the phone number from the input field.
     * @return Phone number as String
     */
    public String getFieldPhone() {
        return fieldPhone.getText();
    }

    /**
     * Gets the email address from the input field.
     * @return Email as String
     */
    public String getFieldEmail() {
        return fieldEmail.getText();
    }

    /**
     * Gets the residential address from the input field.
     * @return Address as String
     */
    public String getFieldAddress() {
        return fieldAddress.getText();
    }

    /**
     * Gets the password from the input field.
     * @return Password as String
     */
    public String getFieldPassword() {
        return fieldPassword.getText();
    }

    /**
     * Gets the selected country from the combo box.
     * @return Country as String
     */
    public String getSelectedCountry() {
        return (String) countryCombo.getSelectedItem();
    }

    // ================= Button Actions ==================

    /**
     * Action handler for the "Back" button.
     * Navigates the user back to the role selection window.
     * @param evt The action event triggered by the button.
     */
    private void onBack(ActionEvent evt) {
        new Selectvw().setVisible(true);
        dispose(); // Close current window
    }

    /**
     * Action handler for the "Next" button.
     * Attempts to create a user profile and displays a confirmation or error message.
     * @param evt The action event triggered by the button.
     */
    public void onNext(ActionEvent evt) {
        // Create a Register object with the data from input fields
        Register rg = new Register(
            getFieldName(),
            getFieldAge(),
            getFieldPhone(),
            getSelectedCountry(),
            getFieldAddress(),
            getFieldEmail(),
            getFieldPassword(),
            null
        );

        // If profile creation is successful
        if (rg.createprof()==true) {
            JLabel fieldVerification = new JLabel();
            fieldVerification.setBounds(10, 20, 100, 30);
            panel.add(fieldVerification);

            JOptionPane.showMessageDialog(this, "Information submitted successfully.");
        } else {
            // Display error message if profile creation fails
            JOptionPane.showMessageDialog(this, "Error, please enter valid data again.");
        }
    }

    // ================= Utility Methods ==================

    /**
     * Adds a label to the panel at the specified position.
     * @param panel The panel where the label is added.
     * @param text The text to display on the label.
     * @param x The x-coordinate of the label.
     * @param y The y-coordinate of the label.
     */
    private void addLabel(JPanel panel, String text, int x, int y) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Tahoma", Font.BOLD, 12));
        label.setBounds(x, y, 200, 20);
        panel.add(label);
    }

    /**
     * Creates a text field and adds it to the panel at the specified position.
     * @param panel The panel where the text field is added.
     * @param x The x-coordinate of the text field.
     * @param y The y-coordinate of the text field.
     * @return The created JTextField.
     */
    private JTextField addTextField(JPanel panel, int x, int y) {
        JTextField textField = new JTextField();
        textField.setBounds(x, y, 190, 34);
        panel.add(textField);
        return textField;
    }
}
    
    



  
