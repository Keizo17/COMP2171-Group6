package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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


public class CheckCart extends JFrame implements ActionListener {
	  
	  File file = new File("Invoices.txt");
	  
      private Container container;
      private JLabel title;
      
      private JLabel Cusid,DelvSch,discount,product;
      private JTextField pcusid,prod;
      
      private JLabel quantity;
      private JTextField pquan;
      private JCheckBox Delv, Disc;
      
      private JTextField searchtxt;
      
      
      private JButton add,Calc;
      private JButton reset;
      private JButton search;
      private JButton returnBtn;
      private Icon back;
      private JTextArea notify;
      
      Color lpink = (new  Color(250, 200, 250));
      Color dblue = (new  Color(10, 10, 15));
      Color dblue2 = (new  Color(21, 21, 31));
      Color dpink = (new  Color(255, 30, 75));
      
      ArrayList<ArrayList<String>> orderlst = new ArrayList<>();

      //Search

      public CheckCart() {
    	  
    	  

          setTitle("T'Curly Sales Manager");
          setBounds(300, 90, 900, 600);
          setDefaultCloseOperation(EXIT_ON_CLOSE);
          setResizable(false);

          container = getContentPane();
          container.setBackground(dblue);
          container.setLayout(null);
         

          title = new JLabel("Processing Order");
          title.setFont(new Font("Arial", Font.BOLD, 35));
          title.setSize(300, 30);
          title.setLocation(300, 20);
          title.setForeground(dpink);
          container.add(title);

          Cusid = new JLabel("Cus ID");
          Cusid.setFont(new Font("Arial", Font.BOLD, 20));
          Cusid.setForeground(lpink);
          Cusid.setSize(150, 20);
          Cusid.setLocation(100, 100);
          container.add(Cusid);
 
          pcusid = new JTextField();
          pcusid.setFont(new Font("Arial", Font.PLAIN, 15));
          pcusid.setBackground(Color.white);
          pcusid.setSize(190, 20);
          pcusid.setLocation(250, 100);
          container.add(pcusid);
          
          product = new JLabel("Product");
          product.setFont(new Font("Arial", Font.BOLD, 20));
          product.setForeground(lpink);
          product.setSize(100, 20);
          product.setLocation(100, 150);
          container.add(product);
 
          prod = new JTextField();
          prod.setFont(new Font("Arial", Font.PLAIN, 15));
          prod.setBackground(Color.white);
          prod.setSize(190, 20);
          prod.setLocation(250, 150);
          container.add(prod);

          quantity= new JLabel("Quantity");
          quantity.setFont(new Font("Arial", Font.BOLD, 20));
          quantity.setForeground(lpink);
          quantity.setSize(100, 20);
          quantity.setLocation(100, 200);
          container.add(quantity);
 
          pquan = new JTextField();
          pquan.setFont(new Font("Arial", Font.PLAIN, 15));
          pquan.setBackground(Color.white);
          pquan.setSize(190, 20);
          pquan.setLocation(250, 200);
          container.add(pquan);


          discount = new JLabel(" Discount");
          discount.setFont(new Font("Arial", Font.BOLD, 20));
          discount.setForeground(lpink);
          discount.setSize(100, 20);
          discount.setLocation(100, 250);
          container.add(discount);
 
          Disc = new JCheckBox();
          Disc.setFont(new Font("Arial", Font.PLAIN, 15));
          Disc.setBackground(Color.white);
          Disc.setSize(20, 15);
          Disc.setLocation(250, 250);
          container.add(Disc);

          DelvSch = new JLabel("Delivery");
          DelvSch.setFont(new Font("Arial", Font.BOLD, 20));
          DelvSch.setForeground(lpink);
          DelvSch.setSize(100, 20);
          DelvSch.setLocation(100, 300);
          container.add(DelvSch);
 
          Delv = new JCheckBox();
          Delv.setFont(new Font("Arial", Font.PLAIN, 15));
          Delv.setBackground(Color.white);
          Delv.setSize(20, 15);
          Delv.setLocation(250, 300);
          container.add(Delv);

          add = new JButton("Add");
          add.setFont(new Font("Arial", Font.PLAIN, 15));
          add.setForeground(Color.white);
          add.setBackground(dpink);
          add.setSize(340, 50);
          add.setLocation(100, 350);
          add.addActionListener(this);
          container.add(add);
          
          reset = new JButton("Reset");
          reset.setFont(new Font("Arial", Font.PLAIN, 15));
          reset.setForeground(Color.white);
          reset.setBackground(dpink);
          reset.setSize(340, 50);
          reset.setLocation(100, 400);
          reset.addActionListener(this);
          container.add(reset);

          Calc = new JButton("Calculate Cost");
          Calc.setFont(new Font("Arial", Font.PLAIN, 15));
          Calc.setForeground(Color.white);
          Calc.setBackground(dpink);
          Calc.setSize(340, 50);
          Calc.setLocation(100, 450);
          Calc.addActionListener(this);
          container.add(Calc);
          
          search = new JButton("Check");
          search.setFont(new Font("Arial", Font.PLAIN, 15));
          search.setBackground(new Color(179, 179, 252));
          search.setSize(100, 30);
          search.setLocation(700, 440);
          search.addActionListener(this);
          container.add(search);
  
          
          searchtxt = new JTextField();
          searchtxt.setFont(new Font("Arial", Font.PLAIN, 15));
          searchtxt.setBackground(Color.white);
          searchtxt.setSize(190, 30);
          searchtxt.setLocation(500, 440);
          container.add(searchtxt);
          

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
          
          returnBtn= new JButton   ("Return", back);
          back = new ImageIcon("icons/exit.png");
          returnBtn.setSize(100, 30);
          returnBtn.setLocation(700, 500);
          returnBtn.addActionListener(this);
          container.add(returnBtn);
          setVisible(true);
          
          }


