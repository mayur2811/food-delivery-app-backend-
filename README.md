-- Users Table
CREATE TABLE users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    address VARCHAR(255),
    phone VARCHAR(20)
);

-- Restaurants Table
CREATE TABLE restaurants (
    restaurant_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    address VARCHAR(255),
    phone VARCHAR(20),
    rating DECIMAL(2,1)
);

-- Menu Items Table
CREATE TABLE menu_items (
    item_id INT AUTO_INCREMENT PRIMARY KEY,
    restaurant_id INT NOT NULL,
    name VARCHAR(100) NOT NULL,
    description TEXT,
    price DECIMAL(10,2) NOT NULL,
    is_available BOOLEAN DEFAULT TRUE,
    FOREIGN KEY (restaurant_id) REFERENCES restaurants(restaurant_id)
);

-- Orders Table
CREATE TABLE orders (
    order_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    restaurant_id INT NOT NULL,
    order_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    status VARCHAR(50) NOT NULL,
    total_price DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(user_id),
    FOREIGN KEY (restaurant_id) REFERENCES restaurants(restaurant_id)
);

-- Order Items Table
CREATE TABLE order_items (
    order_item_id INT AUTO_INCREMENT PRIMARY KEY,
    order_id INT NOT NULL,
    item_id INT NOT NULL,
    quantity INT NOT NULL,
    price DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (order_id) REFERENCES orders(order_id),
    FOREIGN KEY (item_id) REFERENCES menu_items(item_id)
);

-- Payments Table
CREATE TABLE payments (
    payment_id INT AUTO_INCREMENT PRIMARY KEY,
    order_id INT NOT NULL UNIQUE,
    payment_method VARCHAR(50) NOT NULL,
    amount DECIMAL(10,2) NOT NULL,
    payment_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    status VARCHAR(50) NOT NULL,
    FOREIGN KEY (order_id) REFERENCES orders(order_id)
);

-- Delivery Table
CREATE TABLE delivery (
    delivery_id INT AUTO_INCREMENT PRIMARY KEY,
    order_id INT NOT NULL UNIQUE,
    delivery_address VARCHAR(255) NOT NULL,
    delivery_time TIMESTAMP,
    delivery_status VARCHAR(50) NOT NULL,
    delivery_person VARCHAR(100),
    FOREIGN KEY (order_id) REFERENCES orders(order_id)
);

-- Spring Boot Application Design --

Entities:
- User
- Restaurant
- MenuItem
- Order
- OrderItem
- Payment
- Delivery

Packages:
- com.app.model        // Entity classes
- com.app.repository   // JPA repositories
- com.app.service      // Business logic
- com.app.controller   // REST controllers
- com.app.dto          // Data Transfer Objects
- com.app.config       // Configuration classes
- com.app.exception    // Custom exceptions

Main Components:

1. Entity Classes (@Entity)
    - User, Restaurant, MenuItem, Order, OrderItem, Payment, Delivery
    - Map fields to DB columns as per schema

2. Repository Interfaces (@Repository)
    - UserRepository, RestaurantRepository, MenuItemRepository, OrderRepository, OrderItemRepository, PaymentRepository, DeliveryRepository
    - Extend JpaRepository<T, ID>

3. Service Classes (@Service)
    - UserService, RestaurantService, MenuItemService, OrderService, PaymentService, DeliveryService
    - Business logic, validation, transaction management

4. Controller Classes (@RestController)
    - UserController, RestaurantController, MenuItemController, OrderController, PaymentController, DeliveryController
    - CRUD endpoints, order placement, payment, delivery tracking

5. DTOs
    - For request/response payloads (e.g., OrderRequest, PaymentResponse)

6. Security
    - Spring Security for authentication/authorization
    - Password encryption (BCrypt)
    - JWT for stateless auth (optional)

7. Exception Handling
    - @ControllerAdvice for global error handling

8. Application Properties
    - Database connection (spring.datasource.*)
    - JPA settings (spring.jpa.*)

9. Main Application Class
    - @SpringBootApplication annotated class

Example REST Endpoints:
- /users [GET, POST, PUT, DELETE]
- /restaurants [GET, POST, PUT, DELETE]
- /menu-items [GET, POST, PUT, DELETE]
- /orders [GET, POST]
- /orders/{id}/items [GET]
- /payments [POST]
- /delivery [GET, POST]

Testing:
- Unit tests for services
- Integration tests for controllers

Documentation:
- Swagger/OpenAPI for API docs

Build Tool:
- Maven or Gradle

Summary:
This design provides a modular, maintainable Spring Boot application structure for the food ordering system, mapping directly to your SQL schema.
