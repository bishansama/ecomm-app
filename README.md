# E-Commerce Application - Order Service

A Spring Boot microservice for handling order processing in an e-commerce application.

## Features

- RESTful API for order placement
- Returns a unique order ID for each order request
- OpenAPI documentation
- Exception handling
- Docker containerization

## Technologies

- Java 21
- Spring Boot 3.2.3
- Maven
- OpenAPI/Swagger
- Docker

## Getting Started

### Prerequisites

- Java 21 or higher
- Maven 3.6 or higher
- Docker (optional, for containerization)

### Running the Application

#### Using Maven

```bash
cd order-service
./mvnw spring-boot:run
```

#### Using Docker

```bash
cd order-service
docker build -t order-service .
docker run -p 8080:8080 order-service
```

## API Documentation

Once the application is running, you can access the Swagger UI at:

```
http://localhost:8080/swagger-ui.html
```

## API Endpoints

### Place an Order

```
POST /api/orders
```

**Request Body:**
```json
{
  "orderDetails": "Sample order details"
}
```

**Response:**
```json
{
  "orderId": "generated-uuid"
}
```

## Project Structure

```
order-service/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── ecommapp/
│   │   │           └── orderservice/
│   │   │               ├── controller/
│   │   │               ├── exception/
│   │   │               ├── model/
│   │   │               ├── service/
│   │   │               └── OrderServiceApplication.java
│   │   └── resources/
│   │       └── application.yml
│   └── test/
├── Dockerfile
└── pom.xml
```