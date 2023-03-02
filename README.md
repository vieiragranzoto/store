# store
Uma loja intranet para controle de estoque de produtos e pedidos. 

## Table of Contents

- [Projeto](#projeto)
- [Dependencias](#dependencias)
- [Packages](#packages)
- [Model](#model)
  + [Classes](#classes)
- [Dao](#dao)
- [Controller](#controller)
  + [Action](#action)

## Projeto

O projeto utiliza maven, servlet, jsp, postgresql, hibernate, java 19, tomcat v10.1, Dynamic Web Module 5.0.

Este diretório é a base do projeto:

```src/main```

Este diretório contém os pacotes do projeto:

```src/java/br/com/alura/store```

Este diretório contém o arquivo persistence.xml para configuração do hibernate:

```src/resources/META-INF```

Este diretório contém web.xml e as views do projeto:

```webapp/WEB-INF```

## Dependencias

As dependencias utilazadas no projeto como listado no pom.xml são: jakarta.servlet-api, hibernate-entitymanager, junit-jupiter-api, jakarta.servlet.jsp.jstl, jakarta.servlet.jsp-api, jakarta.servlet.jsp.jstl-api, postgresql.
  
## Packages
  
Pacotes criados para o projeto seguem a nomenclatura:
URL ao contrario do site fictício e nome do projeto
  
Pacote contendo entidades/modelos do projeto:

```br.com.alura.store.model```

Pacote contendo daos de entidades do projeto:

```br.com.alura.store.dao```

Pacote contendo a EntradaServlet e Filter:

```br.com.alura.store.controller```

Pacote contendo as actions do projeto:

```br.com.alura.store.controller.action```

Pacote contendo a conexão com o banco de dados do projeto:

```br.com.alura.store.util```

## Model

O pacote model é onde contem todas as entidades do projeto, assim como classes Embbedable.

### Classes

Principal entidade do projeto:

```Produto.java```

Entidade para registro de produtos pedidos por clientes:

```ItemPedido.java```

Entidade para registro de pedidos feitos por clientes:

```Pedido.java```

Entidade para armazenar usuarios do sistema:

```Usuario.java```

Entidade para armazenar categorias de produtos:

```Categoria.java```

Entidade para armazenar os clientes de pedidos feitos:

```Cliente.java```

Entidades que são subprodutos e herdam de Produto:

```Livro.java```

```Informatica.java```

Classes Embeddables feitas para Entidade Cliente:

```ClienteId.java```

```DadosPessoais.java```

## Dao

Pacote com classes responsáveis por trocar informações com o SGBD e fornecer operações CRUD e de pesquisas.

## Controller

Pacote contendo a classe EntradaServlet onde é feito o controle do projeto, e AutorizacaoFilter reponsavel por checar se usuario está logado no sistema.

## Action

Pacote contendo classes que vao se comunicar com HttpServletRequest, HttpServletResponse, daos, jsp.


  
  