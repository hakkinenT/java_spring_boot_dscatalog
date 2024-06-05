
# DSCatalog

[![MIT License](https://img.shields.io/badge/License-MIT-green.svg?style=for-the-badge)](https://github.com/hakkinenT/java_spring_boot_dscatalog/blob/main/LICENSE) 
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)

## Tabela de Conteúdo
- [Sobre o projeto](#sobre-o-projeto)
- [Modelo Conceitual](#modelo-conceitual)
- [Documentação da API](#documentação-da-api)
- [Funcionalidades](#funcionalidades)
- [Tecnologias Utilizadas](#tecnologias-utilizadas)
- [Rodando localmente](#rodando-localmente)
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

<a id="documentação-da-api"></a>
## Documentação da API
1. [Rode a aplicação](#rodando-localmente)
2. Acesse o endereço abaixo
  ```bash
    http://localhost:8080/swagger-ui.html
  ```

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

<a id="rodando-os-testes"></a>
## Rodando os testes

Para rodar os testes, rode o seguinte comando

```bash
  mvn test
```

<a id="autores"></a>
## Autores

- [@hakkinenT](https://github.com/hakkinenT)
