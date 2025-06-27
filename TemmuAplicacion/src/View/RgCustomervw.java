package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.logging.Logger;

/**
 * This class represents the registration form for a Customer in the Temmu app.
 * It allows users to input their personal and contact information to create an account.
 */
public class RgCustomervw extends JFrame {

    // Logger for potential debugging
    private static final Logger logger = Logger.getLogger(RgCustomervw.class.getName());

    // Form fields
    private JTextField fieldName, fieldEmail, fieldPhone, fieldAddress, fieldPassword, fieldAge;
    private JComboBox<String> countryCombo;

    /**
     * Constructor initializes the customer registration window.
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
        setLocationRelativeTo(null); // Center window

        // Main panel setup
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setLayout(null); // Absolute layout

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
        countryCombo = new JComboBox<>(new String[]{"Colombia", "Mexico", "Argentina", "Brasil"});
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

        // Final setup
        add(panel);
        setVisible(true);
    }

    // ================= Getter methods for input fields ==================

    public String getFieldName() {
        return fieldName.getText();
    }

    public String getFieldAge() {
        return fieldAge.getText();
    }

    public String getFieldPhone() {
        return fieldPhone.getText();
    }

    public String getFieldEmail() {
        return fieldEmail.getText();
    }

    public String getFieldAddress() {
        return fieldAddress.getText();
    }

    public String getFieldPassword() {
        return fieldPassword.getText();
    }

    public String getSelectedCountry() {
        return (String) countryCombo.getSelectedItem();
    }

    // ================= Button Actions ==================

    /**
     * Action for the "Back" button.
     * Returns the user to the role selection screen.
     */
    private void onBack(ActionEvent evt) {
        new Selectvw().setVisible(true);
        dispose(); // Close current window
    }

    /**
     * Action for the "Next" button.
     * Here you can implement validation and saving data.
     */
    public void onNext(ActionEvent evt) {
        // TODO: Implement form validation and saving logic
        JOptionPane.showMessageDialog(this, "Information submitted successfully.");
    }

    // ================= Utility Methods ==================

    /**
     * Adds a label to the panel at specified position.
     *
     * @param panel The panel where the label is added.
     * @param text  The text of the label.
     * @param x     The x-coordinate.
     * @param y     The y-coordinate.
     */
    private void addLabel(JPanel panel, String text, int x, int y) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Tahoma", Font.BOLD, 12));
        label.setBounds(x, y, 200, 20);
        panel.add(label);
    }

    /**
     * Creates a text field and adds it to the panel at specified position.
     *
     * @param panel The panel where the text field is added.
     * @param x     The x-coordinate.
     * @param y     The y-coordinate.
     * @return The created JTextField.
     */
    private JTextField addTextField(JPanel panel, int x, int y) {
        JTextField textField = new JTextField();
        textField.setBounds(x, y, 190, 34);
        panel.add(textField);
        return textField;
    }
}
    
    
}

  
