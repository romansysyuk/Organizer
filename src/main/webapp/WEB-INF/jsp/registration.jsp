<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Person Registration Form</title>
</head>

<body>
	<h2>Registration Form</h2>
	<form:form method="POST" modelAttribute="rdto">
		<form:input type="hidden" path="userInfoId" />
		<form:input type="hidden" path="userId" />
		<table>
			<tr>
				<td><label for="firstName">First Name: </label></td>
				<td><form:input path="firstName" /></td>
			</tr>
			<tr>
				<td><label for="lastName">Last Name: </label></td>
				<td><form:input path="lastName" /></td>
			</tr>
			<tr>
				<td><label for="birthday">Birthday: </label></td>
				<td><form:input path="birthday" /></td>
			</tr>
			<tr>
				<td><label for="email">Email: </label></td>
				<td><form:input path="email" /></td>
			</tr>
			 <tr>
				<td><label for="username">Login: </label></td>
				<td><form:input path="username" /></td>
			</tr>
			<tr>
				<td><label for="password">Password: </label></td>
				<td><form:password path="password" /></td>
			</tr> 
			<tr>
				<td colspan="3"><input type="submit" value="Register" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>