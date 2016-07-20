

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class URLServlet
 */
public class URLServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
 	{
 		String tokensID=req.getParameter("tokenID");
 		res.setContentType("text/html");
 		PrintWriter out=res.getWriter();
 		out.println("<html><head><title>Tokens</title></head><body");
 		out.println("style=\"font-family:verdana;font-size:10pt\">");
 		if(tokensID==null)
 		{
 			Random rnd=new Random();
 			tokensID=Long.toString(rnd.nextLong());
 			out.println("<p>Welcome. A new token"+tokensID +"is now established</p>");
 			String requestURLSame=req.getRequestURL().toString()+"?tokens="+tokensID;

 			out.println("<p>Otherwise,click <a href="+requestURLSame +">here </a> again to start browsing with as old identify.</p>");
 		}
 		else
 		{
 			out.println("Welcome back........Your token is "+tokensID +".</p>");
 			
 		}
 		
 		String requestURLNew=req.getRequestURL().toString();
 		out.println("<p>Otherwise,click <a href="+requestURLNew+">here </a> again to start browsing with a new identify.</p>");
 		out.println("</body></html>");
 		out.close();
 	}
}
