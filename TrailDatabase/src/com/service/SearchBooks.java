package com.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.DatabaseConnector;

/**
 * Servlet implementation class SearchBooks
 */
@WebServlet("/SearchBooks")
public class SearchBooks extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con;
	PreparedStatement pst;
	String searchname;
	PrintWriter out;
	ResultSet rs;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchBooks() {
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
			pst = con
					.prepareStatement("select * from books where bname like? ");
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
		searchname = request.getParameter("bookname");
		try {
			out = response.getWriter();
			pst.setString(1, "%" + searchname + "%");
			rs = pst.executeQuery();
			out.println("<!DOCTYPE><html><head><style>#header {	background-color: black;	color: white;	text-align: center;	padding: 5px;}#nav {	line-height: 30px;	background-color: #eeeeee;	height: 775px;	width: 100px;	float: left;	padding: 5px;}#section {	width: 350px;	float: left;	padding: 10px;}#footer {	background-color: black;	color: white;	clear: both;	text-align: center;	padding: 5px;}</style>");
			out.println("</head><body>	<div id=\"header\">		<h1>Library Review System</h1>	</div>");
			out.println("<div id=\"nav\">				<a href=\"AdminLogin.jsp\" style=\"text-decoration: none\">Admin Login</a><br><a href=\"UserLogin.jsp\" style=\"text-decoration: none\">User Login</a><br><a href=\"AllBooks.jsp\" style=\"text-decoration: none\">All Books</a><br>				<a href=\"BookSearch.jsp\" style=\"text-decoration: none\">Book Search</a><br></div>");
			out.println("<div id=\"section\">");
			out.println("<h1>Search Result</h1>");
			while (rs.next()) {

				out.println("<body><a href=\"BookDetails.jsp?bid="
						+ rs.getInt("id") + "\">" + rs.getString("bname")
						+ "</a><br></body>");
			}
			out.println("</div>	<div id=\"footer\">Copyright © Xyz</div></body></html>");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
