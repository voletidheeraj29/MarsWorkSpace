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

import com.dao.DatabaseConnector;
/**
 * Servlet implementation class AdminLogin
 */
@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con;
	ResultSet rs;
	PreparedStatement pst;
	PrintWriter out;
	int type;
	RequestDispatcher rd;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		try {
			con=DatabaseConnector.getDatabaseConnector();
			pst= con
					.prepareStatement("select pass,type from login where name=?");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		out = response.getWriter();
		try {
			pst.setString(1, name);
			rs = pst.executeQuery();
			rs.next();
			if (rs.first()) {
				type = rs.getInt("type");
				if (type == 1) {
					if (rs.getString("pass").equals(password)) {
						rd = request
								.getRequestDispatcher("/AddRemove.jsp");
						rd.forward(request, response);
					} else {
						rd=request.getRequestDispatcher("/AdminLogin.jsp");
						request.setAttribute("error","Check Username and Password.");
						rd.include(request, response);
					}
				} else {
					rd = request.getRequestDispatcher("/AdminLogin.jsp");
					request.setAttribute("error","Your are not a valid User.");
					rd.include(request, response);
				}
			} else {
				rd = request.getRequestDispatcher("/AdminLogin.jsp");
				request.setAttribute("error","Check Username and Password.");
				rd.include(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
