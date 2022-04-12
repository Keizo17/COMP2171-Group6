package logic;

import java.text.DecimalFormat;

public class productRecord{
	private DecimalFormat df = new DecimalFormat("0.00");
	private String name, brand, pNote;
	private double pPrice;
	private int pStock;
	
	public productRecord(String name,String brand,String pNote, double pPrice, int pStock) {
		this.name = name;
		this.brand = brand;
		this.pNote = pNote;
		this.pPrice = pPrice;
		this.pStock = pStock;
	}
	
	public void Product(String name){
		this.name = name;
	}
	
	public String getProdname() {
		return name;
	}

    public String getProdNote(){
        return this.pNote;
    }

    public int getProdStock(){
        return this.pStock;
    }

    public double getProdPrice(){
        return this.pPrice;
    }
    
    public String getPbrand() {
		return brand;
	}
    
    public String toString() {
    	return ""+name+"!"+brand+"!"+pNote+"!"+pPrice+"!"+pStock+"\n";
    }
}