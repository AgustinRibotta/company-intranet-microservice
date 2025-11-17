# ⚙️ Spring Cloud Config Service

The **Config Service** provides centralized configuration for all microservices in the platform.
It serves properties, YAML files, and environment-specific configuration from a Git repository (or local file system) to all services that need them.

---

# 📦 Technologies & Dependencies

### ✔ Spring Boot Starters

* spring-boot-devtools
* spring-boot-starter-test

### ✔ Spring Cloud

* spring-cloud-config-server

This microservice **does not have a database**. It only serves configuration data to other services.

---

# 🔌 Main Responsibilities

1. Centralized configuration management for all microservices
2. Serving properties and YAML files over HTTP
3. Supporting multiple environments (e.g., `dev`, `staging`, `prod`)
4. Integrates seamlessly with Eureka for service discovery (optional)

---

# 🛠️ Features

* 🌐 Exposes REST endpoints for configuration retrieval
* 🔄 Auto-refresh support for clients via `/actuator/refresh` (requires Spring Boot Actuator on client)
* 📝 Supports properties and YAML files
* 🔑 Can integrate with Git repositories, local files, or Vault

---