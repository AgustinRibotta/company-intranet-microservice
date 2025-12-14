# 🧑‍💼 User Service

The **User Service** is responsible for managing all user-related security data within the system.
Its core functionality includes:

* 👤 **User management** (create, update, delete users)
* 🔐 **Role management** (create roles with associated permissions)
* 🛡️ **Permission management** (define system-wide permissions)
* ✅ **Role-based access control (RBAC)** for every endpoint
* 🔑 **JWT validation** — tokens are received from API Gateway, decrypted/validated, and used to enforce access rules

This service acts as the **authorization core** of the platform.
Other microservices depend on the user/role/permission data defined here.

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
* jjwt-jackson
  Used for validating tokens delivered by **API Gateway**.

### ✔ Documentation

* springdoc-openapi-starter-webmvc-ui (2.8.13)

### ✔ Database

* H2 Database (runtime)

### ✔ Utilities

* MapStruct
* Spring HATEOAS

---

# 🔐 Security & Authorization

The service uses **strict RBAC (Role-Based Access Control)**.

### ✔ How authentication works:

1. The user logs in through **auth-service**
2. A JWT is generated
3. The request passes through **API Gateway**
4. API Gateway forwards the JWT to this service
5. This service:

    * Validates the JWT
    * Extracts roles
    * Applies access restrictions
---

# 🧠 Responsibilities of This Microservice

### 1️⃣ User Management

* Create a new user
* Edit user data
* Assign roles to users

### 2️⃣ Role Management

* Create roles (e.g., *ADMIN*, *HR*, *EMPLOYEE*)
* Attach permissions to roles (`ROLE_ADMIN` → `USER_READ`, `USER_CREATE`, etc.)

### 3️⃣ Permission Management

* Assign permissions to roles

---

# 📘 API Documentation (Swagger / OpenAPI)

Swagger UI:

```
http://localhost:<port>/user-service/swagger-ui.html
```

OpenAPI JSON:

```
http://localhost:<port>/user-service/v3/api-docs
```

---

# ✔ Summary

The **User Service** is the **central security authority** of the system, providing:

* User CRUD
* Role creation & storage
* Role-to-permission mapping
* User-to-role assignment
* Full RBAC for all endpoints
* JWT validation
* Integration with Eureka & Config Server
* H2 database for easy development

