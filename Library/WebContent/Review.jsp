<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page import="com.sun.tracing.dtrace.FunctionName"%>
<%@page import="org.apache.catalina.Session"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.Connection" %>
    <%@ page import="java.sql.DriverManager" %>
    <%@ page import="java.sql.PreparedStatement" %>
   <%@ page import="java.sql.ResultSet" %>
    <%@ page import="java.sql.Statement" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="reviewSuccess.html">
Enter Comments: <input type="text" name="comments">
<input type="submit" value="Add Comment">
</form>
<%
Connection con;
ResultSet rs;
PreparedStatement psmt;


Class.forName("com.mysql.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","root");

String id=request.getParameter("id");
Statement stm=con.createStatement();
rs=stm.executeQuery("SELECT * from book where id="+id);

if(rs.next())
{
	String book=rs.getString(1);
	PreparedStatement pst=con.prepareStatement("insert into review values(?,?,?,?) ");
	pst.setString(2, id);
	pst.setString(3, book);
	pst.setString(4, session.getAttribute("UserID").toString());
	pst.setString(5, request.getParameter("comments"));
}
%>
</body>
</html>