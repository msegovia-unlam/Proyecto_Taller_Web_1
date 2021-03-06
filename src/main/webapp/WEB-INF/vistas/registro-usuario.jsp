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
		<a href="home">HOME</a> 
		<a href="login">Login</a>
		<div id="loginbox" style="margin-top: 50px;"
			class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
			<form action="registrarme" method="POST">
				<h3 class="form-signin-heading">Nuevo Usuario</h3>
				<hr class="colorgraph">
				<br> <input name="nombre" type="text" id="nombre"
					class="form-control" placeholder="Ingresar Nombre" /> <input
					name="email" type="email" id="email" class="form-control"
					placeholder="Ingresar Email" /> <input name="clave" type="password"
					id="clave" class="form-control" placeholder="Ingresar Contraseņa" />
				<button id="btn-registrarme"
					class="btn btn-lg btn-primary btn-block" type="submit">
					Registrarme</button>
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