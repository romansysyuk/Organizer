<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit your event here</title>
</head>
<body>
	<h2>Edit Event</h2>
	<form:form method="POST" modelAttribute="event" action="">
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
				<td><input type="submit" value="Edit" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>