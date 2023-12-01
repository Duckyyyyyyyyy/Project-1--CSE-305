package helper;

import java.sql.*;

public class ConnectionProvider {
	private static Connection con;
	
	private static String dbDriver = "com.mysql.cj.jdbc.Driver";
	private static String dbURL = "jdbc:mysql://localhost:3306/";
	private static String dbName = "project305";
	private static String dbUsername = "root";
	private static String dbPassword = "12345678";
	
	public static Connection getConnection() {
		try {
			if(con == null) {
				// load driver class
				Class.forName(dbDriver);
				
				// create connection
				con = DriverManager.getConnection(dbURL + dbName, 
						dbUsername, dbPassword);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}
