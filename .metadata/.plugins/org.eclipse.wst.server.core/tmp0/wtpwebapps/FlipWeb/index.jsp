<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.io.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>www.Flipweb.com</title>
<link href="/FlipWeb/css/main.css" rel="stylesheet" type="text/css">
</head>
<body>
	<ul>
		<ul style="float: left; list-style-type: none;">
			<li><a href="index.jsp">Home</a></li>
			<li><a href="jsp/men.jsp">Men</a></li>
			<li><a href="jsp/women.jsp">Women</a></li>
			<!-- <li><input type="text" class="textInput" name="q" size="50"
				maxlength="120"> <input type="submit" value="search"
				class="searchButton"></li> -->
			<li>
		</ul>
		<ul style="float: right; list-style-type: none;">
			
			<%
			request.getSession();
							String username = "Login";
				if (request.getAttribute("user1") != null) {
					username = request.getAttribute("user1").toString();
				}
				
			%>
			
			<li><a href="jsp/register.jsp">Register</a></li>
			<li><a href="jsp/login.jsp"><%=username%></a></li>
				</ul>
	</ul>
</body>
</html>