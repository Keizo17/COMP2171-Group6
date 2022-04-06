

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

public class DeliveryScheduleEdit extends JFrame{
private JTextField  txtID;
    
    private JButton     cmdUpdate;
    private JButton		cmdContinue;
    private JButton     cmdClose;

    private JPanel      pnlCommand;
    private JPanel      pnlDisplay;
    
    private ArrayList<DeliveryRecord> schedlist;
    
    private DeliverySchedule listing;
    private DeliveryScheduleEdit updateWin,updater;
    
  
    public DeliveryScheduleEdit(ArrayList<DeliveryRecord> schedlist, DeliverySchedule listing)
    {
    	updateWin = this;
        updateWin.setBounds(300, 160, 600, 200);
        
    	pnlCommand = new JPanel();
        pnlDisplay = new JPanel();
		pnlDisplay.add(new JLabel("Please enter the ID of the delivery record to be updated:")); 
        txtID = new JTextField(2);
        pnlDisplay.add(txtID);
        this.schedlist = schedlist;
        this.listing = listing;
        
        cmdContinue      = new JButton("Continue");
        cmdClose   = new JButton("Cancel");
        
        cmdContinue.setBackground(Color.green);
        cmdClose.setBackground(Color.red);
        
        cmdContinue.addActionListener(new ContinueButtonListener());
        cmdClose.addActionListener(new CloseButtonListener()); 

        pnlCommand.add(cmdContinue);
        pnlCommand.add(cmdClose);
        
        add(pnlDisplay, BorderLayout.CENTER);
        add(pnlCommand, BorderLayout.SOUTH);
        pack();
        setVisible(true);

    }
    
    public DeliveryScheduleEdit(int id,ArrayList<DeliveryRecord> schedlist, DeliverySchedule listing) {
    	int pdx = findDeliveryRecord(schedlist,id);
		if (pdx>=0) {
			schedlist.get(pdx).updateLocalData(pdx,updater,updateWin,listing,schedlist);
		}else {
			pnlCommand = new JPanel();
	        pnlDisplay = new JPanel();
	        pnlDisplay.add(new JLabel("Delivery Record not found or ID# is invalid.")); 
	        this.updateWin = this;
	        updateWin.setBounds(350, 200, 600, 200);
	        
	        cmdClose   = new JButton("Close");
	     
	        cmdClose.setBackground(Color.white);
	        
	        
	        cmdClose.addActionListener(new CloseButtonListener()); 

	        pnlCommand.add(cmdClose);
	        
	        add(pnlDisplay, BorderLayout.CENTER);
	        add(pnlCommand, BorderLayout.SOUTH);
	        pack();
	        setVisible(true);
		}
    }
    
    public int findDeliveryRecord(ArrayList<DeliveryRecord> schedlist, int delivId)
	{
		int delivIdx =-1;
		int currIdx=0;
		while ((currIdx<schedlist.size())&&(delivIdx==-1))
		{
			if (schedlist.get(currIdx).getId()==delivId)
				delivIdx = currIdx;
			currIdx++;
		}
		return delivIdx;
	}
    
    private class CloseButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            updateWin.dispose();
        }

    }
    
    private class ContinueButtonListener implements ActionListener{
    	public void actionPerformed(ActionEvent e) {
    		int id = -1;
    		try {
    			id = Integer.parseInt(txtID.getText());
    		}catch (NumberFormatException ex) {
    			updateWin.dispose();
    			updater = new DeliveryScheduleEdit(-1,schedlist,listing);
    		}
    		updateWin.dispose();
    		if (id != -1) {updater = new DeliveryScheduleEdit(id,schedlist,listing);} //creates a new DeliveryScheduleEdit object to use for ID searching
    	}
    }

}
