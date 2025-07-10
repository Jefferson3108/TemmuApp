package View;

import javax.swing.*;
import Controller.Customer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;

public class ProductSelectedvw extends JFrame {
	private String productName;
	private String productPrice;
	private String productDescription;
	private String productImagePath;

    public ProductSelectedvw(String title, String price, String description, String imagePath) {
    	this.productName = title;
        this.productPrice = price;
        this.productDescription = description;
        this.productImagePath = imagePath;
        setTitle("Product Detail");
        setSize(400, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initComponents(title, price, description, imagePath);
    }

    private void initComponents(String name, String price, String description, String imagePath) {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBackground(Color.WHITE);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        // Título
     // Panel con botón "Back" y nombre
        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 20, 50));
        headerPanel.setBackground(Color.WHITE);

        // Botón volver
        JButton backButton = new JButton("←");
        backButton.setFocusPainted(false);
        backButton.setMargin(new Insets(2, 8, 2, 8));
        backButton.setFont(new Font("Tahoma", Font.BOLD, 14));
        backButton.setBackground(new Color(240, 240, 240));
        backButton.addActionListener(e -> {
            dispose(); // cerrar esta ventana
            new MainCustomervw().setVisible(true); // ← reemplaza con tu clase de ventana principal
        });

        // Título
        JLabel titleLabel = new JLabel(name);
        titleLabel.setFont(new Font("Tahoma", Font.BOLD, 20));

        headerPanel.add(backButton);
        headerPanel.add(titleLabel);

        // Subtítulo
        JLabel subTitleLabel = new JLabel("Product");
        subTitleLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        subTitleLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        // Imagen
        JLabel imageLabel = new JLabel();
        imageLabel.setPreferredSize(new Dimension(200, 200));
        imageLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        if (imagePath != null && new File(imagePath).exists()) {
            ImageIcon icon = new ImageIcon(imagePath);
            Image img = icon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
            imageLabel.setIcon(new ImageIcon(img));
        } else {
            imageLabel.setText("No image");
            imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
            imageLabel.setOpaque(true);
            imageLabel.setBackground(new Color(240, 240, 240));
        }

        // Precio
        JLabel priceLabel = new JLabel("PRICE: " + price);
        priceLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        priceLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        priceLabel.setForeground(new Color(85, 85, 85));

        // Botón de pago
        JButton payButton = new JButton("PAY NOW");
        payButton.setBackground(new Color(103, 58, 183)); // color púrpura
        payButton.setForeground(Color.WHITE);
        payButton.setFocusPainted(false);
        payButton.setAlignmentX(Component.LEFT_ALIGNMENT);
        payButton.addActionListener(this::onPayNow);

        // Descripción
        JTextArea descArea = new JTextArea(description);
        descArea.setLineWrap(true);
        descArea.setWrapStyleWord(true);
        descArea.setEditable(false);
        descArea.setFont(new Font("Tahoma", Font.PLAIN, 12));
        descArea.setBackground(new Color(250, 250, 250));
        descArea.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JScrollPane scrollDesc = new JScrollPane(descArea);
        scrollDesc.setPreferredSize(new Dimension(360, 200));
        scrollDesc.setAlignmentX(Component.LEFT_ALIGNMENT);
        // Agregar al panel
        mainPanel.add(backButton);
        mainPanel.add(titleLabel);
        mainPanel.add(subTitleLabel);
        mainPanel.add(Box.createVerticalStrut(10));
        mainPanel.add(imageLabel);
        mainPanel.add(Box.createVerticalStrut(10));
        mainPanel.add(priceLabel);
        mainPanel.add(Box.createVerticalStrut(10));
        mainPanel.add(payButton);
        mainPanel.add(Box.createVerticalStrut(10));
        mainPanel.add(scrollDesc);

        add(mainPanel);
    }
    private void onPayNow(ActionEvent evt) {
        if (Customer.currentCustomer != null) {
        	SwingUtilities.invokeLater(() -> new Paymentvw(this.productName,this.productPrice,this.productImagePath).setVisible(true));
            dispose();
        } else{
            JOptionPane.showMessageDialog(this, "No customer is currently logged in.");
        }
    }
    	
    }

   


