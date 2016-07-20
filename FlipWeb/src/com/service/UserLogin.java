package com.service;

import java.io.IOException;
import java.io.PrintWriter;
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
import javax.servlet.http.HttpSession;

import com.dao.dao;

@WebServlet("/UserLogin")
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con;
	PreparedStatement pst;
	ResultSet rs;

	PrintWriter out;

	public UserLogin() {
		super();

	}

	public void init() throws ServletException {

		try {
			con = dao.getDatabaseConnector();
			pst = con.prepareStatement("select * from register where name=?");
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("name");
		String password = request.getParameter("pass");
		out = response.getWriter();
		try {
			pst.setString(1, name);
			rs = pst.executeQuery();
			rs.next();
			if (rs.getString("pass").equals(password)) {
				request.setAttribute("user1", name);
			
			 HttpSession s=request.getSession();
			 s.setAttribute("user1",name);
			
				RequestDispatcher rk = request.getRequestDispatcher("index.jsp");
				rk.forward(request, response);
			} else {
				RequestDispatcher rd = request.getRequestDispatcher("jsp/error.jsp");
				rd.include(request, response);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

}