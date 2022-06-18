<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
    <c:if test="${not empty canciones}">
        <table class="table">
            <thead>
            <tr>
                <th scope="col" colspan="4">Top 10</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="cancion" items="${canciones}" begin="0">
                <tr>
                    <td>${cancion.nombre}</td>
                    <td>${cancion.artista.nombre}</td>
                    <td>${cancion.album}</td>
                    <td><a href="reproductor?id=${cancion.id}">Play</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>

</body>
</html>
