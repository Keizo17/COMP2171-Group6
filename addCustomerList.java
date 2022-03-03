import java.util.*;
import java.util.List;
import java.io.File;
import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.*;
import java.awt.event.ActionEvent;
import java.awt.event.*;

public class addCustomerList{
    private Scanner scan = new Scanner(System.in);
    static File file = new File("Customers.txt");
    String input;

    public void actionPerformed(ActionEvent event){
        	  
            File file = new File("Customers.txt");

    
            if (event.getSource() == submitBtn){

                String fName = fNameField.getText();
                String lName = lNameField.getText();
                String email = emailField.getText();
                String pNum = pNumField.getText();
                String address = addressField.getText();
                String age = ageField.getText();
                String id = idField.getText();
                notify.setText("");

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
    
                    Customer c = new Customer(fName, lName, email, pNum, address, Integer.valueOf(age), id);
                    System.out.println(c);
                    
                    try{
                        BufferedWriter writer = new BufferedWriter(new FileWriter(file,true));
                        writer.write(c.getfName()+"!"+c.getlName()+"!"+c.getEmail()+"!"+c.getPhone()+"!"+c.getAddress()+"!"+c.getAge()+"!"+c.getID()+"\n");
            
                        writer.close();
                    }catch(Exception e){return;}
                }
            }else if (event.getSource() == resetBtn){
                String blank ="";
                fNameField.setText(blank);
                lNameField.setText(blank);
                emailField.setText(blank);
                pNumField.setText(blank);
                addressField.setText(blank);
                ageField.setText(blank);
                idField.setText(blank);
                notify.setText(blank);
                searchbar.setText(blank);
                fNameField.setBackground(Color.white);
                lNameField.setBackground(Color.white);
                emailField.setBackground(Color.white);
                pNumField.setBackground(Color.white);
                addressField.setBackground(Color.white);
                ageField.setBackground(Color.white);
                idField.setBackground(Color.white);
            }else if(event.getSource() == searchBtn) {
              
                String id = searchbar.getText();
        
                if (id.isEmpty()){
                    notify.setText("Please enter the ID you would like to search.");
                }
                
                else {
                  
                    String blank ="";
                    fNameField.setText(blank);
                    lNameField.setText(blank);
                    emailField.setText(blank);
                    pNumField.setText(blank);
                    addressField.setText(blank);
                    ageField.setText(blank);
                    idField.setText(blank);
                    
                    notify.setText(SearchCustomer(id));
                  
                }
            }
        
            
        }
}
