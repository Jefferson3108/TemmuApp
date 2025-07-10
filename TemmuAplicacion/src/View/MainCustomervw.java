// Author: Jefferson David Rico Ruiz

package View;

import javax.swing.*;

import Controller.Product;
import Controller.Seller;
import Model.data;

import java.awt.*;
import java.io.File;

/**
 * This class represents the main customer catalog window in the TEMMU application.
 * It displays available products in a scrollable list, allows filtering, and opens product detail views.
 */
public class MainCustomervw extends JFrame {

    private JPanel gridPanel;
    private JPanel mainPanel;
    data d = new data();  // Handles data loading from file

    /**
     * Constructor that initializes the customer product catalog window.
     */
    public MainCustomervw() {
        setTitle("Temmu Catalog");
        setSize(400, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initComponents();
        showProducts();
    }

    /**
     * Initializes the UI layout: filter bar, product grid, and scroll pane.
     */
    private void initComponents() {
        mainPanel = new JPanel(new BorderLayout());

        // Top panel with category filters (non-functional)
        JPanel filterPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        String[] filters = { "All", "Exclusive offer", "Women", "Man", "Home" };
        for (String filter : filters) {
            JButton btn = new JButton(filter);
            filterPanel.add(btn);  // Filter buttons (not hooked to logic)
        }
        mainPanel.add(filterPanel, BorderLayout.NORTH);

        // Grid panel (not used in current version, replaced by vertical list)
        gridPanel = new JPanel(new GridLayout(0, 3, 10, 10)); // 3-column grid
        gridPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        gridPanel.setBackground(Color.WHITE);

        // Scroll panel will be populated later in showProducts()
        JScrollPane scrollPane = new JScrollPane(gridPanel);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        add(mainPanel);
    }

    /**
     * Loads and displays the list of available products as individual cards.
     * Each card displays an image, name, price, and stock, and is clickable.
     */
    public void showProducts() {
        // Load product data from file
        Seller.Products.clear();
        d.readProductTxt(Seller.Products);

        // Panel to hold all product cards
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
                        // Fallback label if image fails
                        JLabel imgLabel = new JLabel("No Image");
                        imgLabel.setPreferredSize(new Dimension(100, 100));
                        imgLabel.setHorizontalAlignment(SwingConstants.CENTER);
                        productCard.add(imgLabel, BorderLayout.WEST);
                    }
                }

                // Product details (name, price, stock)
                JPanel infoPanel = new JPanel();
                infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
                infoPanel.setBackground(new Color(245, 245, 245));
                infoPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

                infoPanel.add(new JLabel("Name: " + pr.NamePr));
                infoPanel.add(new JLabel("Price: $" + pr.Price + " Dollars"));
                infoPanel.add(new JLabel("Stock: " + pr.Stock));

                productCard.add(infoPanel, BorderLayout.CENTER);

                // Add click listener to open product detail view
                productCard.addMouseListener(new java.awt.event.MouseAdapter() {
                    @Override
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        SwingUtilities.invokeLater(() ->
                            new ProductSelectedvw(pr.NamePr, String.valueOf(pr.Price), pr.Description, pr.ImagePr).setVisible(true)
                        );
                        dispose(); // Close this window
                    }
                });

                // Add card to panel
                productListPanel.add(Box.createVerticalStrut(10));  // Space between cards
                productListPanel.add(productCard);
            }
        }

        // Add scrollable container
        JScrollPane scrollPane = new JScrollPane(productListPanel);
        scrollPane.setBorder(null);
        scrollPane.setPreferredSize(new Dimension(400, 400));

        mainPanel.add(scrollPane);
        revalidate();
        repaint();
    }
}
