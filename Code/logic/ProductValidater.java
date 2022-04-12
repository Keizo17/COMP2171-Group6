package logic;
import java.util.ArrayList;


public class ProductValidater {
	
	private ArrayList<Boolean> boolList = new ArrayList<Boolean>();
	
	public ArrayList<Boolean> validate(String pName, String pPrice, String pStock) {
		boolList.add(validateName(pName));
		boolList.add(validatePrice(pPrice));
		boolList.add(validateStock(pStock));
		
		return boolList;
	}
	
	private boolean validateName(String pName) {
		char[] chars = pName.toCharArray();
        for (char c : chars) {
            if((!Character.isLetter(c) && !(c=='-') && !(c==' '))) {
            	System.out.println("Invalid product name");
                return false;
            }
        }
        return true;
	}
	
	private boolean validateStock(String pStock){
		try{
	        int stock = Integer.parseInt(pStock);
	        if(stock == 0) {
	        	System.out.println("Invalid product stock. Stock cannot be 0");
	        	return false;
	        }else if (stock <= 10){
      		  	System.out.println("There are less than 10 of this product available. Please remember to restock");
            }
	    }catch(Exception e ){
	    	System.out.println("Invalid product stock");
	        return false;
	    }
	    return true;
	}
	
	private boolean validatePrice(String pPrice) {
		try{
	        double price = Double.parseDouble(pPrice);
	        if(price == 0.00) {
	        	System.out.println("Invalid price. Price cannot be 0");
	        	return false;
	        }
	    }catch(Exception e ){
	    	System.out.println("Invalid price");
	        return false;
	    }
	    return true;
    }
}