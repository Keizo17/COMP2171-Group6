
public class addCustomerValidater {
	if(pNum.length() == 7){
        pNum = "876" + pNum;
    }
    
    if (validateName(fName) == false){
        notify.setText("The submitted first name is not valid. Only letters and certain symbols are permitted.");
        fNameField.setBackground(lpink);
    }else if (validateName(lName) == false){
        notify.setText("The submitted last name is not valid. Only letters and certain symbols are permitted.");
        lNameField.setBackground(lpink);
    }else if (validateEmail(email) == false){
        notify.setText("The submitted email is not valid. Please ensure you added the domain.");
        emailField.setBackground(lpink);
    }else if (validatePhone(pNum) == false){
        notify.setText("The submitted phone number is not valid. Must be 7 or 10 digits and begin with valid digits.");
        pNumField.setBackground(lpink);
    }else if (validateAddress(address) == false){
        notify.setText("The submitted email is not valid. Please emsure you added the street and number.");
        addressField.setBackground(lpink);
    }else if (validateAge(Integer.valueOf(age)) == false){
        notify.setText("The submitted age name is not valid. Please ensure it is an integer between 0 and 130.");
        ageField.setBackground(lpink);
    }else if (validateID(id) == false){
        notify.setText("The submitted ID name is not valid. Please ensure it includes a letter or a number.");
        idField.setBackground(lpink);
    }else{
        String blank ="";
        fNameField.setText(blank);
        lNameField.setText(blank);
        emailField.setText(blank);
        pNumField.setText(blank);
        addressField.setText(blank);
        ageField.setText(blank);
        idField.setText(blank);
    }
    
    public boolean validateName(String name) {
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

    public boolean validateEmail(String email) {
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
    
    public boolean validateAddress(String address) {
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
    
    public boolean validateAge(int age){
    //returns true if the age is a valid human age between 0 and 130
        if((age >= 0) && (age <= 130)){
            return true;
        }else{
            System.out.println("Invalid Age");
            return false;
        }
    }

    public boolean validatePhone(String pNum) {
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

    public boolean validateID(String id) {
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
