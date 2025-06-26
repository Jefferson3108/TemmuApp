
import Controller.Register;
import Controller.Profile;
import View.Registervw;
import View.Selectvw;
public class Main {

	public static void main(String[] args) {
		/*
		 * Console interface to request data
		 */
		Selectvw t= new Selectvw();
		t.setVisible(true);
		Registervw u= new Registervw();
		u.setVisible(true);
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
