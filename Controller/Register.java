package Controller;

import java.util.Scanner;

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
	String name;
	Integer age;
	Long numphon;
	String country;
	String resiadd;
	String email;
	String password;
	String exp;
	String pprf;
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
		System.out.println("Enter your name");
		name = inputs.nextLine();
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
		System.out.println("Enter your age");
		age = inputs.nextInt();
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
		System.out.println("Enter your number of phone");
		numphon = inputs.nextLong();
		inputs.nextLine();
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
		System.out.println("Enter your country");
		country = inputs.nextLine();
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
		System.out.println("Enter your residence adress");
		resiadd = inputs.nextLine();
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
		System.out.println("Enter your email");
		email = inputs.nextLine();
		if (email.contains("@gmail.com") || email.contains("@hotmail.com")) {
			return email;
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
		System.out.println("Enter your password");
		password = inputs.nextLine();
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
		System.out.println("Enter your Work Experience");
		exp = inputs.nextLine();
		return exp;
	}

	/**
	 * @method:This method asks the professional profile
	 * @return: the professFional profile of user
	 */
	public String getpprf() {
		System.out.println("Enter your Professional Profile");
		pprf = inputs.nextLine();
		return pprf;
	}
	public Integer SelectRol() {
		
		System.out.println("Eliga 1 si quiere registrarse como comprador\n");
		System.out.println("Eliga 2 si quiere registrarse como vendedor");
		num=inputs.nextInt();
		if(num==1) {
			System.out.println("Registro como comprador");
			inputs.nextLine();
			return num;
		}else if(num==2) {
			System.out.println("Registro como vendedor");
			inputs.nextLine();
		return num;
		}else {
			while(num!=1||num!=2) {
				System.out.println("Eliga el numero 1 o 2 solamente");
				num=inputs.nextInt();
			}
			return num;
		}
		
		
		
	}
}
