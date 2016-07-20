<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
			if (request.getAttribute("msg") != null) {
				out.print(request.getAttribute("msg").toString());
		%>
		Click here to<a href="UserLogin.jsp">Login</a>
		<%
			}
		%>
		<h1>Registration</h1>
		<form action="UserResgistration" method="post" name="registration">
			<table>
				<tr>
					<td>Name</td>
					<td><input type="text" id="name" placeholder="Username"
						name="name"
						oninvalid="this.setCustomValidity('Enter User Name Here')"
						oninput="setCustomValidity('')" required></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="password" id="name"
						placeholder="password"
						oninvalid="this.setCustomValidity('Enter Password Here')"
						oninput="setCustomValidity('')" required></td>
				</tr>
				<tr>
					<td><input type="submit" value="Submit"></td>
					<td><input type="reset" value="Reset"></td>
				</tr>
			</table>
		</form>

	</div>

	<div id="footer">Copyright © Xyz</div>

</body>
</html>
