import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class addCustomerController {
	
	public static String SearchCustomer(String input){
        try{
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            int i = 0;
            List<String> rdata = new ArrayList<String>();
            
            Scanner scan = new Scanner(System.in);

            while((line = reader.readLine()) != null){
                
                rdata.add(line);
                
                String[] dataFound = rdata.get(i).split("!");
                if(input.equals(dataFound[6])){
                    return ("Customer ID("+dataFound[6]+") Found\n----------------------------\n["
                    +dataFound[0]+" "+dataFound[1]+
                    "]\nEmail:\n-"+dataFound[2]+
                    "\nTelephone:\n-"+dataFound[3]+
                    "\nAddress:\n-"+dataFound[4]+
                    "\nAge:\n-"+Integer.valueOf(dataFound[5]));
                }
                i = i + 1;
            }
            return ("No customer with this ID was found.");
        }catch(Exception e){return ("No customer with this ID was found.");}
    }

}
