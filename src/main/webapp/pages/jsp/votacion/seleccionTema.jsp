<?xml version="1.0" encoding="UTF-8"  ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Votar</title>
</head>
<body>
	<h1>Seleccione el tema a votar</h1>
	<c:set var="seleccionarTemaView" scope="request"
		value="${seleccionarTemaView}" />
	<p>
		<span style="color: red">${errorMsg}</span> <span style="color: green">${successMsg}</span>
	</p>
	<form action="/Web/jsp/votacion/votar" method="post">
		<p>
			<span style="font-weight: bold">Tema: </span> <select name="temas">
				<c:forEach items="${seleccionarTemaView.listTemas}" var="tema">
					<option value="${tema.id}"
						${tema.id == selectedTema ? 'selected' : ''}>${tema.categoria}</option>
				</c:forEach>
			</select>
		</p>
		<p>
			<input type="submit" value="Enviar" />
		</p>
	</form>
	<p>
		<a href="/Web/jsp/home">Volver a Home</a>
	</p>
</body>
</html>