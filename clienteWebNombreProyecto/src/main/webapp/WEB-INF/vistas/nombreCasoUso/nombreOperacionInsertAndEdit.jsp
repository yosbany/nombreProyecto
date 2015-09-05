<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>nombreOperacionInsertAndEdit</title>
</head>
<body>
	<!-- Ejemplo de Formulario -->
	<form:form method="post" commandName="nombreFormularioForm">
		<table width="95%" bgcolor="f8f8ff" border="0" cellspacing="0"
			cellpadding="5">
			<tr>
				<td><form:input path="campo1" /></td>
				<td><form:errors path="campo2" block="ul" item="li"
						cssClass="error" /></td>
			</tr>

			<tr>
				<td><form:input path="campo2" /></td>
				<td><form:errors path="campo2" block="ul" item="li"
						cssClass="error" /></td>
			</tr>

		</table>
		<br>
		<input type="submit" align="center" value="Salvar">
	</form:form>
</body>
</html>