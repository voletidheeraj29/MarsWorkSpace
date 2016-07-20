

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieServlet
 */
public class CookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	static int ctr;
	public void init()
	{
	   ctr=0;

	}
	public void doGet(HttpServletRequest req,HttpServletResponse res)
		throws ServletException,IOException
	{
		Cookie MyCookie=null;
		res.setContentType("Text/html");
		PrintWriter out=res.getWriter();
		out.println("<html><head><title>Tokens</title></head><body");
		 out.println("style=\"font-family:verdana;font-size:10pt\">");
          //out.println("<input value=);

		Cookie[] coki=req.getCookies();
		 
		if(coki !=null)
		 {
			for(int i=0;i<coki.length;i++)
			 {


                
				Cookie c1=coki[i];
					//out.println("Number"+c1.getName());
                   // out.println("Number"+c1.getValue());

				if(coki[i].getName().equals("MyK"))
				 {
					 MyCookie=coki[i];
					 break;
				 }
			 }
		 }

		 //String reset=req.getParameter("reset");
		 //System.out.println(reset);
		 if(MyCookie==null)
		{
			 MyCookie=new Cookie("MyK",Long.toString(new Random().nextLong()));
		 res.addCookie(MyCookie);
		 ctr++;
		  out.println("<p>Welcome. A new token "+MyCookie.getValue()+ "is now established</p>");


		}
		
         else if( MyCookie !=null)
		{
		out.println("welcome back..your token is"+MyCookie.getValue()+".</p>");

		}
		/*if(reset.getValue()=="yes")
		{
			 MyCookie=new Cookie("MyK",Long.toString(new Random().nextLong()));
		 res.addCookie(MyCookie);
		 ctr++;
         out.println("<p>Welcome. A new token "+id+ "is now established</p>");

		}*/
		// else

		   // out.println("Number no cokies");

		 
		/* String reset=req.getParameter("reset");
		 System.out.println("reset"+reset);
		 if(tokens != null)
		 out.println("welcome back..your token is"+tokens.getValue()+".</p>");
		if(tokens==null||(reset!=null && reset.equals("yes")))
          //if(tokens==null)
		{
			 Random rnd=new Random();
			 long id=rnd.nextLong();
			 out.println("<p>Welcome. A new token "+id+ "is now established</p>");
			 tokens=new Cookie("token",Long.toString(id));
			 tokens.setComment("Token to identify user");
			 tokens.setMaxAge(-1);
			 tokens.setPath("/cookie/ ");  
			 
		}
		
		else
		{
			out.println("welcome back..your token is"+tokens.getValue()+".</p>");
		}

		String requestURLSame=req.getRequestURL().toString();
		String requestURLNew=req.getRequestURL() + "?reset=yes";
		out.println("<p>Click<a href=" + requestURLSame +"> here </a> again to continue browsing with the  " + "same identify. </p>");
		out.println("<p>Otherwise, click <a href=" + requestURLNew + "> here </a> again to start browsing  with a new identify.</p>");*/
		out.println("</body></html>");
		out.close();
	}
}
