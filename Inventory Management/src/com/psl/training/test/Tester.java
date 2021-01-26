package com.psl.training.test;

import java.time.LocalDate;
import java.util.Scanner;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.psl.training.connections.ConnectionUtil;
import com.psl.training.model.Customer;
import com.psl.training.model.OrderItem;
import com.psl.training.model.PurchaseOrder;
import com.psl.training.model.StockItem;

public class Tester {
	StockItem stockItems[]=new StockItem[20];
	PurchaseOrder[] po=new PurchaseOrder[20];
	Customer customers[]=new Customer[20];
	
public Tester(Connection cn) {
	initCustomers(cn);
	initStock(cn); // initialize stock
	createPurchaseOrders(cn);
}	
	
public static void main(String[] args) {
	
	Tester test=null;
	
	
	Connection cn = ConnectionUtil.getConnection(); 
	if(cn!=null)
	{
		System.out.println("Connected");
		test=new Tester(cn);
	}
	else
	{
		System.out.println("Not Connected");
	}
	
	for (PurchaseOrder purchaseOrder : test.getPurchaseOrder(1,2)) {
	System.out.println(purchaseOrder);
}
	
	System.out.println("Enter Name of customer to place order :");
	Scanner sc = new Scanner(System.in);
	String name = sc.nextLine();
	System.out.println(" placing Order for "+name);
	Customer customer1=test.placeOrder(name,1,2);
	System.out.println(" Orders of " + name);
	for (PurchaseOrder po : customer1.getPo()) {
		System.out.println(po);
	}
	
	/*System.out.println(" placing Order for Bill");
	Customer customer2=test.placeOrder("Bill", 3);
	System.out.println(" Orders of Bill");
	for (PurchaseOrder po : customer2.getPo()) {
		System.out.println(po);
	}*/
	
	// considering a fixed requirement that we have only 3 orders 
	
	// Po1 - with Jamie
	// po2 - with Jamie
	// po3- with Bill

	// Get all the orders to be shipped and print labels
	//  purchaser Order Array
	
	System.out.println("----- Printing labels for Orders to be shipped ");
	// considering all the orders to be shipped by default
	long totalPrice=0;
	for (PurchaseOrder po : test.po) {
		totalPrice=0;
		String label="--------------------------------------";
		label+="\n Order No :"+po.getPoNumber();
		label+="\n Ordered Date : "+po.getOrderDate();
		po.setShipDate(po.getOrderDate().plusDays(1));
		label+="\n shipped on :"+po.getShipDate();
		label+="\n Items to be shipped ";
		for (OrderItem orderedItem : po.getOrderedItems()) {
			label+="\n Item : "+orderedItem.getStockItem().getItemDesc()+", Qty :"+orderedItem.getOrderedQuntity()+
					",  price :"+orderedItem.getTotal();
			totalPrice+=orderedItem.getTotal();
		}
		label+="\n Total Bill of Order :"+totalPrice;
		System.out.println(label);
	sc.close();	
	}
}
// u can add this method in CustomerService / util class
public void initCustomers(Connection cn){
	Scanner sc = new Scanner(System.in);
	int i=0;
	while(true)
	{
		System.out.println("Enter Customer id: ");
		int id = sc.nextInt();
		sc.nextLine();
		
		System.out.println("Enter Customer Name:");
		String name = sc.nextLine();
		
		System.out.println("Enter Customer Cell Phone No : ");
		String cell_phone = sc.nextLine();
		
		System.out.println("Enter Street: ");
		String street = sc.nextLine();
		
		System.out.println("Enter City: ");
		String city = sc.nextLine();
		
		System.out.println("Enter State: ");
		String state = sc.nextLine();
		
		System.out.println("Enter Zip: ");
		String zip = sc.nextLine();
		
		try {

			customers[i]=new Customer(id,name,cell_phone,street,city,state,zip,null);
			
			PreparedStatement	pstmt = cn.prepareStatement("insert into customer values(?,?,?,?,?,?,?)");
			
			pstmt.setInt(1,customers[i].getCustId());
			pstmt.setString(2,customers[i].getCustomerName());
			pstmt.setString(3,customers[i].getCell_phone());
			pstmt.setString(4,customers[i].getStreet());
			pstmt.setString(5,customers[i].getCity());
			pstmt.setString(6,customers[i].getState());
			pstmt.setString(7,customers[i].getZip());
			
			pstmt.executeUpdate();
			i++; 
		}
		catch(SQLException e1)
		{
			e1.printStackTrace();
		}
		
		System.out.println("Do you want to conti..Y/N");
		String response = sc.nextLine();
		
		System.out.println(response);
		if(response.equals("No"))
		{
			break;
		}
	}
		
		//customers[0]=new Customer(100, "Jamie", "NY", null);
		//customers[1]=new Customer(101, "Bill", "LV", null);
		//customers[2]=new Customer(102, "Joe", "NY", null);
			
	//return customers;
	
	System.out.println("End customer");
	sc.close();
}

public void createPurchaseOrders(Connection cn){

	// 1.	PO 1 - 2 gallons Milk, 2 lbs Chicken and 12 eggs.
	Scanner sc = new Scanner(System.in);
	int stock_id=0,quantity;
	System.out.println("Enter No of Purchase Order : ");
	int purchase = sc.nextInt();
	sc.nextLine();
	
	for(int j=0;j<purchase;j++)
	{
		System.out.println("Enter No of Orders:");
		int order_no = sc.nextInt();
		sc.nextLine();
		OrderItem orderItems[]=new OrderItem[order_no];
		
		for(int i=0;i<order_no;i++)
		{
			try {	
			System.out.println("Enter stock id : ");
			stock_id = sc.nextInt();
			sc.nextLine();
			
			System.out.println("Enter quantity : ");
			quantity = sc.nextInt();
			sc.nextLine();
			
			StockItem stockItem=getStockItemByName(stock_id);
			long total=(long) (quantity*stockItem.getPrice());
			orderItems[i]=new OrderItem(stockItem,quantity,total );
			
			
				
				PreparedStatement	pstmt = cn.prepareStatement("insert into order_item values(?,?,?)");
				
				pstmt.setInt(1,stock_id);
				pstmt.setInt(2,quantity);
				pstmt.setLong(3,total);
				
				pstmt.executeUpdate();
	 
		}
			catch(SQLException e1)
			{
				e1.printStackTrace();
			}
			
		}
		po[j] =new PurchaseOrder(j, LocalDate.now(),LocalDate.now().plus(2,null), orderItems);
	}
	


	//Creating Order Item for 1st Purchase Order

	
	
	// Creating Order Item for 2nd Purchase Order
/*	
	//2.	PO 2 - 5 apples and 10 oranges
	orderItems=new OrderItem[2];
	stockItem=getStockItemByName(10004);
	total=(long) (5*stockItem.getPrice());
	orderItems[0]=new OrderItem(stockItem, 5,total );
	
	 stockItem=getStockItemByName(10005);
	 total=(long) (10*stockItem.getPrice());
	orderItems[1]=new OrderItem(stockItem, 10,total );
	
	po[1] =new PurchaseOrder(2, LocalDate.now(), null, orderItems);
	
	
	// Creating Order Item for 3rd Purchase Order
	
	//3.	PO 3 - 5 Lbs chicken and 10 apples
		orderItems=new OrderItem[2];
		stockItem=getStockItemByName(10002);
		total=(long) (5*stockItem.getPrice());
		orderItems[0]=new OrderItem(stockItem, 5,total );
		
		 stockItem=getStockItemByName(10004);
		 total=(long) (10*stockItem.getPrice());
		orderItems[1]=new OrderItem(stockItem, 10,total );
		
		po[2] =new PurchaseOrder(3, LocalDate.now(), null, orderItems);
		//return po;
*/			
}


public StockItem getStockItemByName(int stockItemId){
	for (StockItem stockItem : stockItems) {
		if(stockItem.getItemNo()==stockItemId)
			return stockItem;
	}
	return null;
}


public void initStock(Connection cn){
	//2.	Create 5 items - Milk, Chicken, Egg, Apple and Orange
	int i=0,id=0;
	Scanner sc1 = new Scanner(System.in);
	while(true)
	{

		try {
		System.out.println("Enter Stock id: ");
		id = sc1.nextInt();
		
		System.out.println("Enter Stock Description :");
		String desc = sc1.nextLine();
		
		System.out.println("Enter Stock Price :");
		double price = sc1.nextDouble();
		sc1.nextLine();
		
		System.out.println("Enter Stock Quantity :");
		int quantity = sc1.nextInt();
		sc1.nextLine();
		

			stockItems[i]=new StockItem(id,desc,price,quantity);
			
			PreparedStatement	pstmt = cn.prepareStatement("insert into stock_item values(?,?,?,?)");
			
			pstmt.setInt(1,stockItems[i].getItemNo());
			pstmt.setString(2,stockItems[i].getItemDesc());
			pstmt.setDouble(3,stockItems[i].getPrice());
			pstmt.setInt(4,stockItems[i].getQuantity());
			pstmt.executeUpdate();
			i++; 
		}
		catch(SQLException e1)
		{
			e1.printStackTrace();
		}
		
		System.out.println("Do you want to conti..Y/N");
		String response = sc1.nextLine();
		sc1.next();
		System.out.println(response);
		if(response.equals("No"))
		{
			break;
		}
	}
	
	
	//return stockItems;
	sc1.close();
}
Customer getCustomerByName(String custName){
	for (Customer customer : customers) {
		if(custName.equals(customer.getCustomerName()))
			return customer;
	}
	return null;
}

PurchaseOrder[] getPurchaseOrder(int... orderNo){
	PurchaseOrder orders[]=new PurchaseOrder[orderNo.length];
	int index=0;
	for(int ono:orderNo)
	{
		for (PurchaseOrder po : this.po) {
		
			if(po.getPoNumber()==ono)
				orders[index++]=po;
		}
			
	}
	return orders;
}

public Customer placeOrder(String customerName,int... orderNo){
	 
	Customer c=getCustomerByName(customerName);
	PurchaseOrder[] po=getPurchaseOrder(orderNo);
	c.setPo(po);
	return c;
}

}
