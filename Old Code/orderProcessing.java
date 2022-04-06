
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

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
import java.awt.event.*;

public class orderProcessing extends JFrame{

    private Scanner scan = new Scanner(System.in);
    static File file = new File("Invoices.txt");

    private Container container;
    private JLabel custIDLabel;
    private JTextField  custID;
    private JLabel prodLabel;
    private JTextField  prod;

    private JButton submitBtn;
    private JButton resetBtn;
    private JButton searchBtn;
    private JButton backBtn;
    private Icon backIcon;
    private JTextArea notify;

    
    private JButton     cmdUpdate;
    private JButton		cmdContinue;
    private JButton     cmdClose;

    private JPanel      pnlCommand;
    private JPanel      pnlDisplay;

    Color lpink = (new  Color(250, 200, 250));
    Color dblue = (new  Color(10, 10, 15));
    Color dblue2 = (new  Color(21, 21, 31));
    Color dpink = (new  Color(255, 30, 75));
    
    public void getDetails(){
        container = getContentPane();
        container.setBackground(dblue);
        container.setLayout(null);
        
        custIDLabel = new JLabel("Please enter the customer ID for the sale");
        custID.setFont(new Font("Arial", Font.BOLD, 20));
        custID.setSize(150, 20);
        custID.setLocation(100, 100);
        custID.setForeground(lpink);
        container.add(custID);
        
        prodLabel = new JLabel("Please enter the product for the sale");
        prod.setFont(new Font("Arial", Font.BOLD, 20));
        prod.setSize(150, 20);
        prod.setLocation(100, 100);
        prod.setForeground(lpink);
        container.add(prod);

        submitBtn = new JButton("Submit");
          submitBtn.setFont(new Font("Arial", Font.BOLD, 25));
          submitBtn.setForeground(dpink);
          submitBtn.setBackground(lpink);
          submitBtn.setSize(340, 50);
          submitBtn.setLocation(100, 450);
          submitBtn.addActionListener((ActionListener) this);
          container.add(submitBtn);
  
          resetBtn = new JButton("Reset");
          resetBtn.setFont(new Font("Arial", Font.BOLD, 25));
          resetBtn.setForeground(Color.white);
          resetBtn.setBackground(dpink);
          resetBtn.setSize(340, 50);
          resetBtn.setLocation(100, 520);
          resetBtn.addActionListener((ActionListener) this);
          container.add(resetBtn);

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
        	  
        File file = new File("Customers.txt");


        if (event.getSource() == submitBtn){

            String custID = custID.getText();
            String prod = prod.getText();
            
            notify.setText("");
            
            if (validateID(custID) == false){
                notify.setText("The submitted ID is not valid. Only letters and certain symbols are permitted.");
                custID.setBackground(lpink);
            }else if (validateName(prod) == false){
                notify.setText("The submitted product name is not valid. Only letters and certain symbols are permitted.");
                prod.setBackground(lpink);
            }else{
                String blank ="";
                custID.setText(blank);
                prod.setText(blank);
                
            }
        }else if (event.getSource() == resetBtn){
            String blank ="";
            custID.setText(blank);
            prod.setText(blank);
            custID.setBackground(Color.white);
            prod.setBackground(Color.white);
        }
    }

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
    
    public static String SearchProduct(String input){
        try{
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            int i = 0;
            List<String> rdata = new ArrayList<String>();
            
            Scanner scan = new Scanner(System.in);

            while((line = reader.readLine()) != null){
                
                rdata.add(line);
                
                //stuff
            }
            return ("No product with this ID was found.");
        }catch(Exception e){return ("No product with this ID was found.");}
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

    class CloseButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)//listener for Close button, initiates when button is clicked
        {
        	MainMenu.createAndShowGUI();
            container.setVisible(false);
            dispose();
        }

    }


}
    


