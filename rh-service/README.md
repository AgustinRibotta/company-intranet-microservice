# Human Resources

The HR Service is responsible for managing user profiles and the designation and creation  of the departments within the 
company.

* 👤 **User profile management** (retrieve, update, delete profile)
* 📦 **User department management** (retrieve, create, update, delete department)
* 🔑 **JWT validation** — tokens are received from API Gateway, decrypted/validated, and used to enforce access rules

This service is responsible for storing all user profiles within the company. It communicates with the User Service microservice to 
ensure that the registered profiles belong to existing users.

---

# 📦 Technologies & Dependencies

### ✔ Spring Boot Starters

* spring-boot-starter-web
* spring-boot-starter-data-jpa
* spring-boot-starter-validation
* spring-boot-starter-security
* spring-boot-starter-oauth2-resource-server
* spring-boot-starter-actuator
* spring-boot-starter-test
* spring-boot-devtools

### ✔ Spring Cloud

* spring-cloud-starter-netflix-eureka-client
* spring-cloud-starter-config

### ✔ JWT Authentication

* jjwt-api
* jjwt-impl
* jjwt-jackson Used for validating tokens delivered by **API Gateway**.

### ✔ Documentation

* springdoc-openapi-starter-webmvc-ui (2.8.13)

### ✔ Database

* H2 Database (runtime)

### ✔ Utilities

* MapStruct
* Spring HATEOAS

---

# 🧠 Responsibilities of This Microservice

### 1️⃣ Profile Management

* Profile creation is done automatically when user is created
* Retriever user profile
* Edit user profile data
* Assign department to users profile

### 2️⃣ Department Management

* Create Department 
* Retriever Department
* Update Department

---

# 📘 API Documentation (Swagger / OpenAPI)

Swagger UI:

```
http://localhost:<port>/rh-service/swagger-ui.html
```

OpenAPI JSON:

```
http://localhost:<port>/rh-service/v3/api-docs
```

# ✔ Summary

The **Human Resources Service** is the **central security authority** of the system, providing:

* Profile CRUD
* Department CRUD
* JWT validation
* Integration with Eureka & Config Server
* H2 database for easy development
