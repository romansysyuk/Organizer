<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Event Form</title>
</head>
<body>
	<h2>New Event</h2>
	<form:form method="POST" modelAttribute="event">
		<form:input type="hidden" path="eventId" />
		<table>
			<tr>
				<td><label for="eventName">Event name:</label></td>
				<td><form:input path="eventName" /></td>
			</tr>
			<tr>
				<td><label for="eventDate">Event date:</label></td>
				<td><form:input path="eventDate" /></td>
			</tr>
			<tr>
				<td><label for="description">Event description:</label></td>
				<td><form:input path="description" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Create" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>