📘 Quiz Application – Backend (Spring Boot)

🚀 Project Overview

This is a backend-only Quiz Application developed using Spring Boot.
The project provides REST APIs to manage quizzes, questions, and evaluate user responses.
It is designed to demonstrate backend development concepts such as RESTful APIs, layered architecture, Spring Data JPA, and transaction management.

Note:
This project does not include any frontend/UI.
It is intended to be consumed by tools like Postman, Swagger, or any frontend application.

🛠️ Tech Stack

Java
Spring Boot
Spring Data JPA
Hibernate
MySQL / H2 (configurable)
Maven
REST APIs

📂 Project Structure
src/main/java/com/example/demo
│
├── Controller
│   ├── QuestionController.java
│   ├── QuizController.java
│
├── Service
│   ├── QuestionService.java
│   ├── QuizService.java
│
├── Repository
│   ├── QuestionRepo.java
│   ├── QuizRepo.java
│
├── Model
│   ├── Question.java
│   ├── Quiz.java
│   ├── Response.java
│   ├── QuestionWrapper.java
│
└── QuizAppApplication.java

✨ Features

1. Create and manage quiz questions
2. Group questions by category
3. Create quizzes with selected questions
4. Fetch quiz questions without exposing correct answers
5. Submit responses and calculate correct answers
6. Delete questions by category
7. Proper use of service and repository layers
8. Transaction management using @Transactional

🔗 API Endpoints (Sample)
📌 Question APIs

Create Question
POST /question/add

Get All Questions
GET /question/all

Delete Questions by Category
DELETE /question/delete/category/{category}

📌 Quiz APIs

Create Quiz
POST /quiz/create

Get Quiz Questions
GET /quiz/get/{id}

Submit Quiz & Get Correct Answers
POST /quiz/submit/{id}

▶️ How to Run the Project
Prerequisites

Java 17+ (or compatible)
Maven
MySQL (optional if using H2)

Steps
git clone <repository-url>
cd demo
mvn spring-boot:run

The application will start at:
http://localhost:8081

🧪 Testing
APIs can be tested using Postman
No frontend is included
JSON-based request & response handling

📌 Future Improvements

Add Swagger/OpenAPI documentation
Add authentication & authorization
Add pagination & validation
Integrate frontend (React / Angular)
Improve exception handling

👨‍💻 Author
Mohd Junaid
Backend Developer | Spring Boot | Java
