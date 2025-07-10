// Author: Jefferson David Rico Ruiz

package View;

import javax.swing.*;
import Controller.Product;
import Controller.Seller;
import Model.data;

import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * This class represents the main seller view in the TEMMU application.
 * It displays a list of the seller's products and allows navigation between
 * products on sale and products sold. It also allows the user to add new products.
 */
public class MainSellervw extends JFrame {

    data d = new data();
    private CardLayout cardLayout;
    private JPanel productPanelContainer;
    private JPanel mainPanel;

    /**
     * Constructor to initialize the window.
     */
    public MainSellervw() {
        setTitle("My Products");
        setSize(400, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initComponents();
        showProducts();
    }

    /**
     * Initializes GUI components and layouts for the seller window.
     */
    private void initComponents() {
        JLabel title = new JLabel("My Products", SwingConstants.CENTER);
        title.setFont(new Font("Tahoma", Font.BOLD, 18));

        // Toggle buttons to switch between SALE and SOLD views
        JToggleButton saleButton = new JToggleButton("SALE");
        JToggleButton soldButton = new JToggleButton("SOLD");

        ButtonGroup toggleGroup = new ButtonGroup();
        toggleGroup.add(saleButton);
        toggleGroup.add(soldButton);
        saleButton.setSelected(true);

        JPanel togglePanel = new JPanel(new GridLayout(1, 2));
        togglePanel.add(saleButton);
        togglePanel.add(soldButton);

        // Card layout to switch between different product panels
        cardLayout = new CardLayout();
        productPanelContainer = new JPanel(cardLayout);

        productPanelContainer.add(buildEmptyMessage("You haven't added any products for sale yet."), "SALE");
        productPanelContainer.add(buildEmptyMessage("No products have been sold yet."), "SOLD");

        // Button to add a new product
        JButton addProductBtn = new JButton("ADD PRODUCT");
        addProductBtn.setBackground(new Color(255, 153, 0));
        addProductBtn.setForeground(Color.BLACK);
        addProductBtn.addActionListener(this::onAddProduct);

        // Top section of the layout
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
        topPanel.add(title);
        topPanel.add(Box.createVerticalStrut(10));
        topPanel.add(togglePanel);

        // Main panel layout
        mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(productPanelContainer, BorderLayout.CENTER);
        mainPanel.add(addProductBtn, BorderLayout.SOUTH);

        // Event listeners for toggle buttons
        saleButton.addActionListener(e -> cardLayout.show(productPanelContainer, "SALE"));
        soldButton.addActionListener(e -> cardLayout.show(productPanelContainer, "SOLD"));

        add(mainPanel);
    }

    /**
     * Builds a panel with a placeholder message for empty product lists.
     * @param message Text to display
     * @return JPanel with message
     */
    private JPanel buildEmptyMessage(String message) {
        JPanel panel = new JPanel(new BorderLayout());
        JLabel label = new JLabel(message, SwingConstants.CENTER);
        label.setFont(new Font("Tahoma", Font.ITALIC, 14));
        label.setForeground(Color.GRAY);
        panel.add(label, BorderLayout.CENTER);
        return panel;
    }

    /**
     * Opens the Add Product window when "ADD PRODUCT" is clicked.
     */
    private void onAddProduct(ActionEvent e) {
        SwingUtilities.invokeLater(() -> new AddProductvw().setVisible(true));
        dispose();  // Close current window
    }

    /**
     * Displays the products added by the seller in a vertical scrollable list.
     * Each product is shown as a card with its image, name, price, and stock.
     */
    public void showProducts() {
        Seller.Products.clear(); // Clear current list
        d.readProductTxt(Seller.Products); // Load products from file

        JPanel productListPanel = new JPanel();
        productListPanel.setLayout(new BoxLayout(productListPanel, BoxLayout.Y_AXIS));
        productListPanel.setBackground(Color.WHITE);

        if (Seller.Products != null) {
            for (Product pr : Seller.Products) {
                JPanel productCard = new JPanel(new BorderLayout());
                productCard.setBorder(BorderFactory.createLineBorder(Color.GRAY));
                productCard.setMaximumSize(new Dimension(Integer.MAX_VALUE, 130));
                productCard.setBackground(new Color(245, 245, 245));
                productCard.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

                // Display product image
                if (pr.ImagePr != null && !pr.ImagePr.isEmpty()) {
                    try {
                        ImageIcon icon = new ImageIcon(pr.ImagePr);
                        Image img = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                        JLabel imgLabel = new JLabel(new ImageIcon(img));
                        imgLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
                        productCard.add(imgLabel, BorderLayout.WEST);
                    } catch (Exception e) {
                        JLabel imgLabel = new JLabel("No image");
                        imgLabel.setPreferredSize(new Dimension(100, 100));
                        imgLabel.setHorizontalAlignment(SwingConstants.CENTER);
                        productCard.add(imgLabel, BorderLayout.WEST);
                    }
                }

                // Product textual info (name, price, stock)
                JPanel infoPanel = new JPanel();
                infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
                infoPanel.setBackground(new Color(245, 245, 245));
                infoPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

                infoPanel.add(new JLabel("Name: " + pr.NamePr));
                infoPanel.add(new JLabel("Price: $" + pr.Price + " Dollars"));
                infoPanel.add(new JLabel("Stock: " + pr.Stock));

                productCard.add(infoPanel, BorderLayout.CENTER);

                productListPanel.add(Box.createVerticalStrut(10));  // spacing
                productListPanel.add(productCard);
            }
        }

        JScrollPane scrollPane = new JScrollPane(productListPanel);
        scrollPane.setBorder(null);
        scrollPane.setPreferredSize(new Dimension(400, 400));

        productPanelContainer.removeAll();  // Clear old view
        productPanelContainer.add(scrollPane, "SALE");
        cardLayout.show(productPanelContainer, "SALE");

        revalidate();
        repaint();
    }
}

	    	
	    	
			
			
		
		
	


