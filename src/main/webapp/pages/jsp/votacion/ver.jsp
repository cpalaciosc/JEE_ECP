<?xml version="1.0" encoding="UTF-8"  ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Valoracion media por tema</title>
</head>
<body>
	<h1>Valorarion media por tema</h1>
	<c:set var="verVotacionesView" scope="request"
		value="${verVotacionesView}" />
	<span style="color: red">${errorMsg}</span>
	<c:choose>
		<c:when test="${empty verVotacionesView.temaValoracionMediaList}">
			<span style="color: red">No existen temas disponibles</span>
		</c:when>
		<c:otherwise>
			<c:forEach var="temaValoracionMedia"
				items="${verVotacionesView.temaValoracionMediaList}">
				<h3>${temaValoracionMedia.tema.categoria} - ${temaValoracionMedia.numeroVotos} votos</h3>
				<table border="2">
					<tr>
						<th>Nivel de estudio</th>
						<th>Valoración media</th>
					</tr>
					<c:forEach var="valoracionMedia"
						items="${temaValoracionMedia.valoracionMedia}">

						<tr>
							<td>${valoracionMedia.nivelEstudio}</td>
							<td>${valoracionMedia.valor}</td>
						</tr>
					</c:forEach>
				</table>
			</c:forEach>
		</c:otherwise>
	</c:choose>


	<p>
		<a href="/Web/jsp/home">Volver a Home</a>
	</p>
</body>
</html>