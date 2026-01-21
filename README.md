
# DSCatalog 📚

[![MIT License](https://img.shields.io/badge/License-MIT-green.svg?style=for-the-badge)](https://github.com/hakkinenT/java_spring_boot_dscatalog/blob/main/LICENSE) 
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)

# DSCatalog 📚

API REST para gerenciamento de um catálogo de produtos, desenvolvida com foco em **boas práticas**, **testes automatizados** e organização de código no ecossistema Spring.

## 🚀 Funcionalidades
- Cadastro, edição e exclusão de produtos
- Listagem paginada
- Associação de produtos a categorias
- Validações de dados
- Tratamento global de exceções

## 🛠️ Tecnologias Utilizadas
- Java
- Spring Boot
- Spring Web
- Spring Data JPA
- PostgreSQL
- JUnit
- Maven

## 🏗️ Arquitetura
- Controller
- Service
- Repository
- DTOs
- Entities

## ▶️ Como executar o projeto

### Pré-requisitos
- Java 17+
- Maven
- PostgreSQL (ou Docker)

### Passos
1. Clone o repositório:
```bash
git clone https://github.com/hakkinenT/java_spring_boot_dscatalog.git
```
2. Acesse o diretório do projeto:

```bash
cd java_spring_boot_dscatalog
```

3. Execute a aplicação:
```bash
mvn spring-boot:run
```

4. A aplicação estará disponível em:
```arduino
http://localhost:8080
```

## 🔐 Autenticação e Autorização

A API utiliza JWT (JSON Web Token) para autenticação.

Após realizar o login, o token retornado deve ser enviado no header das requisições protegidas:

```http
Authorization: Bearer <token>
```

## 📌 Endpoints

| Método | Rota                    | Descrição                          |
|------|--------------------------|------------------------------------|
| GET  | /products                | Lista produtos (paginado)          |
| GET  | /products/{id}           | Busca produto por ID               |
| POST | /products                | Cria novo produto                  |
| PUT  | /products/{id}           | Atualiza produto                   |
| DELETE | /products/{id}         | Remove produto                     |
| GET  | /categories              | Lista categorias                   |

## 📦 Testando a API com Postman

O projeto disponibiliza arquivos do Postman para facilitar o teste da API:

- 📁 Collection: contém todas as requisições da API

- 🌍 Environment: contém variáveis de ambiente, como URL base e token

Como utilizar:

1. Abra o Postman

2. Importe a collection (.json)

3. Importe o environment (.json)

4. Selecione o environment no Postman

5. Execute a requisição de login para obter o token

6. As requisições protegidas utilizarão automaticamente o token salvo no environment

## 🧪 Testes

Este projeto possui testes unitários e de integração utilizando JUnit e Mockito, com foco na validação das regras de negócio.

### Executar todos os testes:
```bash
mvn test
```

Os testes incluem:

- Testes unitários

- Uso de mocks para simulação de dependências

- Validação de serviços e regras de negócio


## 📌 Objetivo do Projeto

Projeto criado para consolidar conhecimentos em Spring Boot, testes automatizados e desenvolvimento de APIs REST seguindo boas práticas.
## Autores

- [@hakkinenT](https://github.com/hakkinenT)
