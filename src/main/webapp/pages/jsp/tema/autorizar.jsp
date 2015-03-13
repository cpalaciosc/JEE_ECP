<?xml version="1.0" encoding="UTF-8"  ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Autorizacion de eliminación de tema</title>
</head>
<body>
    <h1>Autorizacion de eliminación de tema</h1>
    <c:set var="autorizarView" scope="request"
        value="${autorizarView}" />
    <span style="color: red">${errorMsg}</span>
    <form action="/Web/jsp/tema/verificar_codigo_seguridad" method="post">
        <p>
            Ingrese código de seguridad: <input name="codigo" type="text"
                value="${autorizarView.codigoSeguridad}" required />
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