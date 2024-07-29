
# DSCatalog

[![MIT License](https://img.shields.io/badge/License-MIT-green.svg?style=for-the-badge)](https://github.com/hakkinenT/java_spring_boot_dscatalog/blob/main/LICENSE) 
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)

## Tabela de Conteúdo
- [Sobre o projeto](#sobre-o-projeto)
- [Modelo Conceitual](#modelo-conceitual)
- [Requisitos](#requisitos)
- [Documentação da API](#documentação-da-api)
    - [Acessando localmente](#acessando-localmente)
    - [Acessando via servidor](#acessando-via-servidor)
- [Documentação da API](#documentação-da-api)
- [Funcionalidades](#funcionalidades)
- [Tecnologias Utilizadas](#tecnologias-utilizadas)
- [Rodando localmente](#rodando-localmente)
- [Rodando via Servidor](#rodando-via-servidor)
- [Rodando os testes](#rodando-os-testes)
- [Autores](#autores)

<a id="sobre-o-projeto"></a>
## Sobre o projeto
Este projeto foi desenvolvido ao longo do curso **Java Spring Expert** da [DevSuperior](https://devsuperior.com.br), 
ministrado pelo Professor [Nelio Alves](https://github.com/acenelio). O objetivo deste projeto foi desenvolver uma API de catálogos de produtos,
aplicando os conceitos de construção de API já aprendidos no curso **Java Spring Professional**, também ministrado pelo professor Nélio na mesma plataforma, 
além de novos conceitos, como Testes Unitários e de Integração.

<a id="modelo-conceitual"></a>
## Modelo Conceitual
![App Class Diagram](https://github.com/hakkinenT/assets/blob/master/java-spring-projects/modelo-conceitual-dscatalog.png)

<a id="requisitos"></a>
## Requisitos
- [Java JDK (versão 17 ou superior)](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- [Git](https://git-scm.com/downloads) - Sistema de controle de versão de código aberto
- [Uma conta no Github](https://github.com/) - Plataforma de controle de versões
- [Postman](https://www.postman.com/downloads/) ou [Insomnia](https://insomnia.rest/download) - Ferramentas para testar a API
- [Docker (Opcional)](https://www.docker.com/products/docker-desktop/) - Para rodar a aplicação localmente
- [PostgreSQL (Opcional)](https://www.postgresql.org/download/) - Para rodar a aplicação localmente, caso não queira instalar o Docker

<a id="documentação-da-api"></a>
## Documentação da API

<a id="acessando-localmente"></a>
### Acessando localmente

1. [Rode a aplicação localmente](#rodando-localmente)
2. Gere um token de acesso
- Abra um ferramenta para testar a API (Postman, Insomnia...)
- Acesse a url abaixo:
```bash
http://localhost:8080/oauth2/token
```
- Na aba Authorization, acrescente as seguintes informações:
    - Em Auth Type selecione Basic Auth
    - Preencha os campos Username e Password com os seguintes valores:

        | Campo   | Valor       | Descrição                           |
        | :---------- | :--------- | :---------------------------------- |
        | Username | {{client-id}} | Valor do client-id definido no application.properties |
        | Password | {{client-secret}} | Valor do client-secret definido no application.properties |

- Envie a requisição e obtenha o token
- Acesse o endereço:
```bash
  http://localhost:8080/swagger-ui.html
```
- Adicone o token em Authorize
- Acesse as rotas

<a id="acessando-via-servidor"></a>
### Acessando via servidor

1. Gere um token de acesso
- Abra um ferramenta para testar a API (Postman, Insomnia...)
- Acesse a url abaixo:
```bash
https://dscatalog-mal4.onrender.com/oauth2/token
```
- Na aba Authorization, acrescente as seguintes informações:
    - Em Auth Type selecione Basic Auth
    - Preencha os campos Username e Password com os seguintes valores:

        | Campo   | Valor       | Descrição                           |
        | :---------- | :--------- | :---------------------------------- |
        | Username | {{client-id}} | Valor do client-id definido no application.properties |
        | Password | {{client-secret}} | Valor do client-secret definido no application.properties |

- Envie a requisição e obtenha o token
- Acesse o endereço:
```bash
  https://dscatalog-mal4.onrender.com/swagger-ui.html
```
- Adicone o token em Authorize
- Acesse as rotas

<a id="funcionalidades"></a>
## Funcionalidades

- Gerenciar Produtos
- Gerenciar Categorias

<a id="tecnologias-utilizadas"></a>
## Tecnologias Utilizadas

- Java
- Spring boot
- JPA / Hibernate
- Banco de Dados H2

<a id="rodando-localmente"></a>
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

<a id="rodando-via-servidor"></a>
## Rodando via Servidor
- [Acesse a documentação e teste a API](#documentação-da-api):

```bash
https://dscatalog-mal4.onrender.com/swagger-ui.html
```
OU
- Use uma ferramenta para testar a API (Postman, Insomnia...) para testar a API

<a id="rodando-os-testes"></a>
## Rodando os testes

Para rodar os testes, rode o seguinte comando

```bash
  mvn test
```

<a id="autores"></a>
## Autores

- [@hakkinenT](https://github.com/hakkinenT)
