<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Check User</title>
<style>
#header {
	background-color: black;
	color: white;
	text-align: center;
	padding: 5px;
}

#nav {
	line-height: 30px;
	background-color: #eeeeee;
	height: 775px;
	width: 100px;
	float: left;
	padding: 5px;
}

#section {
	width: 350px;
	float: left;
	padding: 10px;
}

#footer {
	background-color: black;
	color: white;
	clear: both;
	text-align: center;
	padding: 5px;
}
</style>
</head>
<body>
	<div id="header">
		<h1>Library Review System</h1>
	</div>

	<div id="nav">
		<a href="AdminLogin.jsp" style="text-decoration: none">Admin Login</a><br>
		<a href="UserLogin.jsp" style="text-decoration: none">User Login</a><br>
		<a href="AllBooks.jsp" style="text-decoration: none">All Books</a><br>
		<a href="BookSearch.jsp" style="text-decoration: none">Book Search</a><br>
	</div>
	<div id="section">
		<%
			if (session.getAttribute("userid") == null) {
		%>
		<h4>

			You are not Logged in. </br> <a href="UserLogin.jsp">Please Login</a>
		</h4>
	</div>
	<%
		} else {
			request.getRequestDispatcher("/EnterReview.jsp").forward(
					request, response);
		}
	%>
	<div id="footer">Copyright © Xyz</div>
</body>
</html>