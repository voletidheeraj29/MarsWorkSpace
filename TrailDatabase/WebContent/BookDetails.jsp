<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.dao.DatabaseConnector"%>
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
		<table border="1">
			<tr>
				<th>ID</th>
				<th>Book Name</th>
				<th>Author</th>
			</tr>
			<%
				String bookid = request.getParameter("bid");
					ResultSet rs;
					Connection con = DatabaseConnector.getDatabaseConnector();
					PreparedStatement pst = con
							.prepareStatement("select * from books where id=?");
					PreparedStatement pst1;
					pst.setString(1, bookid);
					rs = pst.executeQuery();
					while (rs.next()) {
			%>
			<tr>
				<td><%=rs.getInt("id")%></td>
				<td><%=rs.getString("bname")%></td>
				<td><%=rs.getString("author")%></td>
			</tr>
			<%
				}
					DatabaseConnector.CloseConnection(con);
					;
			%>
		</table>
		<%
			con = DatabaseConnector.getDatabaseConnector();
			ResultSet rs1;
			pst1 = con
					.prepareStatement("select review from review where bookid=?");
			pst1.setString(1, bookid);
			rs1 = pst1.executeQuery();
			while (rs1.next()) {
		%>Review-<%=rs1.getString("review")%><br>
		<%
			}
		%>
		<form action="CheckUser.jsp" method="post">
			<%
				session.setAttribute("bookid", bookid);
			%>
			<input type="submit" value="Enter Review">
		</form>
	</div>

	<div id="footer">Copyright © Xyz</div>
</body>
</html>
