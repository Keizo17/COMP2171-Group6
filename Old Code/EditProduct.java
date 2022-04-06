import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class EditProduct extends JFrame{ //SAM means Search and Modify

	private AddProduct Aprod;
	
	private Product fp;
	private JFrame searchFrame;
	private JFrame editFrame;
    private JPanel notificationPanel;
    private JPanel editPanel;
    
	private JFrame edit1Frame;
    private JLabel notification1;
    private JPanel newGUI;
    
	private JFrame NameFrame;
    private JLabel NameLabel;
    private JPanel NamePanel;
    private JTextField NameBar;
    
    private JFrame AFrame;
    private JLabel ALabel;
    private JPanel APanel;
    private JTextField ABar;
    
    private JFrame BFrame;
    private JLabel BLabel;
    private JPanel BPanel;
    private JTextField BBar;
    
    private JFrame CFrame;
    private JLabel CLabel;
    private JPanel CPanel;
    private JTextField CBar;
    
    private JFrame DFrame;
    private JLabel DLabel;
    private JPanel DPanel;
    private JTextField DBar;
    
    private JPanel buttonPanel;
    private JPanel button1Panel;
    private JButton edit;
    private JButton update;
    private JButton delete;
    private JButton exit;
    private JButton search;
    private JButton close;
    private JButton nameButton;
    private JButton descButton;
    private JButton brandButton;
    private JButton amntButton;
    private JButton costButton;
    private JTextArea notify;

    private JTextField searchbar;
    private JPanel searchPanel;
    private JLabel notification;
    //private ArrayList <Product> dat;
    
    File file = new File("Products.txt");
    public EditProduct(){
    	       
    	
        notificationPanel = new JPanel();
        editPanel = new JPanel();
        buttonPanel = new JPanel();
        
        search = new JButton("Search");
        search.setBackground(Color.WHITE);
        search.addActionListener(new SearchButtonListener());
        
        close = new JButton("Exit");
        close.setBackground(Color.WHITE);
        close.addActionListener(new CloseButtonListener());
        
        buttonPanel.add(search);
        buttonPanel.add(close);
        
        searchFrame = new JFrame();
        searchFrame.setForeground(Color.BLACK);
        searchFrame.setFont(new Font("Gill Sans MT", Font.PLAIN, 12));
        searchFrame.setBackground(Color.WHITE);
        searchFrame.getContentPane().add(notificationPanel,BorderLayout.WEST);
        
        notification = new JLabel(" ");
        searchFrame.getContentPane().add(notification, BorderLayout.CENTER);
        
        searchPanel = new JPanel();
        searchFrame.getContentPane().add(searchPanel, BorderLayout.NORTH);
        
        JLabel label = new JLabel("Enter Product Name:");
        searchPanel.add(label);
        
        searchbar = new JTextField(20);
        searchPanel.add(searchbar);
        searchFrame.getContentPane().add(buttonPanel,BorderLayout.PAGE_END);
        searchFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        searchFrame.setTitle("Search Product");
        searchFrame.setVisible(true);
        searchFrame.setBounds(100,100,100,100);
        searchFrame.setSize(350,125);
        searchFrame.pack();
        searchFrame.setResizable(false);
        
        editPanel = new JPanel();      
        editPanel.setSize(500,500);
        editFrame = new JFrame();
        editFrame.setBounds(100,100,350,300);
        editFrame.getContentPane().setLayout(new BorderLayout(0, 0));
        editFrame.getContentPane().add(editPanel);
        editPanel.setLayout(new GridLayout(0, 1, 0, 0));
        
        notify = new JTextArea();
        //editFrame.getContentPane().add(notify);
        notify.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        
        notify.setFont(new Font("Arial", Font.PLAIN, 15));
        notify.setBackground( Color.lightGray );
        notify.setLineWrap(true);
        notify.setEditable(false);
        editPanel.add(notify);
        
        button1Panel = new JPanel();
        editFrame.getContentPane().add(button1Panel,BorderLayout.SOUTH);
        //editPanel.setBackground(Color.red);
        edit = new JButton("Edit");
        
        edit.setBackground(Color.white);
        edit.addActionListener(new EditButtonListener());
        
        delete = new JButton("Delete");
        
        delete.setBackground(Color.white);
        delete.addActionListener(new DeleteButtonListener());
        update = new JButton("Update");
        
        update.setBackground(Color.white);
        update.addActionListener(new UpdateButtonListener());
        
        exit = new JButton("Close");
        
        exit.setBackground(Color.white);
        exit.addActionListener(new Close1ButtonListener());
        button1Panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        //button1Panel.add(edit);
        //button1Panel.add(delete);
        button1Panel.add(update);
        button1Panel.add(exit);
        //button1Panel.setBackground(Color.blue);
        editFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        editFrame.setTitle("Product");
        editFrame.setVisible(false);
        editFrame.setResizable(false);
    }

    private class CloseButtonListener implements ActionListener{
    	
        public void actionPerformed(ActionEvent e){
        	
            searchFrame.dispose();
        }
    }    
    
    private class Close1ButtonListener implements ActionListener{
    	
        public void actionPerformed(ActionEvent e){
        	
            dispose();
            
        }
    }    

    private class DeleteButtonListener implements ActionListener{
    	
    	public void actionPerformed(ActionEvent e) {
    		
    		notify.setEditable(true);
    		notify.setBackground( Color.white);
    	}
    }
    
    private class SearchButtonListener implements ActionListener{
    	
        public void actionPerformed(ActionEvent e){
        	
        	String name = searchbar.getText();
        	productSearch(name);
        	
        	if (name.isEmpty()) {
        		
        		notification.setText("Text field is empty!!");
        	}
        	else {
        		searchbar.setText(null);
        	}
        }
    }
    
    private class EditButtonListener implements ActionListener{
    	
    	public void actionPerformed(ActionEvent e) {
    		
    		notify.setEditable(true);
    		notify.setBackground( Color.white);
    		
    	}
    }
    
    
    private class UpdateButtonListener implements ActionListener{
    	
    	public void actionPerformed(ActionEvent e) {
    		//Aprod = new AddProduct();
    		System.out.println(getFP());
    		
    	}
    }

    
    private class nameButtonListener implements ActionListener{
    	
    	public void actionPerformed(ActionEvent e) {
    		NameFrame = new JFrame();
	  		NamePanel = new JPanel();
	  		NameBar = new JTextField(20);
	  		NameLabel = new JLabel(" Edit Name ");
	  		
	  		NamePanel.add(NameLabel);
	  		NamePanel.add(NameBar);
	  		NameFrame.add(NamePanel);
	  		NameFrame.add(button1Panel,BorderLayout.SOUTH);
	  		NameFrame.setVisible(true);
    		
    	}
    }
    
    private class brandButtonListener implements ActionListener{
    	
    	public void actionPerformed(ActionEvent e) {
    		
    		BFrame = new JFrame();
	  		BPanel = new JPanel();
	  		BBar = new JTextField(20);
	  		BLabel = new JLabel(" Edit Brand ");
	  		
	  		BPanel.add(BLabel);
	  		BPanel.add(BBar);
	  		BFrame.add(BPanel);
	  		BFrame.add(button1Panel,BorderLayout.SOUTH);
	  		BFrame.setVisible(true);
    		
    	}
    }
    
    private class descButtonListener implements ActionListener{
    	
    	public void actionPerformed(ActionEvent e) {
    		
    		DFrame = new JFrame();
	  		DPanel = new JPanel();
	  		DBar = new JTextField(20);
	  		DLabel = new JLabel(" Edit Description ");
	  		
	  		DPanel.add(DLabel);
	  		DPanel.add(DBar);
	  		DFrame.add(DPanel);
	  		DFrame.add(button1Panel,BorderLayout.SOUTH);
	  		DFrame.setVisible(true);
    		
    	}
    }
    
    private class costButtonListener implements ActionListener{
    	
    	public void actionPerformed(ActionEvent e) {
    		
    		CFrame = new JFrame();
	  		CPanel = new JPanel();
	  		CBar = new JTextField(20);
	  		CLabel = new JLabel(" Update Cost ");
	  		
	  		CPanel.add(CLabel);
	  		CPanel.add(CBar);
	  		CFrame.add(CPanel);
	  		CFrame.add(button1Panel,BorderLayout.SOUTH);
	  		CFrame.setVisible(true);
    		
    	}
    }
    
    private class amntButtonListener implements ActionListener{
    	
    	public void actionPerformed(ActionEvent e) {
    		
    		AFrame = new JFrame();
	  		APanel = new JPanel();
	  		ABar = new JTextField(20);
	  		ALabel = new JLabel(" Update Stock ");
	  		
	  		
	  		APanel.add(ALabel);
	  		APanel.add(ABar);
	  		AFrame.add(APanel);
	  		AFrame.add(button1Panel,BorderLayout.SOUTH);
	  		AFrame.setBounds(100,100,300,150);
	  		AFrame.setVisible(true);
    		
    	}
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
    
    public String productSearch(String p) {
  	  try{
            BufferedReader read = new BufferedReader(new FileReader(file));
            String line;
            int i = 0;
            java.util.ArrayList<String> f_data = new ArrayList<String>();
            while((line = read.readLine()) != null){
                
                f_data.add(line);
                
                String[] data = f_data.get(i).split("!");
                if(p.equalsIgnoreCase(data[0])){
              	  
                	
                	//prompt ask user what they want to edit in another GUI
                	//use buttons 1,2,3,4,5
                	edit1Frame = new JFrame();
                	newGUI = new JPanel();
                	notification1 = new JLabel("What would you like to edit?");
                	nameButton = new JButton("Name");
                	nameButton.addActionListener(new nameButtonListener());
                	brandButton = new JButton("Brand");
                	brandButton.addActionListener(new brandButtonListener());
                	descButton = new JButton("Description");
                	descButton.addActionListener(new descButtonListener());
                	costButton = new JButton("Cost");
                	costButton.addActionListener(new costButtonListener());
                	amntButton = new JButton("Amount");
                	amntButton.addActionListener(new amntButtonListener());
                	
                	newGUI.add(notification1);
                	newGUI.add(nameButton);
                	newGUI.add(brandButton);
                	newGUI.add(descButton);
                	newGUI.add(costButton);
                	newGUI.add(amntButton);
                	
                	
                	
                	
                	//newGui.add(backButton);
                	edit1Frame.add(newGUI);
                	edit1Frame.setDefaultCloseOperation(3);
                	System.out.println("What would you like to Edit?");
                	System.out.println("name\nbrand\ndescription\ncost\namount");
                	
                	//if name.... create a gui that changes the name etc...
                	
              	  	Product fp = new Product(data[0],data[1],data[2],data[3],data[4]);
              	  	
              	  	

              	  //System.out.println(data);
              	  
              	  notification.setText(" ");
              	  notify.setText(fp.toString());
              	  edit1Frame.setVisible(true);
              	  
              	  
              	  
              	  read.close();
              	  
              	  return fp.toString();
                    
                }
                i = i + 1;
            }
            
            notification.setText("Product not found!");
            read.close();
            return "Product not found!" ;
        }catch(Exception ex){
        	return "";
        	}
  	  }
    
    public String getFP(){
    	return productSearch(getName());
    }
}
