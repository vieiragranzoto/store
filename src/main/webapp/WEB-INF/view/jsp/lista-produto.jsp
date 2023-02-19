<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Store - Lista de produtos</title>
<style type="text/css">
html, body {
	color: white;
	background-color: black;
}
a{
	background-color: white;
	text-decoration: none;
	color:black;
	border: 2px solid white;
	border-radius:4px;
}
a:hover {
	color: orange;
}
</style>
</head>
<body>
	<c:import url="logout-parcial.jsp"/>
	Deseja cadastrar novo produto? <a href="/store/entrada?acao=CadastrarProdutoForm">Cadastrar</a><br><br><br>
	<c:if test="${not empty lista}">
		Lista de produtos: <br>	
	</c:if>
	<ul>
		<c:forEach items="${lista}" var="produto">
	
			<li>${produto.nome}
			- ${produto.descricao}
			- R$ ${produto.preco}
			- ${produto.dataCadastro}
			- ${produto.categoria.nome}
			- <a href="/store/entrada?id=${produto.id}&acao=MostrarProduto">editar</a>
			- <a href="/store/entrada?id=${produto.id}&acao=RemoverProduto">remover</a></li>
		</c:forEach>
	</ul>
</body>
</html>