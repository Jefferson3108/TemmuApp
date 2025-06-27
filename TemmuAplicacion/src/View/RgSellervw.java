package View;

import javax.swing.*;

import Controller.Profile;
import Controller.Register;
import Controller.Seller;
import Model.data;

import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * This class represents the registration form for a Seller in the Temmu app.
 * It collects personal information, contact details, and work experience from the user.
 */
public class RgSellervw extends JFrame {

    // Form Fields
    private final JTextField fieldName = new JTextField();
    private final JTextField fieldEmail = new JTextField();
    private final JTextField fieldPhone = new JTextField();
    private final JTextField fieldAddress = new JTextField();
    private final JTextField fieldAge = new JTextField();
    private final JTextField fieldPassword = new JTextField();

    // Dropdown for country selection
    private final JComboBox<String> comboCountry = new JComboBox<>(new String[]{
            "Colombia", "Mexico", "Argentina", "Brasil"
    });

    // Text area for work experience
    private final JTextArea textWorkExp = new JTextArea();

    // Buttons
    private final JButton buttonBack = new JButton("Back");
    private final JButton buttonNext = new JButton("Next");

    /**
     * Constructor that initializes the Seller Registration form.
     */
    public RgSellervw() {
        setTitle("Seller Profile");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 700);
        setLocationRelativeTo(null); // Center the window
        setLayout(new BorderLayout());

        // Main panel setup
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
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

        // Input Fields
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

        // Button Listeners
        buttonBack.addActionListener(this::onBack);
        buttonNext.addActionListener(this::onNext);

        // Add panel to the frame
        add(panel, BorderLayout.CENTER);
    }

    /**
     * Utility method to add a label and its corresponding input component to the panel.
     *
     * @param panel The panel where the components are added.
     * @param gbc   GridBagConstraints for layout control.
     * @param label The label text.
     * @param field The input component (JTextField, JComboBox, etc.).
     */
    private void addField(JPanel panel, GridBagConstraints gbc, String label, Component field) {
        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(new JLabel(label), gbc);

        gbc.gridx = 1;
        panel.add(field, gbc);
    }

    /**
     * Action when the "Back" button is clicked.
     * Returns the user to the role selection screen.
     *
     * @param e The action event triggered.
     */
    private void onBack(ActionEvent e) {
        new Selectvw().setVisible(true); // Open selection screen
        dispose(); // Close current window
    }

    /**
     * Action when the "Next" button is clicked.
     * This is where the data submission logic should be implemented.
     * Currently, it shows a confirmation message.
     *
     * @param e The action event triggered.
     */
    private void onNext(ActionEvent e) {
        // Data submission logic should be implemented here (e.g., validation, saving data).
        JOptionPane.showMessageDialog(this, "Information submitted successfully.");
    }

}

   

