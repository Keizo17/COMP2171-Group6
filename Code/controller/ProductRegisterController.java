package controller;
import java.util.ArrayList;
import java.util.List;

import database.ProductList;
import logic.ProductValidater;
import logic.productRecord;


public class ProductRegisterController{

    private productRecord product;
	private List<productRecord> prodList;


    public Boolean createProduct(String pName, String pbrand, String pPrice, String pStock, String pNote){
        ArrayList<Boolean> valid = validateProduct(pName, pPrice, pStock);
        valid.add(true);
        createProdList();
        if(valid.contains(false)) {
            return false;
        }else{
        	this.product = new productRecord(pName, pbrand, pNote, Double.parseDouble(pPrice), Integer.parseInt(pStock));
            updateProductList();
            return true;
        }
    }
    

    

    public void createProdList(){
        prodList = new ProductList().readFile();
    }

    private ArrayList<Boolean> validateProduct(String pName, String pPrice, String pStock){
        return new ProductValidater().validate(pName, pPrice, pStock);
    }


    public void updateProductList() {
		boolean rep = isDuplicate(product.getProdname());
		
		if (rep == false) {
			new ProductList().saveToFile(product, -1);
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



}
