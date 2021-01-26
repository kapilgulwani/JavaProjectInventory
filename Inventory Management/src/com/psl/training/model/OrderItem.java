package com.psl.training.model;

public class OrderItem {
	private StockItem stockItem;
	private int orderedQuntity;
	private long total; // derived field

	public OrderItem() {
		// TODO Auto-generated constructor stub
	}

	public OrderItem(StockItem stockItem, int orderedQuntity, long total) {
		super();
		this.stockItem = stockItem;
		this.orderedQuntity = orderedQuntity;
		this.total = total;
	}

	public StockItem getStockItem() {
		return stockItem;
	}

	public void setStockItem(StockItem stockItem) {
		this.stockItem = stockItem;
	}

	public int getOrderedQuntity() {
		return orderedQuntity;
	}

	public void setOrderedQuntity(int orderedQuntity) {
		this.orderedQuntity = orderedQuntity;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "OrderItem [stockItem=" + stockItem + ", orderedQuntity="
				+ orderedQuntity + ", total=" + total + "]";
	}
	
	

}
