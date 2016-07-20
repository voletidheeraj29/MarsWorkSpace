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
<%

Connection con;
ResultSet rs;
PreparedStatement psmt;

if(session.getAttribute("UserID")==null){
	
	out.println("Please login first...");%>
	<a href="/Library/UserLogin.html">Login</a><br/>
	<%
}
else{
Class.forName("com.mysql.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","root");

String title=request.getParameter("title");
 Statement stm=con.createStatement();
 rs=stm.executeQuery("SELECT *, SUBSTRING(title, 1, 4) FROM book WHERE title like '%"+title+"%'");
 if(rs.next()){
 while(rs.next())
 {
	String bookName = rs.getString(1);
	String author = rs.getString(2);
%>
<a href='details.jsp?id="<%=rs.getInt(5) %>"'><%= bookName %></a>

<% 	
 }
 }
 
 else
 
	 out.println("sorry...this book is not available!");
}
%>
<a href="/Library/index.html">Back to Home</a>
</body>
</html>