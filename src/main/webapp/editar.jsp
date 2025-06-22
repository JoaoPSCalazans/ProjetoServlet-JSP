<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Agenda de Contato</title>
</head>
<body>

	<h1>Editar Contato</h1>
	<form method="get" action="editar">
		<label>Id: <%=request.getAttribute("id")%></label> <br>
		<label for="nome">Nome:</label> <input type="text" id="nome" name="nome" value="<%=request.getAttribute("nome")%>"><br>
		<label for="fone">Fone:</label> <input type="text" id="fone" name="fone" value="<%=request.getAttribute("fone")%>"><br>
		<label for="email">E-mail:</label> <input type="text" id="email" name="email" value="<%=request.getAttribute("email")%>"><br>
		<input type="submit" value="Confirmar" >
	</form>

</body>
</html>