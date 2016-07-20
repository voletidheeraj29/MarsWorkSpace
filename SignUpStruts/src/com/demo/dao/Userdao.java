package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.demo.pojo.UserReg;

public class Userdao {

	public boolean addrecord(UserReg user) throws ClassNotFoundException,
			SQLException {
		Connection con = DBConnector.getconnection();
		PreparedStatement ps = con
				.prepareStatement("insert into userdatabase values(?,?,?,?,?,?)");
		ps.setString(1, user.getFname());
		ps.setString(2, user.getLname());
		ps.setString(3, user.getUname());
		ps.setString(5, user.getEmail());
		ps.setString(6, user.getDob());
		ps.setString(4, user.getPassword());
		ps.executeUpdate();
		return true;

	}

	public boolean isUserExist(String uname) throws SQLException,
			ClassNotFoundException {

		Connection con = DBConnector.getconnection();
		PreparedStatement ps = con
				.prepareStatement("select * from userdatabase where uname=?");
		ps.setString(1, uname);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			 //if (rs.getString(3).toLowerCase().equals(uname))
			return true;
		} else
			return false;

	}
}
