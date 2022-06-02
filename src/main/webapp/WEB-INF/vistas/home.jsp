<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<!-- Bootstrap core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- Bootstrap theme -->
<link href="css/bootstrap-theme.min.css" rel="stylesheet">
<title>TIMELESS MUSIC</title>
</head>
<body>
	<div class="container">
		<h1>TIMELESS MUSIC</h1>
		<a href="lista-canciones" class="btn btn-black">LISTA DE
				CANCIONES</a>
		<a href="streamings" class="btn btn-black">LISTA DE
				STREAMINGS</a>
		<c:if test="${nombreUsuario!=null}">
			<a href="#">${nombreUsuario}</a>
			<a href="cerrar-sesion">Cerrar sesion</a>
		</c:if>
		<c:if test="${nombreUsuario==null}">
			<a href="login">Iniciar sesion</a>
		</c:if>
		<div>
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
								<td>${cancion.album}</td>
								<td><a href="reproductor?id=${cancion.id}">Play</a></td>
							</tr>
						</c:forEach>

					</tbody>
				</table>
			</c:if>
		</div>
	</div>
	<!-- Placed at the end of the document so the pages load faster -->
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