<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- Bootstrap theme -->
<link href="css/bootstrap-theme.min.css" rel="stylesheet">
<meta charset="ISO-8859-1">
<title>TIMELESS MUSIC</title>
</head>
<body>

	<div>
		<h2>${album.nombre}</h2>
		<h5>Artista: ${album.usuario.nombre}</h5>
	</div>
	
	<c:if test="${not empty canciones}">
		<table class="table">
			<thead>
				<tr>
					<th scope="col">Nombre</th>
					<th scope="col">Artista</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="cancion" items="${canciones}" begin="0">
					<tr>
						<td>${cancion.nombre }</td>
						<td>${cancion.artista.nombre}</td>
						<td><a href="${cancion.pathArchivo}">Play</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
	<c:if test="${mensajeAlbunes!=null}">
		<h3>${mensajeAlbunes}</h3>
	</c:if>
	
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