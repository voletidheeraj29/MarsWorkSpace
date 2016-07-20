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
<title>Add/Remove</title>
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
	<%if (request.getAttribute("msg")!= null){
		out.print(request.getAttribute("msg").toString());	
	}%>
	
		<h2>Add/Remove</h2>
		<form action=AddRemove method="post">
			<table align="center">
				<tr>
					<td>Book Name</td>
					<td><input type="text" name="bookname"></td>
				</tr>
				<tr>
					<td>Author</td>
					<td><input type="text" name="author"></td>
				</tr>
				<tr>
					<td><input type="radio" name="update" value="1">Add</td>
					<td><input type="radio" name="update" value="0">Remove</td>
				</tr>
				<tr>
					<td><input type="submit" value="Submit"></td>
					<td><input type="reset"></td>
				</tr>
			</table>
		</form>
	</div>

	<div id="footer">Copyright © Xyz</div>

</body>
</html>