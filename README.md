
# Spring GraphQL Demo

A simple Spring Boot application using GraphQL to expose a `Book` and `Author` API.

## 🧰 Technologies

- Java 21
- Spring Boot 3.2
- Spring for GraphQL
- H2 (in-memory)
- Maven (with wrapper)

## ⚙️ Features

- Query books and their authors
- Add books linked to authors
- Preloaded dataset using `schema.sql` and `data.sql`
- Demonstrates the N+1 problem (great for testing `DataLoader`)

## 🚀 Running the App

```bash
./mvnw spring-boot:run
```

Once running, access the interfaces:

- GraphiQL: [http://localhost:8080/graphiql](http://localhost:8080/graphiql)
- H2 Console: [http://localhost:8080/h2-console](http://localhost:8080/h2-console)
    - JDBC URL: `jdbc:h2:mem:testdb`

---

## 📚 Sample GraphQL Queries

### 🔍 List all books with author details

```graphql
query {
  books {
    id
    title
    author {
      id
      name
    }
  }
}
```

### 🔍 Get a book by ID

```graphql
query {
  bookById(id: 1) {
    title
    author {
      name
    }
  }
}
```

### ➕ Add a book

```graphql
mutation {
  addBook(id: 10, title: "Working Effectively with Legacy Code", authorId: 1) {
    id
    title
    author {
      name
    }
  }
}
```

---

## 🌀 Call GraphQL via `curl`

```bash
curl -X POST http://localhost:8080/graphql -H "Content-Type: application/json" -d '{"query":"query { books { id title author { name } } }"}'
```

### 🧪 Example Mutation via `curl`

```bash
curl -X POST http://localhost:8080/graphql -H "Content-Type: application/json" -d '{"query":"mutation { addBook(id: 11, title: \"The Pragmatic Programmer\", authorId: 1) { id title author { name } } }"}'
```

---

## 📦 Preloaded Data

Via `data.sql`:

- 7 authors
- 9 books linked to authors

---

## 📁 Schema file

The schema is defined in:

```
src/main/resources/schema.graphqls
```

The database schema and initial data are defined in:

```
src/main/resources/schema.sql
src/main/resources/data.sql
```
