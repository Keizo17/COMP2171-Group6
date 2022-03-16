package controller;
import java.util.ArrayList;
import java.util.List;

import ui.customerRegisterUI;
import logic.customerRecord;
import logic.addCustomerValidater;
import database.addCustomerList;

public class addCustomerController {
	private customerRecord customer;
	private addCustomerValidater validater;
	private List<customerRecord> custList;
	
	public ArrayList<Boolean> createCustomer(String cFName, String cLName, int cAge, String cAddr, String cTelNum, String cEmail, String cID) {
		this.customer = new customerRecord(cFName, cLName, cAge, cAddr, cTelNum, cEmail, cID);
		ArrayList<Boolean> valid = validateCustomer(customer);
		createCustList();
		if (valid.contains(false)) {
			return valid;
		}else{
			updateCustList();
			return valid;
			}
		
	}
	
	public void createCustList() {
		custList = new addCustomerList().readFile();
	}
	
	private ArrayList<Boolean> validateCustomer(customerRecord cust) {
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
