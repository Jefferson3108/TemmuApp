import java.util.Scanner;
import Model.User;
public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	User user= new User();
	System.out.println("Ingrese su nombre");
     user.assignname();
     System.out.println("Ingrese su edad");
     user.assignage();
     System.out.println("Ingrese un numero");
     user.assignnumber();
     System.out.println("Ingrese la ciudad");
     user.assigncity();
     System.out.println("Ingrese un email ");
     user.assignemail();
     System.out.println("Ingrese su contraseña");
     user.assignpassword();
     
     
}
}
