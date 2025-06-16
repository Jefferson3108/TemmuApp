package Controller;

public class Profile extends Register {
	
	public Profile(String name,Integer age,Long numphon,String country,String resiadd,String email,String password) {
		this.name=name;
		this.age=age;
		this.numphon=numphon;
		this.country=country;
		this.resiadd=resiadd;
		this.password=password;
		// TODO Auto-generated constructor stub
	}
	public Boolean assignname() {
		if(name==null) {
			while(name==null) {
				System.out.println("Ingrese un nombre valido");
				super.getname();
				}	
		return false;
		}else{
			return true;
		}
		
	}
	public Boolean assignage() {
		if(age==null) {
			while(age==null) {
				System.out.println("Ingrese una edad valida");
				super.getage();
			}
			return false;
		}else {
			return true;
		}
	}
	public Boolean assignnumphon() {
		if(numphon==null) {
			while(numphon==null) {
				System.out.println("Ingrese un numero de telefono valido");
				super.getnumberofphone();
			}
			return false;
		}else {
			return true;
		}
	}
	public Boolean assigncountry() {
		if(country==null) {
			while(country==null) {
				System.out.println("Ingrese una ciudad valida");
				super.getcountry();
			}
			return false;
		}else {
			return true;
		}
	}
	public Boolean assignresaddr() {
		if(resiadd==null) {
			while(resiadd==null) {
				System.out.println("Ingrese una direccion de residencia valida");
			}
			return false;
		}else {
			return true;
		}
	}
	public Boolean assignemail() {
		if(email==null) {
			while(email==null) {
				System.out.println("Ingrese un email valido");
				super.getemail();
			}
			return false;
		}else {
			return true;
		}
	}
	public Boolean assignpassword() {
		if(password==null) {
			while(password==null) {
				System.out.println("Ingrese una contraseña valida");
				super.getpassword();
			}
			return false;
		}else {
			return true;
		}
	}
	public Boolean assignexp() {
		if(exp!=null) {
			return true;
		}else {
			System.out.println("Ingrese una experiencia de trabajo");
			return false;
		}
	}
	public Boolean assignpprf() {
		if(pprf!=null) {
			return true;
		}else {
			System.out.println("Ingrese un perfil profesional ");
			return false;
		}
	}
	public Boolean validateprofile() {
		if(assignname()&&assignage()&&assignnumphon()&&assigncountry()&&assignresaddr()&&assignemail()&&assignpassword()&&assignexp()&&assignpprf()==true) {
			return true;
		}else {
			System.out.println("Error al crear el perfil");
			assignname();
			assignage();
			assignnumphon();
			assigncountry();
			assignresaddr();
			assignemail();
			assignpassword();
			assignexp();
			assignpprf();
			return false; 
		}
		
		
	}
	
  
}
