package database;
import java.util.*;
import java.io.File;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;

import logic.DeliveryRecord;
import logic.productRecord;

public class ProductList{
    private Scanner scan;
    private ArrayList<productRecord> prodList;
    static File prodFile = new File("Products.txt");

    public ArrayList<productRecord> readFile(){
    	prodList = new ArrayList<productRecord>();
        try
        {
        	scan = new Scanner(prodFile);
            while(scan.hasNextLine())
            {
                String [] nextLine = scan.nextLine().split("!");
                String prodName = nextLine[0];
                String pBrand = nextLine[1];
                String prodDescription = nextLine[2];
                double prodPrice = Double.parseDouble(nextLine[3]);
                int prodStock = Integer.parseInt(nextLine[4]);
                
                
                productRecord p = new productRecord(prodName, pBrand, prodDescription, prodPrice, prodStock);
                prodList.add(p);
            }

            scan.close();
        }
        catch(NullPointerException | FileNotFoundException e)
        {}
        
        return prodList;
    }
    
    public void saveToFile(productRecord product, int index) {
    	readFile();
    	System.out.println(index);
    	try{
    		if(index != -1) {
    			BufferedWriter writer = new BufferedWriter(new FileWriter(prodFile,false));
        		prodList.set(index, product);
        		prodFile.delete();
        		for (int i = 0; i < prodList.size(); i++) {
        			writer.write(prodList.get(i).toString());
        		}
                writer.close();
    		}else {
    			BufferedWriter writer = new BufferedWriter(new FileWriter(prodFile,true));
    			writer.write(product.getProdname()+"!"+product.getPbrand()+"!"+product.getProdNote()+"!"
    						+product.getProdPrice()+"!"+product.getProdStock()+"\n");
    			writer.close();
    		}
    	}catch (Exception e) {}
    }
}
