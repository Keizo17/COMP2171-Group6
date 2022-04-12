package controller;

import java.util.ArrayList;
import java.util.List;

import logic.productRecord;
import logic.ProductValidater;
import database.ProductList;

public class ProductEditController {
	private productRecord product;
	private List<productRecord> prodList;
	//private newName, newBran
	private int index;
	
	public Boolean updateProduct(String pName, String pBrand, String pPrice, String pStock, String pNote, String oldname) {
		createProdList();
		ArrayList<String> updatedprod = checkValues(pName, pBrand, pNote, pStock, pPrice, oldname);
		ArrayList<Boolean> valid = validateProduct(updatedprod.get(0), updatedprod.get(3), updatedprod.get(4));
		
		if(valid.contains(false)) {
            return false;
        }else{
        	this.product = new productRecord(updatedprod.get(0), updatedprod.get(1), updatedprod.get(2), 
        			Double.parseDouble(updatedprod.get(3)), Integer.parseInt(updatedprod.get(4)));
            updateProductList();
            return true;
        }
	}
	
	public void createProdList() {
		this.prodList = new ProductList().readFile();
	}
	
	private ArrayList<Boolean> validateProduct(String pName, String pPrice, String pStock){
        return new ProductValidater().validate(pName, pPrice, pStock);
    }
	
	public void updateProductList() {
		boolean rep = isDuplicate(product.getProdname());
		
		if (rep == false) {
			new ProductList().saveToFile(product, index);
		}else {}
	}
	
	private boolean isDuplicate(String prodname) {
		for(int i = 0; i < prodList.size(); i++) {
			if(prodList.get(i).getProdname().equalsIgnoreCase(prodname)){
				return true;
			}
		}
		return false;
	}
	
	public String findID(String name) {
		createProdList();
		for(int i = 0; i < prodList.size(); i++) {
			if(prodList.get(i).getProdname().equalsIgnoreCase(name)){
				product = prodList.get(i);
				
				return ("Product Name "+prodList.get(i).getProdname()+" Found\n----------------------------\n["
	                    +prodList.get(i).getPbrand()+
	                    "]\nPrice:\n-"+prodList.get(i).getProdPrice()+
	                    "\nStock:\n-"+prodList.get(i).getProdStock()+
	                    "\nDescription:\n-"+prodList.get(i).getProdNote());
			}
		}
		return ("No product with this name "+name+" was found.");
	}
	
	public ArrayList<String> checkValues(String newName, String newBrand, String newNote, String newStock, String newPrice, String oldname){
		ArrayList<String> newProd = new ArrayList<String>();
		String oldbrand = "", oldnote = "", oldstock = "", oldprice = "";
		for(int i = 0; i < prodList.size(); i++) {
			if(prodList.get(i).getProdname().equalsIgnoreCase(oldname)){
				oldbrand = prodList.get(i).getPbrand();
				oldnote = prodList.get(i).getProdNote();
				oldprice = Double.toString(prodList.get(i).getProdStock());
				oldstock = Integer.toString(prodList.get(i).getProdStock());
				this.index = i;
			}
		}
		if(newName.isBlank()) {
			newName = oldname;
		}
		if(newBrand.isBlank()) {
			newBrand = oldbrand;
		}
		if(newNote.isBlank()) {
			newNote = oldnote;
		}
		if(newStock.isBlank()) {
			newStock = oldstock;
		}
		if(newPrice.isBlank()) {
			newPrice = oldprice;
		}
		
		newProd.add(newName);
		newProd.add(newBrand);
		newProd.add(newNote);
		newProd.add(newPrice);
		newProd.add(newStock);
		
		return newProd;
	}
	
}