        public void actionPerformed(ActionEvent event){

            if (event.getSource() == add){
                String CusID = pcusid.getText();
                String Quan = pquan.getText();
                String Prod = prod.getText();
                Integer quan = Integer.parseInt(pquan.getText());
                
                //Display errors on pop up window
                //checks the customer file to see if the ID entered is there
                if (validateID(CusID) == false){
                  JOptionPane.showMessageDialog(null, "ID entered does not Exist, Please try again", "WARNING", JOptionPane.WARNING_MESSAGE);
                  pcusid.setBackground(lpink);
                }
                //Check the product file if the product entered is there.
                else if (ValidateProduct(Prod) == false){
                    JOptionPane.showMessageDialog(null, "Product entered is not valid,please enter a valid product or press return to create product", "WARNING", JOptionPane.WARNING_MESSAGE);
                    prod.setBackground(lpink);
                  }
                  // checks that the data entered is an integer.

                else if (isInt(Quan) == false){
                  JOptionPane.showMessageDialog(null, "The Quantity entered includes invalid character(s), Please enter valid quantity", "WARNING", JOptionPane.WARNING_MESSAGE);
                  pquan.setBackground(lpink);
                }
                 //checks to see if the quantity entered for a product is available
                else if (isAvailable(quan,Prod) == false){
                    JOptionPane.showMessageDialog(null, "The quantity Entered is not available please reduce the quantity", "WARNING", JOptionPane.WARNING_MESSAGE);
                    pquan.setBackground(lpink);
                
                }
               

                else{
                //add the product name and quantity to an arraylist
                //that array list is then added to another arrayList for calculations
                //display the message when entries are added
                  String res ="";
                  ArrayList<String> order = new ArrayList<>();
                  order.add(Prod);
                  order.add(Quan);
                  orderlst.add(order);
                  pquan.setText(res);
                  prod.setText(res);
                  JOptionPane.showMessageDialog(null, "Item successfully added to cart", "NOTICE", JOptionPane.INFORMATION_MESSAGE);


                }
                

            }else if (event.getSource() == reset){
                //clear arraylist/customer cart, and other fields
                String res ="";
                pcusid.setText(res);
                pquan.setText(res);
                prod.setText(res);
                Delv.setSelected(false);
                Disc.setSelected(false);
                notify.setText(res);
                searchtxt.setText(res);
                orderlst.clear();
                
            }
            
            
            else if (event.getSource() == returnBtn){
            
            	
                MainMenu.createAndShowGUI();
                container.setVisible(false);
                dispose();
            }
            
            
            else if(event.getSource() == search) {
            	//check the invoice file to for ID number to determine if it's a regular
                String name = searchtxt.getText();
                if (name.isEmpty()){
                  JOptionPane.showMessageDialog(null, "Enter Customer Id to check if it's a regular", "WARNING", JOptionPane.WARNING_MESSAGE);
                }
                
                else {
                	
                	String res ="";
                    if(SearchRegCustomer(name)==true){
                        JOptionPane.showMessageDialog(null, "Customer is a regular, Discount can be applied", "NOTICE", JOptionPane.INFORMATION_MESSAGE);
                    }else{
                        JOptionPane.showMessageDialog(null, "Customer is not a regular,not eligible for Discount", "WARNING", JOptionPane.WARNING_MESSAGE);
                    }
                	searchtxt.setText(res);
                }
            	
            }else if(event.getSource()== Calc){
                Double Itemscost = OrderCalc(orderlst);
                JOptionPane.showMessageDialog(null, "The Total Cost of the Item(s) is: $"+Itemscost+"", "Notice", JOptionPane.INFORMATION_MESSAGE);
                
                String res ="";
                try{
                    //not sure how to put the products name and quantity on the file as yet
                    BufferedWriter writer = new BufferedWriter(new FileWriter(file,true));
                    writer.write(pcusid.getText()+"!"+Itemscost);

                    writer.close();
                }catch(Exception e){return;}
                //clear all fields and empty customer cart
                pcusid.setText(res);
                pquan.setText(res);
                prod.setText(res);
                Delv.setSelected(false);
                Disc.setSelected(false);
                notify.setText(res);
                searchtxt.setText(res);
                orderlst.clear();
            }


          }
          
          
          public boolean ValidateProduct(String p) {
              //goes through the system and compare the input with the product's name ignoring the case
        	  try{
                  BufferedReader reader = new BufferedReader(new FileReader("Products.txt"));
                  String line;
                  int i = 0;
                  java.util.ArrayList<String> f_data = new ArrayList<String>();
                  while((line = reader.readLine()) != null){
                      
                      f_data.add(line);
                      
                      String[] data = f_data.get(i).split("!");
                      if(p.equalsIgnoreCase(data[0])){
                          return true;
                          
                      }
                      i = i + 1;
                  }

                  return false ;
                  
              }catch(Exception e){return false;}
            }
        	  
          

