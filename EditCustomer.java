
/**
 * This class provides functions that allow tghe user to make changes to or remove customer details.
 *
 * @author (Simone Hanson)
 * 
 */
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

public class EditCustomer extends JFrame implements ActionListener
{
    private Scanner scan = new Scanner(System.in);
    String input;
    private static String firstname, lastname, cemail, phone, c_age,caddress; 

    private Container container;
    private JLabel title;
        
    private JLabel fNameLabel;
    private JTextField fNameField;
    private JLabel lNameLabel;
    private JTextField lNameField;
    private JLabel emailLabel;
    private JTextField emailField;
    private JLabel pNumLabel;
    private JTextField pNumField;
    private JLabel addressLabel;
    private JTextField addressField;
    private JLabel ageLabel;
    private JTextField ageField;
    private JLabel idLabel;
    private JTextField idField;
    private JTextField searchbar;
    

    private JButton submitBtn;
    private JButton resetBtn;
    private JButton removeBtn;
    private JButton searchBtn;
    private JButton backBtn;
    private Icon backIcon;
    private JTextArea notify;


    Color lpink = (new  Color(250, 200, 250));
    Color dblue = (new  Color(10, 10, 15));
    Color dblue2 = (new  Color(21, 21, 31));
    Color dpink = (new  Color(255, 30, 75));

