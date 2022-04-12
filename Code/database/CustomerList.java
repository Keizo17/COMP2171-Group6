package database;
import java.util.*;
import java.io.File;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;

import logic.customerRecord;

public class CustomerList{
    private Scanner scan;
    private ArrayList<customerRecord> custList;
    static File custFile = new File("Customers.txt");

    public ArrayList<customerRecord> readFile(){
    	custList = new ArrayList<customerRecord>();
        try
        {
        	scan = new Scanner(custFile);
            while(scan.hasNextLine())
            {
                String [] nextLine = scan.nextLine().split("!");
                String fName = nextLine[0];
                String lName = nextLine[1];
                String email = nextLine[2];
                String telNum = nextLine[3];
                String addr = nextLine[4];
                int age = Integer.parseInt(nextLine[5]);
                String id = nextLine[6];
                
                customerRecord c = new customerRecord(fName, lName, age, addr, telNum, email, id);
                custList.add(c);
            }

            scan.close();
        }
        catch(NullPointerException | FileNotFoundException e)
        {}
        return custList;
    }
    
    public void saveToFile(customerRecord customer, int index) {
    	readFile();
    	
    	try{
    		if(index != -1) {
    			BufferedWriter writer = new BufferedWriter(new FileWriter(custFile,false));
        		custList.set(index, customer);
        		custFile.delete();
        		for (int i = 0; i < custList.size(); i++) {
        			writer.write(custList.get(i).toString());
        		}
                writer.close();
    		}else {
    			BufferedWriter writer = new BufferedWriter(new FileWriter(custFile,true));
    			writer.write(customer.getfName()+"!"+customer.getlName()+"!"+customer.getEmail()
    						+"!"+customer.getPhone()+"!"+customer.getAddress()+"!"+customer.getAge()+"!"+customer.getID()+"\n");
    			writer.close();
    		}
    	}catch (Exception e) {}
    }
}
