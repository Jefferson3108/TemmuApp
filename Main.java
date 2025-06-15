import java.util.Scanner;
import Controller.Register;
public class Main {

	public static void main(String[] args) {
		String input1="";
		Integer input2=0;
		Long input3;
		String input4="";
		String input5="";
		String input6="";
		String input7="";
		String input8="";
		String input9="";
		Scanner inputs=new Scanner(System.in);
		System.out.println("======Welcome to register=====\n\n");
		System.out.println("Enter your name");
		input1=inputs.nextLine();
		System.out.println("Entre your age");
		input2=inputs.nextInt();
		System.out.println("Enter your Number of phone");
		input3=inputs.nextLong();
		inputs.nextLine();
		System.out.println("Enter your country");
		input4=inputs.nextLine();
		System.out.println("Enter your residence adress");
		input5=inputs.nextLine();
		System.out.println("Enter your Email");
		input6=inputs.nextLine();
		System.out.println("Enter your Password");
		input7=inputs.nextLine();
		System.out.println("Enter your Work Experience");
		input8=inputs.nextLine();
		System.out.println("Enter your Profil Professional");
		input9=inputs.nextLine();
		Register rgst=new Register(input1,input2,input3,input4,input5,input6,input7,input8,input9); 
		rgst.getname(input1);
		rgst.getage(input2);
		rgst.getnumberofphone(input3);
		rgst.getcountry(input4);
		rgst.getresaddr(input5);
		rgst.getemail(input6);
		rgst.getexp(input8);
		rgst.getexp(input9);
		
		
		// TODO Auto-generated method stub
		
		

	}

}
