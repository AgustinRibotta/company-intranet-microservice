# 🏷️ Eureka Naming Server

The **Eureka Naming Server** is responsible for **service discovery** in the microservices architecture.
It allows microservices to **register themselves** and **discover other services** dynamically without hardcoding service locations.

---

# 📦 Technologies & Dependencies

### ✔ Spring Boot Starters

* spring-boot-starter-actuator
* spring-boot-devtools
* spring-boot-starter-test

### ✔ Spring Cloud

* spring-cloud-starter-netflix-eureka-server
* spring-cloud-starter-config (optional, for centralized config integration)

---

# 🔌 Main Responsibilities

1. **Service Registration**

    * Microservices register themselves at startup with Eureka.
    * Each service provides metadata (host, port, status, instance ID).

2. **Service Discovery**

    * Other microservices can query Eureka to find instances of a service.
    * Eliminates hardcoded URLs in clients and supports load balancing.

3. **Health Monitoring**

    * Works with Spring Boot Actuator to track service health.
    * Automatically removes unhealthy instances from the registry.

---

# 🛠️ Features

* 🌐 Dynamic service registration and discovery
* ⚡ Integration with Spring Cloud Config Server
* 💻 Dashboard to monitor registered services at:

```
http://localhost:8761
```

* 🔄 Supports multiple instances of the same service for load balancing

