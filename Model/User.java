package Model;
import java.util.Scanner;
public class User {
	String name;
	Integer age;
	String number;
	String city;
	String Email;
	String Password;

	public User() {
		// TODO Auto-generated constructor stub
	}
	public void assignname() {
		
		Scanner input= new Scanner(System.in);
		name=input.nextLine();
		System.out.println("Su nombre es: "+name);
		}
		public void assignage() {
			Scanner input= new Scanner(System.in);
			age=input.nextInt();
			System.out.println("Su edad es: "+age);
				
		}
		public void assignnumber() {
			Scanner input= new Scanner(System.in);
			number=input.nextLine();
			System.out.println("Su numero es: "+number);
			
		}
		public void assigncity() {
			Scanner input= new Scanner(System.in);
			city=input.nextLine();
			System.out.println("La ciudad es: "+city);	
		}
		public void assignemail() {
			Scanner input= new Scanner(System.in);
			Email=input.nextLine();
			System.out.println("El Email es: "+Email);	
		} 
		public void assignpassword() {
			Scanner input= new Scanner(System.in);
			Password=input.nextLine();	
		}
		
		public Boolean createacount(Boolean f) {
		
		return true;	
		}
		public Boolean validateemail(Boolean f) {
		return true;	
		}
		private Boolean validatePassword(Boolean f) {
		return true;	
		}
		public Boolean validatelogin(Boolean f) {
		return true;	
		}

}
