package com.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static String url = "jdbc:mysql://localhost:3306/Store_DB";
    private static String user = "";
    private static String pwd = "";
    
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		//Load driver
				Class.forName("com.mysql.cj.jdbc.Driver");
				
		//create connection
				Connection con = DriverManager.getConnection(url,user,pwd);
				return con;

	}
		

}


