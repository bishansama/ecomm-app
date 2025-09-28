# E-Commerce Application

A comprehensive microservices-based e-commerce application built with Spring Boot, featuring multiple services for order processing, inventory management, user management, product catalog, shopping cart, notifications, and payments.

## Architecture

This application follows a microservices architecture with the following services:

- **Order Service** (Port: 8080) - Handles order placement and management, integrated with fulfillment service
- **Fulfillment Service** (Port: 8081) - Orchestrates order fulfillment, delivery, and payment processing
- **Inventory Service** (Port: 8888) - Manages product inventory
- **User Service** (Port: 8887) - User authentication and management
- **Product Catalog Service** (Port: 8886) - Product information and catalog
- **Shopping Cart Service** (Port: 8885) - Shopping cart functionality
- **Notification Service** (Port: 8890) - Handles notifications (Email, SMS, Push, In-App)
- **Payment Service** (Port: 8891) - Processes payments and transactions

## Features

- **Microservices Architecture**: Independent, scalable services
- **Service Integration**: Order service integrated with fulfillment service for seamless order processing
- **Asynchronous Processing**: Non-blocking order fulfillment using reactive programming
- **RESTful APIs**: Well-designed REST endpoints for each service
- **OpenAPI Documentation**: Swagger UI for all services
- **Exception Handling**: Global exception handling across services
- **Docker Support**: Containerization for easy deployment
- **Kubernetes Ready**: Complete K8s configurations for dev, test, and prod environments
- **Maven Multi-Module**: Centralized dependency management
- **Validation**: Request validation using Jakarta Bean Validation

## Technologies

- **Java 21**
- **Spring Boot 3.5.5**
- **Spring WebFlux** (Reactive programming for order-fulfillment integration)
- **Maven** (Multi-module project)
- **OpenAPI/Swagger** (API Documentation)
- **Docker** (Containerization)
- **Kubernetes** (Container orchestration with environment-specific configs)
- **Lombok** (Code generation)

## Getting Started

### Prerequisites

- Java 21 or higher
- Maven 3.6 or higher
- Docker (optional, for containerization)

### Running Individual Services

#### Using Maven Wrapper

```bash
# Order Service (integrated with fulfillment)
cd order-service
./mvnw spring-boot:run

# Fulfillment Service
cd fulfillment-service
./mvnw spring-boot:run

# Notification Service
cd notification-service
./mvnw spring-boot:run

# Payment Service
cd payment-service
./mvnw spring-boot:run

# Other services...
```

#### Using Docker

```bash
# Build and run a specific service
cd <service-name>
docker build -t <service-name> .
docker run -p <port>:<port> <service-name>
```

### Building All Services

```bash
# From the root directory
mvn clean compile
```

## API Documentation

Each service provides Swagger UI documentation:

- **Order Service**: http://localhost:8080/swagger-ui/index.html
- **Fulfillment Service**: http://localhost:8081/swagger-ui/index.html
- **Inventory Service**: http://localhost:8888/swagger-ui/index.html
- **User Service**: http://localhost:8887/swagger-ui/index.html
- **Product Catalog Service**: http://localhost:8886/swagger-ui/index.html
- **Shopping Cart Service**: http://localhost:8885/swagger-ui/index.html
- **Notification Service**: http://localhost:8890/swagger-ui/index.html
- **Payment Service**: http://localhost:8891/swagger-ui/index.html

## Key API Endpoints

### Order Service
- `POST /api/orders` - Place a new order (integrates with fulfillment service)
- `GET /api/orders/health` - Health check

### Fulfillment Service
- `POST /api/fulfillment/validate-order` - Validate order details
- `POST /api/fulfillment/initiate-delivery` - Initiate delivery process
- `POST /api/fulfillment/capture-payment` - Capture payment for order
- `POST /api/fulfillment/generate-shipping-label` - Generate shipping label
- `GET /api/fulfillment/health` - Health check

### Notification Service
- `POST /api/notifications/send` - Send notifications
- `GET /api/notifications/health` - Health check

### Payment Service
- `POST /api/payments/process` - Process payments
- `GET /api/payments/health` - Health check

### Shopping Cart Service
- `POST /api/cart/add` - Add item to cart
- `GET /api/cart/{userId}` - Get user's cart
- `PUT /api/cart/update` - Update cart item
- `DELETE /api/cart/remove` - Remove item from cart

## Project Structure

```
ecomm-app/
├── pom.xml (Parent BOM)
├── README.md
├── order-service/
│   ├── src/main/java/com/ecommapp/orderservice/
│   ├── pom.xml
│   └── Dockerfile
├── fulfillment-service/
│   ├── src/main/java/com/ecommapp/fulfillmentservice/
│   ├── pom.xml
│   └── Dockerfile
├── inventory-service/
│   ├── src/main/java/com/ecommapp/inventoryservice/
│   ├── pom.xml
│   └── Dockerfile
├── user-service/
│   ├── src/main/java/com/ecommapp/userservice/
│   ├── pom.xml
│   └── Dockerfile
├── product-catalog-service/
│   ├── src/main/java/com/ecommapp/productcatalogservice/
│   ├── pom.xml
│   └── Dockerfile
├── shopping-cart-service/
│   ├── src/main/java/com/ecommapp/shoppingcartservice/
│   ├── pom.xml
│   └── Dockerfile
├── notification-service/
│   ├── src/main/java/com/ecommapp/notificationservice/
│   └── pom.xml
├── payment-service/
│   ├── src/main/java/com/ecommapp/paymentservice/
│   └── pom.xml
└── k8s/
    ├── configmaps/ (Environment-specific configurations)
    │   ├── dev/
    │   ├── test/
    │   └── prod/
    ├── deployments/
    ├── services/
    └── environments/
```

## Service Communication

Services communicate through REST APIs with the following integration patterns:

- **Order-Fulfillment Integration**: Order service uses reactive WebClient to communicate asynchronously with fulfillment service for order validation, delivery initiation, and status updates
- **Health Monitoring**: Each service exposes health check endpoints for monitoring
- **Service Discovery Ready**: Services can be integrated with service discovery and load balancing solutions
- **Environment Configuration**: Kubernetes ConfigMaps provide environment-specific configurations for dev, test, and production deployments

## Deployment

### Kubernetes Deployment

The application includes complete Kubernetes configurations:

```bash
# Deploy to development environment
kubectl apply -f k8s/configmaps/dev/
kubectl apply -f k8s/deployments/
kubectl apply -f k8s/services/

# Deploy to test environment
kubectl apply -f k8s/configmaps/test/
kubectl apply -f k8s/deployments/
kubectl apply -f k8s/services/

# Deploy to production environment
kubectl apply -f k8s/configmaps/prod/
kubectl apply -f k8s/deployments/
kubectl apply -f k8s/services/
```

## Development

### Adding New Services

1. Create a new module directory
2. Add the module to the parent `pom.xml`
3. Follow the existing service structure and patterns
4. Implement controllers, services, models, and exception handling
5. Add appropriate tests and documentation

### Testing

Each service includes comprehensive testing capabilities. Run tests using:

```bash
cd <service-name>
./mvnw test
```

## Integration Status

✅ **Completed Integrations:**
- Order Service ↔ Fulfillment Service: Fully integrated with reactive communication
- Environment Configurations: Complete ConfigMaps for all services across dev/test/prod environments
- Kubernetes Deployment: Ready for container orchestration

🔄 **Future Integration Opportunities:**
- Payment Service ↔ Fulfillment Service: Payment capture integration
- Inventory Service ↔ Fulfillment Service: Stock validation integration
- Notification Service: Event-driven notifications for order status updates