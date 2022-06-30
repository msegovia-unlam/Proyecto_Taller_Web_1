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
		<a href="lista-canciones" class="btn btn-black">LISTA DE CANCIONES</a>
		<a href="lista-albunes" class="btn btn-black">LISTA DE ALBUNES</a>
		<a href="listatop?top=10" class="btn btn-black">TOP CANCIONES</a> 
		 <a href="lista-conciertos" class="btn btn-black">LISTA DE CONCIERTOS</a>
		<a href="streamings" class="btn btn-black">LISTA DE STREAMINGS
			DISPONIBLES</a> 
			<a href="streamingsComprados" class="btn btn-black">LISTA
			DE STREAMINGS COMPRADOS</a>

		<c:if test="${nombreUsuario!=null}">
			<a href="perfil">${nombreUsuario}</a>
			<a href="cerrar-sesion">Cerrar sesion</a>
		</c:if>
		<c:if test="${nombreUsuario==null}">
			<a href="login">Iniciar sesion</a>
		</c:if>
		
		<div>
			<h3>ALBUNES</h3>
			<c:if test="${not empty albunes}">
				<table class="table">
					<thead>
						<tr>
							<th scope="col">Nombre</th>
							<th scope="col">Artista</th>
							
						</tr>
					</thead>
					<tbody>
						<c:forEach var="album" items="${albunes}" begin="0">
							<tr>
								<td><a href="album?id=${album.id}">${album.nombre}</a></td>
								<td>${album.usuario.nombre}</td>
							</tr>
						</c:forEach>

					</tbody>
				</table>
			</c:if>
			<c:if test="${empty albunes}">
				<h5>${mensajeAlbunes}</h5>
			</c:if>
		</div>
		
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

		<div>
			<h3>ARTISTAS</h3>
			<c:if test="${not empty artistas}">
				<table class="table">
					<thead>
						<tr>
							<th scope="col">Nombre Artista</th>
							<th scope="col">Genero</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="artista" items="${artistas}" begin="0">
							<tr>
								<td><a href="artista?id=${artista.id}">${artista.nombre }</a></td>
								<td>${artista.genero}</td>
							</tr>
						</c:forEach>

					</tbody>
				</table>
			</c:if>
			<c:if test="${empty artistas}">
				<h5>${mensajeArtistas}</h5>
			</c:if>
		</div>


		<div>
			<h3>CANCIONES</h3>
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
								<td><a href="reproductor?id=${cancion.id}">Play</a></td>
							</tr>
						</c:forEach>

					</tbody>
				</table>
			</c:if>
			<c:if test="${empty canciones}">
				<h5>${mensajeCanciones}</h5>
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