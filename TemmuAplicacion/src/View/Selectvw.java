package View;
import java.awt.*;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.*;

public class Selectvw extends JFrame {

    private JPanel bg;
    private JButton sellerButton;
    private JButton customerButton;
    private JLabel titleLabel;
    private JLabel logoLabel;
    private JLabel orLabel;
    private JLabel instructionLabel;

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
    	  // Configuración de la ventana
        setTitle("Temmu app");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar la ventana
        
    }
    private void Panel() {
    	// Panel principal
        bg = new JPanel();
        bg.setBackground(Color.WHITE);
        bg.setLayout(null); // Usamos coordenadas absolutas por simplicidad
    }
    private void Labels() {
    	// Título
        titleLabel = new JLabel("CREATE YOUR TEMMU ACCOUNT");
        titleLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
        titleLabel.setBounds(190, 40, 500, 40);
        bg.add(titleLabel);

        // Logo (asegúrate de tener la imagen en la ruta correcta dentro de src/images/)
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
        // Texto OR
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
    	
    }
    private void sellerButtonActionPerformed(ActionEvent evt) {
    	SwingUtilities.invokeLater(() -> new RgSellervw().setVisible(true));
    	dispose();
    }

    private void customerButtonActionPerformed(ActionEvent evt) {
    	  try {
              UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
          } catch (Exception e) {
              Logger.getLogger(RgCustomervw.class.getName()).log(Level.SEVERE, null, e);
          }

          SwingUtilities.invokeLater(() -> {
              new RgCustomervw().setVisible(true);
              dispose();
          });
    }

   
}
