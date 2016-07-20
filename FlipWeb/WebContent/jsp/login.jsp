<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>

<link href="/FlipWeb/css/login.css" rel="stylesheet" type="text/css">
</head>
<body >
	<form action="/FlipWeb/UserLogin" method="post" name="Login">
		<ul>
			<ul style="float: left; list-style-type: none;">
				<li><a href="/FlipWeb/index.jsp">Home</a>
				<li><a href="men.jsp">Men</a>
				<li><a href="women.jsp">Women</a>
			</ul>
			<ul style="float: right; list-style-type: none;">
				<li><a href="register.jsp">Register</a></li>
				<li><a href="login.jsp">Login</a></li>
			</ul>
		</ul>

		<table >

			<tr>
				<td>Name</td>
				<td><input type="text" id="name" placeholder="Username"
					name="name"
					oninvalid="this.setCustomValidity('Enter User Name Here')"
					oninput="setCustomValidity('')" required></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="pass" id="name"
					placeholder="password"
					oninvalid="this.setCustomValidity('Enter Password Here')"
					oninput="setCustomValidity('')" required></td>
			</tr>
			<tr>
				<td><input type="submit" value="Submit" ></td>
				<td><input type="reset" value="Reset"></td>
				<td><a href="recovery.jsp">forgot password</a></td>
			</tr>
		</table>
	</form>
</body>
</html>