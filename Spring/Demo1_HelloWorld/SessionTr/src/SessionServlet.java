

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionServlet
 */
public class SessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	public void doGet(HttpServletRequest req , HttpServletResponse resp) throws ServletException , IOException 
	{
		resp.setContentType("text/html");
  	    PrintWriter out = resp.getWriter();
		HttpSession session = req.getSession(true);
		if(session.isNew())
		{			
			session.setAttribute("hits",new Integer("0"));
			out.println("<form  action=SessionServlet.com>");
			out.println("<input type=submit>");
			out.println("</form>");
		}
		else
		{
			Integer x = (Integer) session.getAttribute("hits") ;
			int hits = x.intValue();
			hits++;
			out.println("<form action=SessionServlet.com>");
			out.println("<input type=submit>");
			out.println("</form>");
			session.setAttribute("hits",new Integer(hits));
		}
		out.println("hits=" + session.getAttribute("hits"));
	}//end of doGet

	public void doPost(HttpServletRequest req , HttpServletResponse resp) throws ServletException , IOException 
	{
        doGet(req,resp);
	}
}
