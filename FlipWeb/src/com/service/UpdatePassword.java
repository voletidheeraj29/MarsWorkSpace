package com.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.dao.dao;
/**
 * Servlet implementation class UpdatePassword
 */

@WebServlet("/UpdatePassword")
public class UpdatePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con;
	PreparedStatement pst,pst1;
	ResultSet rs; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePassword() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init() throws ServletException {

		try {
			con = dao.getDatabaseConnector();
			pst = con.prepareStatement("select name from register where name=?");
			pst1 = con.prepareStatement("update register set pass =? WHERE name = ?"  );
		} catch (Exception e) {

			e.printStackTrace();
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String name = request.getParameter("name");
		
		try {
			pst.setString(1,name);
			rs = pst.executeQuery();
			if(rs.next()){
				if (rs.getString(1).equals(name) ){
			String pass=request.getParameter("pass1");
            pst1.setString(1, pass);
            pst1.setString(2,name);
			pst1.executeUpdate();
			RequestDispatcher rk = request.getRequestDispatcher("jsp/update.jsp");
			rk.forward(request, response);
				}
			}else{
				RequestDispatcher rk = request.getRequestDispatcher("jsp/dne.jsp");
				rk.forward(request, response);
			}
}catch(Exception e){
	
}
}}