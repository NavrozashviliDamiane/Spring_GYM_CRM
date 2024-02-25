# Gym CRM System

## Overview

This project is a Spring-based module that handles a gym Customer Relationship Management (CRM) system. It includes functionality for managing trainers, trainees, and training sessions.

## Functionalities

1. **Trainee Service**: Supports CRUD operations for trainee profiles.
2. **Trainer Service**: Supports CRUD operations for trainer profiles.
3. **Training Service**: Supports creating and selecting training profiles.

## Implementation Details

- **Written in JDK 17**: This project is written in Java and requires JDK 17.
- **Dependency Management**: Uses Maven for dependency management.
- **Framework and Libraries**:
    - Spring Framework
    - Mockito
    - JUnit
    - Log4j2

## Testing

The code is covered by unit tests, achieving a line coverage of at least 80%. Unit tests are written using JUnit and Mockito and adhere to the FIRST principles (Fast, Isolated/Independent, Repeatable, Self-validating, Timely).

## Logging

The code contains comprehensive logging using Log4j2, conforming to best practices. Various log levels are used, providing detailed information without containing sensitive data.

## Usage

### Prerequisites

- JDK 17
- Maven

### Instructions

1. **Clone the Repository**:

    ```bash
    git clone https://github.com/NavrozashviliDamiane/Spring_GYM_CRM.git
    ```

2. **Build the Project**:

    ```bash
    cd Spring_GYM_CRM
    mvn clean test
    ```
   For test coverage used **Jacoco** library, you have to go in project folder **Target/Site/Jacoco/index.html** which you can open in browser and check the coverage.



3. **Run the Application**:



## Additional Notes

- **Clean Code Standards**: The written code adheres to clean code standards, development best practices such as SOLID, KISS, and DRY, and utilizes design patterns to maintain engineering excellence.
- **In-memory Storage Optimization**: The in-memory storage has been implemented correctly and optimally to ensure efficient data handling.
- **Username Duplication**: Measures have been taken to avoid username duplication by appending a serial number when necessary.


