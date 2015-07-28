<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All Users</title>
</head>
<body>
	Welcome ADMIN
	<table border=1>
		<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Birthday</th>
			<th>Email</th>
			<th>Username</th>
			<th>Delete</th>
		</tr>
		<c:forEach items="${users}" var="user">
			<tr>
				<td><c:out value="${user.getFirstName()}" /></td>
				<td><c:out value="${user.getLastName()}" /></td>
				<td><c:out value="${user.getBirthday()}" /></td>
				<td><c:out value="${user.getEmail()}" /></td>
				<td><c:out value="${user.getUser().getUsername()}" /></td>
				<td><a href="deleteUser/${user.getUser().getUserId()}">Delete
						this user</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>