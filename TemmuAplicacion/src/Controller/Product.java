// Author: Jefferson David Rico Ruiz

package Controller;

import Model.data;

/**
 * Represents a Product in the system.
 *
 * This class encapsulates product attributes like name, image, price, description,
 * category, and stock. It provides methods to assign and validate each attribute,
 * and includes logic to publish the product to the system.
 */
public class Product {

    public String NamePr;
    public String ImagePr;
    public Float Price;
    public String Description;
    public Integer Stock;
    public String Category;

    // Instance of the data handler to persist product information
    data d = new data();

    /**
     * Constructor that assigns and validates product attributes.
     *
     * @param NamePr        Product name
     * @param ImagePr       Path or name of the product image
     * @param Price         Product price as a string (converted to float)
     * @param Description   Product description
     * @param Category      Product category
     * @param Stock         Available stock as a string (converted to integer)
     */
    public Product(String NamePr, String ImagePr, String Price, String Description, String Category, String Stock) {
        AssignNamePr(NamePr);
        AssignImagePr(ImagePr);
        AssignPrice(Price);
        AssignDescriptionPr(Description);
        AssignStock(Stock);
        AssignCategory(Category);	
    }

    /**
     * Assigns and validates the product name.
     * The name must have at least 3 characters.
     */
    public void AssignNamePr(String NamePr) {
        try {
            this.NamePr = NamePr;
            if (this.NamePr.length() < 3) {
                this.NamePr = null;
            }
        } catch (Exception e) {
            this.NamePr = null;
        }
    }

    /**
     * Assigns the product image.
     */
    public void AssignImagePr(String ImagePr) {
        try {
            this.ImagePr = ImagePr;
        } catch (Exception e) {
            this.ImagePr = null;
        }
    }

    /**
     * Assigns and validates the product price.
     * Must be between 0 and 300,000.
     */
    public void AssignPrice(String Price) {
        try {
            this.Price = Float.parseFloat(Price);
            if (this.Price < 0 || this.Price > 300000) {
                this.Price = null;
            }
        } catch (Exception e) {
            this.Price = null;
        }
    }

    /**
     * Assigns the product description.
     */
    public void AssignDescriptionPr(String Description) {
        try {
            this.Description = Description;
        } catch (Exception e) {
            this.Description = null;
        }
    }

    /**
     * Assigns and validates the product stock.
     * Must be between 0 and 200.
     */
    public void AssignStock(String Stock) {
        try {
            this.Stock = Integer.parseInt(Stock);
            if (this.Stock < 0 || this.Stock > 200) {
                this.Stock = null;
            }
        } catch (Exception e) {
            this.Stock = null;
        }
    }

    /**
     * Assigns the product category.
     */
    public void AssignCategory(String Category) {
        try {
            this.Category = Category;
        } catch (Exception e) {
            this.Category = null;
        }
    }

    // --- Getters used to check if fields are valid (not null) ---

    public Boolean getNamePr() {
        return this.NamePr != null;
    }

    public Boolean getImagePr() {
        return this.ImagePr != null;
    }

    public Boolean getPrice() {
        return this.Price != null;
    }

    public Boolean getDescriptionPr() {
        return this.Description != null;
    }

    public Boolean getStock() {
        return this.Stock != null;
    }

    public Boolean getCategory() {
        return this.Category != null;
    }

    /**
     * Publishes the product if all fields are valid.
     * Adds the product to the Seller's product list and saves it using the data class.
     * 
     * @return true if the product is successfully published; false otherwise
     */
    public Boolean publishProduct() {
        if (getNamePr() && getImagePr() && getPrice() && getDescriptionPr() && getCategory() && getStock() != null) {
            // Add the product to the list and persist it
            Seller.Products.add(new Product(
                this.NamePr,
                this.ImagePr,
                String.valueOf(this.Price),
                this.Description,
                this.Category,
                String.valueOf(this.Stock)
            ));
            d.savedataProduct(Seller.Products);
            return true;
        } else {
            return false;
        }
    }
}



