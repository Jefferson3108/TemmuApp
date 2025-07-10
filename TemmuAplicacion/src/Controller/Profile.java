// Author: Jefferson David Rico Ruiz

package Controller;

import java.util.ArrayList;
import java.util.List;
import Model.data;

/**
 * The Profile class extends Register and is responsible for validating user profile data.
 * It determines whether the data belongs to a Seller or a Customer and saves it accordingly.
 * It also provides login validation functionality for both types of users.
 */
public class Profile extends Register {

    // Static lists to hold registered sellers and customers
    private static List<Seller> Sellers = new ArrayList<Seller>();
    private static List<Customer> Customers = new ArrayList<Customer>();

    // Used to persist and retrieve user data
    data d = new data();

    // Temporarily stores credentials during login
    static String validateEmail;
    static String validatePassword;

    /**
     * Constructor for creating a new profile (typically for registration).
     * Parses and assigns all profile fields.
     *
     * @param name      User's name
     * @param age       Age as string (converted to Integer)
     * @param numphon   Phone number as string (converted to Long)
     * @param country   User's country
     * @param resiadd   Residential address
     * @param email     Email
     * @param password  Password
     * @param exp       Work experience (if applicable)
     */
    public Profile(String name, String age, String numphon, String country, String resiadd, String email, String password, String exp) {
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

    /**
     * Constructor used specifically for login validation.
     *
     * @param email     Email input from login form
     * @param password  Password input from login form (as char array)
     */
    public Profile(String email, char[] password) {
        super(null, null, null, null, null, email, String.valueOf(password), null);
        Profile.validateEmail = email;
        Profile.validatePassword = String.valueOf(password);
    }

    // ---- Individual Field Validation Methods ----

    public Boolean ValidateAssignname() {
        return name != null;
    }

    public Boolean ValidateAssignage() {
        return age != null;
    }

    public Boolean ValidateAssignnumphon() {
        return numphon != null;
    }

    public Boolean ValidateAssigncountry() {
        return country != null;
    }

    public Boolean ValidateAssignresaddr() {
        return resiadd != null;
    }

    public Boolean ValidateAssignemail() {
        return email != null;
    }

    public Boolean ValidateAssignpassword() {
        return password != null;
    }

    public Boolean ValidateAssignexp() {
        return exp != null;
    }

    // ---- Getters for user lists ----

    public static List<Seller> getlistsll() {
        return Sellers;
    }

    public static List<Customer> getlistcs() {
        return Customers;
    }

    /**
     * Validates the full profile and saves it either as a Seller or Customer.
     * A seller must have work experience assigned.
     *
     * @return true if the profile is valid and saved; false otherwise
     */
    public Boolean validateprofile() {
        if (ValidateAssignname() && ValidateAssignage() && ValidateAssignnumphon()
                && ValidateAssigncountry() && ValidateAssignresaddr() && ValidateAssignemail()
                && ValidateAssignpassword() && ValidateAssignexp()) {

            Sellers.add(new Seller(name, String.valueOf(age), String.valueOf(numphon), country, resiadd, email, password, exp));
            d.saveDataSeller(Sellers);
            return true;

        } else if (ValidateAssignname() && ValidateAssignage() && ValidateAssignnumphon()
                && ValidateAssigncountry() && ValidateAssignresaddr() && ValidateAssignemail()
                && ValidateAssignpassword()) {

            Customers.add(new Customer(name, String.valueOf(age), String.valueOf(numphon), country, resiadd, email, password));
            d.saveDataCustomer(Customers);
            return true;

        } else {
            return false;
        }
    }

    // ---- Temporary Getters used during login ----

    public String setemail() {
        return Profile.validateEmail;
    }

    public String setpassword() {
        return Profile.validatePassword;
    }

    // ---- Seller Login Validation ----

    public Boolean ValidateEmailSeller() {
        List<String> emails = d.readEmailSeller(Sellers);
        for (String email : emails) {
            if (email.equals(setemail())) {
                return true;
            }
        }
        return false;
    }

    public Boolean ValidatePasswordSeller() {
        List<String> passwords = d.readPasswordSeller(Sellers);
        for (String password : passwords) {
            if (password.equals(setpassword())) {
                return true;
            }
        }
        return false;
    }

    // ---- Customer Login Validation ----

    public Boolean ValidateEmailCustomer() {
        List<String> emails = d.readEmailCustomer(Customers);
        for (String email : emails) {
            if (email.equals(setemail())) {
                return true;
            }
        }
        return false;
    }

    public Boolean ValidatePasswordCustomer() {
        List<String> passwords = d.readPasswordCustomer(Customers);
        for (String password : passwords) {
            if (password.equals(setpassword())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks whether the entered credentials match either a seller or customer.
     *
     * @return true if valid login credentials are found; false otherwise
     */
    public Boolean ValidateLogin() {
        if (ValidateEmailSeller() && ValidatePasswordSeller()) {
            return true;
        } else if (ValidateEmailCustomer() && ValidatePasswordCustomer()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Attempts to authenticate the current customer using stored email and password.
     *
     * @return true if the customer is successfully authenticated
     */
    public static Boolean savecurrentcustomer() {
        Boolean success = Customer.AunthenticateCustomer(validateEmail, validatePassword);
        return success;
    }
}
   
   

   
    
    






