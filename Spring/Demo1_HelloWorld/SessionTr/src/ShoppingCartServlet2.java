import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ShoppingCartServlet2 extends HttpServlet
{
  protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException
  {
    HttpSession session = req.getSession(false);
    res.setContentType("text/html");
    res.setHeader("pragma", "no-cache");
    PrintWriter out = res.getWriter();
    out.print("<HTML><HEAD><TITLE>Online Shop</TITLE>"+
	      "</HEAD><BODY><FORM METHOD=POST ACTION=");
    out.print(res.encodeUrl(req.getRequestURI()));
    out.print("><INPUT TYPE=SUBMIT NAME=A VALUE="+
	      "\"Put a A into the shopping cart\">"+
	      "<INPUT TYPE=SUBMIT NAME=B VALUE="+
	      "\"Put a B into the shopping cart\">"+
	      "<INPUT TYPE=SUBMIT NAME=see VALUE="+
	      "\"See the shopping cart contents\">"+
	      "<INPUT TYPE=SUBMIT NAME=buy VALUE="+
	      "\"Buy the shopping cart contents\">"+
	      "</FORM></BODY></HTML>");
    out.close();
  }

  protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException
  {
    String msg;

    HttpSession session = req.getSession(true);
    if(session.isNew())
    {
      session.putValue("A", new int[] { 0 });
      session.putValue("B", new int[] { 0 });
    }

    int[] A = (int[])session.getValue("A");
    int[] B = (int[])session.getValue("B");

    if(req.getParameter("A") != null)
    {
      A[0]++;
      msg = "Bought a A. You now have "+A[0]+".";
    }
    else if(req.getParameter("B") != null)
    {
      B[0]++;
      msg = "Bought a B. You now have "+B[0]+".";
    }
    else if(req.getParameter("buy") != null)
    {
      session.invalidate();
      msg = "Your order for "+A[0]+" As and "+B[0]+
	" Bs has been accepted. Your shopping cart is empty now.";
    }
    else
    {
      msg = "You have "+A[0]+" As and "+B[0]+
	" Bs in your shopping cart.";
    }

    res.setContentType("text/html");
    res.setHeader("pragma", "no-cache");
    PrintWriter out = res.getWriter();
    out.print("<HTML><HEAD><TITLE>Shopping Cart</TITLE></HEAD><BODY>");
    out.print(msg);
    out.print("<HR><A HREF=\"");
    out.print(res.encodeUrl(req.getRequestURI()));
    out.print("\">Back to the shop</A></BODY></HTML>");
    out.close();
  }

  public String getServletInfo()
  {
    return "ShoppingCartServlet2 1.0 by Sangeetaj";
  }
}
