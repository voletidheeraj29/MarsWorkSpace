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
 * Servlet implementation class AddRemove
 */
@WebServlet("/AddRemove")
public class AddRemove extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con;
	PreparedStatement pst,pst1;
	ResultSet rs;
	int operation, type;
	PrintWriter out;
	String bname, author;
	boolean status = false;
	int checkoperation = 2;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddRemove() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		try {
			Connection con = DatabaseConnector.getDatabaseConnector();
			pst = con
					.prepareStatement("insert into books (bname,author) values (?,?)");
			pst1 = con.prepareStatement("delete from books where bname=? ");
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
		operation = Integer.parseInt(request.getParameter("update"));
		bname = request.getParameter("bookname");
		System.out.println(operation);
		author = request.getParameter("author");
		switch (operation) {
		case 0:
			try {
				pst1.setString(1, bname);
				pst1.executeUpdate();
				status = true;
				checkoperation = 0;
				break;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		case 1:

			try {
				pst.setString(1, bname);
				pst.setString(2, author);
				pst.executeUpdate();
				status = true;
				checkoperation = 1;
				break;

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (status) {
			if (checkoperation == 0) {
				RequestDispatcher rd = request
						.getRequestDispatcher("/AddRemove.jsp");
				request.setAttribute("msg", "The data has been successfully deleted.");
				rd.include(request, response);
			} else {
				RequestDispatcher rd = request.getRequestDispatcher("//AddRemove.jsp");
				request.setAttribute("msg", "The data has been successfully inserted.");
				rd.include(request, response);
			}
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("/AddRemove.jsp");
			request.setAttribute("msg", "The data has not been inseted.");
			rd.include(request, response);
		}
	}

}
