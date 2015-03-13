<?xml version="1.0" encoding="UTF-8"  ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Listado de Temas</title>
</head>
<body>
    <h1>Listado de tema</h1>
    <c:set var="listadoTemasView" scope="request"
        value="${listadoTemasView}" />
    <span style="color: red">${errorMsg}</span>
    <c:choose>
        <c:when  test="${empty listadoTemasView.temasList}">
         <span style="color: red">No existen temas disponibles</span>
        </c:when>
        <c:otherwise>
		    <table>
		    <tr>
		        <th>Id</th>
		        <th>Categoría</th>
		        <th>Pregunta</th>
		        <th>Accion</th>
		    </tr>
		    <c:forEach var="tema" items="${listadoTemasView.temasList}">
		        <tr>
		            <td>${tema.id}</td>
		            <td>${tema.categoria}</td>
		            <td>${tema.pregunta}</td>
		            <td>Eliminar</td>
		        </tr>
		    </c:forEach>    
		    </table>        
        </c:otherwise>
    </c:choose>


    <p>
        <a href="/Web/jsp/home">Volver a Home</a>
    </p>
</body>
</html>