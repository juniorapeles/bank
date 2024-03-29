# Bank API

This repository contains the source code for a simple Bank API.

## Features

- Create customer accounts
- Deposit and withdraw funds
- Transfer funds between accounts
- View account balance and transaction history

## Technologies Used

- Java
- Spring Boot
- Spring Data JPA
- PostgreSQL (for database)
- Maven (for dependency management)
- Swagger (for API documentation)

## Getting Started

To run this project locally, follow these steps:

1. Clone this repository: `git clone <repository-url>`
2. Navigate to the project directory: `cd bank-api`
3. Configure the database settings in `application.properties`
4. Build the project: `mvn clean install`
5. Run the application: `mvn spring-boot:run`

The application will start on port 8080 by default. You can access the API documentation using Swagger UI at `http://localhost:8080/swagger-ui.html`.

## API Endpoints

### Customers

- `GET /customers`: Get all customers
- `GET /customers/{id}`: Get customer by ID
- `POST /customers`: Create a new customer
- `PUT /customers/{id}`: Update customer details
- `DELETE /customers/{id}`:
