package com.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
	
public static Connection getconnection() throws ClassNotFoundException, SQLException
{
	Class.forName ("com.mysql.jdbc.Driver");
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/register","root","root");
	return con;
}


}
