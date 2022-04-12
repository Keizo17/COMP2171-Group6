package ui;

import javax.swing.*;

import controller.CustomerRegisterController;

import java.awt.*;
import java.awt.event.*;

public class CustomerRegisterUI extends JFrame implements ActionListener {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private boolean valid;
	
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
    
    private JButton submitBtn;
    private JButton resetBtn;
    private JButton backBtn;
    private Icon backIcon;
    private JTextArea notify;


    Color lpink = (new  Color(250, 200, 250));
    Color dblue = (new  Color(10, 10, 15));
    Color dblue2 = (new  Color(21, 21, 31));
    Color dpink = (new  Color(255, 30, 75));

    public void addCustomerUI(){
        


        setTitle("TCurly Sales Manager");
        setBounds(300, 90, 900, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        container = getContentPane();
        container.setBackground(dblue);
        container.setLayout(null);

          title = new JLabel("New Customer");
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

	   String res ="";
       if (event.getSource() == submitBtn){
           valid = new CustomerRegisterController().createCustomer(fNameField.getText(), lNameField.getText(), ageField.getText()
        		   , addressField.getText(), pNumField.getText(), emailField.getText(), idField.getText());
           if(valid == false) {
        	   notify.setText("Something went wrong...");
           }
           else{
        	   
             fNameField.setText(res);
             lNameField.setText(res);
             emailField.setText(res);
             pNumField.setText(res);
             addressField.setText(res);
             ageField.setText(res);
             idField.setText(res);  
             }
       }else if (event.getSource() == resetBtn){
             
             fNameField.setText(res);
             lNameField.setText(res);
             emailField.setText(res);
             pNumField.setText(res);
             addressField.setText(res);
             ageField.setText(res);
             idField.setText(res);
       }else if (event.getSource() == backBtn){	
    	   
           MainMenu.createAndShowGUI();
           container.setVisible(false);
           dispose();
       }

     }

}