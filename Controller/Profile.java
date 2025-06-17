package Controller;

public class Profile extends Register {

	/**
	 * 
	 * @param name:     Will store the username
	 * @param age:      Will store the age of user
	 * @param numphon:  Will store the number of user
	 * @param country:  Will store the country of user
	 * @param resiadd:  Will store the residence adress of user
	 * @param email:    Will store the email of user
	 * @param password: Will store the password of user
	 * @param exp:      Will store the Experience of user
	 * @param pprf:     Will store the Professional profile of user
	 */

	public Profile(String name, Integer age, Long numphon, String country, String resiadd, String email,
			String password,String exp,String pprf) {
		this.name = name;
		this.age = age;
		this.numphon = numphon;
		this.country = country;
		this.resiadd = resiadd;
		this.email=email;
		this.password = password;
		this.exp=exp;
		this.pprf=pprf;
		// TODO Auto-generated constructor stub
	}
	public Profile(String name, Integer age, Long numphon, String country, String resiadd, String email,
			String password) {
		this.name = name;
		this.age = age;
		this.numphon = numphon;
		this.country = country;
		this.resiadd = resiadd;
		this.email=email;
		this.password = password;
	}

	/**
	 * @method:The method takes the entered name and checks if the data was deleted.
	 *             If it was, the user is notified and prompted to enter it
	 *             correctly.
	 * 
	 * @return true if the data meets the requirements for assignment
	 * @return false if the data does not meet the requirements for assignment
	 */
	public Boolean assignname() {
		if (name == null) {
			while (name == null) {
				System.out.println("Ingrese un nombre valido");
				super.getname();
			}
			return true;
		} else {
			return true;
		}

		/**
		 * @method:The method takes the entered age and checks if the data was deleted.
		 *             If it was, the user is notified and prompted to enter it
		 *             correctly.
		 * 
		 * @return true if the data meets the requirements for assignment
		 * @return false if the data does not meet the requirements for assignment
		 */

	}

	public Boolean assignage() {
		if (age == null) {
			while (age == null) {
				System.out.println("Ingrese una edad valida");
				super.getage();
			}
			return true;
		} else {
			return true;
		}
	}

	/**
	 * @method:The method takes the entered number of phone and checks if the data
	 *             was deleted. If it was, the user is notified and prompted to
	 *             enter it correctly.
	 * 
	 * @return true if the data meets the requirements for assignment
	 * @return false if the data does not meet the requirements for assignment
	 */

	public Boolean assignnumphon() {
		if (numphon == null) {
			while (numphon == null) {
				System.out.println("Ingrese un numero de telefono valido");
				super.getnumberofphone();
			}
			return true;
		} else {
			return true;
		}
	}

	/**
	 * @method:The method takes the entered country and checks if the data was
	 *             deleted. If it was, the user is notified and prompted to enter it
	 *             correctly.
	 * 
	 * @return true if the data meets the requirements for assignment
	 * @return false if the data does not meet the requirements for assignment
	 */

	public Boolean assigncountry() {
		if (country == null) {
			while (country == null) {
				System.out.println("Ingrese una ciudad valida");
				super.getcountry();
			}
			return true;
		} else {
			return true;
		}
	}

	/**
	 * @method:The method takes the entered residence address and checks if the data
	 *             was deleted. If it was, the user is notified and prompted to
	 *             enter it correctly.
	 * 
	 * @return true if the data meets the requirements for assignment
	 * @return false if the data does not meet the requirements for assignment
	 */

	public Boolean assignresaddr() {
		if (resiadd == null) {
			while (resiadd == null) {
				System.out.println("Ingrese una direccion de residencia valida");
			}
			return true;
		} else {
			return true;
		}
	}

	/**
	 * @method:The method takes the entered email and checks if the data was
	 *             deleted. If it was, the user is notified and prompted to enter it
	 *             correctly.
	 * 
	 * @return true if the data meets the requirements for assignment
	 * @return false if the data does not meet the requirements for assignment
	 */

	public Boolean assignemail() {
		if (email == null) {
			while (email == null) {
				System.out.println("Ingrese un email valido");
				super.getemail();
			}
			return true;
		} else {
			return true;
		}
	}

	public Boolean assignpassword() {
		if (password == null) {
			while (password == null) {
				System.out.println("Ingrese una contraseña valida");
				super.getpassword();
			}
			return true;
		} else {
			return true;
		}
	}

	public Boolean assignexp() {
		if (exp == null) {
			while(exp== null) {
				System.out.println("Ingrese una experiencia de trabajo");
				super.getexp();
			}
			return true;
		} else {
			return true;
		}
	}

	public Boolean assignpprf() {
		if (pprf == null) {
			while(pprf==null) {
				System.out.println("Ingrese un perfil profesional");
				super.getpprf();
			}
			return true;
		} else {
			return true;
		}
	}

	public Boolean validateprofile() {
		if (assignname() && assignage() && assignnumphon() && assigncountry() && assignresaddr() && assignemail()
				&& assignpassword()  == true) {
			System.out.println("Datos recibidos con exito");
			return true;
		} else if(assignname() && assignage() && assignnumphon() && assigncountry() && assignresaddr() && assignemail()
				&& assignpassword()&& assignexp()&& assignpprf()==true) {
			System.out.println("Datos recibidos con exito");
			return true;
			
		}else {
			System.out.println("Error al recibir los datos");
			return false;
			
		}

	}

}
