package Controller;

import java.util.List;

import Model.data;
import View.Paymentvw;

public class Customer extends Register {
	public static Customer currentCustomer;
	public Customer(String name,String age, String numphon, String country, String resiadd, String email,String password) {
		super(name, age, numphon, country, resiadd, email, password, null);
		this.name=name;
		this.age=Integer.parseInt(age);
		this.numphon=Long.parseLong(numphon);
		this.country=country;
		this.resiadd=resiadd;
		this.email=email;
		this.password=password;
		
		
	}
	
	public static boolean AuntenticCustomer(String email,String password) {
		List<Customer> Customers= data.getCustomers();
		for(Customer c: Customers) {
			if(c.email.equals(email) && c.password.equals(password)) {
				currentCustomer=c;
				return true;
			}
		}
		return false;
	}

}
