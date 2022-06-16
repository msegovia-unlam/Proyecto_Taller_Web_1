<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- Bootstrap theme -->
<link href="css/bootstrap-theme.min.css" rel="stylesheet">
<title>TIMELESS MUSIC</title>
</head>
<body>
	<a href="crear-concierto" class="btn btn-black">AGREGAR CONCIERTO</a>
	<div>
		<h3>CONCIERTOS</h3>
		<c:if test="${not empty conciertos}">
			<table class="table">
				<thead>
					<tr>
						<th scope="col">Fecha</th>
						<th scope="col">Hora</th>
						<th scope="col">Lugar</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="concierto" items="${conciertos}" begin="0">
						<tr>
							<td>${concierto.fecha}</td>
							<td>${concierto.hora}</td>
							<td>${concierto.lugar}</td>
						</tr>
					</c:forEach>

				</tbody>
			</table>
		</c:if>
		<c:if test="${empty conciertos}">
			<h5>${mensajeConciertos}</h5>
		</c:if>
	</div>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script>
		window.jQuery
				|| document
						.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')
	</script>
	<script src="js/bootstrap.min.js" type="text/javascript"></script>
</body>
</html>