<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Organizer index page</title>
</head>

<body>
	<c:if test="${pageContext.request.userPrincipal.name != null}">
		<c:out value="Hello, ${pageContext.request.userPrincipal.name}" />
	</c:if>
	<c:if test="${pageContext.request.userPrincipal.name == null}">
		<c:out value="Hello, you are unregistered user" />
	</c:if>
	<table align="center" border="1">
		<tr>
			<td><a href="newUser">Registration</a></td>
			<td><a href="login">Login</a></td>
			<sec:authorize access="hasRole('ADMIN')">
				<td><a href="admin/allEvents">Events</a></td>
				<td><a href="admin/allUsers">Users</a></td>
			</sec:authorize>
		</tr>
	</table>
</body>
</html>