package Controller;

public class Customer extends Register {
	
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

}