    public void findCustomer(){
        


        setTitle("TCurly Sales Manager");
        setBounds(300, 90, 900, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        container = getContentPane();
        container.setBackground(dblue);
        container.setLayout(null);

          title = new JLabel("Edit Customer Details");
          title.setFont(new Font("Arial", Font.BOLD, 35));
          title.setSize(300, 30);
          title.setLocation(300, 30);
          title.setForeground(dpink);
          container.add(title);
          
            fNameLabel = new JLabel("First Name");
          fNameLabel.setFont(new Font("Arial", Font.BOLD, 20));
          fNameLabel.setSize(150, 20);
          fNameLabel.setLocation(100, 100);
          fNameLabel.setForeground(lpink);
          container.add(fNameLabel);
 
          fNameField = new JTextField();
          fNameField.setFont(new Font("Arial", Font.PLAIN, 15));
          fNameField.setBackground(Color.white);
          fNameField.setSize(190, 20);
          fNameField.setLocation(250, 100);
          container.add(fNameField);
          
          lNameLabel = new JLabel("Last Name");
          lNameLabel.setFont(new Font("Arial", Font.BOLD, 20));
          lNameLabel.setSize(100, 20);
          lNameLabel.setLocation(100, 150);
          lNameLabel.setForeground(lpink);
          container.add(lNameLabel);
 
          lNameField = new JTextField();
          lNameField.setFont(new Font("Arial", Font.PLAIN, 15));
          lNameField.setBackground(Color.white);
          lNameField.setSize(190, 20);
          lNameField.setLocation(250, 150);
          container.add(lNameField);

          emailLabel = new JLabel("Email");
          emailLabel.setFont(new Font("Arial", Font.BOLD, 20));
          emailLabel.setSize(100, 20);
          emailLabel.setLocation(100, 200);
          emailLabel.setForeground(lpink);
          container.add(emailLabel);
 
          emailField = new JTextField();
          emailField.setFont(new Font("Arial", Font.PLAIN, 15));
          emailField.setBackground(Color.white);
          emailField.setSize(190, 20);
          emailField.setLocation(250, 200);
          container.add(emailField);

          pNumLabel = new JLabel("Phone #");
          pNumLabel.setFont(new Font("Arial", Font.BOLD, 20));
          pNumLabel.setSize(100, 20);
          pNumLabel.setLocation(100, 250);
          pNumLabel.setForeground(lpink);
          container.add(pNumLabel);
 
          pNumField = new JTextField();
          pNumField.setFont(new Font("Arial", Font.PLAIN, 15));
          pNumField.setBackground(Color.white);
          pNumField.setSize(190, 20);
          pNumField.setLocation(250, 250);
          container.add(pNumField);
          
          addressLabel = new JLabel("Address");
          addressLabel.setFont(new Font("Arial", Font.BOLD, 20));
          addressLabel.setSize(100, 20);
          addressLabel.setLocation(100, 300);
          addressLabel.setForeground(lpink);
          container.add(addressLabel);
 
          addressField = new JTextField();
          addressField.setFont(new Font("Arial", Font.PLAIN, 15));
          addressField.setBackground(Color.white);
          addressField.setSize(190, 20);
          addressField.setLocation(250, 300);
          container.add(addressField);

          ageLabel = new JLabel("Age");
          ageLabel.setFont(new Font("Arial", Font.BOLD, 20));
          ageLabel.setSize(100, 25);
          ageLabel.setLocation(100, 350);
          ageLabel.setForeground(lpink);
          container.add(ageLabel);
 
          ageField = new JTextField(3);
          ageField.setFont(new Font("Arial", Font.PLAIN, 15));
          ageField.setBackground(Color.white);
          ageField.setSize(190, 20);
          ageField.setLocation(250, 350);
          container.add(ageField);

          idLabel = new JLabel("Assign ID");
          idLabel.setFont(new Font("Arial", Font.BOLD, 20));
          idLabel.setSize(100, 25);
          idLabel.setLocation(100, 400);
          idLabel.setForeground(lpink);
          container.add(idLabel);
 
          idField = new JTextField();
          idField.setFont(new Font("Arial", Font.PLAIN, 15));
          idField.setBackground(Color.white);
          idField.setSize(190, 20);
          idField.setLocation(250, 400);
          container.add(idField);

          submitBtn = new JButton("Submit");
          submitBtn.setFont(new Font("Arial", Font.BOLD, 25));
          submitBtn.setForeground(dpink);
          submitBtn.setBackground(lpink);
          submitBtn.setSize(340, 50);
          submitBtn.setLocation(100, 450);
          submitBtn.addActionListener(this);
          container.add(submitBtn);
  
          resetBtn = new JButton("Reset");
          resetBtn.setFont(new Font("Arial", Font.BOLD, 25));
            resetBtn.setForeground(Color.white);
          resetBtn.setBackground(dpink);
          resetBtn.setSize(340, 50);
          resetBtn.setLocation(100, 520);
          resetBtn.addActionListener(this);
          container.add(resetBtn);
          
          removeBtn = new JButton("Remove Customer");
          removeBtn.setFont(new Font("Arial", Font.BOLD, 25));
          removeBtn.setForeground(Color.white);
          removeBtn.setBackground(dpink);
          removeBtn.setSize(340, 50);
          removeBtn.setLocation(100, 550);
          removeBtn.addActionListener(this);
          container.add(removeBtn);
          
          notify = new JTextArea();
          notify.setFont(new Font("Arial", Font.PLAIN, 20));
          notify.setSize(300, 320);
          notify.setForeground(Color.white);
          notify.setBackground(dblue2);
          notify.setLocation(500, 100);
          notify.setLineWrap(true);
          notify.setEditable(false);
          notify.setBorder(BorderFactory.createLineBorder(lpink));
          container.add(notify);
          
          
          
           searchBtn = new JButton("Search Customer ID");
          searchBtn.setFont(new Font("Arial", Font.PLAIN, 15));
          searchBtn.setBackground(new Color(179, 179, 252));
          searchBtn.setSize(100, 30);
          searchBtn.setLocation(700, 440);
          searchBtn.addActionListener(this);
          container.add(searchBtn);
          searchbar = new JTextField();
          searchbar.setFont(new Font("Arial", Font.PLAIN, 15));
          searchbar.setBackground(Color.white);
          searchbar.setSize(190, 30);
          searchbar.setLocation(500, 440);
          container.add(searchbar);
          backIcon = new ImageIcon("icons/exit.png");
          backBtn= new JButton   ("", backIcon);
          backBtn.addActionListener(new CloseButtonListener());
          backBtn.setSize(100, 70);
          backBtn.setBackground(lpink);
          backBtn.setLocation(700, 500);
          container.add(backBtn);
          
          setVisible(true);
         

         

        
    }
    public void actionPerformed(ActionEvent event){
         if(event.getSource() == searchBtn) {
              
                String id = searchbar.getText();
        
                if (id.isEmpty()){
                    notify.setText("Please enter the ID of the customer you would like to edit.");
                }
                
                else {
                    notify.setText(SearchCustomer(id));
                    String blank ="";
                    fNameField.setText(blank);
                    lNameField.setText(blank);
                    emailField.setText(blank);
                    pNumField.setText(blank);
                    addressField.setText(blank);
                    ageField.setText(blank);
                    idField.setText(id);
                    
                    
                  
                }
              
            if(event.getSource() == removeBtn){
                        try
                        {
                
                        String old = "";
                        BufferedReader reader1 = new BufferedReader(new FileReader("Customers.txt"));
                        
                            String line1 = reader1.readLine();
                       
                            while (line1 != null)
                        {
                                old = old + line1 + System.lineSeparator();
                                 line1 = reader1.readLine();
                        }
                        String new1 = old.replaceAll(""+firstname+lastname+cemail+phone+caddress+c_age+id,"");
                        FileWriter writer1 = new FileWriter("Customers.txt");
                        writer1.write(new1);
                        reader1.close();
                        writer1.close(); 
                         }
                        catch (IOException ioe)
                        {
                            ioe.printStackTrace();
                        }

            }

    
            if (event.getSource() == submitBtn){
                String fName;
                String lName;
                String email;
                String pNum;
                String address;
                String age;
        
                
                if(((fNameField.getText()).isEmpty())!=true){
                     fName = fNameField.getText();}
                     else{fName=firstname;
                        }
                if(((lNameField.getText()).isEmpty())!=true){
                 lName = lNameField.getText();}
                 else{lName=lastname;
                        }
                if(((emailField.getText()).isEmpty())!=true){ 
                    email = emailField.getText();}
                    else{email=cemail;
                        }
                if(((pNumField.getText()).isEmpty())!=true){ 
                    pNum = pNumField.getText();}
                    else{pNum=phone;
                        }
                if(((addressField.getText()).isEmpty())!=true){ 
                    address = addressField.getText();}
                    else{address=caddress;
                        }
                if(((ageField.getText()).isEmpty())!=true){ 
                    age = ageField.getText();}
                    else{age=c_age;
                        }
                
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
                    notify.setText("The submitted age is not valid. Please ensure it is an integer between 0 and 130.");
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
                       
                        String oldContent = "";
                        BufferedReader reader = new BufferedReader(new FileReader("Customers.txt"));
                        String line = reader.readLine();

                            while (line != null)
                        {
                                oldContent = oldContent + line + System.lineSeparator();
                                 line = reader.readLine();
                        }
                        String newContent = oldContent.replaceAll(""+firstname+lastname+cemail+phone+caddress+c_age+id, c.getfName()+"!"+c.getlName()+"!"+c.getEmail()+"!"+c.getPhone()+"!"+c.getAddress()+"!"+c.getAge()+"!"+c.getID()+"\n");
                        FileWriter writer = new FileWriter("Customers.txt");
                        writer.write(newContent);
                        reader.close();
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
            }
            }
        
            
        }

        


    public static String SearchCustomer(String input){
        try{
            BufferedReader reader = new BufferedReader(new FileReader("Customer.txt"));
            String line;
            int i = 0;
            List<String> rdata = new ArrayList<String>();
            
            Scanner scan = new Scanner(System.in);

            while((line = reader.readLine()) != null){
                
                rdata.add(line);
                
                String[] dataFound = rdata.get(i).split("!");
                if(input.equals(dataFound[6])){
                    
                    firstname=dataFound[0];
                    lastname=dataFound[1];
                    c_age=dataFound[5];
                    cemail=dataFound[2];
                    phone=dataFound[3];
                    caddress=dataFound[4];
                    
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
    public class CloseButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)//listener for Close button, initiates when button is clicked
        {
            MainMenu.createAndShowGUI();
            container.setVisible(false);
            dispose();
        }

    }}




    // @Override
    // public void actionPerformed(ActionEvent e) {
    //     // TODO Auto-generated method stub
        
    // }