          public boolean isAvailable(int q,String p) {
              //search the product file for the product then compare the quantity demanded to what's available
            try{
                BufferedReader reader = new BufferedReader(new FileReader("Products.txt"));
                String line;
                int i = 0;
                java.util.ArrayList<String> f_data = new ArrayList<String>();
                while((line = reader.readLine()) != null){
                    
                    f_data.add(line);
                    
                    String[] data = f_data.get(i).split("!");
                    if(p.equalsIgnoreCase(data[0])){
                        Integer quan = Integer.parseInt(data[4]);
                        if(q<=quan){
                            return true;
                        
                        }return false;
                       
                    }
                    i = i + 1;
                }

                return false ;
                
            }catch(Exception e){return false;}
            
        }
          
          
          
          public static boolean SearchRegCustomer(String input){
              ////check the invoice file to for ID number to determine 
            try{
                BufferedReader reader = new BufferedReader(new FileReader("Invoices.txt"));
                String line;
                int i = 0;
                List<String> rdata = new ArrayList<String>();
    
                while((line = reader.readLine()) != null){
                    
                    rdata.add(line);
                    
                    String[] invoices = rdata.get(i).split("!");
                    if(input.equals(invoices[0])){
                        return true;
                    }
                    i = i + 1;
                }
                reader.close();
                
            return (false);
            }catch(Exception e){return (false);}
        }

