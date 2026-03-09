# Todo Backend API

Backend RESTful API for managing tasks, built with Spring Boot.

## Tech Stack

- Java 8+
- Spring Boot
- Spring Data JPA
- Hibernate
- PostgreSQL
- Maven
- REST API

## Project Architecture
src/main/java/com/bara/todo
│
├── controller # REST endpoints
├── service # Business logic
├── repository # Data access layer
├── entity # JPA entities
└─  dto # Data Transfer Objects


## Features

- Create a task
- Retrieve all tasks
- Retrieve a task by ID
- Update a task
- Delete a task

## API Endpoints

| Method | Endpoint | Description |
|------|------|------|
| POST | /tasks | Create a new task |
| GET | /tasks | Get all tasks |
| GET | /tasks/{id} | Get task by ID |
| PUT | /tasks/{id} | Update task |
| DELETE | /tasks/{id} | Delete task |

## Example Request

POST /tasks

```json
{
"title": "I love Java",
"description": "Build a REST API",
"status": "TODO"
}
```

Run the Project

Clone the repository

git clone https://github.com/your-username/todo-backend.git

Configure the database in application.properties

Run the application

mvn spring-boot:run

The API will be available at:

http://localhost:8080/tasks
Author

Backend project built to practice Java and Spring Boot development.