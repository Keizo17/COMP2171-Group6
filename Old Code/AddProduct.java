import java.util.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.*;


public class AddProduct extends JFrame implements ActionListener {
	  
	  File file = new File("Products.txt");
	  
      private Container container;
      private JLabel title;
      
      private JLabel name;
      private JTextField pname;
      
      private JLabel brand;
      private JTextField pbrand;
      
      private JLabel desc;
      private JTextArea pdesc;
      
      private JLabel price;
      private JTextField pprice;
      
      private JLabel stockc;
      private JTextField pstockc;
      
      private JTextField searchtxt;
      
      
      private JButton submit;
      private JButton reset;
      private JButton search;
      private JButton returnBtn;
      private Icon back;
      private JTextArea notify;
      
      Color lpink = (new  Color(250, 200, 250));
      Color dblue = (new  Color(10, 10, 15));
      Color dblue2 = (new  Color(21, 21, 31));
      Color dpink = (new  Color(255, 30, 75));
      
      
      
      
    //Search
      public Product pProductSearch(String pname) {
        	  try{
                  BufferedReader reader = new BufferedReader(new FileReader(file));
                  String line;
                  int i = 0;
                  java.util.ArrayList<String> f_data = new ArrayList<String>();
                  while((line = reader.readLine()) != null){
                      
                      f_data.add(line);
                      
                      String[] data = f_data.get(i).split("!");
                      if(pname.equalsIgnoreCase(data[0])){
                    	  
                    	  Product fp = new Product(data[0],data[1],data[2],data[3],data[4]);
                          return fp;
                          
                      }
                      i = i + 1;
                  }

                  Product nfp = new Product("Not Found") ;
                  return nfp;
                  
              }catch(Exception e){return new Product("Not Found");}
        	  
          }

      //Search

      public AddProduct() {
    	  
    	  

          setTitle("T’Curly Sales Manager");
          setBounds(300, 90, 900, 600);
          setDefaultCloseOperation(EXIT_ON_CLOSE);
          setResizable(false);

          container = getContentPane();
          container.setBackground(dblue);
          container.setLayout(null);
         

          title = new JLabel("New Product");
          title.setFont(new Font("Arial", Font.BOLD, 35));
          title.setSize(300, 30);
          title.setLocation(300, 30);
          title.setForeground(dpink);
          container.add(title);

          name = new JLabel("Name");
          name.setFont(new Font("Arial", Font.BOLD, 20));
          name.setForeground(lpink);
          name.setSize(150, 20);
          name.setLocation(100, 100);
          container.add(name);
 
          pname = new JTextField();
          pname.setFont(new Font("Arial", Font.PLAIN, 15));
          pname.setBackground(Color.white);
          pname.setSize(190, 20);
          pname.setLocation(250, 100);
          container.add(pname);
          
          brand = new JLabel("Brand");
          brand.setFont(new Font("Arial", Font.BOLD, 20));
          brand.setForeground(lpink);
          brand.setSize(100, 20);
          brand.setLocation(100, 150);
          container.add(brand);
 
          pbrand = new JTextField();
          pbrand.setFont(new Font("Arial", Font.PLAIN, 15));
          pbrand.setBackground(Color.white);
          pbrand.setSize(190, 20);
          pbrand.setLocation(250, 150);
          container.add(pbrand);

          desc = new JLabel("Details");
          desc.setFont(new Font("Arial", Font.BOLD, 20));
          desc.setForeground(lpink);
          desc.setSize(100, 20);
          desc.setLocation(100, 200);
          container.add(desc);
 
          pdesc = new JTextArea();
          pdesc.setFont(new Font("Arial", Font.PLAIN, 15));
          pdesc.setBackground(Color.white);
          pdesc.setSize(190, 80);
          pdesc.setLocation(250, 200);
          pdesc.setLineWrap(true);
          container.add(pdesc);

          price = new JLabel("Price");
          price.setFont(new Font("Arial", Font.BOLD, 20));
          price.setForeground(lpink);
          price.setSize(100, 20);
          price.setLocation(100, 300);
          container.add(price);
 
          pprice = new JTextField();
          pprice.setFont(new Font("Arial", Font.PLAIN, 15));
          pprice.setBackground(Color.white);
          pprice.setSize(190, 20);
          pprice.setLocation(250, 300);
          container.add(pprice);
          
          stockc = new JLabel("# in Stock");
          stockc.setFont(new Font("Arial", Font.BOLD, 20));
          stockc.setForeground(lpink);
          stockc.setSize(100, 20);
          stockc.setLocation(100, 350);
          container.add(stockc);
 
          pstockc = new JTextField();
          pstockc.setFont(new Font("Arial", Font.PLAIN, 15));
          pstockc.setBackground(Color.white);
          pstockc.setSize(190, 20);
          pstockc.setLocation(250, 350);
          container.add(pstockc);


          submit = new JButton("Submit");
          submit.setFont(new Font("Arial", Font.PLAIN, 15));
          submit.setForeground(dpink);
          submit.setBackground(lpink);
          submit.setSize(340, 50);
          submit.setLocation(100, 450);
          submit.addActionListener(this);
          container.add(submit);
          
          reset = new JButton("Reset");
          reset.setFont(new Font("Arial", Font.PLAIN, 15));
          reset.setForeground(Color.white);
          reset.setBackground(dpink);
          reset.setSize(340, 50);
          reset.setLocation(100, 520);
          reset.addActionListener(this);
          container.add(reset);
          
          search = new JButton("Search");
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
          returnBtn.setLocation(700, 540);
          returnBtn.addActionListener(this);
          container.add(returnBtn);
          setVisible(true);
          
          }


