package View;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import Controller.Product;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;

public class AddProductvw extends JFrame {

    private JTextField nameField, priceField, categoryField, stockField;
    private JTextArea descriptionArea;
    private JButton publishButton;
    private JLabel imageLabel;
    private JButton ImageButton;
    private ImageIcon ImageProduct;
    private  String directionImg;

    public AddProductvw() {
        setTitle("Add Product");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 600);
        setLocationRelativeTo(null);
        initComponents();
    }

    private void initComponents() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));
        panel.setBackground(Color.WHITE);

        // Espacio para imagen del producto
        imageLabel = new JLabel("Product Image", SwingConstants.CENTER);
        imageLabel.setPreferredSize(new Dimension(150, 150));
        imageLabel.setMaximumSize(new Dimension(150, 150));
        imageLabel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        imageLabel.setOpaque(true);
        imageLabel.setBackground(new Color(245, 245, 245));


        JLabel title = new JLabel("Details", SwingConstants.CENTER);
        title.setFont(new Font("Tahoma", Font.BOLD, 20));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Nombre del producto
        JLabel nameLabel = new JLabel("Name of product");
        nameField = new JTextField();

        // Precio
        JLabel priceLabel = new JLabel("Price");
        priceField = new JTextField();

        // Descripción
        JLabel descLabel = new JLabel("Description of product");
        descriptionArea = new JTextArea(5, 20);
        descriptionArea.setLineWrap(true);
        descriptionArea.setWrapStyleWord(true);
        JScrollPane descScroll = new JScrollPane(descriptionArea);

        // Categoría
        JLabel categoryLabel = new JLabel("Category of product");
        categoryField = new JTextField();

        // Stock
        JLabel stockLabel = new JLabel("Assign stock");
        stockField = new JTextField();

        // Botón Publicar
        publishButton = new JButton("Publish product");
        publishButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        publishButton.setBackground(Color.ORANGE);
        publishButton.setForeground(Color.BLACK);
        publishButton.setFocusPainted(false);
        publishButton.setFont(new Font("Tahoma", Font.BOLD, 14));
        publishButton.addActionListener(this:: onAddProduct);
        ImageButton= new JButton("Add Image");
        ImageButton.addActionListener(this:: onAddImage);

        // Agregar al panel
        panel.add(title);
        panel.add(Box.createVerticalStrut(20));
        panel.add(imageLabel);
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(Box.createVerticalStrut(10));
        panel.add(priceLabel);
        panel.add(priceField);
        panel.add(Box.createVerticalStrut(10));
        panel.add(descLabel);
        panel.add(descScroll);
        panel.add(Box.createVerticalStrut(10));
        panel.add(categoryLabel);
        panel.add(categoryField);
        panel.add(Box.createVerticalStrut(10));
        panel.add(stockLabel);
        panel.add(stockField);
        panel.add(Box.createVerticalStrut(20));
        panel.add(publishButton);
        panel.add(ImageButton);
        add(panel);
    }
    
    public String getFieldNamePr() {
    	return nameField.getText();
    }
    
   public String getFieldPrice() {
	   return priceField.getText();
   }
   
   public String getFieldDescription() {
	   return descriptionArea.getText();
   }
   
   public String getFieldCategory() {
	   return categoryField.getText();
   }
   
   public String getFieldStock() {
	   return stockField.getText();
   }
   public String getDirectionImg() {
	   return this.directionImg;
   }
    private void onAddProduct(ActionEvent evt) {
    	Product prod= new Product(getFieldNamePr(),getDirectionImg(),getFieldPrice(),getFieldDescription(),getFieldStock(),getFieldCategory());
    	if(prod.publishProduct()==true) {
    		System.out.println("XD");
    	}else {
    		JOptionPane.showMessageDialog(this, "Error, Enter all the data and make sure it is valid.");
    	}
    }
    
    private void onAddImage(ActionEvent evt) {
    	JFileChooser fileChooser= new JFileChooser();
    	FileNameExtensionFilter filterImage= new FileNameExtensionFilter("ImagesProducts","png");
    	fileChooser.setFileFilter(filterImage);
    	 int selection = fileChooser.showOpenDialog(AddProductvw.this);
    	 if(selection == JFileChooser.APPROVE_OPTION) {
    		 File image= fileChooser.getSelectedFile();
    	    	this.directionImg= image.getAbsolutePath();
    	    	ImageProduct= new ImageIcon(directionImg);
    	    	imageLabel.setIcon(ImageProduct); 
    	 }
    }
    
    
    

    
}
