package Model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Controller.Customer;
import Controller.Product;
import Controller.Seller;

/**
 * The data class handles saving and reading seller, customer, and product information
 * to and from local text files. It supports basic data persistence for the application.
 */
public class data {

    /**
     * Default constructor.
     */
    public data() {
        // Empty constructor
    }

    /**
     * Saves a list of sellers to "src/images/dataapp.txt" using tab-separated values.
     *
     * @param sellers List of Seller objects to be saved
     */
    public void saveDataSeller(List<Seller> sellers) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/images/dataapp.txt", true))) {
            for (Seller sl : sellers) {
                writer.write(sl.name + "\t" +
                             sl.age + "\t" +
                             sl.numphon + "\t" +
                             sl.country + "\t" +
                             sl.resiadd + "\t" +
                             sl.email + "\t" +
                             sl.password + "\t" +
                             sl.exp);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing seller data: " + e.getMessage());
        }
    }

    /**
     * Saves a list of customers to "src/images/dataapp2.txt" using tab-separated values.
     *
     * @param customers List of Customer objects to be saved
     */
    public void saveDataCustomer(List<Customer> customers) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/images/dataapp2.txt", true))) {
            for (Customer cs : customers) {
                writer.write(cs.name + "\t" +
                             cs.age + "\t" +
                             cs.numphon + "\t" +
                             cs.country + "\t" +
                             cs.resiadd + "\t" +
                             cs.email + "\t" +
                             cs.password);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing customer data: " + e.getMessage());
        }
    }

    /**
     * Reads and returns the list of seller emails from file.
     */
    public List<String> readEmailSeller(List<Seller> sellers) {
        List<String> emails = new ArrayList<>();
        readtxt1(sellers);
        for (Seller sl : sellers) {
            emails.add(sl.email);
        }
        return emails;
    }

    /**
     * Reads and returns the list of seller passwords from file.
     */
    public List<String> readPasswordSeller(List<Seller> sellers) {
        List<String> passwords = new ArrayList<>();
        readtxt1(sellers);
        for (Seller sl : sellers) {
            passwords.add(sl.password);
        }
        return passwords;
    }

    /**
     * Reads and returns the list of customer emails from file.
     */
    public List<String> readEmailCustomer(List<Customer> customers) {
        List<String> emails = new ArrayList<>();
        readtxt2(customers);
        for (Customer cs : customers) {
            emails.add(cs.email);
        }
        return emails;
    }

    /**
     * Reads and returns the list of customer passwords from file.
     */
    public List<String> readPasswordCustomer(List<Customer> customers) {
        List<String> passwords = new ArrayList<>();
        readtxt2(customers);
        for (Customer cs : customers) {
            passwords.add(cs.password);
        }
        return passwords;
    }

    /**
     * Loads seller data from "src/images/dataapp.txt" into a given list.
     *
     * @param getdataseller The list to populate with seller data
     */
    public void readtxt1(List<Seller> getdataseller) {
        try (BufferedReader reader = new BufferedReader(new FileReader("src/images/dataapp.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] block = line.split("\t");
                if (block.length == 8) {
                    String name = block[0];
                    String age = block[1];
                    String numphon = block[2];
                    String country = block[3];
                    String resiadd = block[4];
                    String email = block[5];
                    String password = block[6];
                    String exp = block[7];
                    getdataseller.add(new Seller(name, age, numphon, country, resiadd, email, password, exp));
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading seller data: " + e.getMessage());
        }
    }

    /**
     * Loads customer data from "src/images/dataapp2.txt" into a given list.
     *
     * @param getdatacustomer The list to populate with customer data
     */
    public void readtxt2(List<Customer> getdatacustomer) {
        try (BufferedReader reader = new BufferedReader(new FileReader("src/images/dataapp2.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] block = line.split("\t");
                if (block.length == 7) {
                    String name = block[0];
                    String age = block[1];
                    String numphon = block[2];
                    String country = block[3];
                    String resiadd = block[4];
                    String email = block[5];
                    String password = block[6];
                    getdatacustomer.add(new Customer(name, age, numphon, country, resiadd, email, password));
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading customer data: " + e.getMessage());
        }
    }

    /**
     * Saves product data to "src/images/dataproduct.txt".
     * Overwrites the file every time it's called.
     *
     * @param Products List of Product objects to be saved
     */
    public void savedataProduct(List<Product> Products) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/images/dataproduct.txt"))) {
            for (Product pr : Products) {
                writer.write(pr.NamePr + "\t" +
                             pr.ImagePr + "\t" +
                             pr.Price + "\t" +
                             pr.Description + "\t" +
                             pr.Category + "\t" +
                             pr.Stock);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing product data: " + e.getMessage());
        }
    }

    /**
     * Loads product data from "src/images/dataproduct.txt" into a given list.
     *
     * @param getdataproduct The list to populate with product data
     */
    public void readProductTxt(List<Product> getdataproduct) {
        try (BufferedReader reader = new BufferedReader(new FileReader("src/images/dataproduct.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] block = line.split("\t");
                if (block.length == 6) {
                    String NamePr = block[0];
                    String ImagePr = block[1];
                    String Price = block[2];
                    String Description = block[3];
                    String Category = block[4];
                    String Stock = block[5];
                    getdataproduct.add(new Product(NamePr, ImagePr, Price, Description, Category, Stock));
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading product data: " + e.getMessage());
        }
    }

    /**
     * Returns a list of all customers by reading from "src/images/dataapp2.txt".
     *
     * @return List of Customer objects
     */
    public static List<Customer> getCustomers() {
        List<Customer> Customers = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("src/images/dataapp2.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] block = line.split("\t");
                if (block.length == 7) {
                    String name = block[0];
                    String age = block[1];
                    String numphon = block[2];
                    String country = block[3];
                    String resiadd = block[4];
                    String email = block[5];
                    String password = block[6];
                    Customers.add(new Customer(name, age, numphon, country, resiadd, email, password));
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading customer data: " + e.getMessage());
        }
        return Customers;
    }
}



	

