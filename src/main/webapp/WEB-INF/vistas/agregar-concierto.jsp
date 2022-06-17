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
	<a href="home">Home</a>
	<a href="lista-canciones" class="btn btn-black">LISTA DE CANCIONES</a>
	<a href="listatop?top=10" class="btn btn-black">TOP CANCIONES</a>
	<a href="streamings" class="btn btn-black">LISTA DE STREAMINGS</a>
	<a href="lista-conciertos" class="btn btn-black">LISTA DE
		CONCIERTOS</a>
	<div class="container">
		<div id="loginbox" style="margin-top: 50px;"
			class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
			<form action="saveConcierto" method="POST">
				<input name="fecha" id="fecha" type="date" /> <input name="hora"
					id="hora" type="text" /> <select class="form-select" multiple
					name="artistas">
					<c:forEach var="artista" items="${artistas}" begin="0">
						<option value="${artista.id}">${artista.nombre}</option>
					</c:forEach>
				</select> <input name="lugar" id="lugar" type="lugar" required
					placeholder="Ingrese el lugar del concierto" />
				<button type="submit">GUARDAR CONCIERTO</button>
			</form>


			<c:if test="${not empty mensaje}">
				<h4>
					<span>${mensaje}</span>
				</h4>
				<br>
			</c:if>

			<c:if test="${not empty error}">
				<h4>
					<span>${error}</span>
				</h4>
				<br>
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