          public void actionPerformed(ActionEvent event){
        	  
        	File file = new File("Products.txt");

            if (event.getSource() == submit){
                String n = pname.getText();
                String brand = pbrand.getText();
                String desc = pdesc.getText();
                String price = pprice.getText();
                String stock = pstockc.getText();
                
          

                if (validateName(n) == false){
                  notify.setText("Name not valid, please enter a valid product name!");
                }

                else if (isInt(price) == false){
                  notify.setText("The price includes invalid character(s). Please enter a valid price");
                }
                
                else if (isInt(stock) == false){
                    notify.setText("The stock number includes invalid character(s). Please enter a valid number");
                  }

                else if (Integer.valueOf(stock)  == 0){
                  notify.setText("You cannot add a product that is not in stock");
                }
               

                else{
                  String res ="";
                  pname.setText(res);
                  pbrand.setText(res);
                  pprice.setText(res);
                  pstockc.setText(res);
                  pdesc.setText(res);

                  Product p = new Product(n,brand,desc,price,stock);
                  System.out.println(p);
                  
                  String searchR=productSearch(p.getPname());
                  
                  if (searchR == ("Product not found, fill all fields and press submit to add it!") || productSearch(p.getPname()) == ("") ){
                	  
                	  try{
                          BufferedWriter writer = new BufferedWriter(new FileWriter(file,true));
                          writer.write(p.getPname() +"!"+ p.getPbrand()+ "!" +p.getPdesc()+ "!" +p.getPprice()+ "!" +p.getStockCount() + "\n");

                          writer.close();
                      }catch(Exception e){return;}
                	  
                	  String stocknotif = "";
                	  
                	  if (Integer.valueOf(p.getStockCount())  <= 10){
                		  
                		  stocknotif = "There are less than 10 of this product available. Please rememeber to restock";
                        }
                	  notify.setText("Product added :" + "\n" + p + "\n" + stocknotif);
                	 
                  }
                  
                  else{
                	  
                	  notify.setText("Product already exists. See details :" + "\n" + searchR);

                    
                  }

                }
                

              }


            else if (event.getSource() == reset){
                  String res ="";
                  pname.setText(res);
                  pbrand.setText(res);
                  pprice.setText(res);
                  pstockc.setText(res);
                  pdesc.setText(res);
                  notify.setText(res);
                  searchtxt.setText(res);
            }
            
            
            else if (event.getSource() == returnBtn){
            
            	
                MainMenu.createAndShowGUI();
                container.setVisible(false);
                dispose();
            }
            
            
            else if(event.getSource() == search) {
            	
                String name = searchtxt.getText();
                if (name.isEmpty()){
                  notify.setText("Please enter a product name to search!");
                }
                
                else {
                	
                	String res ="";
                	pname.setText(res);
                    pbrand.setText(res);
                    pprice.setText(res);
                    pstockc.setText(res);
                    pdesc.setText(res);
                    
                    notify.setText(productSearch(name));
                	
                }
            	
            }//end


          }
          
          
          public String productSearch(String p) {
        	  try{
                  BufferedReader reader = new BufferedReader(new FileReader(file));
                  String line;
                  int i = 0;
                  java.util.ArrayList<String> f_data = new ArrayList<String>();
                  while((line = reader.readLine()) != null){
                      
                      f_data.add(line);
                      
                      String[] data = f_data.get(i).split("!");
                      if(p.equalsIgnoreCase(data[0])){
                    	  
                    	  Product fp = new Product(data[0],data[1],data[2],data[3],data[4]);
                          return fp.toString();
                          
                      }
                      i = i + 1;
                  }

                  return "Product not found, fill all fields and press submit to add it!" ;
                  
              }catch(Exception e){return "";}
        	  
          }
          
          
          
          
          
          
          public boolean validateName(String name) {
              char[] chars = name.toCharArray();
              for (char c : chars) {
                  if((!Character.isLetter(c) && !(c=='-') && !(c==' '))) {
                      return false;
                  }
              }
              return true;
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

	/*Product examples :
	
	Wild Growth Hair Oil
	Wild Growth
	Hair Oil
	$1700
	20

	Maui Moisture Heal & Hydrate + Shea Butter Hair Mask
	Maui Moisture Hair Care
	Repairs dry, damaged hair. Infused with Shea Butter, Coconut Oil and Macadamia Oil
	$1700
	7

	Mielle Avocado Moisturizing Hair Milk 
	Mielle Organics 
	Moisturizes and hydrates dry, thirsty hair. Great for smoothing and softening the hair for moisture and manageability. 
	$2300
	5

	Aussie Miracle Moist Shampoo
	Aussie
	Cleanses and hydrates hair for nourished and manageable hair
	$1250
	6

	Aussie Miracle Moist Conditioner 
	Aussie
	Conditions and softens hair to improve manageability 
	$1250
	6

	Cream of Nature Pure Honey Texturizing Curl Setting Lotion 
	Cream of Nature
	Defines curls, providing a lasting firm old without the hard crunchy feel
	$950
	3 */

	      