# 🔐 Auth Service

Authentication and authorization microservice built with **Java 21** and **Spring Boot**, designed to provide centralized security for applications following a microservices architecture.

The service is responsible for authenticating users, generating JWT tokens, and providing the security foundation that other microservices can use to protect their APIs.

## 🏗️ Architecture

The project follows **Hexagonal Architecture (Ports and Adapters)** principles, separating business rules from infrastructure and framework-specific implementations.

```text
                    ┌──────────────────────┐
                    │      Client / API    │
                    └──────────┬───────────┘
                               │
                               ▼
                    ┌──────────────────────┐
                    │   Authentication     │
                    │      Controller      │
                    └──────────┬───────────┘
                               │
                               ▼
                    ┌──────────────────────┐
                    │    Application       │
                    │       Layer          │
                    │                      │
                    │   Use Cases / Ports  │
                    └──────────┬───────────┘
                               │
                ┌──────────────┴──────────────┐
                │                             │
                ▼                             ▼
      ┌──────────────────┐          ┌──────────────────┐
      │ Security Adapter │          │ Persistence /    │
      │                  │          │ External Adapter │
      │ JWT / Security   │          │                  │
      └──────────────────┘          └──────────────────┘
```

The main package structure is organized into:

```text
com.kvales.auth
├── adapter
├── application
├── config
└── AuthMain.java
```

This separation helps keep the domain/application logic independent from infrastructure concerns.





