package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class RgSellervw extends JFrame {

    // Componentes
    private JTextField fieldName, fieldEmail, fieldPhone, fieldPassword, fieldAddress;
    private JTextArea textExperience;
    private JComboBox<String> comboCountry;
    private JButton btnNext, btnBack;

    public RgSellervw() {
        setTitle("Seller Profile - TEMMU");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 650);
        setLocationRelativeTo(null);

        // Panel principal
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));
        add(mainPanel);

        // Logo y título
        JLabel logo = new JLabel("TEMMU", loadIcon(), JLabel.LEFT);
        logo.setFont(new Font("Tahoma", Font.BOLD, 24));
        logo.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel title = new JLabel("Seller Profile");
        title.setFont(new Font("Tahoma", Font.BOLD, 22));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        mainPanel.add(logo);
        mainPanel.add(title);
        mainPanel.add(Box.createVerticalStrut(20));

        // Campos del formulario
        fieldName = new JTextField(20);
        fieldEmail = new JTextField(20);
        fieldPhone = new JTextField(20);
        fieldPassword = new JTextField(20);
        fieldAddress = new JTextField(20);

        comboCountry = new JComboBox<>(new String[]{"Colombia", "Mexico", "Argentina", "Brasil"});

        textExperience = new JTextArea(5, 20);
        textExperience.setLineWrap(true);
        textExperience.setWrapStyleWord(true);
        JScrollPane scrollArea = new JScrollPane(textExperience);

        // Añadir campos
        mainPanel.add(createLabeledField("Full Name", fieldName));
        mainPanel.add(createLabeledField("Email Address", fieldEmail));
        mainPanel.add(createLabeledField("Phone Number", fieldPhone));
        mainPanel.add(createLabeledField("Password", fieldPassword));
        mainPanel.add(createLabeledField("Resident Address", fieldAddress));
        mainPanel.add(createLabeledField("Country", comboCountry));
        mainPanel.add(createLabeledField("Work Experience", scrollArea));

        // Panel de botones
        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 40, 10));
        btnBack = new JButton("Back");
        btnNext = new JButton("Next");

        btnBack.addActionListener(this::onBack);
        btnNext.addActionListener(this::onNext);

        btnPanel.add(btnBack);
        btnPanel.add(btnNext);

        mainPanel.add(Box.createVerticalStrut(15));
        mainPanel.add(btnPanel);
    }

    private JPanel createLabeledField(String labelText, JComponent field) {
        JPanel panel = new JPanel(new BorderLayout(5, 5));
        JLabel label = new JLabel(labelText);
        label.setFont(new Font("Tahoma", Font.BOLD, 12));
        panel.add(label, BorderLayout.NORTH);
        panel.add(field, BorderLayout.CENTER);
        panel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 70));
        return panel;
    }

    private void onBack(ActionEvent e) {
        // Simulación del botón Back
        JOptionPane.showMessageDialog(this, "Going back...");
        dispose();
        new Selectvw().setVisible(true);
        // new Selectvw().setVisible(true);  // Descomenta si tienes la clase Selectvw
    }

    private void onNext(ActionEvent e) {
        // Validación simple
        if (fieldName.getText().trim().isEmpty() ||
            fieldEmail.getText().trim().isEmpty() ||
            fieldPhone.getText().trim().isEmpty() ||
            fieldPassword.getText().trim().isEmpty()) {

            JOptionPane.showMessageDialog(this, "Please fill in all required fields.",
                    "Validation Error", JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Registration Successful!");
            // Aquí puedes agregar la lógica para ir a la siguiente pantalla
        }
    }

    private ImageIcon loadIcon() {
        try {
            return new ImageIcon(getClass().getResource("/images/temu_80x80.png"));
        } catch (Exception e) {
            System.out.println("Image not found.");
            return null;
        }
    }

   
}
