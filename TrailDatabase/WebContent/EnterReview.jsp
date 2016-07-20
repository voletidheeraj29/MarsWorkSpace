<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.dao.DatabaseConnector"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Enter Review</title>
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
	<%
		String bookname = "";
		int bookid = 0;
		bookid = Integer.parseInt((session.getAttribute("bookid")
				.toString()));
		Connection con = DatabaseConnector.getDatabaseConnector();
		PreparedStatement pst = con
				.prepareStatement("select * from books where id= ?");
		try {
			pst.setInt(1, bookid);
			ResultSet rs = pst.executeQuery();
			rs.next();
			bookname = rs.getString("bname");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	%>
	<div id="section">
		<h2>Enter Review</h2>
		<%
			if (request.getAttribute("result") == "true") {
				%>The Review is stored.<%
			}
		%>
		<form action=InsertReview method="post">
			<table align="center">
				<tr>
					<td>Book Name-</td>
					<td><input type="text" value=<%=bookname%> name="bname"
						readonly="readonly"></td>
				</tr>
				<tr>
					<td>Book Id-</td>
					<td><input type="text" value=<%=bookid%> name="bookid"
						readonly="readonly"></td>
				</tr>
				<tr>
					<td>Review-</td>
					<td><textarea name="reviewtext" rows="20" cols="50"></textarea></td>
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
