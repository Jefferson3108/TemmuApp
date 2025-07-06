package Controller;

public class Product {
	public String NamePr;
	public String ImagePr;
	public Float Price;
	public String Description;
	public Integer Stock;
	public String Category;
	
	public Product(String NamePr, String ImagePr, String Price,  String Description, String Stock, String Category) {
		AssignNamePr(NamePr);
		AssignImagePr(ImagePr);
		AssignPrice(Price);
		AssignDescriptionPr(Description);
		AssignStock(Stock);
		AssignCategory(Category);	
	}
	
	public void AssignNamePr(String NamePr){
		try {
			this.NamePr= NamePr;
			if(this.NamePr.length()<3) {
				this.NamePr= null;
				
			}
		}catch(Exception e) {
			this.NamePr=null;
		}
		
	}
	
	public void AssignImagePr(String ImagePr) {
		try {
			this.ImagePr= ImagePr;
		}catch(Exception e) {
			this.ImagePr=null;
		}
		
		
	}
	
	public void AssignPrice(String Price) {
		try {
			this.Price=Float.parseFloat(Price);
			if(this.Price<0 || this.Price > 300000) {
				this.Price= null;	
			}
		}catch(Exception e) {
			this.Price=null;
		}
		
	}
	public void AssignDescriptionPr(String Description) {
		try {
			this.Description=Description;
		}catch(Exception e) {
			this.Description=null;
		}
		
	}
	
	public void AssignStock(String Stock) {
		try {
			this.Stock=Integer.parseInt(Stock);
			if(this.Stock<0 || this.Stock>200 ) {
				this.Stock= null;
			}
		}catch(Exception e) {
			this.Stock=null;	
		}
		
	}
	
	public void AssignCategory(String Category) {
		try {
			this.Category= Category;
		}catch(Exception e) {
			this.Category=null;
		}
	}
	
	public Boolean getNamePr() {
		return this.NamePr != null;
	}
	
	public Boolean getImagePr() {
		return this.ImagePr !=null;
	}
	
	public Boolean getPrice() {
		return this.Price !=null;
	}
	
	public Boolean getDescriptionPr() {
		return this.Description !=null;
	}
	
	public Boolean getStock() {
		return this.Stock !=null;
	}
	
	public Boolean getCategory() {
		return this.Category !=null;
	}
	
	public Boolean publishProduct() {
		if(getNamePr() && getImagePr() && getPrice() && getDescriptionPr() && getStock() && getCategory()!= null) {
			return true;
		}else {
			return false;
		}
	}
}



