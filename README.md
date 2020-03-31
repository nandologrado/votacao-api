# Votação API
Api do sistema de votação para decisões tomadas em 

# Visão geral

O projeto é uma aplicação back-end com objetivo com o objetivo de gerenciar as sessoes de votações de decisões que serão tomadas em assembléias.

## Tecnologias

- [Spring Boot](https://projects.spring.io/spring-boot) é uma ferramenta que simplifica a configuração e execução de aplicações Java stand-alone,  com conceitos de dependências “starters”, auto configuração e servlet container embutidos é proporcionado uma grande produtividade desde o start-up da aplicação até sua ida a produção.
 
- [Spring MVC](https://docs.spring.io/spring/docs/current/spring-framework-reference/html/mvc.html) é um framework já consolidado no mercado, que a partir da versão fornece mecanismos simplificados para a criação de APIs RESTful através de anotação, além disso, também possui recursos de serialização e deserialização de objetos de forma transparente 
 
- [Spring Data](http://projects.spring.io/spring-data/) é um framework que abstrai o acesso ao modelo de dados, independente a tecnologia de base de dados.

 
# Setup da aplicação (local)

## Pré-requisito

Antes de rodar a aplicação é preciso garantir que as seguintes dependências estejam corretamente instaladas:
```
Java 8
MySQL Server 8.0
Maven 3.6.1 
```

## Preparando ambiente

É necessário a criação da base de dados MySQL

```
DROP DATABASE IF EXISTS votacao_db;
CREATE DATABASE votacao_db;
USE votacao_db;
```

## Instalação da aplicação

Primeiramente, faça o clone do repositório:
```
https://github.com/nandologrado/votacao-api.git
```
Feito isso, acesse o projeto:
```
cd votacao-api
```
É preciso compilar o código e baixar as dependências do projeto:
```
mvn clean package
```
Finalizado esse passo, vamos iniciar a aplicação:
```
mvn spring-boot:run
```
Pronto. A aplicação está disponível em http://localhost:8080
```
Tomcat started on port(s): 8080 (http) with context path ''
Started VotacaoApiApplication in xxxx seconds (JVM running for xxxx)
```

## Acessar a documentação da aplicação via swagger
Após a execução da aplicação a documento da api via swagger ficará disponível no link http://localhost:8080/swagger-ui.html#/


# APIs

O projeto disponibiliza algumas APIs em 4 contextos diferentes: Pauta, Sessao, Usuario e Votacao onde utilizam o padrão Rest de comunicação, produzindo e consumindo arquivos no formato JSON.

Segue abaixo as APIs disponíveis no projeto:

#### Pauta

 - /api/v1/pautas (GET)
 - /api/v1/pautas/{id} (GET)
 - /api/v1/pautas/{id} (DELETE)
 - /api/v1/pautas (POST)
     - Espera atributos para serem critérios de busca no body da requisição, exemplo:
    ```
	{
		"nome":"teste",
		"descricao":"ISSO É UM TESTE"
	}
    ```

#### Sessao
 
 - /api/v1/sessoes (POST)
     - Espera atributos para serem critérios de busca no body da requisição, exemplo:
    ```
	{
		"pautaId":"1",
		"duracaoSessao":"500"
	}
    ```
 - /api/v1/sessoes/pauta/{id} (GET)
 - /api/v1/sessoes/{id} (GET)
 - /api/v1/sessoes/{id}/details (GET)
 
 #### Usuarios
 
 - /api/v1/usuarios (GET)
 - /api/v1/usuarios (POST)
	- Espera atributos para serem critérios de busca no body da requisição, exemplo:
    ```
	{
		"nome":"fernando",
		"cpf":"09305748503"
	}
	``` 
 - /api/v1/usuarios/{id} (GET)                

#### Votacao

 - /files/bills (POST)
    - Espera as informações de Bill como um arquivo, exemplo:
    ```
	{
		"sessaoId":"1",
		"usuarioId":"2",
		"voto":"SIM"
	}
    ```