
package Controller;

import java.util.ArrayList;
import java.util.List;
import Model.data;

/**
 * The Profile class extends Register and serves to validate the user's profile information.
 * It checks if each attribute has valid data and determines if the profile is acceptable.
 */
public class Profile extends Register {
	private static  List<Seller> Sellers= new ArrayList<Seller>();
	private static   List<Customer> Customers= new ArrayList<Customer>();
	data d= new data();
	static String validateEmail;
	static String validatePassword;
    /**
     * Constructor for the Profile class.
     * Initializes the attributes by parsing and assigning the data received from the form.
     *
     * @param name     Will store the username
     * @param age      Will store the age of the user (as String to be parsed)
     * @param numphon  Will store the phone number of the user (as String to be parsed)
     * @param country  Will store the country of the user
     * @param resiadd  Will store the residence address of the user
     * @param email    Will store the email of the user
     * @param password Will store the password of the user
     * @param exp      Will store the work experience of the user
     * 
     */
    public Profile(String name, String age, String numphon, String country, String resiadd, String email, String password, String exp) {
        super(name, age, numphon, country, resiadd, email, password, exp);
        this.name = name;
        try {
        	this.age = Integer.parseInt(age);
        }catch(Exception e) {
        	this.age=null;
        }
        
        try {
        	this.numphon = Long.parseLong(numphon);
        }catch(Exception e) {
        	this.numphon=null;
        }
        this.country = country;
        this.resiadd = resiadd;
        this.email = email;
        this.password = password;
        this.exp = exp;
    }
    public Profile(String email, char[] password) {
    	super(null, null, null, null, null, email, String.valueOf(password), null);
    	Profile.validateEmail=email;
    	Profile.validatePassword=String.valueOf(password);
    }

    /**
     * Validates if the name is assigned correctly.
     * 
     * @return true if the name is valid, false otherwise
     */
    public Boolean ValidateAssignname() {
        if (name == null) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Validates if the age is assigned correctly.
     * 
     * @return true if the age is valid, false otherwise
     */
    public Boolean ValidateAssignage() {
        if (age == null) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Validates if the phone number is assigned correctly.
     * 
     * @return true if the phone number is valid, false otherwise
     */
    public Boolean ValidateAssignnumphon() {
        if (numphon == null) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Validates if the country is assigned correctly.
     * 
     * @return true if the country is valid, false otherwise
     */
    public Boolean ValidateAssigncountry() {
        if (country == null) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Validates if the residence address is assigned correctly.
     * 
     * @return true if the residence address is valid, false otherwise
     */
    public Boolean ValidateAssignresaddr() {
        if (resiadd == null) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Validates if the email is assigned correctly.
     * 
     * @return true if the email is valid, false otherwise
     */
    public Boolean ValidateAssignemail() {
        if (email == null) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Validates if the password is assigned correctly.
     * 
     * @return true if the password is valid, false otherwise
     */
    public Boolean ValidateAssignpassword() {
        if (password == null) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Validates if the work experience is assigned correctly.
     * 
     * @return true if the experience is valid, false otherwise
     */
    public Boolean ValidateAssignexp() {
        if (exp == null) {
            return false;
        } else {
            return true;
        }
    }
    public static List<Seller> getlistsll(){
    	return Sellers;
    }
    
    public static List<Customer> getlistcs(){
    	return Customers;
    }
    

    /**
     * Validates the entire profile by checking if all required fields are valid.
     * 
     * @return true if the profile passes validation, false otherwise
     */
    
    public Boolean validateprofile() {
        if (ValidateAssignname() && ValidateAssignage() && ValidateAssignnumphon() && ValidateAssigncountry() && ValidateAssignresaddr() && ValidateAssignemail()
                && ValidateAssignpassword()&& ValidateAssignexp() == true) {
        	Sellers.add(new Seller(this.name, String.valueOf(this.age), String.valueOf(this.numphon), this.country, this.resiadd, this.email, this.password, this.exp));
        	d.saveDataSeller(Sellers);
            return true;
        } else if (ValidateAssignname() && ValidateAssignage() && ValidateAssignnumphon() && ValidateAssigncountry() && ValidateAssignresaddr() && ValidateAssignemail()
                && ValidateAssignpassword()  == true) {
        	Customers.add(new Customer(this.name, String.valueOf(this.age), String.valueOf(this.numphon), this.country, this.resiadd, this.email, this.password));
        	d.saveDataCustomer(Customers);
            return true;
        } else {
            return false;
        }
    }
    public String setemail() {
    	return Profile.validateEmail;
    }
    public String setpassword(){
    	return Profile.validatePassword;
    }
    
    public Boolean ValidateEmailSeller() {
    	List<String> emails= d.readEmailSeller(Sellers);
    	for(String email: emails ) {
    		if(email.equals(setemail())){
    			return true;
    		}
    	}
    	return false;
    }
    public Boolean ValidatePasswordSeller() {
    	List<String> passwords= d.readPasswordSeller(Sellers);
    	
    	for(String password: passwords) {
    		if(password.equals(setpassword())) {
    			return true;
    			
    		}
    	}
    	return false;
    }
    public Boolean ValidateEmailCustomer() {
    	List<String> emails= d.readEmailCustomer(Customers);
    	for(String email: emails) {
    		if(email.equals(setemail())) {
    			return true;
    		}
    	}
    	return false;
    }
    public Boolean ValidatePasswordCustomer() {
    	List<String> passwords= d.readPasswordCustomer(Customers);
    	for(String password: passwords) {
    		if(password.equals(setpassword())) {
    			return true;
    		}
    	}
    	return false;
    }
    
    public Boolean ValidateLogin() {
    	if(ValidateEmailSeller() && ValidatePasswordSeller()==true) {
    		
    		return true;
    	}else if(ValidateEmailCustomer()&& ValidatePasswordCustomer()==true) {
    		return true;
    	}else {
    		return false;
    	}
    }
    
    public static Boolean savecurrentcustomer() { 
    	Boolean sucess= Customer.AuntenticCustomer(validateEmail, validatePassword);
    	return sucess;
    }
   
   

   
    
    

}




