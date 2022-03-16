package logic;
import java.util.ArrayList;


public class addCustomerValidater {
	
	public addCustomerValidater() {}
	
	private ArrayList<Boolean> boolList = new ArrayList<Boolean>();
	
	public ArrayList<Boolean> validate(customerRecord cus) {
		boolList.add(validateName(cus.getfName()));
		boolList.add(validateName(cus.getlName()));
		boolList.add(validateAge(cus.getAge()));
		boolList.add(validateAddress(cus.getAddress()));
		boolList.add(validatePhone(cus.getPhone()));
		boolList.add(validateEmail(cus.getEmail()));
		boolList.add(validateID(cus.getID()));
		
		return boolList;
	}
	
	private boolean validateName(String name) {
		char[] chars = name.toCharArray();
        for (char c : chars) {
            if((!Character.isLetter(c) && !(c=='-') && !(c==' '))) {
            //if the name contains characters aside from letters, "-" or a space, it is invalid
                System.out.println("Invalid Name");
                return false;
            }
        }
        return true;
	}
	
	private boolean validateAge(int age){
	    //returns true if the age is a valid human age between 0 and 130
	    if((age >= 0) && (age <= 130)){
	        return true;
	    }else{
	         System.out.println("Invalid Age");
	         return false;
	    }
	}
	
	private boolean validateAddress(String address) {
        boolean hasLetter = false;
        boolean hasNum = false;

        char[] chars = address.toCharArray();
        for (char c : chars) {
            if(Character.isLetter(c)){
            //checks if the address has letters
            
                hasLetter = true;
            }
            if(Character.isDigit(c)){
            //checks if the address has numbers
                hasNum = true;
            }
        }
        if((hasLetter == true) && (hasNum == true)){
        //if the address does not have both a number and letters, it is invalid
            return true;
        }else{
            System.out.println("Invalid Address");
            return false;
        }
    }
    
    

    private boolean validatePhone(String pNum) {
        if (pNum.length() == 7){
            pNum = "876"+pNum;
        }
        if (pNum.length() != 10){
            //a phone number must be 10 digits including its area code to be valid
            System.out.println("Invalid Phone Number");
            return false;
        }else{
            if ((pNum.charAt(3) == '0') || (pNum.charAt(3) == '1')){
            //if the number after the area code begins with 0 or 1, it is invalid
                System.out.println("Invalid Phone Number");
                return false;
            }else{
                char[] num = pNum.toCharArray();
                for (char n : num) {
                    if(!(Character.isDigit(n))){
                    //if any character is not a digit, the number is invalid
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
    private boolean validateEmail(String email) {
        int atCount = 0;
        int dotCount = 0;
        char[] chars = email.toCharArray();

        if (!Character.isLetter(email.charAt(0)) && !Character.isDigit(email.charAt(0))){
        //if the email does not begin with a letter or number, it is invalid
            System.out.println("Invalid Email");
            return false;
        }else{
            for (char c : chars){
                if((!Character.isLetter(c) && !(Character.isDigit(c)) && !(c=='@') && !(c=='.'))) {
                //if the email contains characters that are not letters, numbers, '@' or '.', it is invalid
                    System.out.println("Invalid Email");
                    return false;
                }
                if(c == '@'){
                //counting the number of '@' in the email
                    atCount = atCount + 1;
                }
                if(c == '.'){
                //counting the number of '.' in the email
                    dotCount = dotCount + 1;
                }
            }
            if((atCount != 1) || (dotCount < 1)){
            //if the email does not include only 1 '@' and at least 1 '.', it is invalid
                System.out.println("Invalid Email");
                return false;
            }

            return true;
        }
    }
    
    

    private boolean validateID(String id) {
        boolean hasLetter = false;
        boolean hasNum = false;

        char[] chars = id.toCharArray();
        for (char c : chars) {
        //if the id has neither a letter nor number, it is invalid
            if(Character.isLetter(c)){
                hasLetter = true;
            }
            if(Character.isDigit(c)){
                hasNum = true;
            }
            if(c == '!'){
                return false;
            }
        }
        if((hasLetter == true) || (hasNum == true)){
            return true;
        }else{
            System.out.println("Invalid ID");
            return false;
        }
	
    }
}