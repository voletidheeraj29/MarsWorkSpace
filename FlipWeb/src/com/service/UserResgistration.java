package com.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.dao;

@WebServlet("/UserResgistration")
public class UserResgistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con;
	PreparedStatement pst, pst1;
	ResultSet rs;

	public UserResgistration() {
		super();

	}

	public void init() throws ServletException {

		try {
			con = dao.getDatabaseConnector();
			pst = con.prepareStatement("insert into register (name,pass,email)values (?,?,?)");
			pst1 = con.prepareStatement("select name from register where name=?");
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		String email = request.getParameter("email");
		try {
			pst.setString(1, name);
			pst.setString(2, pass);
			pst.setString(3, email);
			pst1.setString(1, name);

			rs = pst1.executeQuery();
			if (rs.next()) {
				if (rs.getString(1).equals(name)) {
					RequestDispatcher rk = request.getRequestDispatcher("jsp/exists.jsp");
					rk.include(request, response);
				}
			} else {
				pst.executeUpdate();
				RequestDispatcher rd = request.getRequestDispatcher("jsp/success.jsp");
				rd.include(request, response);
			}

		} catch (SQLException e) {
			RequestDispatcher rk = request.getRequestDispatcher("jsp/exists.jsp");
			rk.include(request, response);

		}

	}
}
