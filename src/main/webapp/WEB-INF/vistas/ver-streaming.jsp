<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>TIMELESS MUSIC</title>
</head>
<body>
	<a href="home">HOME</a>
	<a href="lista-canciones" class="btn btn-black">LISTA DE CANCIONES</a>
	<a href="listatop?top=10" class="btn btn-black">TOP CANCIONES</a>
	<a href="streamings" class="btn btn-black">LISTA DE STREAMINGS</a>
	<a href="lista-conciertos" class="btn btn-black">LISTA DE
		CONCIERTOS</a>
	<div class="container">
		<iframe width="420" height="315" src="${url}"></iframe>
	</div>
</body>
</html>