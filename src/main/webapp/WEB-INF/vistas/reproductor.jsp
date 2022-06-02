<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
  Created by IntelliJ IDEA.
  User: MS-D
  Date: 01/06/2022
  Time: 18:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<title>TIMELESS MUSIC</title>
</head>
<body>
	<a href="home">HOME</a>
	<video controls autoplay name="media">
		<source src="${cancion.getArchivo()}" type="audio/mpeg">
	</video>

</body>
</html>
