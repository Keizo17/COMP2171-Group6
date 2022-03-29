package controller;
import java.util.ArrayList;
import java.util.List;



import logic.productRecord;


public class addProductController{

    private productRecord product;
	private addProductValidater validater;
	private List<productRecord> prodLst;


    public ArrayList<Boolean> createProduct(String pName, int sCode){
        this.product = new productRecord(pName, sCode);
        ArrayList<Boolean> vaild = validateProduct(product);
        createProductLst();
        if(valid.contains(flase)) {
            return valid;
        }else{
            updateProductLst();
            retrurn valid;
        }
    
    }
    

    

    public void createProductLst(){
        prodLst = new addProductList().readFile();
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
	
	private boolean isDuplicate(String code) {
		for(int i = 0; i < prodLst.size(); i++) {
			if(prodLst.get(i).getsCode().equals(code)){
				return true;
			}
		}
		return false;
		
	}



}

