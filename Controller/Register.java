package Controller;
/**
 * This class receives the data entered
 *  by the user and validates some conditions 
 *  to keep the data or delete it.
 */
public class Register {
	/**
	 * @param namep:Will store the username
	 * @param agep:Will store the age of user
	 */
	String name;
	Integer age;
	Long numphon;
	String country;
	String resiadd;
	String email;
	String password;
	String exp;
	String pprf;
	/**
	 * 
	 * @param name:Contain the name of user
	 * @param age:Contain the age of user
	 */

	public Register(String name,Integer age,Long numphon,String country,String resiadd,String email,String password,String exp,String pprf) {
		// TODO Auto-generated constructor stub
		this.name=name;
		this.age=age;
		this.numphon=numphon;
		this.country=country;
		this.resiadd=resiadd;
		this.email=email;
		this.password=password;
		this.exp=exp;
		this.pprf=pprf;
	}
	/**
	 * 
	 * @param namep:Will store the username
	 * 
	 * "method:This method receives the name 
	 * and if the length of this is less than 
	 * 3 it deletes this information
	 */
	public void getname(String name) {
		if(name.length()<3) {
			name=null;
		}else {
			System.out.println("EL nombre es:"+name);
		}
	/**
	 * @param agep:Will store the age of user
	 * 
	 * @method:This method receives the user's age 
	 * and if it is less than 18 or negative, 
	 * deletes the information.
	 */
	}
	public void getage(Integer age) {
		if(age<0||age<18) {
			age=null;
		}else {
			System.out.println("La edad es:"+age);
		}
		
	}
	/**
	 * @param numphon:Will store the number of phone of user
	 * 
	 * @method:This method receives the phone number 
	 * and checks if it has the length of a phone number.
	 */
	public void getnumberofphone(Long numphon) {
		String numStr=Long.toString(numphon);
		if(numStr.length()!=10) {
			numphon=null;
		}else {
			System.out.println("El numero de telefono es:"+numphon);
		}	
	}
	public void getcountry(String country) {
		if(country.length()<4) {
			country=null;
		}else {
			System.out.println("El pais es:"+country);
		}
		
		
	}
	public void getresaddr(String resiadd) {
		System.out.println("La direccion es:"+resiadd);
	}
	public void getemail(String email) {
		if(email.contains("@gmail.com")||email.contains("@hotmail.com")) {
			System.out.println("El email es:"+email);
		}else {
			email=null;
		}
	}
	private void getpassword(String password) {
		if(password.length()<6) {
			password=null;
		}
	}
	public void getexp(String exp) {
		System.out.println("La experiencia de trabajo es:"+exp);
	}
	public void getpprf(String pprf) {
		System.out.println("La experiencia de trabajo es:"+exp);
	}
	
	
}

	
