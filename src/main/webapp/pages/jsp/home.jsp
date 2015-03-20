<?xml version="1.0" encoding="UTF-8"  ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Home Proyecto JEE_ECP</title>
</head>
<body>
	<h1>Home Proyecto JEE_ECP Versión JSP</h1>
	<p>
		<span style="color: red">${errorMsg}</span> <span style="color: green">${successMsg}</span>
	</p>
	<p>
		<a href="/Web/jsp/tema/nuevo">Incorporar Tema</a>
	</p>
	<p>
		<a href="/Web/jsp/tema/autorizar">Eliminar Tema</a>
	</p>
	<p>
		<a href="/Web/jsp/votacion/seleccionTema">Votar</a>
	</p>
	<p>
		<a href="/Web/jsp/votacion/ver">Ver votaciones</a>
	</p>
	<p>
		<a href="/Web/index.html">Volver al inicio</a>
	</p>
</body>
</html>