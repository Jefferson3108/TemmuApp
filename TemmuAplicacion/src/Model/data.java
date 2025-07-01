
package Model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import Controller.Customer;
import Controller.Seller;

/**
 * The Data class handles saving seller data to a file.
 * It extends the Register class (although inheritance here may not be necessary).
 */
public class data  {

    /**
     * Default constructor.
     */
    public data() {
    	
        // Empty constructor
    	    }
    /**
     * Saves a list of sellers to a text file located at /images/dataapp.txt.
     * Each seller's information is stored in a tab-separated format.
     *
     * @param sellers List of Seller objects to be saved.
     */
    public void saveDataSeller(List<Seller> sellers) {
        try {
            // Open file in append mode
            BufferedWriter writer = new BufferedWriter(new FileWriter("src/images/dataapp.txt", true));

            for (Seller sl : sellers) {
                writer.write(
                        sl.name + "\t" +
                        sl.age + "\t" +
                        sl.numphon + "\t" +
                        sl.country + "\t" +
                        sl.resiadd + "\t" +
                        sl.email + "\t" +
                        sl.password + "\t" +
                        sl.exp
                );
                writer.newLine();
            }

            writer.close();
        } catch (IOException e) {
            System.out.println("Error writing data: " + e.getMessage());
        }
    }
    
    public void saveDataCustomer(List<Customer> customers) {
        try {
            // Open file in append mode
            BufferedWriter writer = new BufferedWriter(new FileWriter("src/images/dataapp2.txt", true));

            for (Customer cs : customers) {
                writer.write(
                        cs.name + "\t" +
                        cs.age + "\t" +
                        cs.numphon + "\t" +
                        cs.country + "\t" +
                        cs.resiadd + "\t" +
                        cs.email + "\t" +
                        cs.password + "\t" 
                  
                );
                writer.newLine();
            }

            writer.close();
        } catch (IOException e) {
            System.out.println("Error writing data: " + e.getMessage());
        }
    }
}

	

