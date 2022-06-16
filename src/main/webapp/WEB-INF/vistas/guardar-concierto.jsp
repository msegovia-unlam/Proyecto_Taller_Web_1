<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>Fecha: ${fecha}</h3>
	<h3>Hora: ${hora}</h3>
	<h3>Lugar: ${lugar}</h3>
	<c:forEach var="artista" items="${artistas}" begin="0">
		<h5>${artista.nombre}</h5>
	</c:forEach>
</body>
</html>