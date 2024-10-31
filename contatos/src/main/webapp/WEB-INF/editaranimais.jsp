<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listagem dos animais</title>
<link rel="icon" href="imagens/coracao.png">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>Editar animais</h1>
	<form name="frmAnimais" action="update">
		<table>
			<tr>
				<td><input type="text" name="idpet" id="caixa3" readonly value = "<%out.print(request.getAttribute("idpet"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="nomepet" class="Caixa1" value = "<%out.print(request.getAttribute("nomepet"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="especie" class="Caixa2" value = "<%out.print(request.getAttribute("especie"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="sexo" class="Caixa1" value = "<%out.print(request.getAttribute("sexo"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="idade" class="Caixa2" value = "<%out.print(request.getAttribute("idade"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="situacao" class="Caixa2" value = "<%out.print(request.getAttribute("situacao"));%>"></td>
			</tr>
		</table>
		<input type="button" value="Salvar" class="Botao1" onclick="validar()">
	</form>
	<script src="scripts/validadoranimais.js"></script>
</body>
</html>