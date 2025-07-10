package Controller;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import Model.data;

public class Payment {
	public Integer PaymentID;
	public String Datepy;
	public  Integer CardNumber;
	public Integer SecurityCode;
	public String MethodPayment;
	private Integer NumCard1=1218396892;
	private Integer NumCard2=1849501121;
	private Integer NumCard3=1238039233;
	private Integer NumSec1=321;
	private Integer NumSec2=534;
	private Integer NumSec3=132;
	public Payment(String CardNumber, String SecurityCode ) {
		try {
			this.CardNumber=Integer.parseInt(CardNumber);
		}catch(Exception e) {
			this.CardNumber=null;
		}
		try {
			this.SecurityCode=Integer.parseInt(SecurityCode);
		}catch(Exception e) {
			this.SecurityCode=null;
		}
		
		
		
		// TODO Auto-generated constructor stub
	}
	
	public void GeneratePaymentID() {
		Random Id= new Random();
		Integer randId= Id.nextInt(9000)+1000;
		this.PaymentID=randId;
	}
	
	public void GenerateDate() {
		LocalDate date= LocalDate.now();
		SimpleDateFormat Formatdate= new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		String strdate= Formatdate.format(date);
		this.Datepy=strdate;
	}
	
	
	public Integer ValidateCardNumber(String CardNumber) {
		if(CardNumber.length()<10 || CardNumber.contains("-")) {
			this.CardNumber=Integer.parseInt(CardNumber);
			this.CardNumber=null;
			System.out.println("XD");
		}else {
			if(this.NumCard1== this.CardNumber) {
				return Integer.parseInt(CardNumber);
			}else if(this.NumCard2== this.CardNumber) {
				return Integer.parseInt(CardNumber);
				
			}else if(this.NumCard3== this.CardNumber) {
				return Integer.parseInt(CardNumber);
			}else {
				return this.CardNumber=null;
				
			}
			
		}
		return this.CardNumber=null;
	}
	
	public Integer ValidateSecurityCard(String SecurityCode) {
		if(SecurityCode.length()>3 || SecurityCode.contains("-")) {
			this.SecurityCode=Integer.parseInt(SecurityCode);
			this.SecurityCode=null;
		}else {
			if(this.NumSec1== this.SecurityCode) {
				return Integer.parseInt(SecurityCode);
			}else if(this.NumSec2== this.SecurityCode) {
				return Integer.parseInt(SecurityCode);
				
			}else if(this.NumSec3== this.SecurityCode) {
				return Integer.parseInt(SecurityCode);
			}else {
				return this.SecurityCode=null;
			}
			
		}
		return this.SecurityCode=null;
	}
	
	public Boolean getNumberCard() {
		return this.CardNumber !=null;
	}
	
	public Boolean getSecurityCard() {
		return this.SecurityCode !=null;
	}
	public Boolean ValidatePurchase() {
		if(getNumberCard()&& getSecurityCard()!=null) {
			
			return true;
		}else {
			
			return false;
		}
		
	}
	

}

