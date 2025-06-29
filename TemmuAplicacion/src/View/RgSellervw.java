package View;

import javax.swing.*;

import Controller.Register;

import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * This class represents the registration form for a Seller in the Temmu app.
 * It collects personal information, contact details, and work experience from the user.
 */
public class RgSellervw extends JFrame {

    // ================== UI Components ==================

    // Form input fields
    private final JTextField fieldName = new JTextField();
    private final JTextField fieldEmail = new JTextField();
    private final JTextField fieldPhone = new JTextField();
    private final JTextField fieldAddress = new JTextField();
    private final JTextField fieldAge = new JTextField();
    private final JTextField fieldPassword = new JTextField();

    // Dropdown for selecting the country
    private final JComboBox<String> comboCountry = new JComboBox<>(new String[]{
            "Colombia", "Mexico", "Argentina", "Brazil"
    });

    // Text area for work experience
    private final JTextArea textWorkExp = new JTextArea();

    // Buttons
    private final JButton buttonBack = new JButton("Back");
    private final JButton buttonNext = new JButton("Next");

    // Main panel and layout constraints
    JPanel panel;
    GridBagConstraints gbc;

    /**
     * Constructor that initializes the Seller Registration form.
     */
    public RgSellervw() {
        setTitle("Seller Profile");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 700);
        setLocationRelativeTo(null); // Center the window
        setLayout(new BorderLayout());

        // Initialize main panel
        panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setLayout(new GridBagLayout());

        // Initialize layout constraints
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Padding between components
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;

        // Logo and App Name
        JLabel logo = new JLabel(
                "TEMMU",
                new ImageIcon(getClass().getResource("/images/temu_80x80.png")),
                JLabel.LEFT
        );
        logo.setFont(new Font("Tahoma", Font.BOLD, 24));
        panel.add(logo, gbc);

        // Title Label
        gbc.gridy++;
        JLabel title = new JLabel("Seller Profile", JLabel.CENTER);
        title.setFont(new Font("Tahoma", Font.BOLD, 24));
        gbc.gridwidth = 2;
        panel.add(title, gbc);
        gbc.gridwidth = 1;

        // Adding input fields with labels
        addField(panel, gbc, "Full Name", fieldName);
        addField(panel, gbc, "Phone Number", fieldPhone);
        addField(panel, gbc, "Age", fieldAge);
        addField(panel, gbc, "Country", comboCountry);
        addField(panel, gbc, "Email Address", fieldEmail);
        addField(panel, gbc, "Resident Address", fieldAddress);
        addField(panel, gbc, "Password", fieldPassword);

        // Work Experience Text Area
        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(new JLabel("Work Experience"), gbc);

        gbc.gridx = 1;
        textWorkExp.setRows(5);
        textWorkExp.setLineWrap(true);
        textWorkExp.setWrapStyleWord(true);
        panel.add(new JScrollPane(textWorkExp), gbc);

        // Buttons (Back and Next)
        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(buttonBack, gbc);

        gbc.gridx = 1;
        panel.add(buttonNext, gbc);

        // Button Event Listeners
        buttonBack.addActionListener(this::onBack);
        buttonNext.addActionListener(this::onNext);

        // Add main panel to the frame
        add(panel, BorderLayout.CENTER);
    }

    /**
     * Utility method to add a label and its corresponding input component to the panel.
     *
     * @param panel The panel where the components are added.
     * @param gbc   Layout constraints for positioning.
     * @param label The text for the label.
     * @param field The input component (JTextField, JComboBox, etc.).
     */
    private void addField(JPanel panel, GridBagConstraints gbc, String label, Component field) {
        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(new JLabel(label), gbc);

        gbc.gridx = 1;
        panel.add(field, gbc);
    }

    // ================== Getters for Form Data ==================

    /**
     * Retrieves the full name from the input field.
     * @return Full name as String.
     */
    public String getFieldName() {
        return fieldName.getText();
    }

    /**
     * Retrieves the age from the input field.
     * @return Age as String.
     */
    public String getFieldAge() {
        return fieldAge.getText();
    }

    /**
     * Retrieves the phone number from the input field.
     * @return Phone number as String.
     */
    public String getFieldPhone() {
        return fieldPhone.getText();
    }

    /**
     * Retrieves the email address from the input field.
     * @return Email address as String.
     */
    public String getFieldEmail() {
        return fieldEmail.getText();
    }

    /**
     * Retrieves the residential address from the input field.
     * @return Address as String.
     */
    public String getFieldAddress() {
        return fieldAddress.getText();
    }

    /**
     * Retrieves the password from the input field.
     * @return Password as String.
     */
    public String getFieldPassword() {
        return fieldPassword.getText();
    }

    /**
     * Retrieves the selected country from the combo box.
     * @return Country as String.
     */
    public String getSelectedCountry() {
        return (String) comboCountry.getSelectedItem();
    }

    /**
     * Retrieves the work experience description from the text area.
     * @return Work experience as String.
     */
    public String getFieldExp() {
        return textWorkExp.getText();
    }

    // ================== Button Actions ==================

    /**
     * Action triggered when the "Back" button is clicked.
     * Returns the user to the role selection screen.
     * @param e Action event triggered.
     */
    private void onBack(ActionEvent e) {
        new Selectvw().setVisible(true); // Open selection screen
        dispose(); // Close the current window
    }

    /**
     * Action triggered when the "Next" button is clicked.
     * Handles data submission logic and displays confirmation or error messages.
     * @param e Action event triggered.
     */
    private void onNext(ActionEvent e) {
        // Create Register object with user input
        Register rg = new Register(
                getFieldName(),
                getFieldAge(),
                getFieldPhone(),
                getSelectedCountry(),
                getFieldAddress(),
                getFieldEmail(),
                getFieldPassword(),
                getFieldExp()
        );

        // Check if profile creation is successful
        if (rg.createprof()==true) {
            JLabel fieldVerification = new JLabel();
            fieldVerification.setBounds(10, 20, 100, 30);
            panel.add(fieldVerification);

            JOptionPane.showMessageDialog(this, "Information submitted successfully.");
        } else {
            JOptionPane.showMessageDialog(this, "Error, please enter valid data again.");
        }
    }
}
    

   

