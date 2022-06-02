<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Taller Web 1</title>
</head>
<body>
	Hola Taller Web!!
	<br>
	<c:forEach items="${streamings}" var="streaming">
	    <p>${streaming.id}</p>
	    <p>${streaming.artista}</p>
	    <p>${streaming.url}</p>
	</c:forEach>
	<br>
	
	<br>
	POST
	<br>
	GET

</body>
</html>