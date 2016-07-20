<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:useBean id="obj" class="com.java.User"></jsp:useBean>
<jsp:setProperty property="*" name="obj" />
<%@page import="java.io.PrintStream"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register page</title>
</head>
<body>
	<%
		System.out.print(request.getParameter("name"));
	%>

</body>
</html>