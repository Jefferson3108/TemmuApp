// Author: Jefferson David Rico Ruiz

package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

import Controller.Customer;
import Controller.Payment;

/**
 * This class represents the payment view in the TEMMU application.
 * It shows customer and product information, and allows entering credit card data
 * to simulate a purchase.
 */
public class Paymentvw extends JFrame {

    JTextField cardField;
    JTextField codeField;

    /**
     * Constructor to initialize the payment window with product information.
     * 
     * @param NameProduct Name of the product being purchased
     * @param Price       Price of the product
     * @param Image       Path to product image
     */
    public Paymentvw(String NameProduct, String Price, String Image) {
        setTitle("Payment");
        setSize(450, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initComponents(NameProduct, Price, Image);
    }

    /**
     * Initializes the layout and components for customer info, product info,
     * payment form and button.
     * 
     * @param NameProduct Product name
     * @param Price       Product price
     * @param getImage    Image path
     */
    private void initComponents(String NameProduct, String Price, String getImage) {
        Customer c = Customer.currentCustomer;

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        mainPanel.setBackground(Color.WHITE);

        // ===== Customer Info =====
        JLabel userInfo = new JLabel("Customer Information");
        userInfo.setFont(new Font("Tahoma", Font.BOLD, 18));
        userInfo.setAlignmentX(Component.LEFT_ALIGNMENT);

        JPanel customerPanel = new JPanel(new GridLayout(3, 1, 5, 5));
        customerPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        customerPanel.setBackground(Color.WHITE);

        JLabel nameLabel = new JLabel("Name: " + c.name);
        JLabel addressLabel = new JLabel("Address: " + c.resiadd);
        JLabel countryLabel = new JLabel("Country: " + c.country);

        Font labelFont = new Font("Tahoma", Font.PLAIN, 14);
        nameLabel.setFont(labelFont);
        addressLabel.setFont(labelFont);
        countryLabel.setFont(labelFont);

        customerPanel.add(nameLabel);
        customerPanel.add(addressLabel);
        customerPanel.add(countryLabel);

        // ===== Product Info =====
        JLabel productInfo = new JLabel("Product Information");
        productInfo.setFont(new Font("Tahoma", Font.BOLD, 18));
        productInfo.setAlignmentX(Component.LEFT_ALIGNMENT);

        JPanel productPanel = new JPanel(new BorderLayout(10, 10));
        productPanel.setMaximumSize(new Dimension(400, 120));
        productPanel.setBackground(new Color(245, 245, 245));
        productPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));

        JLabel productImage = new JLabel();
        productImage.setPreferredSize(new Dimension(100, 100));
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

        JPanel productText = new JPanel();
        productText.setLayout(new BoxLayout(productText, BoxLayout.Y_AXIS));
        productText.setBackground(new Color(245, 245, 245));

        JLabel productName = new JLabel("Name: " + NameProduct);
        JLabel productPrice = new JLabel("Price: $" + Price);
        productName.setFont(labelFont);
        productPrice.setFont(labelFont);

        productText.add(productName);
        productText.add(productPrice);

        productPanel.add(productImage, BorderLayout.WEST);
        productPanel.add(productText, BorderLayout.CENTER);

        // ===== Payment Details =====
        JLabel paymentLabel = new JLabel("Payment Details");
        paymentLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
        paymentLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        JPanel cardPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        cardPanel.setBackground(Color.WHITE);

        JLabel cardLabel = new JLabel("Card Number:");
        cardField = new JTextField();
        cardField.setFont(new Font("Tahoma", Font.PLAIN, 16));
        cardField.setPreferredSize(new Dimension(250, 35));

        JLabel codeLabel = new JLabel("Security Code:");
        codeField = new JTextField();
        codeField.setFont(new Font("Tahoma", Font.PLAIN, 16));
        codeField.setPreferredSize(new Dimension(120, 35));

        cardLabel.setFont(labelFont);
        codeLabel.setFont(labelFont);

        cardPanel.add(cardLabel);
        cardPanel.add(cardField);
        cardPanel.add(codeLabel);
        cardPanel.add(codeField);

        // ===== Payment Methods =====
        JPanel methodPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 5));
        methodPanel.setBackground(Color.WHITE);
        JRadioButton visaRbtn = new JRadioButton("Visa");
        JRadioButton masterRbtn = new JRadioButton("MasterCard");
        ButtonGroup group = new ButtonGroup();
        group.add(masterRbtn);
        group.add(visaRbtn);
        methodPanel.add(visaRbtn);
        methodPanel.add(masterRbtn);

        // ===== Pay Button =====
        JButton payBtn = new JButton("PAY NOW");
        payBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
        payBtn.setBackground(new Color(103, 58, 183));
        payBtn.setForeground(Color.WHITE);
        payBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        payBtn.addActionListener(this::onPayProduct);

        // ===== Assemble Panels =====
        mainPanel.add(userInfo);
        mainPanel.add(Box.createVerticalStrut(10));
        mainPanel.add(customerPanel);

        mainPanel.add(Box.createVerticalStrut(20));
        mainPanel.add(productInfo);
        mainPanel.add(Box.createVerticalStrut(10));
        mainPanel.add(productPanel);

        mainPanel.add(Box.createVerticalStrut(20));
        mainPanel.add(paymentLabel);
        mainPanel.add(Box.createVerticalStrut(10));
        mainPanel.add(cardPanel);

        mainPanel.add(Box.createVerticalStrut(20));
        mainPanel.add(methodPanel);
        mainPanel.add(Box.createVerticalStrut(10));
        mainPanel.add(payBtn);

        add(mainPanel);
    }

    /**
     * Gets the card number input as text.
     * @return Card number string
     */
    public String getTextNumcard() {
        return cardField.getText();
    }

    /**
     * Gets the security code input as text.
     * @return Security code string
     */
    public String getTextcodCard() {
        return codeField.getText();
    }

    /**
     * Action triggered when the Pay button is clicked.
     * Validates the card and shows success or error message.
     */
    public void onPayProduct(ActionEvent evt) {
        Payment py = new Payment(getTextNumcard(), getTextcodCard());
        if (py.ValidatePurchase()) {
            JOptionPane.showMessageDialog(this, "Purchase successfully completed");
            SwingUtilities.invokeLater(() -> new MainCustomervw().setVisible(true));
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Error, enter a valid card");
        }
    }
}
