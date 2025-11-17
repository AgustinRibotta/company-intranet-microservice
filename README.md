# 🧩 Microservices Practice Project

This project is a hands-on microservices architecture built using **Spring Boot**, **Spring Cloud**, **Feign**, **Eureka Discovery**, **Spring Cloud Config**, **JWT Authentication**, and **Swagger/OpenAPI**.

It is designed for learning the fundamental building blocks of modern distributed systems while keeping everything simple and easy to run locally.

---

# 📁 Project Structure

```
.
├── api-gateway                 # Routing, filters, entry point
├── auth-service                # Login, JWT generation
├── user-service                # User management, JWT validation
├── eureka-naming-server        # Service registry
└── spring-cloud-config-service # Central config server
```

---

# 🚀 Features

* **API Gateway** using Spring Cloud Gateway
* **Centralized Configuration** using Spring Cloud Config
* **Service Discovery** via Eureka
* **JWT Authentication & Authorization**
* **Inter-service communication** using Feign
* **OpenAPI 3.0 documentation** with Swagger UI
* **H2 in-memory database** for simplicity
* **Actuator endpoints** for health, metrics, and monitoring
* **MapStruct** for DTO–entity mapping

---

# 🛠️ Technologies & Dependencies

### ✔ Spring Boot Starters

* **spring-boot-starter-web** – REST controllers
* **spring-boot-starter-data-jpa** – persistence layer
* **spring-boot-starter-validation** – request validation
* **spring-boot-starter-security** – authentication & role-based authorization
* **spring-boot-starter-actuator** – monitoring
* **spring-boot-starter-test** – testing framework
* **spring-boot-devtools** – development hot reload

---

### ✔ Spring Cloud

* **spring-cloud-starter-netflix-eureka-client** – service discovery
* **spring-cloud-starter-config** – centralized configuration
* **spring-cloud-starter-openfeign** – declarative REST clients
* **Spring Cloud Gateway** – routing, filters, API entry point

---

### ✔ Security & Authentication

* **spring-boot-starter-oauth2-resource-server** – validates JWT tokens
* **jjwt-api**, **jjwt-impl**, **jjwt-jackson** – JWT creation & parsing
* **Role-Based Pre-Authorization** implemented via:

    * `@PreAuthorize("hasRole('ROLE_NAME')")`
    * Spring Security `SecurityFilterChain`
    * JWT claims with embedded roles

---

### ✔ Documentation

* **springdoc-openapi-starter-webmvc-ui (2.8.13)**

    * Auto-generates Swagger UI
    * API documentation exposed at `/swagger-ui.html`

---

### ✔ Database

* **H2 Database** (runtime, in-memory)

    * Ideal for development and testing
    * Replaceable with PostgreSQL or MySQL later

---

### ✔ Utilities

* **MapStruct** – fast mapper for DTO ↔ entity conversions

---

# 📝 Future Improvements

* Add Docker Compose for running all services

* Add refresh tokens
* Add rate limiting in API Gateway
* Move from H2 → PostgreSQL / MySQL
* Improve security configuration for production
* Implement more microservices

---

# 👨‍💻 Author

**Agustin Ribotta**
Microservices Practice Project for Spring

• Spring Boot

• Spring Cloud 

• JWT 

• Feign 

• Swagger

