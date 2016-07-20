package com.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.DatabaseConnector;

/**
 * Servlet implementation class UserLogin
 */
@WebServlet("/UserLogin")
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	int type;
	PrintWriter out;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserLogin() {
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
			pst = con.prepareStatement("select * from login where name=?");
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
		int id;
		HttpSession session = request.getSession(true);
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		out = response.getWriter();
		try {
			pst.setString(1, name);
			rs = pst.executeQuery();
			rs.next();
			if (rs.first()) {
				type = rs.getInt("type");
				if (type == 0) {
					if (rs.getString("pass").equals(password)) {
						id = rs.getInt("id");
						session.setAttribute("username", name);
						session.setAttribute("userid", id);
						RequestDispatcher rd = request
								.getRequestDispatcher("/BookSearch.jsp");
						rd.forward(request, response);
					} else {
						RequestDispatcher rd = request
								.getRequestDispatcher("/UserLogin.jsp");
						// out.println("<body>Check Username and Password.</body>");
						request.setAttribute("errormsg",
								"Check Username and Password.");
						rd.include(request, response);
					}
				} else {
					RequestDispatcher rd = request
							.getRequestDispatcher("/UserLogin.jsp");
					// out.println("<body>Your are not a valid User.</body>");
					request.setAttribute("errormsg",
							"Your are not a valid User.");
					rd.include(request, response);
				}
			} else {
				RequestDispatcher rd = request
						.getRequestDispatcher("/UserLogin.jsp");
				request.setAttribute("errormsg", "Check Username and Password.");
				// out.println("<body>Check Username and Password.</body>");
				rd.include(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
