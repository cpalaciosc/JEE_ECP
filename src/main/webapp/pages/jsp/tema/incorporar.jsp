<?xml version="1.0" encoding="UTF-8"  ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Incorporar Tema</title>
</head>
<body>
	<h1>Incorporar tema</h1>
	<c:set var="incorporarTemaView" scope="request"
		value="${incorporarTemaView}" />
	<p>
		<span style="color: red">${errorMsg}</span>
	</p>
	<form action="/Web/jsp/tema/crear" method="post">
		<p>
			Categoría: <input name="categoria" type="text"
				value="${incorporarTemaView.tema.categoria}" required />
		</p>
		<p>
			Pregunta: <input name="pregunta" type="text"
				value="${incorporarTemaView.tema.pregunta}" required />
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