package com.psl.training.model;

import java.time.LocalDate;
import java.util.Arrays;

public class PurchaseOrder {
	private int poNumber;
	private LocalDate orderDate;
	private LocalDate shipDate;
	private OrderItem[] orderedItems=new OrderItem[5];
	
	public PurchaseOrder() {
		// TODO Auto-generated constructor stub
	}

	public PurchaseOrder(int poNumber, LocalDate orderDate, LocalDate shipDate,
			OrderItem[] orderedItems) {
		super();
		this.poNumber = poNumber;
		this.orderDate = orderDate;
		this.shipDate = shipDate;
		this.orderedItems = orderedItems;
	}

	public int getPoNumber() {
		return poNumber;
	}

	public void setPoNumber(int poNumber) {
		this.poNumber = poNumber;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public LocalDate getShipDate() {
		return shipDate;
	}

	public void setShipDate(LocalDate shipDate) {
		this.shipDate = shipDate;
	}

	public OrderItem[] getOrderedItems() {
		return orderedItems;
	}

	public void setOrderedItems(OrderItem[] orderedItems) {
		this.orderedItems = orderedItems;
	}

	@Override
	public String toString() {
		return "PurchaseOrder [poNumber=" + poNumber + ", orderDate="
				+ orderDate + ", shipDate=" + shipDate + ", orderedItems="
				+ Arrays.toString(orderedItems) + "]";
	}
	
	
}
