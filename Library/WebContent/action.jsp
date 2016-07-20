<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String action1=request.getParameter("add");
String action2=request.getParameter("remove");
 if(action1.equals("Add Book"))
{
out.println("add");
}

 if(action2.equals("Remove Book"))
{
out.println("remove");	
} 
%>
</body>
</html>