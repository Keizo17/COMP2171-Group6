package controller;

import java.util.ArrayList;
import java.util.List;

import logic.customerRecord;
import logic.CustomerValidater;
import database.CustomerList;

public class CustomerEditController {
	private customerRecord customer;
	private List<customerRecord> custList;
	private int index;
	
	public boolean updateCustomer(String cFName, String cLName, String cAge, 
			String cAddr, String cTelNum, String cEmail, String cID, String oldid) {
		createCustList();
		
		ArrayList<String> updatedcust = checkValues(cFName, cLName, cAge, cAddr, cTelNum, cEmail, cID, oldid);
		this.customer = new customerRecord(updatedcust.get(0), updatedcust.get(1), Integer.parseInt(updatedcust.get(2)),
				updatedcust.get(3), updatedcust.get(4), updatedcust.get(5), updatedcust.get(6));
		
		ArrayList<Boolean> valid = validateCustomer(customer);
		
		if(valid.contains(false)) {
            return false;
        }else{
        	
            updateCustList();
            return true;
        }
	}
	
	public void createCustList() {
		this.custList = new CustomerList().readFile();
	}
	
	private ArrayList<Boolean> validateCustomer(customerRecord cust) {
		return new CustomerValidater().validate(cust);
	}
	
	public void updateCustList() {
		boolean dup = findDuplicate(customer.getID());
		System.out.print(index);
		if (dup == false) {
			new CustomerList().saveToFile(customer, index);
		}else {}
	}
	
	private boolean findDuplicate(String cID) {
		for(int i = 0; i < custList.size(); i++) {
			if(custList.get(i).getID().equals(cID)&& i != index){
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
				return ("Customer ID "+custList.get(i).getID()+" Found\n----------------------------\n["
	                    +custList.get(i).getfName()+" "+custList.get(i).getlName()+
	                    "]\nEmail:\n-"+custList.get(i).getEmail()+
	                    "\nTelphone:\n-"+custList.get(i).getPhone()+
	                    "\nAddress:\n-"+custList.get(i).getAddress()+
	                    "\nAge:\n-"+custList.get(i).getAge());
				
			}
		}
		return ("No customer with this ID"+id+"was found.");
	}
	
	public ArrayList<String> checkValues(String newFName, String newLName, String newAge, String newAddr, String newTelNum,
			String newEmail, String newID,String oldid){
		ArrayList<String> newCust = new ArrayList<String>();
		String oldFName = "",oldLName = "", oldAge = "", oldAddr = "", oldTelNum = "", oldEmail = "", oldID = "";
		for(int i = 0; i < custList.size(); i++) {
			if(custList.get(i).getID().equalsIgnoreCase(oldid)){
				oldFName = custList.get(i).getfName();
				oldLName = custList.get(i).getlName();
				oldAge = Integer.toString(custList.get(i).getAge());
				oldTelNum = custList.get(i).getPhone();
				oldAddr = custList.get(i).getAddress();
				oldEmail = custList.get(i).getEmail();
				oldID = custList.get(i).getID();
				this.index = i;
			}
		}
		if(newFName.isBlank()) {
			newFName = oldFName;
		}
		if(newLName.isBlank()) {
			newLName = oldLName;
		}
		if(newAge.isBlank()) {
			newAge = oldAge;
		}
		if(newAddr.isBlank()) {
			newAddr = oldAddr;
		}
		if(newTelNum.isBlank()) {
			newTelNum = oldTelNum;
		}
		if(newEmail.isBlank()) {
			newEmail = oldEmail;
		}
		if(newID.isBlank()) {
			newID = oldID;
		}
		
		newCust.add(newFName);
		newCust.add(newLName);
		newCust.add(newAge);
		newCust.add(newAddr);
		newCust.add(newTelNum);
		newCust.add(newEmail);
		newCust.add(newID);
		
		return newCust;
	}
	
}
