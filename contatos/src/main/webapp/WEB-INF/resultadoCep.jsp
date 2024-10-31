<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Resultado da Busca de CEP</title>
</head>
<body>
    <h2>Resultado da busca de CEP</h2>
    <c:if test="${not empty endereco}">
        <p><strong>Logradouro:</strong> ${endereco.logradouro}</p>
        <p><strong>Bairro:</strong> ${endereco.bairro}</p>
        <p><strong>Cidade:</strong> ${endereco.localidade}</p>
        <p><strong>Estado:</strong> ${endereco.uf}</p>
    </c:if>

    <c:if test="${empty endereco}">
        <p>CEP não encontrado!</p>
    </c:if>

    <a href="index.jsp">Voltar</a>
</body>
</html>
