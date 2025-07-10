// Author: Jefferson David Rico Ruiz

package Controller;

import java.util.List;
import Model.data;
import View.Paymentvw;

/**
 * Represents a Customer user in the application.
 * 
 * This class extends the Register class and is responsible for managing
 * customer-specific data and authentication.
 * It also provides a static reference to the currently logged-in customer.
 */
public class Customer extends Register {

    // Holds the currently authenticated customer instance
    public static Customer currentCustomer;

    /**
     * Constructor for the Customer class.
     *
     * @param name      The customer's full name
     * @param age       The customer's age as a String (converted to int)
     * @param numphon   The customer's phone number as a String (converted to long)
     * @param country   The customer's country
     * @param resiadd   The customer's residential address
     * @param email     The customer's email
     * @param password  The customer's password
     */
    public Customer(String name, String age, String numphon, String country, String resiadd, String email, String password) {
        // Call the superclass constructor from Register
        super(name, age, numphon, country, resiadd, email, password, null);
        
        // Initialize instance fields after converting data types
        this.name = name;
        this.age = Integer.parseInt(age);
        this.numphon = Long.parseLong(numphon);
        this.country = country;
        this.resiadd = resiadd;
        this.email = email;
        this.password = password;
    }

    /**
     * Authenticates a customer based on email and password.
     * 
     * Iterates through the list of customers loaded from the data model
     * and checks for a match with the provided credentials.
     * If a match is found, the matching customer is set as the currentCustomer.
     *
     * @param email     The email to validate
     * @param password  The password to validate
     * @return true if authentication is successful; false otherwise
     */
    public static boolean AunthenticateCustomer(String email, String password) {
        List<Customer> Customers = data.getCustomers();  // Retrieve all registered customers
        
        for (Customer c : Customers) {
            if (c.email.equals(email) && c.password.equals(password)) {
                currentCustomer = c;  // Set the authenticated customer as current
                return true;
            }
        }
        
        return false;  // No match found
    }
}
