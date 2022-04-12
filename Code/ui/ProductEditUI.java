package ui;

import java.util.*;
import java.util.List;
import javax.swing.*;

import controller.ProductEditController;
import controller.ProductRegisterController;

import java.awt.*;
import java.awt.event.*;


public class ProductEditUI extends JFrame implements ActionListener{
	private boolean valid;

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
    private JTextField searchbar;
    

    private JButton submitBtn;
    private JButton resetBtn;
    private JButton searchBtn;
    private JButton backBtn;
    private Icon backIcon;
    private JTextArea notify;


    Color lpink = (new  Color(250, 200, 250));
    Color dblue = (new  Color(10, 10, 15));
    Color dblue2 = (new  Color(21, 21, 31));
    Color dpink = (new  Color(255, 30, 75));

    public void findProduct(){
        


        setTitle("TCurly Sales Manager");
        setBounds(300, 90, 900, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        container = getContentPane();
        container.setBackground(dblue);
        container.setLayout(null);

          title = new JLabel("Edit Product Record");
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

          searchBtn = new JButton("Search ID");
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
          backBtn.addActionListener(this);
          backBtn.setSize(100, 70);
          backBtn.setBackground(lpink);
          backBtn.setLocation(700, 500);
          container.add(backBtn);

        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent event){
    	String oldname = searchbar.getText();
    	
        if (event.getSource() == submitBtn){
        	if (oldname.isEmpty()){
        		notify.setText("Please search for the product you would like to edit.");
        	}else { 
        		valid = new ProductEditController().updateProduct(pname.getText(), pbrand.getText(), pprice.getText(), 
            		pstockc.getText(), pdesc.getText(), oldname);
        	    if(valid == false) {
        	    	System.out.println("Something went wrong...");
        	    }else{
        	    	String res ="";
        	    	pname.setText(res);
        	    	pbrand.setText(res);
        	    	pprice.setText(res);
        	    	pstockc.setText(res);
        	    	pdesc.setText(res);  
        	    }
        	}
        }else if (event.getSource() == resetBtn){
              String res ="";
              pname.setText(res);
              pbrand.setText(res);
              pprice.setText(res);
              pstockc.setText(res);
              pdesc.setText(res);
              notify.setText(res);
        }else if (event.getSource() == backBtn){	
            MainMenu.createAndShowGUI();
            container.setVisible(false);
            dispose();
        }else{
        
        	if (oldname.isEmpty()){
        		notify.setText("Please enter the ID you would like to search.");
        	}else {
        		String blank ="";
        		pname.setText(blank);
        		pbrand.setText(blank);
        		pdesc.setText(blank);
        		pprice.setText(blank);
        		pstockc.setText(blank);
            
        		notify.setText(new ProductEditController().findID(oldname));
        		}
        	
        }
    }
}
