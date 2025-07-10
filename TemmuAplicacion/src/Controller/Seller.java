
// Author: Jefferson David Rico Ruiz

package Controller;

import java.util.ArrayList;
import java.util.List;

/**
 * The Seller class extends the Register class and represents a user who can sell products.
 * It stores seller profile information and a shared product list among all sellers.
 */
public class Seller extends Register {

    // === Seller-Specific Product Attributes (Unused currently) ===
    public String NamePr;
    public String ImagePr;
    public Float Price;
    public String SllName;
    public String Descrip;
    public Integer Stock;
    public String Category;
    public Boolean Discount;

    // === Static shared list of all products posted by any seller ===
    public static List<Product> Products = new ArrayList<Product>();

    // === Static reference to the currently logged-in seller ===
    public static Seller currentSeller;

    /**
     * Constructs a new Seller object using registration details.
     * Parses numeric fields and assigns values to corresponding attributes.
     *
     * @param name     Seller's name
     * @param age      Seller's age (as string)
     * @param numphon  Seller's phone number (as string)
     * @param country  Seller's country
     * @param resiadd  Seller's residence address
     * @param email    Seller's email
     * @param password Seller's password
     * @param exp      Seller's work experience
     */
    public Seller(String name, String age, String numphon, String country, String resiadd, String email, String password, String exp) {
        super(name, age, numphon, country, resiadd, email, password, exp);

        this.name = name;

        try {
            this.age = Integer.parseInt(age);
        } catch (Exception e) {
            this.age = null;
        }

        try {
            this.numphon = Long.parseLong(numphon);
        } catch (Exception e) {
            this.numphon = null;
        }

        this.country = country;
        this.resiadd = resiadd;
        this.email = email;
        this.password = password;
        this.exp = exp;
    }

    // Additional methods (e.g., for managing products) can be added here in future.
}
	

