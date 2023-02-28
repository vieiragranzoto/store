<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<c:url value="/entrada" var="recurso"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Store - Editar Produto</title>
<style type="text/css">
html, body {
	color: white;
	background-color: black;
	text-align: center;
}
form {
	heigth: 500px;
	margin: 0 auto;
	width: 400px;
}
.valor {
	display: block;
	padding: 10px;
	margin: 0 auto;
	width: 40%;
}
.botao {
	width: 45%;
	display: block;
	padding: 10px;
	margin: 10px auto;
}
</style>
</head>
<body>
	<c:import url="logout-parcial.jsp"/>
	<form method="post" action="${recurso}">
		Informe o nome:
		<input class="valor" type="text" name="nome" value="${produto.nome}" required></input>
		<input class="valor" type="text" name="descricao" value="${produto.descricao}" required></input>
		<input class="valor" type="number" name="preco" value="${produto.preco}" step=".01" required></input>
		<input type="hidden" name="id" value="${produto.id}">
		<input type="hidden" name="acao" value="EditarProduto">
		<input class="botao" type="submit" value="Enviar" ></input>
	</form>
</body>
</html>