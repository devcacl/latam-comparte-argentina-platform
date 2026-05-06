# Latam Comparte Argentina Platform

Spring Boot platform for the Argentina implementation of Latam Comparte.

## Tech Stack

- Java 17
- Spring Boot 4
- Maven Wrapper
- Thymeleaf
- Spring Data JPA
- PostgreSQL

## Requirements

- JDK 17 or newer
- PostgreSQL for runtime environments that use persistence

## Getting Started

Run the application with the Maven Wrapper:

```bash
./mvnw spring-boot:run
```

On Windows:

```powershell
.\mvnw.cmd spring-boot:run
```

Run the test suite:

```bash
./mvnw test
```

## Project Structure

```text
src/main/java      Application source code
src/main/resources Runtime configuration and templates
src/test/java      Automated tests
```

## Configuration

Application configuration lives in `src/main/resources/application.properties`.
Do not commit credentials or environment-specific secrets. Prefer environment
variables or deployment-level configuration for database credentials and other
sensitive values.
