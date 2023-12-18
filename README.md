# posts-microservices## User Microservice Documentation
### Overview
The Posts Microservice is a Spring Boot-based application designed to manage posts-related information. It utilizes Spring Data JPA for data persistence, Spring Cloud for service registration and discovery, and RabbitMQ for asynchronous messaging. The application is containerized using Docker.



## Table of Contents

1. [Project Structure](#project-structure)
2. [Build and Run](#build-and-run)
3. [Dependencies](#dependencies)

## Project Structure <a name="project-structure"></a>

```plaintext
user-microservice/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/usermicroservice/
│   │   │       ├── Post
│   │   │       ├── PostController
│   │   │       ├── PostMicroserviceApplication
│   │   │       ├── PostRepository
│   │   │       └── PostSenderService
│   │   │       └── PostService
│   │   │       └── CacheConfig
│   │   ├── resources/
│   │   │   └── application.yml
│   │   │   └── data.sql
│   │   │   └── schema.sql
│   └── test/
├── Dockerfile
├── pom.xml
```

### Build and Run <a name="build-and-run"></a>

To build amd run the application, run the following Maven command:

```bash
mvn clean install

java -jar ./target/user-microservice-0.0.1-SNAPSHOT.jar
```
Or use docker
```bash
docker build -t user-microservice .
docker run -p 8081:8081 user-microservice
```

### Dependencies
1. Spring Boot: 3.1.4
2. Spring Cloud: 2022.0.4
3. Database: H2
4. Message Broker: RabbitMQ
