package helper;

import java.sql.*;
import java.sql.Connection;

public class ConnectionProvider {
	private static Connection con;

//	private static String dbDriver = "com.mysql.cj.jdbc.Driver";
	private static String dbURL = "jdbc:mysql://localhost:3306/";
	private static String dbName = "project305";
	private static String dbUsername = "root";
	private static String dbPassword = "123456789";

	public static Connection getConnection() {
		try {
			if (con == null) {
				// load driver class
				Class.forName("com.mysql.cj.jdbc.Driver");

				// create connection
				con = DriverManager.getConnection(dbURL + dbName, dbUsername, dbPassword);

			}
		} catch (Exception e) {
			e.printStackTrace();

		}

		return con;
	}
}
