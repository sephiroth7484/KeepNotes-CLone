# KeepNotes-Clone

![KeepNotes-Clone Logo](https://websitedesign.plus/wp-content/uploads/logo-google-keep.png)  
*An exact replica of the Google Keep notes application focusing on backend development.*

## 📋 Overview

KeepNotes-Clone is a backend-centric project that replicates the core functionalities of the Google Keep notes application. Leveraging my experience in backend development, this project aims to build a robust, scalable, and secure backend to manage notes, labels, and user data.

## 🚧 In Progress

Currently working on:
- **REST API for Labels Management**: Creating APIs to add, update, and delete labels for note organization.
- **Service Layer Refactor**: Refactoring the service layer for better code modularity and maintainability.
- **JWT Authentication Integration**: Adding and refining JWT-based authentication for secure API access.
- **Unit Testing**: Writing unit tests for `NotesController` and `NotesService` to ensure functionality and reliability.

## 🚀 Features

- **User Authentication**: Implement secure login and registration with JWT-based authentication.
- **Notes Management**: Create, read, update, and delete notes using RESTful APIs.
- **Labels**: Add, update, and delete labels to organize notes.
- **Search Functionality**: Efficiently search notes by title and content.
- **Backup & Restore**: Options for backing up and restoring notes data.

## 🔧 Technologies & Skills Used

- **Java**: Core programming language for implementing business logic.
- **Spring Boot**: Framework for creating RESTful APIs and managing application configuration.
- **Hibernate & JPA**: ORM for seamless database interactions.
- **MySQL**: Relational database management system for storing user data and notes.
- **JWT**: JSON Web Tokens for secure authentication and authorization.
- **Docker**: Containerization for consistent development and deployment environments.
- **Maven**: Build automation tool for managing project dependencies.
- **Redis**: Caching to improve performance and reduce database load.
- **Apache Kafka**: For asynchronous messaging and event streaming.
- **Prometheus & Grafana**: Monitoring and visualization of application metrics.

## 📦 Setup Instructions

1. **Clone the repository:**

    ```bash
    git clone https://github.com/yourusername/KeepNotes-Clone.git
    cd KeepNotes-Clone
    ```

2. **Install dependencies:**

    ```bash
    mvn install
    ```

3. **Configure application properties:**

    Update `src/main/resources/application.properties` with your database credentials and other necessary configurations.

4. **Run the application:**

    ```bash
    mvn spring-boot:run
    ```

5. **Access the API:**

    The backend server will be available at `http://localhost:8080`.

## 📂 API Endpoints

- **POST /api/auth/register**: Register a new user.
- **POST /api/auth/login**: Log in and receive a JWT token.
- **GET /api/notes**: Retrieve all notes for the logged-in user.
- **POST /api/notes**: Create a new note.
- **PUT /api/notes/{id}**: Update an existing note.
- **DELETE /api/notes/{id}**: Delete a note.

## 🌐 Example

For more details on how Google Keep works, visit their [official website](https://keep.google.com).

## 📊 Screenshots

Here are some mockups of the application:

![Example Screenshot 1](https://www.example.com/screenshot1.png)  
![Example Screenshot 2](https://www.example.com/screenshot2.png)  

## 🛠️ Future Enhancements

- **Frontend Integration**: Develop a frontend application to interact with the backend services.
- **Advanced Features**: Implement note sharing, reminders, and real-time updates.

## 📝 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
