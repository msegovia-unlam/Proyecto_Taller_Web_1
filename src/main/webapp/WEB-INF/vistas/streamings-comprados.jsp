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
		<table class="table table-hover">
			<thead>
				<tr>
					<th>Id</th>
					<th>Artista</th>
					<th>Stream</th>
				</tr>				
			</thead>
			<tbody>				
				<c:forEach items="${streamings}" var="streaming">
					<tr>
						<td>${streaming.id}</td>
						<td>${streaming.artista}</td>
						<td><a href="${streaming.url}" target="_blank">Ver streaming</a></td>
					</tr>
				</c:forEach>
			</tbody>
			<h2>${error}</h2>
		</table>				
	</body>
</html>