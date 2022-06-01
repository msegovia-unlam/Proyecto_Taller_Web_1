<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet" >
    <!-- Bootstrap theme -->
    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
</head>
<body>
<a href="home">Home</a>
<div class = "container">
    <div id="loginbox" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
       <form action="saveCancion" method="POST" enctype="multipart/form-data">
 			<input name="nombre" id="nombre" type="text" required placeholder="Ingrese nombre de la cancion"/>
 			<select class="form-select" aria-label="Disabled select example" disabled>
  				<option selected>${nombreArtista}</option>
			</select>
 			<input name="album" id="album" type="text" required placeholder="Ingrese album de la cancion"/>
 			<input name="archivo" id="archivo" type="file">
 			<button type="submit">GUARDAR CANCION</button>
 		</form>
 		
 		
		<c:if test="${not empty mensaje}">
            <h4><span>${mensaje}</span></h4>
            <br>
        </c:if>
		
        <c:if test="${not empty error}">
            <h4><span>${error}</span></h4>
            <br>
        </c:if>
    </div>
</div>

<!-- Placed at the end of the document so the pages load faster -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
</body>
</html>