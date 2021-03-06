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
	<a href="home">Home</a>
		<a href="lista-canciones" class="btn btn-black">LISTA DE CANCIONES</a>
		<a href="lista-albunes" class="btn btn-black">LISTA DE ALBUNES</a> <a
			href="listatop?top=10" class="btn btn-black">TOP CANCIONES</a> <a
			href="lista-conciertos" class="btn btn-black">LISTA DE CONCIERTOS</a>
		<a href="streamings" class="btn btn-black">LISTA DE STREAMINGS
			DISPONIBLES</a> 
			<a href="streamingsComprados" class="btn btn-black">LISTA
			DE STREAMINGS COMPRADOS</a>
	<c:if test="${nombreUsuario!=null}">
		<a href="agregar-cancion">AGREGAR CANCION</a>
		<a href="cerrar-sesion">Cerrar sesion</a>
	</c:if>
	<c:if test="${nombreUsuario==null}">
		<a href="login">Iniciar sesion</a>
	</c:if>
	<form action="lista-canciones">
		<input type="text" name="busqueda" id="busqueda"
			placeholder="Buscar por nombre de cancion"> <input
			type="submit" value="Buscar">
	</form>
	<c:if test="${not empty canciones}">
		<table class="table">
			<thead>
				<tr>
					<th scope="col">Nombre Cancion</th>
					<th scope="col">Artista</th>
					<th scope="col">Album</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="cancion" items="${canciones}" begin="0">
					<tr>
						<td>${cancion.nombre }</td>
						<td>${cancion.artista.nombre}</td>
						<td>${cancion.album.nombre}</td>
						<td><a href="${cancion.pathArchivo}">Play</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
	<c:if test="${mensaje!=null}">
		<h3>${mensaje}</h3>
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