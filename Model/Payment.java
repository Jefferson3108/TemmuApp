package Model;

public class Payment {

	public Payment() {
		// TODO Auto-generated constructor stub
	}
	public String generatepaymentid(String PyId) {
	return PyId;
	}
	public String generatepaymentdate(String Pydt) {
	return Pydt;	
	}
	public String identifypaymentmethod(String Pymt) {
	return Pymt;	
	}
	public boolean validatecardnumber(Boolean f) {
	return true;	
	}
	public Integer deductcardamount(Integer numP,Integer numD) {
		return numP;
	}
	

}
