package Controller;
public class Seller extends Register {

	public Seller(String name,String age, String numphon, String country, String resiadd, String email,String password,String exp) {
		// TODO Auto-generated constructor stub
		super(name, age, numphon, country, resiadd, email, password, exp);
		this.name=name;
		this.age=Integer.parseInt(age);
		this.numphon=Long.parseLong(numphon);
		this.country=country;
		this.resiadd=resiadd;
		this.email=email;
		this.password=password;
		this.exp=exp;
	}


	

	
	

}
