# 🔑 Auth Service

The **Auth Service** is responsible for **user authentication, token generation, and validation** in the microservices ecosystem.
It acts as the central authority for issuing **JWT tokens** after verifying user credentials through the **User Service**.

---

# 📦 Technologies & Dependencies

### ✔ Spring Boot Starters

* spring-boot-starter-web (REST APIs)
* spring-boot-starter-security (Spring Security)
* spring-boot-starter-oauth2-resource-server (JWT validation for incoming requests)
* spring-boot-starter-hateoas (HATEOAS support for hypermedia APIs)
* spring-boot-devtools (development utilities)
* spring-boot-starter-test / spring-security-test (unit and integration testing)

### ✔ Spring Cloud

* spring-cloud-starter-config (externalized configuration)
* spring-cloud-starter-netflix-eureka-client (service discovery)
* spring-cloud-starter-openfeign (Feign client for communicating with User Service)

### ✔ JWT Libraries

* jjwt-api, jjwt-impl, jjwt-jackson (for token creation and parsing)

---

# 🔌 Main Responsibilities

1. **User Authentication**

    * Validates user credentials by querying the **User Service** via Feign client.
    * Ensures that login requests are only accepted for existing users.

2. **JWT Token Management**

    * Generates JWT tokens upon successful authentication.
    * Includes roles and permissions in token claims for downstream authorization.
    * Validates incoming JWT tokens for protected endpoints.

3. **Inter-service Security**

    * Acts as the **trusted authority** for internal microservices to validate tokens.
    * Integrates with API Gateway and other services for role-based access control.

---

# 🛠️ Features

* 🔐 **Secure Login**: Authenticate users and generate JWT tokens.
* 🎫 **Token Verification**: Validates JWT for downstream requests.
* 📨 **User Service Integration**: Checks credentials via Feign client.
* ⚡ **Role-based Claims**: Tokens carry role and permission information.
* 🌐 **Centralized Auth**: Single point of authentication for all microservices.

---

# ✔ Summary

The **Auth Service** centralizes authentication and JWT management, ensuring secure communication across the microservices ecosystem.
It is critical for:

* User verification and login
* JWT-based security for internal and external endpoints
* Role and permission propagation for authorization

---
