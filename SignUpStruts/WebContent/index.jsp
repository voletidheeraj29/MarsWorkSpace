<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<s:actionmessage />

	<s:form action="login">
		<s:textfield name="fname" label="First Name" />
		<s:textfield name="lname" label="Last Name" />
		<s:textfield name="uname" label="User Name" />
		<s:password name="password" label="Password" />
		<s:textfield name="email" label="Email" />
		<div>
			<div>
				<s:textfield name="dob" label="Date of Birth (in DD/mm/YYYY) "></s:textfield>
			</div>
<!-- 			<div> -->
<%-- 				<s:text name="Please Enter date in DD/mm/YYYY" /> --%>
<!-- 			</div> -->
		</div>

		<s:submit />
	</s:form>
</body>
</html>