package Controller;
import java.util.Scanner;

import View.RgCustomervw;

/**
 * This class receives the data entered by the user and validates some
 * conditions to keep the data or delete it.
 */
public class Register {
	/**
	 * @param name:     Will store the username
	 * @param age:      Will store the age of user
	 * @param numphon:  Will store the number of user
	 * @param country:  Will store the country of user
	 * @param resiadd:  Will store the residence adress of user
	 * @param email:    Will store the email of user
	 * @param password: Will store the password of user
	 * @param exp:      Will store the Experience of user
	 * @param pprf:     Will store the Professional profile of user
	 * @param inputs:   Will recieve the data for console
	 */
	public String name;
	public Integer age;
	public Long numphon;
	public String country;
	public String resiadd;
	public String email;
	public String password;
	public String exp;
	Integer num=0;
	Scanner inputs = new Scanner(System.in);

	public Register() {
		// TODO Auto-generated constructor stub
		
	}

	/**
	 * 
	 * @method:This method asks the user for the name, receives it and validates
	 *              that it has a length greater than 3, otherwise it deletes it.
	 * @return:the name of user
	 */
	public String getname() {
		RgCustomervw rg= new RgCustomervw();
		name=rg.getfieldn();
		if (name.length() < 3) {
			name = null;
		}
		return name;
	}

	/**
	 * @method:This method asks the user's age and if it is negative or less than
	 *              18, it deletes the data.
	 * @return: the age of user
	 */
	public Integer getage() {
		RgCustomervw rg= new RgCustomervw();
		try {
			age=Integer.parseInt(rg.getfieldag());
		}catch(Exception e) {
			System.out.println("Error");
		}
		if (age < 0 || age < 18) {
			age = null;
		}
		return age;
	}

	/**
	 * 
	 * @method:This method asks for the user's phone number and if it has less than
	 *              10 digits, it deletes the data and return the value.
	 *              
	 * @return: the number of phone of user
	 */
	public Long getnumberofphone() {
		RgCustomervw rg= new RgCustomervw();
		try {
			numphon=Long.parseLong(rg.getfieldag());
		}catch(Exception e) {
			System.out.println("Error");
		}
		String numStr = Long.toString(numphon);
		if (numStr.length() != 10) {
			numphon = null;
		}
		return numphon;
	}

	/**
	 * @method:This method asks the user's country
	 * 
	 * @return: the country of user
	 */
	public String getcountry() {
		if (country.length() < 4) {
			country = null;
		}
		return country;
	}

	/**
	 * @method:This method asks for the user's residential address and return the
	 *              value of the function.
	 *              
	 * @return: the residence adrees of user
	 */
	public String getresaddr() {
		RgCustomervw rg= new RgCustomervw();
		resiadd=rg.getfieldaddr();
		return resiadd;
	}

	/**
	 * @method:This method asks the user for the email and if it does not contain
	 *              the extensions of an email it will delete it and return the
	 *              value of email.
	 *              
	 * @return: the email of user
	 */

	public String getemail() {
		RgCustomervw rg= new RgCustomervw();
		email=rg.getfieldem();
		if (email.contains("@gmail.com") || email.contains("@hotmail.com")) {
		} else {
			email = null;
		}
		return email;
	}

	/**
	 *@method: This method asks the user for the password and, once verified, if it does not
	 *              have a minimum length of 6 characters, it deletes it.
	 * 
	 * @return: the password of user
	 */

	public String getpassword() {
		RgCustomervw rg= new RgCustomervw();
		password=rg.getfieldpass();
		if (password.length() < 6) {
			password = null;
		}
		return password;
	}

	/**
	 * @method:This method asks about work experience
	 * @return: the work experience of user
	 * 
	 */
	public String getexp() {
		return exp;
	}
	public void createprof() {
		Profile prof=new Profile(getname(),getage(),getnumberofphone(),getcountry(),getresaddr(),getemail(),getpassword(),null);
	}
	

	/**
	 * @method:This method asks the professional profile
	 * @return: the professFional profile of user
	 */
}
