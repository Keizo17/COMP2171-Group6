package logic;

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

import ui.DeliveryScheduleEditUI;
import ui.DeliveryScheduleUI;

public class deliveryRecord extends JFrame implements Comparable<deliveryRecord>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String address, cusId;
	private double orderCost;
	private DecimalFormat df = new DecimalFormat("0.00");
	private int id, index;
	private static int nextid =0;
	
	private JTextField  txtAddress;       //address
	private JTextField  txtDelivDate;       //delivery date
    private JTextField  txtOrderCost;        //order cost
    
    private JButton     cmdUpdate;
    private JButton     cmdCancel;
    private JButton     cmdClose;

    private JPanel      pnlCommand;
    private JPanel      pnlDisplay;
    
    private ArrayList<deliveryRecord> schedlist;
    
    private deliveryRecord d, popUP;
    private DeliveryScheduleUI listing;
    private DeliveryScheduleEditUI updater,updateWin;
    
    File schedFile = new File("schedule.txt");
	
	
	public deliveryRecord (String address, String cusId, double orderCost) {
		this.address = address;
		this.cusId = cusId;
		this.orderCost = orderCost;
		id = nextid;
		nextid++;
  	}
	
	public deliveryRecord (int id, String address, String cusId, double orderCost) {
		this.address = address;
		this.cusId = cusId;
		this.orderCost = orderCost;
		this.id = id;
  	}
	
	public int getId()
	{
		return id;
	}
	
	public String getCusId()
	{
		return cusId;
	}
	
	public double getOrderCost()
	{
		return orderCost;
	}

	public String getAddress()
	{
		return address;
	}
	
	public int compareTo(deliveryRecord other)
	{
		return this.getAddress().compareTo(other.getAddress());
	}
	
	public void setAddress(String adr)
	{
		this.address = adr;
	}
	
	public void setName(String cusId)
	{
		this.cusId = cusId;
	}
	
	public void setOrderCost(double orderCost)
	{
		this.orderCost = orderCost;
	}
	
	public String toString()
	{
		return this.address +"!"+this.cusId+"!"+df.format(this.orderCost)+"\n";
	}
	
	public static void resetId()
	{
		nextid=0;
	}
	
	
	public void updateLocalData(int index, DeliveryScheduleEditUI updater, DeliveryScheduleEditUI updateWin,
			DeliveryScheduleUI listing, ArrayList<deliveryRecord> schedlist)
	{
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
	
	private deliveryRecord(String input) {
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
    		String address = txtAddress.getText(), text = txtOrderCost.getText(); // storing text field values
    		double orderCost = -1;
        		
        		if (text.equals(""))
            		orderCost = getOrderCost();
            	else
            		try {
            			orderCost = Double.parseDouble(text);
            		}catch (NumberFormatException ex) {
            			new deliveryRecord("order cost");
            		}
        		
        		if (address.equals(""))
            		address = getAddress();
        		
            	txtAddress.setText("");
            	txtDelivDate.setText("");
            	txtOrderCost.setText("");
            	
            	if (orderCost > -1) 
            	try{
            		BufferedWriter writer = new BufferedWriter(new FileWriter(schedFile,false));
            		schedlist.set(index, new deliveryRecord(id, address, getCusId(),orderCost));
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
