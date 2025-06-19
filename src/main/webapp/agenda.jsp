<%@page import="model.Contatos"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%ArrayList<Contatos> contatos = (ArrayList<Contatos>) request.getAttribute("contatos");%>
<head>
<meta charset="UTF-8">
<title>Agenda de Contatos</title>
</head>
<body>
	<h1>Agendade de Contatos</h1>
	<a href="insert">Adicionar</a>
	<table>
		<thead>
			<tr>
				<th>Id</th>
				<th>Nome</th>
				<th>Fone</th>
				<th>Email</th>
			</tr>
		</thead>
		<tbody>
			<%for(Contatos con : contatos) {%>
				<tr>
					<td><%out.print(con.getId());%></td>
					<td><%out.print(con.getNome());%></td>
					<td><%out.print(con.getFone());%></td>
					<td><%out.print(con.getEmail());%></td>
				</tr>
			<%} %>
		</tbody>
	</table>

</body>
</html>