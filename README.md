# Event Registration API

Simple Spring Boot REST API for managing and registering events (Lab Work 6).

## JDK Version
- Java 17 (or compatible Java 17+ environment)

## How to Run the Application
1. Clone the repository or extract the project archive.
2. Open the project in IntelliJ IDEA.
3. Run the application using Gradle or by executing the main class:
   - `EventRegistrationApiApplication.java`
4. Access the API in your browser or via Postman at:
   - `http://localhost:8080/api/events`

## Component Explanation
 - Model (`EventInfo`): Represents the data entity of an event, containing fields such as `id`, `title`, and `location`.
 - Service (`EventService`): Contains the business logic, managing an in-memory list of predefined events and providing data to the controller.
 - Controller (`RegistrationController`): Handles incoming HTTP GET requests at `/api/events` and returns the JSON response containing the list of events.
