<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inicio</title>
</head>
<body>
	
	<a href=<spring:url value="/nombreCasoUso/nombreOperacionList.do" />>List</a>
	<br />
	<a href=<spring:url value="/nombreCasoUso/nombreOperacionInsertAndEdit.do" />>InsertAndEdit</a>
	<br /> 
	<br /> 
	<br /> 
	<br /> 
	<h3>Datos del Modelo</h3>
	${modelo}
</body>
</html>