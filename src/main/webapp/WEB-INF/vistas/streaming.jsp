<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="<c:url value="/css/bootstrap.min.css" />" rel="stylesheet">
<script src="<c:url value="/js/example.js" />"></script>
<title>TIMELESS MUSIC</title>
</head>
<body>
	<a href="home">HOME</a>
		<a href="lista-canciones" class="btn btn-black">LISTA DE CANCIONES</a>
		<a href="lista-albunes" class="btn btn-black">LISTA DE ALBUNES</a> <a
			href="listatop?top=10" class="btn btn-black">TOP CANCIONES</a> <a
			href="lista-conciertos" class="btn btn-black">LISTA DE CONCIERTOS</a>
		<a href="streamings" class="btn btn-black">LISTA DE STREAMINGS
			DISPONIBLES</a> 
			<a href="streamingsComprados" class="btn btn-black">LISTA
			DE STREAMINGS COMPRADOS</a>
	<table class="table table-hover">
		<thead>
			<tr>
				<th>Id</th>
				<th>Artista</th>
				<th>Stream</th>
				<th>Comprar</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${streamings}" var="streaming">
				<tr>
					<td>${streaming.id}</td>
					<td>${streaming.artista}</td>
					<td><a href="${streaming.url}" target="_blank">Ver
							streaming</a></td>
					<td><button type="button" class="btn btn-success">
							<a href="/proyecto-limpio-spring/compraStreaming/${streaming.id}">Comprar</a>
						</button></td>
				</tr>
			</c:forEach>
		</tbody>
		<h2>${error}</h2>
	</table>
</body>
</html>