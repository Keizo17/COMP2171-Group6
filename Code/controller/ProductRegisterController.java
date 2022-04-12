package controller;
import java.util.ArrayList;
import java.util.List;

import database.ProductList;
import logic.ProductValidater;
import logic.productRecord;


public class ProductRegisterController{

    private productRecord product;
	private List<productRecord> prodList;


    public Boolean createProduct(String pName, String pID, String pPrice, String pStock, String pNote){
        ArrayList<Boolean> valid = new ArrayList<Boolean>();//validateProduct(pName, pID, pPrice, pStock, pNote);
        valid.add(true);
        createProdList();
        if(valid.contains(false)) {
            return false;
        }else{
        	this.product = new productRecord(pName, Integer.parseInt(pID), Double.parseDouble(pPrice), Integer.parseInt(pStock), pNote);
            updateProductList();
            return true;
        }
    
    }
    

    

    public void createProdList(){
        prodList = new ProductList().readFile();
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



}
