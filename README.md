# 🛒 E-Commerce Application

A Java Spring Boot-based e-commerce backend application that provides RESTful APIs for user management, product management, and order processing. The application uses Spring Data JPA, Hibernate, and MySQL to manage application data and relationships.

## 🎯 Project Overview

The E-Commerce Application is designed to handle essential online shopping operations through a Java-based backend.

Users can register and log in, retrieve product information, and place orders containing multiple products with their respective quantities.

The application follows a layered architecture using Spring Boot, Spring Data JPA, and Hibernate to separate request handling, business logic, and database operations.

## 🛠️ Technologies Used

| Technology | Purpose |
|---|---|
| Java 21 | Backend programming |
| Spring Boot | Application development |
| Spring Web MVC | REST API development |
| Spring Data JPA | Database interaction |
| Hibernate | Object-Relational Mapping (ORM) |
| MySQL | Relational database |
| Maven | Dependency management and build |
| Lombok | Reducing boilerplate code |

## ✨ Key Features

### 👤 User Management
- User registration.
- User login using email and password.
- Retrieve registered users.

### 📦 Product Management
- Retrieve all available products.
- Retrieve product details using product ID.
- Add new products.
- Delete products using product ID.

### 🛍️ Order Management
- Place orders for registered users.
- Support multiple products in a single order.
- Manage product quantities within an order.
- Store order amount, date, and status.
- Retrieve all orders.
- Retrieve orders belonging to a specific user.

### 🗄️ Database Management
- MySQL database integration.
- Entity relationships using JPA annotations.
- Database operations using Spring Data JPA repositories.
- Automatic persistence of related order items using cascading.

## 🏗️ Application Architecture

The application follows the Controller-Service-Repository architecture.

```text
                Client Request
                      |
                      v
                 Controller
                      |
                      v
                   Service
                      |
                      v
                 Repository
                      |
                      v
                   Hibernate
                      |
                      v
                   MySQL DB
```

### Layer Responsibilities

- **Controller:** Handles HTTP requests and returns application responses.
- **Service:** Contains business logic for user, product, and order operations.
- **Repository:** Performs database operations using Spring Data JPA and JpaRepository.
- **Entity:** Represents database tables and defines relationships between application objects.
- **DTO:** Transfers structured order information in API responses.

## 🔗 REST API Endpoints

### User APIs

| HTTP Method | Endpoint | Description |
|---|---|---|
| POST | `/user/register` | Register a new user |
| POST | `/user/login` | Authenticate user credentials |
| GET | `/user/get` | Retrieve all users |

### Product APIs

| HTTP Method | Endpoint | Description |
|---|---|---|
| GET | `/product` | Retrieve all products |
| GET | `/product/{id}` | Retrieve product by ID |
| POST | `/product/add-Product` | Add a new product |
| POST | `/product/delete/{id}` | Delete product by ID |

### Order APIs

| HTTP Method | Endpoint | Description |
|---|---|---|
| POST | `/order/place/{userId}` | Place an order for a user |
| GET | `/order/all-order` | Retrieve all orders |
| GET | `/order/user/{userId}` | Retrieve orders by user ID |

## 🔄 Order Processing Workflow

1. The client sends an order request with the user ID, product IDs, quantities, and total amount.
2. The application retrieves the corresponding user from MySQL.
3. The application retrieves each product using its product ID.
4. Order and OrderItem objects are created.
5. The order is associated with the user.
6. Each order item is associated with its corresponding product and order.
7. The order is saved using Spring Data JPA.
8. Order details are returned through an OrderDTO response.

## 🗂️ Database Entity Relationships

The application uses the following entities:

- **User:** Stores user information and maintains a relationship with orders.
- **Product:** Stores product details and maintains a relationship with order items.
- **Orders:** Stores order information and maintains relationships with users and order items.
- **OrderItem:** Connects products with orders and stores product quantities.

### Entity Relationship Overview

```text
          User
            |
            | One-to-Many
            |
          Orders
            |
            | One-to-Many
            |
         OrderItem
            |
            | Many-to-One
            |
          Product
```

## 📂 Project Structure

```text
ecommorce/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/sanjay/ecommorce/
│   │   │       │
│   │   │       ├── controller/
│   │   │       │   ├── UserController.java
│   │   │       │   ├── ProductController.java
│   │   │       │   └── OrderController.java
│   │   │       │
│   │   │       ├── service/
│   │   │       │   ├── UserService.java
│   │   │       │   ├── ProductService.java
│   │   │       │   └── OrderService.java
│   │   │       │
│   │   │       ├── repository/
│   │   │       │   ├── UserRepository.java
│   │   │       │   ├── ProductRepository.java
│   │   │       │   └── OrderRepository.java
│   │   │       │
│   │   │       ├── entity/
│   │   │       │   ├── User.java
│   │   │       │   ├── Product.java
│   │   │       │   ├── Orders.java
│   │   │       │   ├── OrderItem.java
│   │   │       │   └── OrderRequest.java
│   │   │       │
│   │   │       ├── dto/
│   │   │       │   ├── OrderDTO.java
│   │   │       │   └── OrderItemDTO.java
│   │   │       │
│   │   │       └── EcommorceApplication.java
│   │   │
│   │   └── resources/
│   │       └── application.properties
│   │
│   └── test/
│
├── pom.xml
└── README.md

```

## ⚙️ Getting Started

### Prerequisites

- Java JDK 21
- Maven
- MySQL Server
- IntelliJ IDEA or another Java IDE
- Postman (for API testing)

### Installation and Setup

**1. Clone the repository**

```bash
git clone https://github.com/codewithsanjay-hacks/E-Commerce-Application.git
```

**2. Navigate to the project directory**

```bash
cd E-Commerce-Application/ecommorce
```

**3. Configure MySQL**

Create a MySQL database and configure the connection in:

`src/main/resources/application.properties`

Example configuration:

```properties
spring.application.name=ecommorce

spring.datasource.url=jdbc:mysql://localhost:3306/ecommerce
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect
```

Replace the database name and credentials with your own configuration.

**4. Run the application**

Using Maven:

```bash
mvn spring-boot:run
```

Or using Maven Wrapper:

```bash
./mvnw spring-boot:run
```

The application will start on the configured Spring Boot server port.

## 📚 Concepts Applied

- Object-Oriented Programming (OOP)
- Java 21
- Spring Boot Application Development
- RESTful API Development
- Controller-Service-Repository Architecture
- Spring Data JPA
- Hibernate ORM
- JpaRepository
- Custom Repository Methods
- JPQL and JOIN FETCH
- One-to-Many and Many-to-One Relationships
- DTO Pattern
- Cascade Operations
- MySQL Database Integration
- Maven Dependency Management

## 👨‍💻 Author

**Sanjay P Achar**

Aspiring Java Developer | Learning Java & Spring Boot

- GitHub: [codewithsanjay-hacks](https://github.com/codewithsanjay-hacks)
- LinkedIn: [Sanjay P Achar](https://linkedin.com/in/sanjay-p-achar)

---

⭐ If you find this project useful, consider giving it a star!
