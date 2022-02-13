<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Persons</title>
</head>
<body>

	<c:forEach items="${persons}" var="person">
		<p>
			<c:out value="${person.id} ${person.name}" />
		</p>
	</c:forEach>

</body>
</html>