
import Controller.Register;
import Controller.Profile;

public class Main {

	public static void main(String[] args) {
		/*
		 * Console interface to request data
		 */
		System.out.println("======Welcome to register=====\n\n");
		Register rgst = new Register();
		if(rgst.SelectRol()==1) {
			Profile prf = new Profile(rgst.getname(), rgst.getage(), rgst.getnumberofphone(), rgst.getcountry(),
					rgst.getresaddr(), rgst.getemail(), rgst.getpassword());
			prf.assignname();
			prf.assignage();
			prf.assignnumphon();
			prf.assigncountry();
			prf.assignemail();
			prf.assignpassword();
			prf.validateprofile();
			
		}else {
			Profile prf = new Profile(rgst.getname(), rgst.getage(), rgst.getnumberofphone(), rgst.getcountry(),
					rgst.getresaddr(), rgst.getemail(), rgst.getpassword(),rgst.getexp(),rgst.getpprf());
			prf.assignname();
			prf.assignage();
			prf.assignnumphon();
			prf.assigncountry();
			prf.assignemail();
			prf.assignpassword();
			prf.assignexp();
			prf.assignpprf();
			prf.validateprofile();
			
		}
		
		

		// TODO Auto-generated method stub

	}

}
