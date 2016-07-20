

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HiddenFormField
 */
public class HiddenFormField extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	public void doGet(HttpServletRequest req,HttpServletResponse res)
	{
		try
		{
			PrintWriter out=res.getWriter();
			res.setContentType("text/html");
			String para=req.getParameter("hidden");
			System.out.println(para);
			int no=Integer.parseInt(para);
			
			no++;
			out.println("<h1>Hit Count: "+no+"</h1>");
			out.println("<form action='h1'>");
			out.println("<input type=submit>");
			out.println("<input type=hidden name='hidden' value='"+no+"'>");

		}
		catch(Exception e)
		{
			System.out.println(e);
		}
          
	}

}
