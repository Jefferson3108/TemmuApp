package View;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * This class represents the selection window for the Temmu app.
 * The user can choose between registering as a Seller or a Customer or go to login.
 */
public class Selectvw extends JFrame {

    // Components
    private JPanel bg;
    private JButton sellerButton;
    private JButton customerButton;
    private JButton loginButton; // Nuevo botón
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

    private void showComponents() {
        Frame();
        Panel();
        Labels();
        Buttons();
        getContentPane().add(bg);
    }

    private void Frame() {
        setTitle("Temmu app");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar ventana
    }

    private void Panel() {
        bg = new JPanel();
        bg.setBackground(Color.WHITE);
        bg.setLayout(null); // Posicionamiento absoluto
    }

    private void Labels() {
        // Título
        titleLabel = new JLabel("CREATE YOUR TEMMU ACCOUNT");
        titleLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
        titleLabel.setBounds(190, 40, 500, 40);
        bg.add(titleLabel);

        // Logo
        logoLabel = new JLabel();
        ImageIcon icon = new ImageIcon(getClass().getResource("/images/temu_80x80.png"));
        logoLabel.setIcon(icon);
        logoLabel.setBounds(100, 20, 80, 80);
        bg.add(logoLabel);

        // Instrucción
        instructionLabel = new JLabel("Select your role in the app");
        instructionLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        instructionLabel.setBounds(270, 150, 300, 30);
        bg.add(instructionLabel);

        // Texto "OR"
        orLabel = new JLabel("OR");
        orLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        orLabel.setBounds(370, 250, 40, 20);
        bg.add(orLabel);
    }

    private void Buttons() {
        // Botón Seller
        sellerButton = new JButton("Seller");
        sellerButton.setBounds(170, 220, 120, 70);
        sellerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                sellerButtonActionPerformed(evt);
            }
        });
        bg.add(sellerButton);

        // Botón Customer
        customerButton = new JButton("Customer");
        customerButton.setBounds(460, 220, 120, 70);
        customerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                customerButtonActionPerformed(evt);
            }
        });
        bg.add(customerButton);

        // Botón Log In
        loginButton = new JButton("Log In");
        loginButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
        loginButton.setBounds(325, 330, 150, 50); // Posición centrada debajo de los otros botones
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });
        bg.add(loginButton);
    }

    private void sellerButtonActionPerformed(ActionEvent evt) {
        SwingUtilities.invokeLater(() -> new RgSellervw().setVisible(true));
        dispose();
    }

    private void customerButtonActionPerformed(ActionEvent evt) {
        SwingUtilities.invokeLater(() -> new RgCustomervw().setVisible(true));
        dispose();
    }

    /**
     * Acción del botón Log In.
     * Abre la ventana de login directamente.
     */
    private void loginButtonActionPerformed(ActionEvent evt) {
        SwingUtilities.invokeLater(() -> new Loginvw().setVisible(true));
        dispose();
    }
}