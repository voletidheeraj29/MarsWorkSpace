<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Recovery password</title>
<link href="/FlipWeb/css/login.css" rel="stylesheet" type="text/css">
</head>
<body>
	
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
		   <script>
    function check_pass(){
    if (document.getElementById('pass1').value==document.getElementById('pass2').value){
 document.getElementById('submit').disabled = false;
}
else {
 document.getElementById('submit').disabled = true;
}
    }
    </script>
    <form action="/FlipWeb/UpdatePassword" method="post">
		<table>
			<tr>
				<td>Name</td>
				<td><input type="text" id="name" placeholder="Username"
					name="name"
					oninvalid="this.setCustomValidity('Enter User Name Here')"
					oninput="setCustomValidity('')" required></td>
			</tr>
		
			<tr>
				<td>New password</td>
				<td><input type="password" id="pass1" placeholder="Newpassword"
					name="pass1"
					oninvalid="this.setCustomValidity('Enter new password Here')"
					oninput="setCustomValidity('')" required onchange='check_pass();'></td>
			</tr>
			<tr>
				<td>Retype Password</td>
				<td><input type="password" name="pass2" id="pass2"
					placeholder="Retype password"
					oninvalid="this.setCustomValidity('Enter retypePassword Here')"
					oninput="setCustomValidity('')" required  onchange='check_pass();'></td>
			</tr>
	<tr>
				<td><input type="submit" value="Submit" id="submit" disabled></td>
				<td><input type="reset" value="Reset"></td>

			</tr>
		</table>
	</form>
</body>
</html>