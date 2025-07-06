package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MainSellervw extends JFrame {

    private CardLayout cardLayout;
    private JPanel productPanelContainer;

    public MainSellervw() {
        setTitle("My Products");
        setSize(400, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initComponents();
    }

    private void initComponents() {
        JLabel title = new JLabel("My Products", SwingConstants.CENTER);
        title.setFont(new Font("Tahoma", Font.BOLD, 18));

        JLabel subtitle = new JLabel("Within 5 miles • $$-$$$", SwingConstants.CENTER);
        subtitle.setFont(new Font("Tahoma", Font.PLAIN, 12));

        // Toggle buttons
        JToggleButton saleButton = new JToggleButton("SALE");
        JToggleButton soldButton = new JToggleButton("SOLD");

        ButtonGroup toggleGroup = new ButtonGroup();
        toggleGroup.add(saleButton);
        toggleGroup.add(soldButton);
        saleButton.setSelected(true);

        JPanel togglePanel = new JPanel(new GridLayout(1, 2));
        togglePanel.add(saleButton);
        togglePanel.add(soldButton);

        // Card layout container
        cardLayout = new CardLayout();
        productPanelContainer = new JPanel(cardLayout);

        productPanelContainer.add(buildEmptyMessage("You haven't added any products for sale yet."), "SALE");
        productPanelContainer.add(buildEmptyMessage("No products have been sold yet."), "SOLD");

        // Toggle logic
        saleButton.addActionListener(e -> cardLayout.show(productPanelContainer, "SALE"));
        soldButton.addActionListener(e -> cardLayout.show(productPanelContainer, "SOLD"));

        // Add Product Button
        JButton addProductBtn = new JButton("ADD PRODUCT");
        addProductBtn.setBackground(new Color(255, 153, 0));
        addProductBtn.setForeground(Color.BLACK);
        addProductBtn.addActionListener(this::onAddProduct);

        // Layout
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
        topPanel.add(title);
        topPanel.add(subtitle);
        topPanel.add(Box.createVerticalStrut(10));
        topPanel.add(togglePanel);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(productPanelContainer, BorderLayout.CENTER);
        mainPanel.add(addProductBtn, BorderLayout.SOUTH);

        add(mainPanel);
    }

    private JPanel buildEmptyMessage(String message) {
        JPanel panel = new JPanel(new BorderLayout());
        JLabel label = new JLabel(message, SwingConstants.CENTER);
        label.setFont(new Font("Tahoma", Font.ITALIC, 14));
        label.setForeground(Color.GRAY);
        panel.add(label, BorderLayout.CENTER);
        return panel;
    }

    private void onAddProduct(ActionEvent e) {
        JOptionPane.showMessageDialog(this, "Here would go the 'Add Product' form.");
        SwingUtilities.invokeLater(() -> new AddProductvw().setVisible(true));
        dispose();
    }

}
