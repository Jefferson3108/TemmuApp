package View;

import javax.swing.*;

import Controller.Product;
import Controller.Seller;
import Model.data;

import java.awt.*;
import java.io.File;

public class MainCustomervw extends JFrame {
    private JPanel gridPanel;
    private JPanel mainPanel;
    data d= new data();
    public MainCustomervw() {
        setTitle("Temmu Catalog");
        setSize(400, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initComponents();
        showProducts();
       
    }

    private void initComponents() {
         mainPanel = new JPanel(new BorderLayout());

        // Header de filtros
        JPanel filterPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        String[] filters = {"All", "Exclusive offer", "Women", "Man", "Home"};
        for (String filter : filters) {
            JButton btn = new JButton(filter);
            filterPanel.add(btn);
        }
        
        

        mainPanel.add(filterPanel, BorderLayout.NORTH);

        // Grid de productos
        gridPanel = new JPanel(new GridLayout(0, 3, 10, 10)); // 3 columnas
        gridPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        gridPanel.setBackground(Color.WHITE);
        
       

        // Scroll para grid
        JScrollPane scrollPane = new JScrollPane(gridPanel);
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        add(mainPanel);
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
                     infoPanel.add(new JLabel("Precio: $" + pr.Price + " Dollars"));
                     infoPanel.add(new JLabel("Stock: " + pr.Stock));

                     productCard.add(infoPanel, BorderLayout.CENTER);

                     // Panel clickeable
                     productCard.addMouseListener(new java.awt.event.MouseAdapter() {
                         @Override
                         public void mouseClicked(java.awt.event.MouseEvent evt) {
                        	 SwingUtilities.invokeLater(() -> new ProductSelectedvw(pr.NamePr,String.valueOf(pr.Price),pr.Description,pr.ImagePr).setVisible(true));
                        	 dispose();
                         }
                     });

                     // Añadir espacio y panel
                     productListPanel.add(Box.createVerticalStrut(10));
                     productListPanel.add(productCard);
                 }
            	
            }
            JScrollPane scrollPane = new JScrollPane(productListPanel);
            scrollPane.setBorder(null);
            scrollPane.setPreferredSize(new Dimension(400, 400));
            mainPanel.add(scrollPane);
            
            revalidate();
            repaint();
    }

    
}
