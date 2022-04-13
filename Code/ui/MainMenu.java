package ui;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainMenu extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static JFrame		frame;
	
	private JPanel      pnlCommand;
    private JPanel      pnlDisplay;
	
	private JButton		cmdAddCustomer;
    private JButton     cmdEditCustomer;
    private JButton     cmdAddProduct;
    private JButton     cmdEditProduct;
    private JButton     cmdProcessOrder;
    private JButton     cmdDeliverySchedule;
    private JButton     cmdClose;

    public MainMenu() {
    	super(new GridLayout(1,1));
    	
        pnlCommand = new JPanel();
        pnlDisplay = new JPanel();
        pnlCommand.setPreferredSize(new Dimension(300,300));
        BoxLayout menuLayout = new BoxLayout(pnlCommand, BoxLayout.PAGE_AXIS);
        pnlCommand.setLayout(menuLayout);
        
        cmdAddCustomer  = new JButton("Add New Customer");
        cmdEditCustomer  = new JButton("Edit Customer Record");
        cmdAddProduct  = new JButton("Add New Product");
        cmdEditProduct  = new JButton("Edit Product Record");
        cmdProcessOrder  = new JButton("Process Orders");
        cmdDeliverySchedule  = new JButton("View Delivery Schedule");
        cmdClose   = new JButton("Close");

        //centering
        cmdAddCustomer.setAlignmentX(CENTER_ALIGNMENT);
        cmdEditCustomer.setAlignmentX(CENTER_ALIGNMENT);
        cmdAddProduct.setAlignmentX(CENTER_ALIGNMENT);
        cmdEditProduct.setAlignmentX(CENTER_ALIGNMENT);
        cmdProcessOrder.setAlignmentX(CENTER_ALIGNMENT);
        cmdDeliverySchedule.setAlignmentX(CENTER_ALIGNMENT);
        cmdClose.setAlignmentX(CENTER_ALIGNMENT);

        //button commands
        cmdAddCustomer.addActionListener(new AddCustomerButtonListener());
        cmdEditCustomer.addActionListener(new EditCustomerButtonListener());
        cmdAddProduct.addActionListener(new AddProductButtonListener());
        cmdEditProduct.addActionListener(new EditProductButtonListener());
        cmdProcessOrder.addActionListener(new ProcessOrderButtonListener());
        cmdDeliverySchedule.addActionListener(new DeliveryScheduleButtonListener());
        cmdClose.addActionListener(new CloseButtonListener());
        
        cmdAddCustomer.setBackground(Color.pink);
        cmdEditCustomer.setBackground(Color.pink);
        cmdAddProduct.setBackground(Color.pink);
        cmdEditProduct.setBackground(Color.pink);
        cmdProcessOrder.setBackground(Color.pink);
        cmdDeliverySchedule.setBackground(Color.pink);
        cmdClose.setBackground(Color.red);
        pnlCommand.setBackground(Color.black);
        pnlDisplay.setBackground(Color.black);
        
        pnlCommand.add(cmdAddCustomer);
        pnlCommand.add(cmdEditCustomer);
        pnlCommand.add(cmdAddProduct);
        pnlCommand.add(cmdEditProduct);
        pnlCommand.add(cmdProcessOrder);
        pnlCommand.add(cmdDeliverySchedule);
        pnlCommand.add(cmdClose);
        
        ////
        
        ImageIcon logo = new ImageIcon("icons/logo.png");
        JLabel label = new JLabel("", logo, JLabel.CENTER);
        add(label);
        add(pnlCommand);
        add(pnlDisplay);
    }
    
    static void createAndShowGUI() {
        //Create and set up the window.
        frame = new JFrame("T'Curly Manager Main Menu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        MainMenu newContentPane = new MainMenu();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
        
    }
    
    public static void main(String[] args) {
        //new EntryScreen();
    	createAndShowGUI();
    }
    
    public class AddCustomerButtonListener implements ActionListener{
    	public void actionPerformed(ActionEvent e) { //listener for AddCustomer button, initiates when button is clicked
    		new CustomerRegisterUI().addCustomerUI();
            frame.setVisible(false);
    	}
    }
    
    public class EditCustomerButtonListener implements ActionListener{
    	public void actionPerformed(ActionEvent e) {//listener for EditCustomer button, initiates when button is clicked
    		new CustomerEditUI().findCustomer();
    		frame.setVisible(false);
    	}
    }
    
    public class AddProductButtonListener implements ActionListener{
    	public void actionPerformed(ActionEvent e) {//listener for AddProductMethod button, initiates when button is clicked
    		new ProductRegisterUI().registerProduct();
    		frame.setVisible(false);
    	}
    }
    
    public class EditProductButtonListener implements ActionListener{
    	public void actionPerformed(ActionEvent e) {//listener for EditProduct button, initiates when button is clicked
    		new ProductEditUI().findProduct();
    		frame.setVisible(false);
    	}
    }
    
    public class ProcessOrderButtonListener implements ActionListener{
    	public void actionPerformed(ActionEvent e) {//listener for ProcessOrder button, initiates when button is clicked
    		new CheckCart();
    		frame.setVisible(false);
    	}
    }
    
    public class DeliveryScheduleButtonListener implements ActionListener{
    	public void actionPerformed(ActionEvent e) {//listener for DeliverySchedule button, initiates when button is clicked
    		DeliveryScheduleUI.createAndShowGUI();
    		frame.setVisible(false);
    	}
    }
    

    public class CloseButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)//listener for Close button, initiates when button is clicked
        {
        	System.exit(0);
        
        }

    }
    
}
