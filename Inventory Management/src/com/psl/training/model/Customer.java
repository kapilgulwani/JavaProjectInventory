package com.psl.training.model;

import java.util.Arrays;

public class Customer {
private int custId;
private String customerName;
private String city;
private String state;
private String street;
private String zip;
private String cell_phone;
private PurchaseOrder po[]=new PurchaseOrder[5];

public Customer() {
	// TODO Auto-generated constructor stub
}

public int getCustId() {
	return custId;
}

public void setCustId(int custId) {
	this.custId = custId;
}

public String getCustomerName() {
	return customerName;
}

public void setCustomerName(String customerName) {
	this.customerName = customerName;
}

public String getCity() {
	return city;
}

public void setCity(String city) {
	this.city = city;
}

public String getState() {
	return state;
}

public void setState(String state) {
	this.state = state;
}

public String getStreet() {
	return street;
}

public void setStreet(String street) {
	this.street = street;
}

public String getZip() {
	return zip;
}

public void setZip(String zip) {
	this.zip = zip;
}

public String getCell_phone() {
	return cell_phone;
}

public void setCell_phone(String cell_phone) {
	this.cell_phone = cell_phone;
}

public PurchaseOrder[] getPo() {
	return po;
}

public void setPo(PurchaseOrder[] po) {
	this.po = po;
}

public Customer(int custId, String customerName, String city, String state,
		String street, String zip, String cell_phone, PurchaseOrder[] po) {
	super();
	this.custId = custId;
	this.customerName = customerName;
	this.city = city;
	this.state = state;
	this.street = street;
	this.zip = zip;
	this.cell_phone = cell_phone;
	this.po = po;
}

@Override
public String toString() {
	return "Customer [custId=" + custId + ", customerName=" + customerName
			+ ", city=" + city + ", state=" + state + ", street=" + street
			+ ", zip=" + zip + ", cell_phone=" + cell_phone + ", po="
			+ Arrays.toString(po) + "]";
}



}
