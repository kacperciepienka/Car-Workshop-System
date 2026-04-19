# 🏎️ Car Workshop Management System

A professional REST API built with **Spring Boot 3** to manage car repair operations. This project was developed to master backend development fundamentals, focusing on clean architecture, database relations, and complex business logic.

## 🛠️ Tech Stack
* **Java 21**
* **Spring Boot 3** (Spring Web, Spring Data JPA, Validation)
* **H2 Database** (In-memory for development)
* **Lombok** (Boilerplate reduction)
* **IntelliJ IDEA** (HTTP Client for testing)

## 🚀 Key Features

### 1. Layered Architecture
Strict separation of concerns to ensure code maintainability:
* **Controller**: Handles HTTP requests and returns proper `ResponseEntity` (200, 201, 204, 404).
* **Service**: Contains all business logic and validations.
* **Repository**: Manages database communication via Spring Data JPA.

### 2. Advanced Business Logic
* **Dynamic Pricing**: The system automatically calculates the `totalCost` of a repair by adding a specialization bonus (e.g., Engine or Suspension bonus) to the base price of the service.
* **Status Workflow**: Prevents any modifications to an order once its status is set to `COMPLETED`.
* **Relationship Management**: Handles complex `@ManyToOne` relationships between Cars, Mechanics, and Repair Orders.

### 3. Comprehensive Filtering & Search
Advanced search capabilities across all entities:
* Search by registration number, brand, or model.
* Filter services and orders by price ranges and estimated time.
* Find orders handled by specific mechanics or specializations.

### 4. Data Validation
Ensures data integrity using **Jakarta Validation** annotations (`@NotBlank`, `@Min`, `@Size`, `@Valid`).

## 📂 Project Structure
```text
src/main/java/pl/nauka3/
├── controllers/    # REST Endpoints
├── services/       # Business Logic
├── repositories/   # Database access
├── models/         # Entities & Enums
