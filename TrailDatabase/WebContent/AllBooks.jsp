<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*"%>
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
	height: 100px
}

#headerright {
	background-color: black;
	height: 25px;
	color: white;
	float: right;
	text-align: center;
	width: 400px
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
		<h1>Books</h1>
		<div id="headerright"></div>
	</div>

	<div id="nav">
		<a href="AdminLogin.jsp" style="text-decoration: none">Admin Login</a><br>
		<a href="UserLogin.jsp" style="text-decoration: none">User Login</a><br>
		<a href="AllBooks.jsp" style="text-decoration: none">All Books</a><br>
		<a href="BookSearch.jsp" style="text-decoration: none">Book Search</a><br>
	</div>


	<div id="section">
		<h2>Books</h2>
		<table border="1">
			<tr>
				<th>ID</th>
				<th>Book Name</th>
				<th>Author</th>
			</tr>
			<%
				Connection con = DatabaseConnector.getDatabaseConnector();
				PreparedStatement pst = con.prepareStatement("select * from books");
				ResultSet rs = pst.executeQuery();
				while (rs.next()) {
			%>
			<tr>
				<td><%=rs.getInt("id")%></td>
				<td><a href="BookDetails.jsp?bid=<%=rs.getInt("id")%>"><%=rs.getString("bname")%></a></td>
				<td><%=rs.getString("author")%></td>
			</tr>
			<%
				}
				;
			%>
		</table>
	</div>

	<div id="footer">Copyright © Xyz</div>

</body>
</html>
