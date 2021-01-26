package com.psl.training.connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class ConnectionUtil {
	static Connection cn=null;

	public ConnectionUtil(){
		
	}
	static String driverClass="com.mysql.jdbc.Driver";
	static String url="jdbc:mysql://localhost/inventory_management";
	static String username="root";
	static String password="root";
	
	
	public static Connection getConnection(){
		if(cn==null){
			// Optional
			try {
				Class.forName(driverClass);
				cn=DriverManager.getConnection(url,username,password);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
					}
		
		return cn;
		
	
	}
	
	public void closeConnection(){
		try {
			cn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
