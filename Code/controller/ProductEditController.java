package controller;

import java.util.ArrayList;
import java.util.List;

import logic.productRecord;
import logic.ProductValidater;
import database.ProductList;

public class ProductEditController {
	private productRecord product;
	private List<productRecord> prodList;
	
	public Boolean updateProduct(String pName, String pID, String pPrice, String pStock, String pNote) {
		createProdList();
		ArrayList<Boolean> valid = new ArrayList<Boolean>();//validateProduct(pName, pID, pPrice, pStock, pNote);
		if(valid.contains(false)) {
            return false;
        }else{
        	this.product = new productRecord(pName, Integer.parseInt(pID), Double.parseDouble(pPrice), Integer.parseInt(pStock), pNote);
            updateProductList();
            return true;
        }
	}
	
	public void createProdList() {
		this.prodList = new ProductList().readFile();
	}
	
	private ArrayList<Boolean> validateProduct(String pName, String pID, String pPrice, String pStock, String pNote){
        return new ProductValidater().validate(pName, pID, pPrice, pStock, pNote);
    }
	
	public void updateProductList() {
		boolean rep = isDuplicate(product.getProdID());
		
		if (rep == false) {
			new ProductList().saveToFile(product);
		}else {}
	}
	
	private boolean isDuplicate(int pID) {
		for(int i = 0; i < prodList.size(); i++) {
			if(prodList.get(i).getProdID() == pID){
				return true;
			}
		}
		return false;
		
	}
	public String findID(String id) {
		createProdList();
		for(int i = 0; i < prodList.size(); i++) {
			if(prodList.get(i).getProdID() == Integer.parseInt(id)){
				this.product = prodList.get(i);
				return ("Product ID("+prodList.get(i).getProdID()+") Found\n----------------------------\n["
	                    +prodList.get(i).getProdName()+
	                    "]\nPrice:\n-"+prodList.get(i).getProdPrice()+
	                    "\nStock:\n-"+prodList.get(i).getProdStock()+
	                    "\nDescription:\n-"+prodList.get(i).getProdNote());
			}
		}
		return ("No product with this ID "+id+" was found.");
	}
	
}
