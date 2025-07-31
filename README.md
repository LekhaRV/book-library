# 📚 Book Library - Spring Boot Application

This is a simple full-featured Book Library CRUD application built with **Spring Boot**, using **MySQL** for data persistence. It supports:

- ✅ Create, Read, Update, Delete (CRUD) operations
- 🔍 Flexible search by title, author, genre, or published year
- 🛠️ Partial update support via `PATCH`
- 🛡️ Bean validation (e.g. title/author not blank, year not in future)
- ⚠️ Centralized error handling with validation feedback
- 📄 Pagination-ready repository design (optional)
- 🌱 Easy to extend with RESTful APIs

---

## 📦 Technologies Used

- Java 17+
- Spring Boot 3+
- Spring Data JPA
- MySQL
- Hibernate Validator (JSR-380)
- Maven

---
## API Endpoints
| Method | Endpoint            | Description                       |
| ------ | ------------------- | --------------------------------- |
| GET    | `/books`            | List all books                    |
| GET    | `/books/{id}`       | Get book by ID                    |
| POST   | `/books`            | Create new book                   |
| PUT    | `/books/{id}`       | Update book                       |
| PATCH  | `/books/{id}`       | Partially update book fields      |
| DELETE | `/books/{id}`       | Delete book                       |
| GET    | `/books/search?...` | Search by title/author/genre/year |

---
## Author
Lekha R Varier


