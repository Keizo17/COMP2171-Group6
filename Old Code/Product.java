

public class Product {
	String name,brand, desc, price,stockCount;
	
	public Product(String name,String brand,String desc, String price, String stockCount) {
		this.name = name;
		this.brand = brand;
		this.desc = desc;
		this.price = price;
		this.stockCount = stockCount;
	}
	
	public Product(String name){
		this.name = name;
		
	}
	
	public String getPname() {
		return name;
		
	}
	
	public String getPbrand() {
		return brand;
		
	}
	
	public String getPdesc() {
		return desc;
		
	}

	public String getPprice() {
		return price;
	
	}
	public String getStockCount(){
		return stockCount;
	
	}
	
	public String toString() {
		return "Name: " + name + "\n" + "Brand: " + brand + "\n" + "Description: " 
				+ desc + "\n" + "Price: " + price + "\n" + "Amount in stock: " +  stockCount;
	}




	

}
