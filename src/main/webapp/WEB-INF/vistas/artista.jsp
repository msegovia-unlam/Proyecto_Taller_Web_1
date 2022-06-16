<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Bootstrap core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- Bootstrap theme -->
<link href="css/bootstrap-theme.min.css" rel="stylesheet">
<title>TIMELESS MUSIC</title>
</head>
<body>
	<h2>${nombre}</h2>

	<div>
		<h4>CANCIONES</h3>
		<c:if test="${not empty canciones}">
			<table class="table">
				<thead>
					<tr>
						<th scope="col">Nombre Cancion</th>
						<th scope="col">Album</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="cancion" items="${canciones}" begin="0">
						<tr>
							<td>${cancion.nombre }</td>
							<td>${cancion.album}</td>
							<td><a href="reproductor?id=${cancion.id}">Play</a></td>
						</tr>
					</c:forEach>

				</tbody>
			</table>
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