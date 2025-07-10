package View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Controller.Product;
import Controller.Seller;
import Model.data;

import java.awt.*;
import java.awt.event.ActionEvent;

public class MainSellervw extends JFrame {
	data d= new data();
    private CardLayout cardLayout;
    private JPanel productPanelContainer;
    private JPanel mainPanel;



    public MainSellervw() {
        setTitle("My Products");
        setSize(400, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initComponents();
        showProducts();
    }

    private void initComponents() {
        JLabel title = new JLabel("My Products", SwingConstants.CENTER);
        title.setFont(new Font("Tahoma", Font.BOLD, 18));


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
        topPanel.add(Box.createVerticalStrut(10));
        topPanel.add(togglePanel);

         mainPanel = new JPanel(new BorderLayout());
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
    
    public void showProducts() {
    	Seller.Products.clear();
    	d.readProductTxt(Seller.Products);
            JPanel productListPanel = new JPanel();
            productListPanel.setLayout(new BoxLayout(productListPanel, BoxLayout.Y_AXIS));
            productListPanel.setBackground(Color.WHITE);
            if(Seller.Products!=null) {
            	 for (Product pr : Seller.Products) {
                     JPanel productCard = new JPanel(new BorderLayout());
                     productCard.setBorder(BorderFactory.createLineBorder(Color.GRAY));
                     productCard.setMaximumSize(new Dimension(Integer.MAX_VALUE, 130));
                     productCard.setBackground(new Color(245, 245, 245));
                     productCard.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

                     // Cargar y mostrar imagen
                     if (pr.ImagePr != null && !pr.ImagePr.isEmpty()) {
                         try {
                             ImageIcon icon = new ImageIcon(pr.ImagePr);
                             Image img = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                             JLabel imgLabel = new JLabel(new ImageIcon(img));
                             imgLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
                             productCard.add(imgLabel, BorderLayout.WEST);
                         } catch (Exception e) {
                             JLabel imgLabel = new JLabel("Sin imagen");
                             imgLabel.setPreferredSize(new Dimension(100, 100));
                             imgLabel.setHorizontalAlignment(SwingConstants.CENTER);
                             productCard.add(imgLabel, BorderLayout.WEST);
                         }
                     }

                     // Panel con información textual del producto
                     JPanel infoPanel = new JPanel();
                     infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
                     infoPanel.setBackground(new Color(245, 245, 245));
                     infoPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

                     infoPanel.add(new JLabel("Nombre: " + pr.NamePr));
                     infoPanel.add(new JLabel("Precio: $" + pr.Price +" Dollars"));
                     infoPanel.add(new JLabel("Stock: " + pr.Stock));

                     productCard.add(infoPanel, BorderLayout.CENTER);

                     // Añadir espacio y panel
                     productListPanel.add(Box.createVerticalStrut(10));
                     productListPanel.add(productCard);
                 }
            	
            }
            JScrollPane scrollPane = new JScrollPane(productListPanel);
            scrollPane.setBorder(null);
            scrollPane.setPreferredSize(new Dimension(400, 400));
            productPanelContainer.removeAll();
            productPanelContainer.add(scrollPane, "SALE");
            cardLayout.show(productPanelContainer, "SALE");

            revalidate();
            repaint();
    }

	    	
	    	
			
			
		}
		
	


