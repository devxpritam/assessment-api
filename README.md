# Online Assessment System (MySQL Version)

A Spring Boot REST API for managing online tests, student attempts, and automated grading.

##  Features
- **Assessments**: Create and list test categories.
- **Questions**: Add multiple questions to specific tests.
- **Auto-Grading**: Real-time score calculation upon submission.
- **Ranking**: Leaderboard view sorted by highest score (Descending).

## 🛠 Tech Stack
- Java 17
- Spring Boot 3
- Spring Data JPA
- **MySQL Database**
- Maven

##  API Specification

| Task | Method | Endpoint |
| :--- | :--- | :--- |
| Create Assessment | POST | /assessments |
| Add Questions | POST | /assessments/{id}/questions |
| List All Tests | GET | /assessments |
| Start Attempt | POST | /attempts/start |
| Submit Answers | POST | /attempts/{id}/submit |
| View Rankings | GET | /results/{assessmentId} |

##  Setup & Configuration

### 1. Database Setup
1. Create a MySQL database named `assessment_db`.
2. Update `src/main/resources/application.properties` with your MySQL username and password.

### 2. Run the Application
1. Open the project in your IDE.
2. Run the `AssessmentApplication.java` main class.
3. The server will start on port **9696**.
4. Tables will be created automatically via Hibernate `ddl-auto`.

## Testing Instructions
1. Import the provided `Assessment_API_Tests.json` file into Postman.
2. Run the requests in order (1 through 6) to verify the full workflow.

##  Project Structure
- `src/main/java/.../controller`: REST Endpoints.
- `src/main/java/.../service`: Scoring and Ranking logic.
- `src/main/java/.../repository`: JPA Data Access.
