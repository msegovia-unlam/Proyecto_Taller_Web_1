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
	<a href="streamings" class="btn btn-black">LISTA DE STREAMINGS</a>
	<div class="container">
		<div id="loginbox" style="margin-top: 50px;"
			class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
			<form action="saveConcierto" method="POST" name="concierto">
				<select name="anio" onchange="cambiar()">
					<c:forEach var="anio" items="${anios}" begin="0">
						<option value="${anio}">${anio}
					</c:forEach>
				</select> <select name="mes" onchange="cambiar()">
					<c:forEach var="mes" items="${meses}" begin="0">
						<option value="${mes}">${mes}
					</c:forEach>
				</select> <select name="dia">
					<option value="-">-
				</select> <input name="hora" id="hora" type="text" /> <select
					class="form-select" multiple name="artistas">
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

	<script type="text/javascript">
		var mesesCon31Dias = new Array(1, 3, 5, 7, 8, 10, 12);
		var mesesCon30Dias = new Array(4, 6, 9, 11);
		var diasEnOption = new Array();
		var cantidadDias = 0;

		function cambiar() {
			var mes;
			mes = document.concierto.mes[document.concierto.mes.selectedIndex].value;
			var anio = document.concierto.anio[document.concierto.anio.selectedIndex].value;
			if ((mes==1)||(mes==3)||(mes==5)||(mes==7)||(mes==8)||(mes==10)||(mes==12)) {
				cantidadDias = 31;
			}
			
			if ((mes==4)||(mes==6)||(mes==9)||(mes==11)) {
				cantidadDias = 30;
			}
			
			if (mes == 2) {
				if (esBisiesto(anio)) {
					cantidadDias = 29;
				} else {
					cantidadDias = 28;
				}
			}
			diasEnOption = cargarDias(cantidadDias, diasEnOption);

			//misOptions = eval(diasEnOption);

			numeroOptions = diasEnOption.length;
			document.concierto.dia.length = numeroOptions;
			for (i = 0; i < numeroOptions; i++) {
				document.concierto.dia.options[i].value = diasEnOption[i];
				document.concierto.dia.options[i].text = diasEnOption[i];
			}
			document.concierto.dia.options[0].selected = true;
		}

		function cargarDias(cantidadDias, array) {
			diasEnOption.splice(0);
			for (var i = 1; i <= cantidadDias; i++) {
				array.push(i);
			}
			return array;
		}

		function esBisiesto(anio) {
			if ((anio % 4) == 0) {
				if ((anio % 100) == 0) {
					if ((anio % 400) == 0) {
						return true;
					} else {
						return false;
					}
				} else {
					return true;
				}
			} else {
				return false;
			}
		}
	</script>
</body>
</html>