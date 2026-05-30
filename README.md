# 🎓 API Cursos

API REST desenvolvida com **Java + Spring Boot + PostgreSQL**, permitindo o gerenciamento de cursos através de operações de criação, consulta, atualização e remoção.

## 🚀 Tecnologias Utilizadas

* Java 21
* Spring Boot
* Spring Data JPA
* Spring Validation
* PostgreSQL
* Docker
* Maven
* Lombok

---

## 📂 Estrutura do Projeto

```text
src
├── controllers
├── dto
├── entities
├── exceptions
├── repositories
├── useCases
└── ApiCursosApplication.java
```

A aplicação segue uma arquitetura baseada em **Use Cases**, separando responsabilidades entre controllers, regras de negócio e acesso a dados.

---

## ⚙️ Configuração do Banco de Dados

### Docker Compose

```yaml
version: '3.8'

services:
  postgres:
    container_name: api_cursos_postgres
    image: postgres
    ports:
      - 5433:5432
    environment:
      - POSTGRES_USER=admin
      - POSTGRES_PASSWORD=admin
      - POSTGRES_DB=api_cursos
```

### Subir o banco

```bash
docker compose up -d
```

Verificar container:

```bash
docker ps
```

---

## 🔧 Configuração da Aplicação

Arquivo `application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5433/api_cursos
spring.datasource.username=admin
spring.datasource.password=admin

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

## ▶️ Executando o Projeto

Instalar dependências:

```bash
mvn clean install
```

Executar aplicação:

```bash
mvn spring-boot:run
```

A API ficará disponível em:

```http
http://localhost:8080
```

---

# 📌 Endpoints

## Criar Curso

**POST**

```http
POST /courses
```

Body:

```json
{
  "name": "Java Spring Boot",
  "category": "Backend",
  "professor": "Fabricio Almeida"
}
```

---

## Listar Todos os Cursos

**GET**

```http
GET /courses
```

---

## Filtrar por Nome

**GET**

```http
GET /courses?name=Java
```

---

## Filtrar por Categoria

**GET**

```http
GET /courses?category=Backend
```

---

## Atualizar Curso

**PUT**

```http
PUT /courses/{id}
```

Body:

```json
{
  "name": "Java Spring Boot Avançado"
}
```

ou

```json
{
  "category": "Programação"
}
```

ou

```json
{
  "professor": "João Silva"
}
```

---

## Ativar / Desativar Curso

**PATCH**

```http
PATCH /courses/{id}/active
```

A cada chamada o valor do campo `active` será alternado entre `true` e `false`.

---

## Remover Curso

**DELETE**

```http
DELETE /courses/{id}
```

Retorno:

```http
204 No Content
```

---

## 📊 Estrutura da Entidade

| Campo     | Tipo          | Descrição                  |
| --------- | ------------- | -------------------------- |
| id        | UUID          | Identificador único        |
| name      | String        | Nome do curso              |
| category  | String        | Categoria                  |
| professor | String        | Professor responsável      |
| active    | Boolean       | Curso ativo ou inativo     |
| createdAt | LocalDateTime | Data de criação            |
| updatedAt | LocalDateTime | Data da última atualização |

---

## ✅ Funcionalidades Implementadas

* Criar curso
* Listar cursos
* Filtrar por nome
* Filtrar por categoria
* Atualizar curso
* Ativar/Desativar curso
* Excluir curso
* Validações com Bean Validation
* Tratamento global de exceções
* Persistência com PostgreSQL
* Containerização com Docker

---

## 👨‍💻 Autor

Desenvolvido por **Fabrício Almeida** como projeto de estudo utilizando Spring Boot e PostgreSQL.
