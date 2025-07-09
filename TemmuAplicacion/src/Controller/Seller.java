
package Controller;

import java.util.ArrayList;
import java.util.List;

public class Seller extends Register {
	public String NamePr;
	public String ImagePr;
	public Float Price; 
	public String SllName;
	public String Descrip;
	public Integer Stock;
	public String Category;
	public Boolean Discount;
	public static List<Product> Products= new ArrayList<Product>();
	public Seller(String name,String age, String numphon, String country, String resiadd, String email,String password,String exp ) {
		// TODO Auto-generated constructor stub
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
	
	
	
	
	
	
}
	

