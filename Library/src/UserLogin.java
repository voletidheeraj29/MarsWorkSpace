

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con;
	ResultSet rs;
	PreparedStatement psmt;
	String uid, pass;
    
    public UserLogin() {
        super();
    }
	public void init(ServletConfig config) throws ServletException {

		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","root");
			
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
	
			
		 catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session=request.getSession();
		PrintWriter out=response.getWriter();
		uid=request.getParameter("uid");
		pass=request.getParameter("pass");
		try {
			psmt=con.prepareStatement("select * from users where uid=? and pass=?");
		
		psmt.setString(1, uid);
		psmt.setString(2, pass);
		rs=psmt.executeQuery();
		
		if(rs.next())
		{
			
			String userid=rs.getString(1);
			session.setAttribute("UserID", userid);
			String typ=rs.getString(3);
			if(typ.equals("admin"))
			{
				
				RequestDispatcher rd=request.getRequestDispatcher("addRemove.html");
				rd.forward(request, response);
			
			}
			else
			{
				RequestDispatcher rd=request.getRequestDispatcher("BookSearch.jsp");
				rd.forward(request, response);
			}	
		}
		else
		{
			out.println("Incorrect credentials...");
		RequestDispatcher rd=request.getRequestDispatcher("UserLogin.html");
		rd.include(request,response);
		}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("hi");
		}
	}

}
