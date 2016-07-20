<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Books</title>
</head>
<body>
<h3><%=session.getAttribute("UserID") %></h3>
<jsp:include page="Logout.html"/>

<form action="/Library/BookDetails.jsp">
Enter Title : <input type="text" name="title">
<input type="submit" value="Search">
</form>
<a href="/Library/index.html">LOGOUT</a>
<a href="/Library/index.html">Back to Home</a>
</body>
</html>