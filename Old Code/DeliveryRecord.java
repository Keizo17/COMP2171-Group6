
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DeliveryRecord extends JFrame implements Comparable<DeliveryRecord>{
	private String address, delivDate;
	private double orderCost;
	private DecimalFormat df = new DecimalFormat("0.00");
	private int id, cusId, index;
	private static int nextid =0;
	
	private JTextField  txtAddress;       //address
	private JTextField  txtCusId;       //customer id
	private JTextField  txtDelivDate;       //delivery date
    private JTextField  txtOrderCost;        //order cost
    
    private JButton     cmdUpdate;
    private JButton     cmdCancel;
    private JButton     cmdClose;

    private JPanel      pnlCommand;
    private JPanel      pnlDisplay;
    
    private ArrayList<DeliveryRecord> schedlist;
    
    private DeliveryRecord d, popUP;
    private DeliverySchedule listing;
    private DeliveryScheduleEdit updater,updateWin;
    
    File schedFile = new File("schedule.txt");
	
	
	public DeliveryRecord (String date, String address, int cusId, double orderCost) {
		this.delivDate = date;
		this.address = address;
		this.cusId = cusId;
		this.orderCost = orderCost;
		id = nextid;
		nextid++;
  	}
	
	public DeliveryRecord (int id,String date, String address, int cusId, double orderCost) {
		this.delivDate = date;
		this.address = address;
		this.cusId = cusId;
		this.orderCost = orderCost;
		this.id = id;
  	}
	
	public int getId()
	{
		return id;
	}
	
	public int getCusId()
	{
		return cusId;
	}
	
	public double getOrderCost()
	{
		return orderCost;
	}
	
	public String getDate()
	{
		return delivDate;
	}

	public String getAddress()
	{
		return address;
	}
	
	public int compareTo(DeliveryRecord other)
	{
		return this.getAddress().compareTo(other.getAddress());
	}
	
	public void setAddress(String adr)
	{
		this.address = adr;
	}
	
	public void setDate(String date)
	{
		this.delivDate = date;
	}
	
	public void setName(int cusId)
	{
		this.cusId = cusId;
	}
	
	public void setOrderCost(double orderCost)
	{
		this.orderCost = orderCost;
	}
	
	public String toString()
	{
		return this.delivDate+" "+this.address +" "+this.cusId+" "+df.format(this.orderCost)+"\n";
	}
	
	public static void resetId()
	{
		nextid=0;
	}
	
	
	public void updateLocalData(int index, DeliveryScheduleEdit updater, DeliveryScheduleEdit updateWin, DeliverySchedule listing, ArrayList<DeliveryRecord> schedlist)
	{
		String currDate = getDate();
		String currAddress = getAddress();
		double currOrderCost = getOrderCost();
		this.schedlist = schedlist;
		this.updater = updater;
		this.updateWin = updateWin;
		this.listing = listing;
		this.index = index;
		d = this;
		d.setBounds(300, 160, 600, 200);
		
		setTitle("Updating Delivery Record");
		
        pnlCommand = new JPanel();
        pnlDisplay = new JPanel();
        
        pnlDisplay.add(new JLabel(("Current delivery date: "+currDate+""))); 
        pnlDisplay.add(new JLabel(("Enter a new delivery date in the format (dd-mm-yyyy) or leave blank to keep current date"))); 
        txtDelivDate = new JTextField(10);
        pnlDisplay.add(txtDelivDate);
        
        pnlDisplay.add(new JLabel(("Current address: "+currAddress+""))); 
        pnlDisplay.add(new JLabel(("Enter a new address or leave blank to keep current address"))); 
        txtAddress = new JTextField(20);
        pnlDisplay.add(txtAddress);
        
        pnlDisplay.add(new JLabel("Current order cost: "+currOrderCost+""));
        pnlDisplay.add(new JLabel("Enter a new order cost or leave blank to keep current order cost"));
        txtOrderCost = new JTextField(9);
        pnlDisplay.add(txtOrderCost);
        
        pnlDisplay.setLayout(new GridLayout(0,1));
       
        cmdUpdate      = new JButton("Update");
        cmdCancel   = new JButton("Cancel");
        
        cmdUpdate.setBackground(Color.green);
        cmdCancel.setBackground(Color.red);
        
        cmdUpdate.addActionListener(new UpdateButtonListener());
        cmdCancel.addActionListener(new CloseButtonListener()); 

        pnlCommand.add(cmdUpdate);
        pnlCommand.add(cmdCancel);
        add(pnlDisplay, BorderLayout.CENTER);
        add(pnlCommand, BorderLayout.SOUTH);
        pack();
        setVisible(true);
	}
	
	public boolean validateDate(String date) {
		int[] dateArr = new int[3];
		if (date.length() == 10) {
			String[] dateNumbers = date.split("-");
			System.out.print(dateNumbers);
			for (int i = 0; i<dateNumbers.length; i++) {
				try {
					dateArr[i] = Integer.parseInt(dateNumbers[i]);
				}catch (NumberFormatException e) {}
			}
			if ((dateArr[0]>0 && dateArr[0]<32) && (dateArr[1] == 1 || dateArr[1] == 3 || dateArr[1] == 5 || 
					dateArr[1] == 7 || dateArr[1] == 8 || dateArr[1] == 10 || dateArr[1] == 12)) {
				return true;
			}
			else if ((dateArr[0]>0 && dateArr[0]<31) && (dateArr[1] == 4 || dateArr[1] == 6 || dateArr[1] == 9 || 
					dateArr[1] == 11)) {
				return true;
			}else if ((dateArr[0]>0 && dateArr[0]<29) && (dateArr[1] == 2) || 
					(dateArr[0]>0 && dateArr[0]<30) && (dateArr[1] == 2 && dateArr[2]%4 == 0 && dateArr[2]%100 != 0)) {
				
			}else {
				return false;
			}
		}
		return false;
	}
	
	private DeliveryRecord(String input) {
		pnlCommand = new JPanel();
        pnlDisplay = new JPanel();
        pnlDisplay.add(new JLabel("Invalid "+input+" input format.")); 
        this.popUP = this;
        popUP.setBounds(350, 200, 600, 200);
        
        cmdClose   = new JButton("Close");
     
        cmdClose.setBackground(Color.white);
        
        
        cmdClose.addActionListener(new CloseButtonListener()); 

        pnlCommand.add(cmdClose);
        
        add(pnlDisplay, BorderLayout.CENTER);
        add(pnlCommand, BorderLayout.SOUTH);
        pack();
        setVisible(true);
	}
	
	private class CloseButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent a)
        {
        	if (a.getSource() == cmdCancel)
        		d.dispose();
        	else
        		popUP.dispose();
        		
        }

    }
	
	private class UpdateButtonListener implements ActionListener{
    	public void actionPerformed(ActionEvent a) { //listener for Update button, initiates when button is clicked
    		String delivDate = txtDelivDate.getText(), address = txtAddress.getText(), text = txtOrderCost.getText(); // storing text field values
    		double orderCost = -1;
        		if (delivDate.equals(""))
        			delivDate = getDate();
        		else if (validateDate(delivDate) == false) 
        			new DeliveryRecord("date");
        		
        		if (text.equals(""))
            		orderCost = getOrderCost();
            	else
            		try {
            			orderCost = Double.parseDouble(text);
            		}catch (NumberFormatException ex) {
            			new DeliveryRecord("order cost");
            		}
        		
        		if (address.equals(""))
            		address = getAddress();
        		
            	txtAddress.setText("");
            	txtDelivDate.setText("");
            	txtOrderCost.setText("");
            	
            	if (validateDate(delivDate) == true && orderCost > -1) 
            	try{
            		BufferedWriter writer = new BufferedWriter(new FileWriter(schedFile,false));
            		schedlist.set(index, new DeliveryRecord(id, delivDate, address, getCusId(),orderCost));
            		listing.schedFile.delete();
            		for (int i = 0; i < schedlist.size(); i++) {
            			writer.write(schedlist.get(i).toString());
            		}
                    writer.close();
                    listing.refresh(schedlist);
            		d.dispose(); // close current window
            	}catch (Exception e) {}
        }
    }
}
