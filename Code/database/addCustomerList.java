package database;
import java.util.*;
import java.io.File;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;

import logic.customerRecord;

public class addCustomerList{
    private Scanner scan;
    private ArrayList<customerRecord> custList;
    static File custFile = new File("Customers.txt");
    String input;

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
    
    public void saveToFile(customerRecord cust) {
    	try{
    		BufferedWriter writer = new BufferedWriter(new FileWriter(custFile,true));
    		writer.write(cust.getfName()+"!"+cust.getlName()+"!"+cust.getEmail()+"!"+cust.getPhone()+"!"+cust.getAddress()+"!"+cust.getAge()+"!"+cust.getID()+"\n");
    		writer.close();
    	}catch (Exception e) {}
    }
}
