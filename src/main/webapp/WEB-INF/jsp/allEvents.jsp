<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All Events</title>
</head>
<body>
	Welcome ADMIN
	<table border=1>
		<tr>
			<th>Event Name</th>
			<th>Event Date</th>
			<th>Description</th>
			<th>Username</th>
			<th>Delete</th>
		</tr>
		<c:forEach items="${events}" var="event">
			<tr>
				<td><c:out value="${event.getEventName()}" /></td>
				<td><c:out value="${event.getEventDate()}" /></td>
				<td><c:out value="${event.getDescription()}" /></td>
				<td><c:out value="${event.getUser().getUsername()}" /></td>
				<td><a href="deleteEvent/${event.getEventId()}">Delete this
						event</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>