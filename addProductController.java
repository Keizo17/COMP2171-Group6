package controller;
import java.util.ArrayList;
import java.util.List;



import logic.productRecord;


public class addProductController{

    private productRecord product;
	private addProductValidater validater;
	private List<productRecord> prodList;


    public ArrayList<Boolean> createProduct(String pName, int pID, double pPrice, int pStock, String pNote){
        this.product = new productRecord(pName, pID, pPrice, pStock, pNote);
        ArrayList<Boolean> vaild = validateProduct(product);
        createProdList();
        if(valid.contains(flase)) {
            return valid;
        }else{
            updateProdList();
            retrurn valid;
        }
    
    }
    

    

    public void createProdList(){
        prodList = new addProductList().readFile();
    }

    private ArrayList<Boolean> validateProduct(productRecord prod){
        return new addProductValidater().validate(prod);
    }


    public void updateProductLst() {
		boolean rep = isDuplicate(product.getCode());
		
		if (rep == false) {
			new addproductLst().saveToFile(product);
		}else {}
	}
	
	private boolean isDuplicate(String pID) {
		for(int i = 0; i < prodList.size(); i++) {
			if(prodList.get(i).getsCode().equals(pID)){
				return true;
			}
		}
		return false;
		
	}



}

