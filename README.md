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

## 🚀 Features

* 🔐 JWT-based authentication
* 🛡️ Spring Security integration
* 🔑 Token generation and validation
* 🌐 OAuth2 Resource Server support
* 🔗 Communication with other services using OpenFeign
* 🧩 Hexagonal Architecture
* 📦 Microservice-oriented design
* ☕ Java 21
* 🌱 Spring Boot
* 🏗️ Gradle build system

## 🛠️ Tech Stack

| Technology             | Purpose                              |
| ---------------------- | ------------------------------------ |
| Java 21                | Programming language                 |
| Spring Boot 3.2.4      | Application framework                |
| Spring Security        | Authentication and authorization     |
| Spring Web             | REST API                             |
| JWT                    | Token-based authentication           |
| OAuth2 Resource Server | JWT validation / resource protection |
| Spring Cloud OpenFeign | Service-to-service communication     |
| Gradle                 | Build and dependency management      |

The project uses Spring Boot `3.2.4`, Java `21`, JJWT `0.12.6`, Spring Cloud `2023.0.5`, and OpenFeign.

## 🔐 Authentication Flow

The authentication service acts as the central component responsible for issuing authentication tokens.

A typical authentication flow is:

```text
  ┌──────────┐
  │  Client  │
  └────┬─────┘
       │
       │ Credentials
       ▼
┌─────────────────┐
│   Auth Service  │
│                 │
│ Spring Security │
└───────┬─────────┘
        │
        │ Validate credentials
        ▼
┌─────────────────┐
│     User        │
│   Repository    │
└───────┬─────────┘
        │
        │ Valid
        ▼
┌─────────────────┐
│   JWT Service   │
│                 │
│ Generate Token  │
└───────┬─────────┘
        │
        │ JWT
        ▼
┌──────────────┐
│    Client    │
└──────┬───────┘
       │
       │ Authorization: Bearer <token>
       ▼
┌─────────────────────┐
│ Other Microservices │
│                     │
│ Validate JWT        │
└─────────────────────┘
```

### Token propagation

After successful authentication, the client receives a JWT.

For subsequent requests, the client sends the token using:

```http
Authorization: Bearer <JWT>
```


