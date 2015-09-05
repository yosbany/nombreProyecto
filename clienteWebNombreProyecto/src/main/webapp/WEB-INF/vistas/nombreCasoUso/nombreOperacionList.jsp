<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>nombreOperacionList</title>
</head>
<body>
	<div align="center">
		<h1>Listando Objeto</h1>
		<table border="1">
			<th>No</th>
			<th>Campo1</th>
			<c:forEach var="objeto" items="${lista}" varStatus="status">
				<tr>
					<td>${status.index + 1}</td>
					<td>${objeto}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>