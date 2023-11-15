
# DSCatalog

[![MIT License](https://img.shields.io/badge/License-MIT-green.svg?style=for-the-badge)](https://github.com/hakkinenT/java_spring_boot_dscatalog/blob/main/LICENSE) 
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)


## Sobre o projeto
Este projeto foi desenvolvido ao longo do curso **Java Spring Expert** da [DevSuperior](https://devsuperior.com.br), 
ministrado pelo Professor [Nelio Alves](https://github.com/acenelio). O objetivo deste projeto foi desenvolver uma API de catálogos de produtos,
aplicando os conceitos de construção de API já aprendidos no curso **Java Spring Professional**, também ministrado pelo professor Nélio na mesma plataforma, 
além de novos conceitos, como Testes Unitários e de Integração.

## Modelo Conceitual
![App Class Diagram](https://github.com/hakkinenT/assets/blob/master/java-spring-projects/modelo-conceitual-dscatalog.png)

## Funcionalidades

- Gerenciar Produtos
- Gerenciar Categorias


## Tecnologias Utilizadas

- Java
- Spring boot
- JPA / Hibernate
- Banco de Dados H2

## Rodando localmente

Clone o projeto

```bash
  git clone https://github.com/hakkinenT/java_spring_boot_dscatalog
```

Entre no diretório do projeto

```bash
  cd java_spring_boot_dscatalog
```

Rode a aplicação

```bash
  ./mvnw spring-boot:run
```

A API estará acessível em http://localhost:8080

## API Endpoints
A API fornece os seguintes endpoints:

**/categories**

```bash
GET /categories - Recupera uma lista paginada de todas as categorias

GET /categories?page=0&size=1&sort=name,asc - Recupera uma lista paginada de categorias de acordo com o valor dos parâmetros de requisção

GET /categories/{id} - Recupera uma categoria

POST /categories - Registra uma nova categoria

PUT /categories/{id} - Atualiza uma categoria

DELETE /categories/{id} - Deleta uma categoria

```
**/products**

```bash
GET /products - Recupera uma lista paginada de todos produtos

GET /products?page=0&size=1&sort=name,asc - Recupera uma lista paginada de produtos de acordo com o valor dos parâmetros de requisção

GET /products/{id} - Recupera um produto

POST /products - Registra um novo produto

PUT /products/{id} - Atualiza um produto

DELETE /products/{id} - Deleta um produto

```
## Rodando os testes

Para rodar os testes, rode o seguinte comando

```bash
  mvn test
```


## Autores

- [@hakkinenT](https://github.com/hakkinenT)
