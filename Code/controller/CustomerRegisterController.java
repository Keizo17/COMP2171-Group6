package controller;
import java.util.ArrayList;
import java.util.List;

import logic.customerRecord;
import logic.CustomerValidater;
import database.CustomerList;

public class CustomerRegisterController {
	private customerRecord customer;
	
	private List<customerRecord> custList;
	
	public ArrayList<Boolean> createCustomer(String cFName, String cLName, int cAge, String cAddr, String cTelNum, String cEmail, String cID) {
		createCustList();
		
		this.customer = new customerRecord(cFName, cLName, cAge, cAddr, cTelNum, cEmail, cID);
		ArrayList<Boolean> valid = validateCustomer(customer);
		
		if (valid.contains(false)) {
			return valid;
		}else{
			updateCustList();
			return valid;
			}
		
	}
	
	public void createCustList() {
		custList = new CustomerList().readFile();
	}
	
	private ArrayList<Boolean> validateCustomer(customerRecord customer) {
		return new CustomerValidater().validate(customer);
	}
	
	public void updateCustList() {
		boolean dup = findDuplicate(customer.getID());
		
		if (dup == false) {
			new CustomerList().saveToFile(customer);
		}else {}
	}
	
	private boolean findDuplicate(String cID) {
		for(int i = 0; i < custList.size(); i++) {
			if(custList.get(i).getID().equals(cID)){
				return true;
			}
		}
		return false;
		
	}

}
