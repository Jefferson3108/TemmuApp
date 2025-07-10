package View;

import javax.swing.*;
import java.awt.*;
import Controller.Customer;
import Controller.Product;

public class Paymentvw extends JFrame {

    public Paymentvw(String NameProduct, String Price, String Image) {
        setTitle("Payment");
        setSize(450, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initComponents( NameProduct, Price, Image);
    }

    private void initComponents(String NameProduct, String Price, String getImage) {
    	Customer c= Customer.currentCustomer;
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Customer info
        JLabel userInfo = new JLabel("Customer Info", SwingConstants.CENTER);
        userInfo.setFont(new Font("Tahoma", Font.BOLD, 18));
        userInfo.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel nameLabel = new JLabel("Name: " + c.name);
        JLabel addressLabel = new JLabel("Address: " + c.resiadd);
        JLabel countryLabel = new JLabel("Country: " + c.country);

        // Product info
        JLabel productInfo = new JLabel("Product Info", SwingConstants.CENTER);
        productInfo.setFont(new Font("Tahoma", Font.BOLD, 18));
        productInfo.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel productName = new JLabel("Name: " + NameProduct);
        JLabel productPrice = new JLabel("Price: $" + Price);
        JLabel productImage = new JLabel();

        if (getImage != null && !getImage.isEmpty()) {
            try {
                ImageIcon icon = new ImageIcon(getImage);
                Image img = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                productImage.setIcon(new ImageIcon(img));
            } catch (Exception e) {
                productImage.setText("Image not available");
            }
        } else {
            productImage.setText("No image");
        }

        // Payment fields
        JLabel cardLabel = new JLabel("Card Number:");
        JTextField cardField = new JTextField();

        JLabel codeLabel = new JLabel("Security Code:");
        JTextField codeField = new JTextField();

        // Payment buttons
        JPanel methodPanel = new JPanel(new FlowLayout());
        JButton visaBtn = new JButton("Visa");
        JButton masterBtn = new JButton("MasterCard");
        JButton payBtn = new JButton("PAY NOW");

        methodPanel.add(visaBtn);
        methodPanel.add(masterBtn);

        // Add components to panel
        mainPanel.add(userInfo);
        mainPanel.add(Box.createVerticalStrut(10));
        mainPanel.add(nameLabel);
        mainPanel.add(addressLabel);
        mainPanel.add(countryLabel);
        mainPanel.add(Box.createVerticalStrut(20));

        mainPanel.add(productInfo);
        mainPanel.add(Box.createVerticalStrut(10));
        mainPanel.add(productName);
        mainPanel.add(productPrice);
        mainPanel.add(productImage);
        mainPanel.add(Box.createVerticalStrut(20));

        mainPanel.add(cardLabel);
        mainPanel.add(cardField);
        mainPanel.add(Box.createVerticalStrut(10));
        mainPanel.add(codeLabel);
        mainPanel.add(codeField);
        mainPanel.add(Box.createVerticalStrut(20));

        mainPanel.add(methodPanel);
        mainPanel.add(Box.createVerticalStrut(10));
        mainPanel.add(payBtn);

        add(mainPanel);
    }
}


