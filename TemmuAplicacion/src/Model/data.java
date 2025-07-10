
package Model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import Controller.Customer;
import Controller.Payment;
import Controller.Product;
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
     * Saves a list of sellers to a text file located at src/images/dataapp.txt.
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
    /**
     * Saves a list of customers to a text file located at src/images/dataapp.txt.
     * Each seller's information is stored in a tab-separated format.
     *
     * @param sellers List of Seller objects to be saved.
     */
    
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
    
    public List<String> readEmailSeller(List<Seller> sellers) {
    	List<String> emails= new ArrayList<>();
    	readtxt1(sellers);
    	for(Seller sl: sellers ) {
    		emails.add(sl.email);
    	}
    	return emails;
    }
    public List<String> readPasswordSeller(List<Seller> sellers){
    	List<String> passwords= new ArrayList<>();
    	readtxt1(sellers);
    	for(Seller sl: sellers) {
    		passwords.add(sl.password);
    	}
    	return passwords;
    }
    public List<String> readEmailCustomer(List<Customer> customers ){
    	List<String> emails= new ArrayList<>();
    	readtxt2(customers);
    	for(Customer cs: customers) {
    		emails.add(cs.email);
    	}
    	return emails;
    }
    
    public List<String> readPasswordCustomer(List<Customer> customers){
    	List<String> passwords= new ArrayList<>();
    	readtxt2(customers);
    	for(Customer cs: customers) {
    		passwords.add(cs.password);
    	}
    	return passwords;
    }
    public void readtxt1(List<Seller>getdataseller) {
    	try {
    		BufferedReader reader = new BufferedReader(new FileReader("src/images/dataapp.txt"));
    		String line="";
    		while((line=reader.readLine())!=null) {
    			String[] block= line.split("\t");
    			if(block.length==8) {
    				String name= block[0];
        			String age= block[1];
        			String numphon= block[2];
        			String country= block[3];
        			String resiadd= block[4];
        			String email= block[5];
        			String password= block[6];
        			String exp= block[7];
        			getdataseller.add(new Seller(name, age, numphon, country, resiadd, email, password, exp));
    			}
    	
    		}
    		reader.close();
    		
    	}catch(IOException e) {
    		System.out.println("Error writing data: " + e.getMessage());
    		
    	}
    }
    
    public void readtxt2(List<Customer>getdatacustomer) {
    	try {
    		BufferedReader reader = new BufferedReader(new FileReader("src/images/dataapp2.txt"));
    		String line="";
    		while((line=reader.readLine())!=null) {
    			String[] block= line.split("\t");
    			if(block.length==7) {
    				String name= block[0];
        			String age= block[1];
        			String numphon= block[2];
        			String country= block[3];
        			String resiadd= block[4];
        			String email= block[5];
        			String password= block[6];
        			getdatacustomer.add(new Customer(name, age, numphon, country, resiadd, email, password));
        		}	
    			}
    		reader.close();
    		
    		
    	}catch(IOException e) {
    		System.out.println("Error writing data: " + e.getMessage());
    		
    	}
    }
    
    public void savedataProduct(List<Product> Products) {
    	try {
            // Open file in append mode
            BufferedWriter writer = new BufferedWriter(new FileWriter("src/images/dataproduct.txt"));

            for (Product pr : Products) {
                writer.write(
                        pr.NamePr + "\t" +
                        pr.ImagePr + "\t" +
                        pr.Price + "\t" +
                        pr.Description + "\t" +
                        pr.Category+ "\t" +
                        pr.Stock+ "\t" 
                  
                );
                writer.newLine();
            }

            writer.close();
        } catch (IOException e) {
            System.out.println("Error writing data: " + e.getMessage());
        }
    }
    
    public void readProductTxt(List<Product> getdataproduct) {
    	try {
    		BufferedReader reader = new BufferedReader(new FileReader("src/images/dataproduct.txt"));
    		String line="";
    		while((line=reader.readLine())!=null) {
    			String[] block= line.split("\t");
    			if(block.length==6) {
    				String NamePr= block[0];
        			String ImagePr= block[1];
        			String Price= block[2];
        			String Description= block[3];
        			String Stock= block[4];
        			String Category= block[5];
        			getdataproduct.add(new Product(NamePr, ImagePr, Price, Description, Stock, Category));	
    			}
    		}
    		reader.close();
    		
    	}catch(IOException e) {
    		System.out.println("Error writing data: " + e.getMessage());
    		
    	}
    	
    }
    
    public static List<Customer> getCustomers(){
    	List<Customer> Customers= new ArrayList<>();
    	try {
    		BufferedReader reader = new BufferedReader(new FileReader("src/images/dataapp2.txt"));
    		String line="";
    		while((line=reader.readLine())!=null) {
    			String[] block= line.split("\t");
    			if(block.length==7) {
    				String name= block[0];
        			String age= block[1];
        			String numphon= block[2];
        			String country= block[3];
        			String resiadd= block[4];
        			String email= block[5];
        			String password= block[6];
        			Customer c= new Customer(name,age,numphon,country,resiadd,email,password);
        			Customers.add(c);
    			}
    		}
    		reader.close();
    		
    	}catch(IOException e) {
    		System.out.println("Error writing data: " + e.getMessage());
    		
    	}
    	return Customers;
    }
    
    public void savedataPayments(List<Payment> Payments) {
        try {
            // Open file in append mode
            BufferedWriter writer = new BufferedWriter(new FileWriter("src/images/Payments.txt", true));

            for (Payment py : Payments) {
                writer.write(
                        py.PaymentID + "\t" +
                        py.Datepy + "\t" +
                        py.CardNumber + "\t" +
                        py.SecurityCode 
                        
                );
                writer.newLine();
            }

            writer.close();
        } catch (IOException e) {
            System.out.println("Error writing data: " + e.getMessage());
        }
    	
    	
    }
   
}



	

