<?xml version="1.0" encoding="UTF-8"  ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Ingreso de votación</title>
</head>
<body>
	<h1>Ingreso de votación</h1>
	<c:set var="votarView" scope="request" value="${votarView}" />
	<span style="color: red">${errorMsg}</span>
	<span style="color: green">${successMsg}</span>
	<form action="/Web/jsp/votacion/procesar" method="post">
		<p>
			<span style="font-weight: bold">Categoría: </span>${votarView.tema.categoria}</p>
		<p>
			<span style="font-weight: bold">Pregunta: </span>
			${votarView.tema.pregunta}
		</p>
		<p>
			<span style="font-weight: bold">Nivel de estudios: </span> <select
				name="nivelEstudio">
				<c:forEach items="${votarView.nivelEstudioList}" var="nivelEstudio">
					<option value="${nivelEstudio}">${nivelEstudio}</option>
				</c:forEach>
			</select>
		</p>
        <p>
            <span style="font-weight: bold">Valoracion: </span> <select
                name="valoracion">
                <c:forEach items="${votarView.valoracionesList}" var="valoracion">
                    <option value="${valoracion}">${valoracion}</option>
                </c:forEach>
            </select>
        </p>		
		<p>
			<input type="submit" value="Enviar" /> <input type="hidden"
				value="${votarView.tema.id}" name="idTema" />
		</p>
	</form>
	<p>
		<a href="/Web/jsp/home">Volver a Home</a>
	</p>
</body>
</html>