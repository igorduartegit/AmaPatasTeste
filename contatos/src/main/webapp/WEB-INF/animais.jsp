<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.JavaBeans"%>
<%@ page import="java.util.ArrayList"%>
<%
	@ SuppressWarnings ("unchecked")
	ArrayList<JavaBeans> listaAnimais =(ArrayList<JavaBeans>) request.getAttribute("animais");
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<title>Animais AmaPatas</title>
<link rel="icon" href="imagens/icon.png"> 
<link rel="stylesheet" href="novo.css">
</head>
<body>
	<h1>Animais da AmaPatas</h1>
	<a href="cadastroAnimais.html" class="Botao1">Novo animal</a>
	<a href="reportAnimais" class="Botao2"> Relatório animais</a>
	<table id="tabela">
		<thead>
			<tr>
				<th>Idpet</th>
				<th>Nomepet</th>
				<th>Especie</th>
				<th>Idade</th>
				<th>Sexo</th>
				<th>Situacao</th>
			</tr>
		</thead>
		<tbody>
			<% for (int i = 0; i < listaAnimais.size(); i++) { %>
				<tr>
					<td><%=listaAnimais.get(i).getIdpet()%></td>
					<td><%=listaAnimais.get(i).getNomepet()%></td>
					<td><%=listaAnimais.get(i).getEspecie()%></td>
					<td><%=listaAnimais.get(i).getIdade()%></td>
					<td><%=listaAnimais.get(i).getSexo()%></td>
					<td><%=listaAnimais.get(i).getSituacao()%></td>
					<td><a href ="select?idcon=<%=listaAnimais.get(i).getIdpet() %>"class="Botao1">Editar</a>
						<a href ="javascript: confirmar(<%=listaAnimais.get(i).getIdpet() %>)" class="Botao2">Excluir</a>
					</td>
				</tr>
			<% } %>
		</tbody>
	</table>
	<script src="scripts/confirmador.js"></script>
</body>
</html>