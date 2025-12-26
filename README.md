# Kasparro Backend – Spring Boot & ETL System

## Project Overview
Kasparro Backend is a Spring Boot–based backend application developed as part of an internship assignment.  
The project demonstrates end-to-end backend development using clean architecture, REST APIs, database integration, ETL processing, pagination, global error handling, and Docker-based deployment.

This project reflects real-world backend engineering practices using Java and Spring Boot.

---

## Tech Stack
- Java 21  
- Spring Boot  
- Spring Data JPA  
- Hibernate  
- PostgreSQL  
- Docker & Docker Compose  
- Maven  
- Postman  

---

## Project Architecture
The application follows a clean layered architecture:

Controller → Service → Repository → Database

This structure ensures:
- Separation of concerns  
- Better maintainability  
- Scalable and readable code  

---

## Assignment Implementation

### P0 – Project Setup
- Spring Boot project initialization  
- PostgreSQL database configuration  
- Health check endpoint  

Endpoint:
GET /health

---

### P1 – Core Backend & Clean Architecture
- Entity: HealthStatus  
- Repository using JpaRepository  
- Service layer for business logic  
- Controller layer for REST APIs  
- DTOs with validation  
- Global exception handling using RestControllerAdvice  

This phase establishes a clean and maintainable backend foundation.

---

### P2 – ETL (Extract, Transform, Load)
- Extract data from JSON input  
- Transform input into entity objects  
- Load transformed data into PostgreSQL database  
- ETL exposed via REST endpoint  

---

### P3 – Advanced REST APIs, Pagination & PUT Update
Implemented production-ready APIs:
- Create record (POST)  
- Read all records (GET)  
- Read record by ID (GET)  
- Update record using PUT (full update)  
- Delete record (DELETE)  
- Pagination using Spring Data Pageable  

Pagination example:
GET /health/all?page=0&size=1

The response includes metadata such as total pages and total elements.

---

## Docker Support
The application is fully containerized.

- Dockerfile for Spring Boot application  
- Docker Compose for backend and PostgreSQL  
- Container networking and port mapping  

Run using:
docker compose up --build

Backend runs on:
http://localhost:8081

PostgreSQL runs on:
localhost:5433

---

## API Testing
All APIs were tested using Postman, including:
- CRUD operations  
- Pagination  
- ETL execution  
- PUT update validation  
- Global error handling  

---

## Key Learnings
- Clean backend architecture using Spring Boot  
- Service-based business logic implementation  
- REST API best practices  
- Pagination using Spring Data  
- ETL workflow implementation  
- Docker containerization and rebuild workflow  
- Debugging containerized applications  

---

## Project Outcome
This project demonstrates the ability to:
- Build scalable backend systems  
- Follow industry-standard architecture  
- Work with databases and REST APIs  
- Implement ETL pipelines  
- Containerize applications using Docker  

---

## Author
Swapnil  
Backend Developer – Java & Spring Boot  
Internship Assignment Project
