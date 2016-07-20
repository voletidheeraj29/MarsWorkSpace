package com.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dao{
	static Connection con;

	public dao() {

	}

	public static Connection getDatabaseConnector() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/dheeraj", "root", "root");
		return con;
	}

	public static void CloseConnection(Connection con) {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

