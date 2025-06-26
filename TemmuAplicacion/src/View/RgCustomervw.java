package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RgCustomervw extends JFrame {

    private static final   Logger logger = Logger.getLogger(RgCustomervw.class.getName());

    private JTextField nameField, emailField, phoneField, addressField, passwordField;
    private JComboBox<String> countryCombo;

    public RgCustomervw() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Customer Profile");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 600);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Logo
        JLabel logoLabel = new JLabel("TEMMU", JLabel.CENTER);
        try {
            ImageIcon icon = new ImageIcon(getClass().getResource("/images/temu_80x80.png"));
            logoLabel.setIcon(icon);
        } catch (Exception e) {
            logger.log(Level.WARNING, "Logo not found", e);
        }
        logoLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(logoLabel, gbc);

        // Title
        JLabel titleLabel = new JLabel("Customer Profile", JLabel.CENTER);
        titleLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
        gbc.gridy++;
        panel.add(titleLabel, gbc);

        gbc.gridwidth = 1;

        // Full Name
        addLabel(panel, "Full Name", gbc, 0, 2);
        nameField = new JTextField(20);
        addField(panel, nameField, gbc, 1, 2);

        // Phone Number
        addLabel(panel, "Phone Number", gbc, 0, 3);
        phoneField = new JTextField(20);
        addField(panel, phoneField, gbc, 1, 3);

        // Email
        addLabel(panel, "Email Address", gbc, 0, 4);
        emailField = new JTextField(20);
        addField(panel, emailField, gbc, 1, 4);

        // Country
        addLabel(panel, "Country", gbc, 0, 5);
        countryCombo = new JComboBox<>(new String[]{"Colombia", "Mexico", "Argentina", "Brasil"});
        addField(panel, countryCombo, gbc, 1, 5);

        // Password
        addLabel(panel, "Password", gbc, 0, 6);
        passwordField = new JTextField(20);
        addField(panel, passwordField, gbc, 1, 6);

        // Resident Address
        addLabel(panel, "Resident Address", gbc, 0, 7);
        addressField = new JTextField(20);
        addField(panel, addressField, gbc, 1, 7);

        // Buttons
        JButton backButton = new JButton("Back");
        backButton.addActionListener(this::handleBack);
        gbc.gridx = 0;
        gbc.gridy = 8;
        panel.add(backButton, gbc);

        JButton nextButton = new JButton("Next");
        nextButton.addActionListener(this::handleNext);
        gbc.gridx = 1;
        gbc.gridy = 8;
        panel.add(nextButton, gbc);

        add(panel);
    }

    private void addLabel(JPanel panel, String text, GridBagConstraints gbc, int x, int y) {
        gbc.gridx = x;
        gbc.gridy = y;
        panel.add(new JLabel(text), gbc);
    }

    private void addField(JPanel panel, Component field, GridBagConstraints gbc, int x, int y) {
        gbc.gridx = x;
        gbc.gridy = y;
        panel.add(field, gbc);
    }

    private void handleBack(ActionEvent evt) {
        JOptionPane.showMessageDialog(this, "Going Back...");
        // Puedes abrir otra ventana, ejemplo:
        // new SelectVW().setVisible(true);
        dispose();
        new Selectvw().setVisible(true);
        
    }

    private void handleNext(ActionEvent evt) {
    	 // Validación simple
        if (nameField.getText().trim().isEmpty() ||
            emailField.getText().trim().isEmpty() ||
            phoneField.getText().trim().isEmpty() ||
            passwordField.getText().trim().isEmpty()) {

            JOptionPane.showMessageDialog(this, "Please fill in all required fields.",
                    "Validation Error", JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Registration Successful!");
            // Aquí puedes agregar la lógica para ir a la siguiente pantalla
        }
   
    }

   
}
