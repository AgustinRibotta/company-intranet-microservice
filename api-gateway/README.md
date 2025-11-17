

# 🌐 API Gateway

The **API Gateway** acts as the **single entry point** for all client requests to the microservices ecosystem.
It is responsible for **routing, security, request filtering, and inter-service communication**.

---

# 📦 Technologies & Dependencies

### ✔ Spring Boot Starters

* spring-boot-starter-actuator
* spring-boot-devtools
* spring-boot-starter-test

### ✔ Spring Cloud

* spring-cloud-starter-gateway-server-webflux (API Gateway / Routing)
* spring-cloud-starter-netflix-eureka-client (Service discovery)
* spring-cloud-starter-openfeign (Feign client for inter-service calls)

### ✔ Utilities

* feign-core (core Feign library for declarative REST clients)

---

# 🔌 Main Responsibilities

1. **Routing Requests**

    * Routes incoming requests to the appropriate microservices.
    * Uses Eureka for dynamic service discovery.

2. **Security & Filtering**

    * Provides filters to allow certain endpoints **only between microservices**.
    * Supports JWT token validation or role-based pre-authentication when integrated with User Service.

3. **Load Balancing & Resilience**

    * Integrates with Spring Cloud for **client-side load balancing**.
    * Ensures high availability by routing requests to healthy instances.

4. **Inter-service Communication**

    * Uses **Feign clients** to communicate between microservices seamlessly.

---

# 🛠️ Features

* 🔄 Dynamic routing based on Eureka registry
* 🔒 Secure internal endpoints with custom filters
* ⚡ Automatic discovery of new microservice instances
* 📊 Monitoring endpoints via Spring Boot Actuator

---
