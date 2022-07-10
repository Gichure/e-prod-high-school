[![CircleCI](https://dl.circleci.com/status-badge/img/gh/Gichure/e-prod-high-school/tree/develop.svg?style=svg)](https://dl.circleci.com/status-badge/redirect/gh/Gichure/e-prod-high-school/tree/develop)  
# E-Prod High School System
This web-based application provides APIs to manage Classes and Students for E-Prod High School

### Technology Stack
-  Java 17
-  Spring Boot 2.7
-  Spring Data
-  REST APIs
-  Thymeleaf
-  OpenAPi(Swagger)
-  MySQL
-  Bootstrap CSS

### Setup
-  Create MySQL user e_prod and password Eprod123#@!. Om running the application, required database and database objects shall be created.
-  Ensure you have JDK 17+ installed
-  Have Maven 3.8+ setup in the PC you are using
-  Have Git 2.0+ installed in your PC

### Run
-  Clone this repository
-  Change the working directory to cd Application
-  Run the command mvn clean spring-boot:run

### Endpoints
Browse to http://localhost:9191/swagger-ui/index.html  
![APIs Home](images/apis-home.png)

-  **Create a Class**  
`` curl -X POST "http://localhost:9191/classes" -H  "accept: application/json" -H  "Content-Type: application/json" -d "{  \"code\": \"F1A\",  \"name\": \"Form 1 A\"}"  ``  
**Response Body**  
```json
{
  "id": 1,
  "name": "Form 1 A",
  "code": "F1A"
}
```
-  **View Class**  
``curl -X GET "http://localhost:9191/classes/2" -H  "accept: application/json"``  
**Response Body**
```json
{
  "id": 2,
  "name": "Form 1 B",
  "code": "F1B"
}
```
-  **View all the class streams**  
`` curl -X GET "http://localhost:9191/classes" -H  "accept: application/json" ``  
```json
[
  {
    "id": 1,
    "name": "Form 1 A",
    "code": "F1A"
  },
  {
    "id": 2,
    "name": "Form 1 B",
    "code": "F1B"
  },
  {
    "id": 3,
    "name": "Form 1 C",
    "code": "F1C"
  },
  {
    "id": 4,
    "name": "Form 1 D",
    "code": "F1D"
  }
]
```  
-  **View a single class stream**    
`` curl -X GET "http://localhost:9191/classes/2" -H  "accept: application/json" ``  
**Response Body**  
```json
{
  "id": 2,
  "name": "Form 1 B",
  "code": "F1B"
}
```
-  **Capture student’s data**    
`` curl -X POST "http://localhost:9191/students" -H  "accept: application/json" -H  "Content-Type: application/json" -d "{  \"dateOfBirth\": \"2020-07-10\",  \"firstName\": \"Paul\",  \"lastName\": \"Gichure\",  \"registrationNumber\": \"2022/001\",  \"stream\": {   \"id\": 1 }}" ``  

**Response body**  
```json
{
  "id": 1,
  "firstName": "Paul",
  "lastName": "Gichure",
  "registrationNumber": "2022/001",
  "dateOfBirth": 1594339200000,
  "stream": {
    "id": 1,
    "name": "Form 1 A",
    "code": "F1A"
  }
}
```  
-  **Assign a student to a particular class stream**
-  **Edit student’s data**
-  **Delete a student’s data**
-  **View a single student’s data**  
`` curl -X GET "http://localhost:9191/students/3" -H  "accept: application/json" ``  

**Response body**  
```json
{
  "id": 3,
  "firstName": "Mary",
  "lastName": "Doe",
  "registrationNumber": "2022/003",
  "dateOfBirth": 1594339200000,
  "stream": {
    "id": 2,
    "name": "Form 1 B",
    "code": "F1B"
  }
} 
```  

-  **View all the students**  
`` curl -X GET "http://localhost:9191/students" -H  "accept: application/json" ``   
**Response body**  
```json
[
  {
    "id": 1,
    "firstName": "Paul",
    "lastName": "Gichure",
    "registrationNumber": "2022/001",
    "dateOfBirth": 1594339200000,
    "stream": {
      "id": 1,
      "name": "Form 1 A",
      "code": "F1A"
    }
  },
  {
    "id": 2,
    "firstName": "John",
    "lastName": "Doe",
    "registrationNumber": "2022/002",
    "dateOfBirth": 1594339200000,
    "stream": {
      "id": 1,
      "name": "Form 1 A",
      "code": "F1A"
    }
  },
  {
    "id": 3,
    "firstName": "Mary",
    "lastName": "Doe",
    "registrationNumber": "2022/003",
    "dateOfBirth": 1594339200000,
    "stream": {
      "id": 2,
      "name": "Form 1 B",
      "code": "F1B"
    }
  }
]
```  
-  **View students that belong to a particular class stream.**  
`` curl -X GET "http://localhost:9191/classes/2/students" -H  "accept: application/json" ``  
**Response Body**  
```json
[
  {
    "id": 3,
    "firstName": "Mary",
    "lastName": "Doe",
    "registrationNumber": "2022/003",
    "dateOfBirth": 1594339200000,
    "stream": {
      "id": 2,
      "name": "Form 1 B",
      "code": "F1B"
    }
  }
]
```    

-  **Search for a student by name**  
`` curl -X GET "http://localhost:9191/students/search?name=doe" -H  "accept: application/json" ``  
**Response Body**  
```json
[
  {
    "id": 2,
    "firstName": "John",
    "lastName": "Doe",
    "registrationNumber": "2022/002",
    "dateOfBirth": 1594339200000,
    "stream": {
      "id": 1,
      "name": "Form 1 A",
      "code": "F1A"
    }
  },
  {
    "id": 3,
    "firstName": "Mary",
    "lastName": "Doe",
    "registrationNumber": "2022/003",
    "dateOfBirth": 1594339200000,
    "stream": {
      "id": 2,
      "name": "Form 1 B",
      "code": "F1B"
    }
  }
] 
```

### Author
Paul Gichure
