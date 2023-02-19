<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<c:url value="/entrada" var="recurso"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Loja Virtual - Cadastrar Produto</title>
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
	<form method="post" action="${recurso}">
		Informe o nome:
		<input class="valor" type="text" name="nome"></input>
		Informe a descricao:
		<input class="valor" type="text" name="descricao"></input>
		Informe o preço:
		<input class="valor" type="text" name="preco"></input>
		Informe a categoria:
		<input class="valor" type="text" name="categoria"></input>
		<input type="hidden" name="acao" value="CadastrarProduto">
		<input class="botao" type="submit" value="Enviar" ></input>
	</form>
</body>
</html>