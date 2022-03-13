package controller;
import java.util.List;

import ui.customerRegisterUI;
import logic.customerRecord;
import logic.addCustomerValidater;
import database.addCustomerList;

public class addCustomerController {
	private customerRecord customer;
	private addCustomerValidater validater;
	private List<customerRecord> custList;
	
	public boolean createCustomer(String cFName, String cLName, int cAge, String cAddr, String cTelNum, String cEmail, String cID) {
		this.customer = new customerRecord(cFName, cLName, cAge, cAddr, cTelNum, cEmail, cID);
		boolean valid = validateCustomer(customer);
		createCustList();
		if (valid == true) {
			updateCustList();
			return true;
		}else{
			System.out.println('E');
			return false;
			}
		
	}
	
	public void createCustList() {
		custList = new addCustomerList().readFile();
	}
	
	private boolean validateCustomer(customerRecord cust) {
		return new addCustomerValidater().validate(cust);
	}
	
	public void updateCustList() {
		boolean dup = isDuplicate(customer.getID());
		
		if (dup == false) {
			new addCustomerList().saveToFile(customer);
		}else {}
	}
	
	private boolean isDuplicate(String id) {
		for(int i = 0; i < custList.size(); i++) {
			if(custList.get(i).getID().equals(id)){
				return true;
			}
		}
		return false;
		
	}

}
