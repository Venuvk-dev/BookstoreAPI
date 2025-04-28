# BookstoreAPI

BookstoreAPI is a RESTful web service built with JAX-RS and Jersey that provides a complete backend solution for an online bookstore application. The API allows for managing books, authors, customers, shopping carts, and orders.

## Table of Contents

- [Overview](#overview)
- [Project Structure](#project-structure)
- [Key Features](#key-features)
- [API Endpoints](#api-endpoints)
- [Exception Handling](#exception-handling)
- [Getting Started](#getting-started)
- [Dependencies](#dependencies)
- [Development](#development)

## Overview

BookstoreAPI is built using Java 8 with the JAX-RS REST API standard, implemented through Jersey 2.32. The application provides a set of RESTful services to manage various entities in an online bookstore system, including books, authors, customers, shopping carts, and orders. The API is designed to be scalable, maintainable, and easy to use for frontend developers.

## Project Structure

```
BookstoreAPI/
├── src/main/java/com/bookstore/
│   ├── config/             # Application configuration
│   ├── exception/          # Custom exceptions
│   │   └── mapper/         # Exception mappers for RESTful error responses
│   ├── model/              # Entity models (Book, Author, etc.)
│   └── resources/          # RESTful resource endpoints
├── src/main/resources/     # Application resources
├── src/main/webapp/        # Web application files
│   ├── META-INF/           # Context configuration
│   └── WEB-INF/            # Web application configuration
├── pom.xml                 # Maven project configuration
└── README.md               # Project documentation
```

## Key Features

- Complete RESTful API for a bookstore application
- CRUD operations for books, authors, customers, carts, and orders
- In-memory data storage (can be extended to use a database)
- Standardized error handling with JSON responses
- Comprehensive logging with SLF4J and Logback
- JAX-RS compliant API design

## API Endpoints

### Books

- `GET /api/books` - Get all books
- `GET /api/books/{id}` - Get a book by ID
- `POST /api/books` - Add a new book
- `PUT /api/books/{id}` - Update a book
- `DELETE /api/books/{id}` - Delete a book

### Authors

- `GET /api/authors` - Get all authors
- `GET /api/authors/{id}` - Get an author by ID
- `POST /api/authors` - Add a new author
- `PUT /api/authors/{id}` - Update an author
- `DELETE /api/authors/{id}` - Delete an author

### Customers

- `GET /api/customers` - Get all customers
- `GET /api/customers/{id}` - Get a customer by ID
- `POST /api/customers` - Add a new customer
- `PUT /api/customers/{id}` - Update a customer
- `DELETE /api/customers/{id}` - Delete a customer

### Carts

- `GET /api/carts` - Get all carts
- `GET /api/carts/{id}` - Get a cart by ID
- `POST /api/carts` - Create a new cart
- `PUT /api/carts/{cartId}/add/{bookId}/{quantity}` - Add a book to cart
- `DELETE /api/carts/{cartId}/remove/{bookId}` - Remove a book from cart
- `DELETE /api/carts/{cartId}` - Delete a cart

### Orders

- `GET /api/orders` - Get all orders
- `GET /api/orders/{id}` - Get an order by ID
- `POST /api/orders` - Create a new order
- `PUT /api/orders/{id}` - Update an order
- `DELETE /api/orders/{id}` - Delete an order

## Exception Handling

The API uses custom exception classes and mappers to provide consistent error responses:

- `BookNotFoundException` - When a requested book doesn't exist
- `AuthorNotFoundException` - When a requested author doesn't exist
- `CustomerNotFoundException` - When a requested customer doesn't exist
- `CartNotFoundException` - When a requested cart doesn't exist
- `OrderNotFoundException` - When a requested order doesn't exist
- `InvalidInputException` - When input validation fails
- `OutOfStockException` - When a book is out of stock

All exceptions return appropriate HTTP status codes and JSON error messages.

## Getting Started

### Prerequisites

- Java 8 or higher
- Maven 3.5 or higher
- Apache Tomcat 8.5 or higher (or another servlet container)

### Installation

1. Clone the repository:
   ```
   git clone https://github.com/yourusername/BookstoreAPI.git
   ```

2. Build the project:
   ```
   cd BookstoreAPI
   mvn clean install
   ```

3. Deploy the WAR file to your servlet container:
   ```
   cp target/BookstoreAPI-1.0-SNAPSHOT.war /path/to/tomcat/webapps/
   ```

4. Start your servlet container:
   ```
   /path/to/tomcat/bin/startup.sh
   ```

5. The API will be available at:
   ```
   http://localhost:8080/BookstoreAPI/api/
   ```

## Dependencies

- Jersey 2.32 (JAX-RS implementation)
- Jackson (JSON processing)
- SLF4J and Logback (logging)
- Java Servlet API
- Maven for build management

## Development

### Adding a New Resource

1. Create a new model class in `com.bookstore.model`
2. Create custom exceptions if needed in `com.bookstore.exception`
3. Add exception mappers in `com.bookstore.exception.mapper`
4. Create a new resource class in `com.bookstore.resources`
5. Register the new resource in `com.bookstore.config.ApplicationConfig`

### Testing the API

You can test the API using tools like:

- cURL
- Postman
- REST clients in IDEs like IntelliJ IDEA or Eclipse

Example cURL command to get all books:
```
curl -X GET http://localhost:8080/BookstoreAPI/api/books
```

Example cURL command to create a new book:
```
curl -X POST \
  http://localhost:8080/BookstoreAPI/api/books \
  -H 'Content-Type: application/json' \
  -d '{
    "title": "The Great Gatsby",
    "author": "F. Scott Fitzgerald",
    "price": 12.99,
    "isbn": "9780743273565",
    "publicationYear": 1925,
    "stockQuantity": 15
}'
```

## Future Enhancements

- Implement database persistence with JPA/Hibernate
- Add authentication and authorization with JWT
- Create a search API with filtering capabilities
- Implement pagination for large result sets
- Add unit and integration tests
