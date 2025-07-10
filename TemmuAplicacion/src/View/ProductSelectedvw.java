// Author: Jefferson David Rico Ruiz

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
	
	/**
     * Constructor to initialize the product detail window.
     * 
     * @param title       Name of the product
     * @param price       Price of the product
     * @param description Description of the product
     * @param imagePath   Path to the product image file
     */

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
    
    /**
     * Builds and arranges the UI components in the frame.
     * 
     * @param name        Product name
     * @param price       Product price
     * @param description Product description
     * @param imagePath   Path to product image
     */

    private void initComponents(String name, String price, String description, String imagePath) {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBackground(Color.WHITE);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        
        // --- Header Panel with back button and title ---
        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 20, 50));
        headerPanel.setBackground(Color.WHITE);

        // --- back button ---
        JButton backButton = new JButton("←");
        backButton.setFocusPainted(false);
        backButton.setMargin(new Insets(2, 8, 2, 8));
        backButton.setFont(new Font("Tahoma", Font.BOLD, 14));
        backButton.setBackground(new Color(240, 240, 240));
        backButton.addActionListener(e -> {
            dispose(); // Close current window
            new MainCustomervw().setVisible(true); // Return to customer main view
        });

        JLabel titleLabel = new JLabel(name);
        titleLabel.setFont(new Font("Tahoma", Font.BOLD, 20));

        headerPanel.add(backButton);
        headerPanel.add(titleLabel);

        // --- Subtitle ---
        JLabel subTitleLabel = new JLabel("Product");
        subTitleLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        subTitleLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        // --- Product Image ---
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

        // --- Product Price ---
        JLabel priceLabel = new JLabel("PRICE: " + price);
        priceLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        priceLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        priceLabel.setForeground(new Color(85, 85, 85));

        // --- Pay Button ---
        JButton payButton = new JButton("PAY NOW");
        payButton.setBackground(new Color(103, 58, 183)); 
        payButton.setForeground(Color.WHITE);
        payButton.setFocusPainted(false);
        payButton.setAlignmentX(Component.LEFT_ALIGNMENT);
        payButton.addActionListener(this::onPayNow);

        // --- Product Description ---
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
        
        // --- Add components to main panel ---
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
    
    /**
     * Action performed when the PAY NOW button is clicked.
     * Opens the payment window if a customer is logged in.
     */
    private void onPayNow(ActionEvent evt) {
        if (Customer.currentCustomer != null) {
        	SwingUtilities.invokeLater(() -> new Paymentvw(this.productName,this.productPrice,this.productImagePath).setVisible(true));
            dispose(); // Close this window
        } else{
            JOptionPane.showMessageDialog(this, "No customer is currently logged in.");
        }
    }
    	
    }

   


