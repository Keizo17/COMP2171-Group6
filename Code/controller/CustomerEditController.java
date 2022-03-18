package controller;

import java.util.ArrayList;
import java.util.List;

import logic.customerRecord;
import logic.CustomerValidater;
import database.CustomerList;

public class CustomerEditController {
	private customerRecord customer;
	private CustomerValidater validater;
	private List<customerRecord> custList;
	
	public ArrayList<Boolean> updateCustomer(String cFName, String cLName, int cAge, String cAddr, String cTelNum, String cEmail, String cID) {
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
	
	private ArrayList<Boolean> validateCustomer(customerRecord cust) {
		return new CustomerValidater().validate(cust);
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
	
	public String findID(String id) {
		createCustList();
		for(int i = 0; i < custList.size(); i++) {
			if(custList.get(i).getID().equals(id)){
				this.customer = custList.get(i);
				return ("Customer ID("+custList.get(i).getID()+") Found\n----------------------------\n["
	                    +custList.get(i).getfName()+" "+custList.get(i).getlName()+
	                    "]\nEmail:\n-"+custList.get(i).getEmail()+
	                    "\nTelphone:\n-"+custList.get(i).getPhone()+
	                    "\nAddress:\n-"+custList.get(i).getAddress()+
	                    "\nAge:\n-"+custList.get(i).getAge());
				
			}
		}
		return ("No customer with this ID was found.");
	}
	
}
