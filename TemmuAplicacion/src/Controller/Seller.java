package Controller;

import java.util.ArrayList;
import java.util.List;


public class Seller extends Register {

	public Seller(String name,Integer age, Long numphon, String country, String resiadd, String email,String password,String exp) {
		// TODO Auto-generated constructor stub
		this.name=name;
		this.age=age;
		this.numphon=numphon;
		this.country=country;
		this.resiadd=resiadd;
		this.email=email;
		this.password=password;
		this.exp=exp;
	}

	public void createSeller() {
		List<Seller> sellers = new ArrayList<>();
		sellers.add(new Seller(name,age,numphon,country,resiadd,email,password,exp));
	}

	
	

}
