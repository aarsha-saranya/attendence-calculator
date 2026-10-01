# AttendenceCalculator# Attendance Calculator

A simple and user-friendly web application that calculates student attendance percentage and determines eligibility based on a 75% attendance requirement.

Built with **Spring Boot** and integrated with **Maven, GitHub, Jenkins, and Docker** to demonstrate a complete CI/CD workflow.

---

## Overview

The Attendance Calculator allows users to enter:

* Student Name
* Total Classes Conducted
* Classes Attended

The application calculates the attendance percentage and displays whether the student is eligible based on the 75% requirement.

### Attendance Formula

```text
Attendance Percentage = (Classes Attended / Total Classes) × 100
```

For example:

```text
Total Classes     : 60
Classes Attended  : 52

Attendance = (52 / 60) × 100
           = 86.67%

Status     : Eligible
```

---

## Tech Stack

| Technology  | Purpose                         |
| ----------- | ------------------------------- |
| Java        | Application development         |
| Spring Boot | Web application framework       |
| Thymeleaf   | Server-side HTML rendering      |
| HTML / CSS  | User interface                  |
| Maven       | Build and dependency management |
| JUnit       | Application testing             |
| Git         | Version control                 |
| GitHub      | Source code hosting             |
| Jenkins     | CI/CD automation                |
| Docker      | Containerization                |

---

## Application Architecture

```text
                    SOURCE CODE
                         |
                         v
                      GitHub
                         |
                         v
                     Jenkins
                         |
             +-----------+-----------+
             |                       |
             v                       v
       Maven Build                Testing
             |                       |
             +-----------+-----------+
                         |
                         v
                    Executable JAR
                         |
                         v
                    Docker Build
                         |
                         v
                  Docker Container
                         |
                         v
                Spring Boot App
                         |
                         v
                  localhost:2020
```

---

## Project Structure

```text
AttendanceCalculator/
|
+-- README.md
+-- Dockerfile
+-- pom.xml
|
+-- src/
    |
    +-- main/
    |   |
    |   +-- java/
    |   |   |
    |   |   +-- com/example/attendance/
    |   |       |
    |   |       +-- AttendanceCalculatorApplication.java
    |   |       +-- AttendanceController.java
    |   |
    |   +-- resources/
    |       |
    |       +-- application.properties
    |       +-- templates/
    |           |
    |           +-- index.html
    |           +-- result.html
    |
    +-- test/
        |
        +-- java/
            |
            +-- com/example/attendance/
                |
                +-- AttendanceControllerTest.java
```

---

## Running the Application Locally

### Prerequisites

Make sure the following are installed:

* Java 17 or later
* Maven
* Git

### Clone the Repository

```bash
git clone https://github.com/aarsha-saranya/attendence-calculator.git
cd attendence-calculator
```

### Build the Application

```bash
mvn clean package
```

### Run the Application

```bash
java -jar target/AttendanceCalculator-1.0.jar
```

Open your browser and visit:

```text
http://localhost:2020
```

---

## Testing

The project includes a Spring Boot test that verifies successful application startup.

Run:

```bash
mvn test
```

Expected result:

```text
Tests run: 1
Failures: 0
Errors: 0
Skipped: 0
```

---

## Docker

The application can be packaged and executed as a Docker container.

### Build the Docker Image

```bash
docker build -t attendance-calculator .
```

### Run the Container

```bash
docker run -d --name attendance-container -p 2020:2020 attendance-calculator
```

The application will then be available at:

```text
http://localhost:2020
```

### Docker Workflow

```text
Spring Boot Application
          |
          v
       Maven
          |
          v
        JAR
          |
          v
   Docker Image
          |
          v
  Docker Container
          |
          v
    Application
```

---

## Jenkins CI/CD Pipeline

Jenkins is used to automate the build, testing, containerization, and deployment process.

### Pipeline Stages

```text
Checkout
   |
   v
Build and Test
   |
   v
Docker Build
   |
   v
Docker Deploy
```

### 1. Checkout

Jenkins retrieves the latest source code from the `main` branch of the GitHub repository.

### 2. Build and Test

Maven:

* Cleans the previous build
* Compiles the source code
* Compiles test classes
* Runs the tests
* Packages the application
* Creates the executable Spring Boot JAR

### 3. Docker Build

Jenkins uses the project's `Dockerfile` to create the Docker image:

```text
attendance-calculator
```

### 4. Docker Deploy

Jenkins:

1. Stops the existing container
2. Removes the existing container
3. Starts a new container using the latest image

This ensures that the deployed application uses the latest successful build.

---

## CI/CD Pipeline Result

The complete pipeline successfully performs:

```text
GitHub
   |
   v
Jenkins Checkout
   |
   v
Maven Build
   |
   v
Automated Test
   |
   v
Spring Boot JAR
   |
   v
Docker Image
   |
   v
Docker Container
   |
   v
Running Web Application
```

---

## Application Configuration

The application runs on port:

```properties
server.port=2020
```

Application URL:

```text
http://localhost:2020
```

---

## Future Improvements

* Support multiple student records
* Store attendance data using a database
* Add attendance history
* Generate attendance reports
* Add graphical attendance statistics
* Add user authentication
* Add low-attendance notifications
* Deploy the application to a cloud platform
* Configure GitHub webhook-based automatic Jenkins triggering

---

## Learning Outcomes

This project demonstrates practical implementation of:

* Spring Boot web application development
* MVC-based application structure
* Maven build automation
* Unit and application testing
* Git version control
* GitHub repository management
* Jenkins pipeline automation
* Docker image creation
* Docker container deployment
* Basic CI/CD workflow
