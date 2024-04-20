# Currency Conversion API Test Project

This project is aimed at testing the Currency Conversion API using Java, Cucumber, and Rest Assured. It includes features for validating API responses, checking for successful API calls, and verifying JSON schemas.

## Table of Contents

- [Introduction](#introduction)
- [Setup](#setup)
- [Usage](#usage)
- [Project Structure](#project-structure)


## Introduction

The Currency Conversion API Test Project is designed to ensure the correctness and reliability of the Currency Conversion API. It utilizes Cucumber for writing test scenarios in Gherkin syntax and Rest Assured for making HTTP requests and validating responses. Additionally, it employs JSON Schema validation to ensure that the API responses confirm to a predefined schema.

## Setup

### Prerequisites

- Java Development Kit (JDK)
- Apache Maven
- IDE (Integrated Development Environment) such as IntelliJ IDEA or Eclipse

### Installation

1. Clone the repository:

   ```bash
   git clone <repository-url>
2. Navigate to the project directory:
 ```bash
	cd currency-conversion-api-test-project
3. Build the project using Maven:
 ```bash
	mvn clean install

##Usage
1. Open the project in your preferred IDE.
2. Write or modify feature files in the src/test/resources/features directory to define test scenarios.
3. Implement step definitions in the src/test/java/stepdefinitions directory to define the behavior for each step.
4. Execute the tests by running the Cucumber test runner class or using Maven commands.	

##Project Structure

The project structure is organized as follows:

- src/test/resources/features: Contains feature files written in Gherkin syntax.
- src/test/java/stepdefinitions: Includes step definition files corresponding to the feature files.
- commonutils: Contains utility classes for JSON schema validation and schema generation.
- config: Holds configuration classes for test environment settings.
- pom.xml: Maven configuration file specifying project dependencies and build settings.
