package com.psl.training.model;

public class StockItem {
	
	private int itemNo;
	private String itemDesc;
	private double price;
	private int quantity;
	
	
	public StockItem() {
		// TODO Auto-generated constructor stub
	}


	public StockItem(int itemNo, String itemDesc, double price, int quantity) {
		super();
		this.itemNo = itemNo;
		this.itemDesc = itemDesc;
		this.price = price;
		this.quantity = quantity;
	}


	public int getItemNo() {
		return itemNo;
	}


	public void setItemNo(int itemNo) {
		this.itemNo = itemNo;
	}


	public String getItemDesc() {
		return itemDesc;
	}


	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	@Override
	public String toString() {
		return "StockItem [itemNo=" + itemNo + ", itemDesc=" + itemDesc
				+ ", price=" + price + ", quantity=" + quantity + "]";
	}
	
	
	

}
