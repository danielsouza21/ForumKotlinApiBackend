# ForumKotlinApiBackend
Projeto de estudos sobre a linguaguem Kotlin aplicado a API REST Backend, desenvolvendo uma aplicação de Fórum com SpringBoot e Gradle.

## Tópicos aplicados e implementados:
* CRUD com API REST utilizando controllers 
* Conceitos de DependencyInjection com atributos `@Service` e `@Component`
* DataTransferObject (DTOs) para criação de contratos nos controller
* Validadores de modelos (`@BeanValidator`)
* Tratamento de erros com middlewares
* Utilização de JPA para persistência
  * Banco de dados H2 (`http://localhost:8099/h2-console`)
* InterfaceRepository Pattern
* Migrations com Flyway
* Utilização de Cache (em memória, com spring)
* Paginação, ordenação e projections em queries
  * Exemplo:`http://localhost:8099/topicos?nomeCurso=Kotlin&size=3&page=1&sort=id,desc`

### Observações:
* URI: `http://localhost:8099`