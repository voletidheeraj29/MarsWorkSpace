package com.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.DatabaseConnector;

/**
 * Servlet implementation class UserResgistration
 */
@WebServlet("/UserResgistration")
public class UserResgistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con;
	PreparedStatement pst;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserResgistration() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		try {
			con = DatabaseConnector.getDatabaseConnector();
			pst = con
					.prepareStatement("insert into login (name,pass,type)values (?,?,0)");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String pass = request.getParameter("password");
		try {
			pst.setString(1, name);
			pst.setString(2, pass);
			pst.executeUpdate();
			RequestDispatcher rd = request
					.getRequestDispatcher("/Register.jsp");
			request.setAttribute("msg",
					"The data is successfully inserted.");
			rd.include(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