        public Double OrderCalc(ArrayList<ArrayList<String>> cart){
            int i;
            //create an arrayList to only store the prices in 
            ArrayList<Double> prices= new ArrayList<>();
            Double DelvCost = 300.0;
            //goes through the list of arrays [[product,quantity],[product,quantity]]
            for(i=0;i<cart.size();i++){
                String p = getProdPrice(cart.get(i).get(0)); //get String price of product 
                Double price= Double.parseDouble(p);
                Integer quan = Integer.parseInt(cart.get(i).get(1)); //get quantity of product
                Double Itprice = quan*price; //total price of the item
                prices.add(Itprice);
            }
            Double pricebftx = LstCalc(prices); //sum of all prices in the cart
            if(Disc.isSelected()==true){
                //if discount check box is selected, calculate discount which is 3%
                Double dprice = DiscountCalc(pricebftx);
                if(Delv.isSelected()==true){
                    // if delivery is selected, which is a set price of 300
                    Double pricewtdelv = dprice+DelvCost;
                    Double finalprice= TaxCalc(pricewtdelv);//calculate tax at 15%
                    return finalprice;
                }else{
                    Double finalprice= TaxCalc(dprice);
                    return finalprice;
                }
            }else{
                if(Delv.isSelected()==true){
                    Double pricewtdelv = pricebftx+DelvCost;
                    Double finalprice= TaxCalc(pricewtdelv);
                    return finalprice;
                }else{
                    Double finalprice= TaxCalc(pricebftx);
                    return finalprice;
                }
            }// once the check box are selected, calculate button doesn't works not sure why

    
        }
        public Double TaxCalc(Double price){
            double tax = 0.15;
            Double markup= tax*price;
            Double Totalcost = markup+price;
            return Totalcost;
        }
        public Double DiscountCalc(Double price){
            Double disc = 0.03;
            Double markdown= disc*price;
            Double Totalcost= price-markdown;
            return Totalcost;
        }
        public String getProdPrice(String pro){
            //take a product name as the input, goes through the product file and get the price of the product inputted 
            try{
                BufferedReader reader = new BufferedReader(new FileReader("Products.txt"));
                String line;
                int i = 0;
                List<String> lstproduct = new ArrayList<String>();
    
                while((line = reader.readLine()) != null){
                    
                    lstproduct.add(line);
                    
                    String[] product = lstproduct.get(i).split("!");
                    if(pro.equals(product[0])){
                        String price = product[3];
                        return price;
                        
                    }
                    i = i + 1;
                }
                return "Product does not exist!";
                
            }catch(Exception e){return "An Exception Happened";}
            
        }
        public Double LstCalc(ArrayList<Double> prices){
            int i;
            Double sum= 0.0;
            for(i=0;i<prices.size();i++){
                sum+=prices.get(i);
                
            }
            return sum;
        }
          
          
        public boolean validateID(String id) {
            
                try{
                    BufferedReader reader = new BufferedReader(new FileReader("Customers.txt"));
                    String line;
                    int i = 0;
                    List<String> rdata = new ArrayList<String>();
        
                    while((line = reader.readLine()) != null){
                        
                        rdata.add(line);
                        
                        String[] dataFound = rdata.get(i).split("!");
                        if(id.equals(dataFound[6])){
                            return (true);
                        }
                        i = i + 1;
                    }
                    return (false);
                }catch(Exception e){return (false);}
            }
        
    
          
          public  boolean isInt(String number ){
              
        	    try{
        	        Integer.parseInt(number);
        	    }catch(Exception e ){
        	        return false;
        	    }
        	    return true;
        	}
          
    }
