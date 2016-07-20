package com.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.DatabaseConnector;

/**
 * Servlet implementation class InsertReview
 */
@WebServlet("/InsertReview")
public class InsertReview extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	int userid;
	int bookid;
	String bname, review;
	RequestDispatcher rd;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InsertReview() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		try {
			con = DatabaseConnector.getDatabaseConnector();
			pst = con.prepareStatement("insert into review (userid,bookid,review) values (?,?,?)");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		userid = (int) request.getSession().getAttribute("userid");
		bookid = Integer.parseInt(request.getParameter("bookid"));
		bname = request.getParameter("bname");
		review = request.getParameter("reviewtext");
		try {
			pst.setInt(1, userid);
			pst.setInt(2, bookid);
			pst.setString(3, review);
			pst.executeUpdate();
			rd = request.getRequestDispatcher("/EnterReview.jsp");
			request.setAttribute("result", "true");
			rd.include(request, response);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
