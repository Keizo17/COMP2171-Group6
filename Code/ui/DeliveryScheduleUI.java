package ui;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import logic.deliveryRecord;

public class DeliveryScheduleUI extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static JFrame	frame;
	
	private DecimalFormat df = new DecimalFormat("0.00");
	
	private JButton		cmdEditDelivery;
    private JButton     cmdClose;
    private JButton     cmdSortAddress;
    private JButton     cmdSortCusId;
    private JButton     cmdSortOrderCost;
  
    private JPanel      pnlCommand;
    private ArrayList<deliveryRecord> deliverylist;
    private DeliveryScheduleUI thisList;
    private JScrollPane scrollPane;

    private JTable table;
    private DefaultTableModel model;
    
    public File schedFile = new File("schedule.txt");
    //Creates a file object using a predetermined file

    public DeliveryScheduleUI() {
        super(new GridLayout(2,1));
        thisList = this;
        
        frame.setBounds(250, 150, 600, 200);
        pnlCommand = new JPanel();
        new JPanel();

        deliverylist= loadSchedule(schedFile);
        String[] columnNames=  {"ID#",
        		"Address",
        		"Customer ID#",
                "Order Cost"};
        model=new DefaultTableModel(columnNames,0);
        table = new JTable(model);
        table.setEnabled(false);
        showTable(deliverylist);

        table.setPreferredScrollableViewportSize(new Dimension(600, deliverylist.size()*15 +50));
        table.setFillsViewportHeight(true);

        scrollPane = new JScrollPane(table);
       
        add(scrollPane);
        
        cmdEditDelivery  = new JButton("Edit Delivery Record");
        cmdSortAddress  = new JButton("Sort by Address");
        cmdSortCusId  = new JButton("Sort by Customer ID");
        cmdSortOrderCost  = new JButton("Sort by Order Cost");
        cmdClose   = new JButton("Close");

        cmdEditDelivery.addActionListener(new EditDeliveryButtonListener());
        cmdSortAddress.addActionListener(new SortAddressButtonListener());
        cmdSortCusId.addActionListener(new SortCustomerIDButtonListener());
        cmdSortOrderCost.addActionListener(new SortOrderCostButtonListener());
        cmdClose.addActionListener(new CloseButtonListener());
        
        cmdEditDelivery.setBackground(Color.yellow);
        cmdSortAddress.setBackground(Color.white);
        cmdSortCusId.setBackground(Color.white);
        cmdSortOrderCost.setBackground(Color.white);
        cmdClose.setBackground(Color.red);
        pnlCommand.setBackground(Color.white);
        
        pnlCommand.add(cmdEditDelivery);
        pnlCommand.add(cmdSortAddress);
        pnlCommand.add(cmdSortCusId);
        pnlCommand.add(cmdSortOrderCost);
        pnlCommand.add(cmdClose);
       
        add(pnlCommand);
    }

    private void showTable(ArrayList<deliveryRecord> schedlist)
    {
    	for(int i = 0; i<schedlist.size(); i++) {
    		  addToTable(schedlist.get(i));
         }
    }
    private void addToTable(deliveryRecord d)
    {
        String address = d.getAddress();
        String[] item={""+ d.getId(), address,""+ d.getCusId(),"" + df.format(d.getOrderCost())};
        model.addRow(item);        

    }

    static void createAndShowGUI() {
        //Create and set up the window.
        frame = new JFrame("T'Curly Delivery Schedule");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        //Create and set up the content pane.
        DeliveryScheduleUI newContentPane = new DeliveryScheduleUI();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
        
    }

    private ArrayList<deliveryRecord> loadSchedule(File schedFile) //Extracts data as an arraylist
    {
        ArrayList<deliveryRecord> schedlist = new ArrayList<deliveryRecord>();
        try
        {
        	Scanner dscan = new Scanner(schedFile);
            while(dscan.hasNextLine())
            {
                String [] nextLine = dscan.nextLine().split("!");
                String address = nextLine[0];
                String cusId = nextLine[1];
                double orderCost = Double.parseDouble(nextLine[2]);
                deliveryRecord d = new deliveryRecord(address,cusId , orderCost);
                schedlist.add(d);
            }

            dscan.close();
        }
        catch(NullPointerException | FileNotFoundException e)
        {}
        return schedlist;
    }
    
    public class EditDeliveryButtonListener implements ActionListener{
    	public void actionPerformed(ActionEvent e) { //listener for EditDelivery button, initiates when button is clicked
    		new DeliveryScheduleEditUI(deliverylist, thisList);
    	}
    }
    
    public class SortAddressButtonListener implements ActionListener{
    	public void actionPerformed(ActionEvent e) {//listener for SortAddress button, initiates when button is clicked
    		Collections.sort(deliverylist);
    		refresh(deliverylist);
    	}
    }
    
    public class SortCustomerIDButtonListener implements ActionListener{
    	public void actionPerformed(ActionEvent e) {//listener for SortCustomerID button, initiates when button is clicked
    		Collections.sort(deliverylist);
    		refresh(deliverylist);
    	}
    }
    
    public class SortOrderCostButtonListener implements ActionListener{
    	public void actionPerformed(ActionEvent e) {//listener for SortOrderCost button, initiates when button is clicked
    		Collections.sort(deliverylist, new OrderCostSort());
    		refresh(deliverylist);
    	}
    }
    

    public class CloseButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)//listener for Close button, initiates when button is clicked
        {
        	MainMenu.createAndShowGUI();
            frame.dispose();
        }

    }
    
    public void refresh(ArrayList<deliveryRecord> schedlist) {
    	//method used to refresh the table after modifying it.
    	model.setRowCount(0);
		for(deliveryRecord d: schedlist) {
			addToTable(d);
		}
    }

}

class CustomerIDSort implements Comparator<deliveryRecord>{//used to help sort deliveries based on customer ID

	@Override
	public int compare(deliveryRecord d1, deliveryRecord d2) {
		int compare = d1.getCusId().compareTo(d2.getCusId());
		if (compare < 0){
		    return -1;
		}
		else if (compare > 0) {
		    return 1;
		}
		else {
		    return 0;
		}
	}
	
}

class OrderCostSort implements Comparator<deliveryRecord>{//used to help sort deliveries based on order cost

	@Override
	public int compare(deliveryRecord d1, deliveryRecord d2) {
		if (d1.getOrderCost()<d2.getOrderCost()) {
			return 1;
		}else {
			if(d2.getOrderCost()<d1.getOrderCost()) {
				return -1;
			}else {
				return 0;
			}
		}
	}
}

