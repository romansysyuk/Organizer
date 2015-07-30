<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	Welcome : ${pageContext.request.userPrincipal.name}
	<table border=1>
		<tr>
			<th>Event Name</th>
			<th>Event Date</th>
			<th>Description</th>
			<th>Delete/Edit</th>
		</tr>
		<c:forEach items="${events}" var="event">
			<tr>
				<td><c:out value="${event.getEventName()}" /></td>
				<td><c:out value="${event.getEventDate()}" /></td>
				<td><c:out value="${event.getDescription()}" /></td>
				<td><a href="deleteEvent/${event.getEventId()}">Delete</a> <br>
					<a href="editEvent/${event.getEventId()}">Edit</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>