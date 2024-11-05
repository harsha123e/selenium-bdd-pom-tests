# Selenium Test Automation Project Using BDD and POM

This project is a robust Selenium-based test automation framework designed for testing user account management functionalities, including login and sign-up processes. It employs **Behavior Driven Development (BDD)** using Cucumber to define test scenarios in a human-readable format. Additionally, the framework incorporates the **Page Object Model (POM)** design pattern, promoting code reusability and maintainability by encapsulating the interactions with web pages in dedicated classes.

This project aims to enhance the reliability and efficiency of testing processes while providing clear and maintainable test cases that align with business requirements.


## Features

- **User Login**: Tests the successful login of users with valid credentials.
- **User Sign Up**: Tests the successful account creation process with valid user details.
- **Headless Browser Testing**: Runs tests in a headless browser environment for CI/CD integration.

## Technologies Used

- **Java**: The primary programming language used in this project.
- **Selenium**: A powerful tool for web browser automation.
- **Cucumber**: A BDD framework for writing test scenarios in Gherkin syntax.
- **JUnit**: For running tests and assertions.
- **Maven**: For dependency management and project build automation.
- **GitHub Actions**: For Continuous Integration and Continuous Deployment (CI/CD).

## Getting Started

### Prerequisites

- Java 11
- Maven

### Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/harsha123e/your-repo-name.git
   cd your-repo-name
   ```

2. Install dependencies:
   ```bash
   mvn install
   ```

### Running Tests

To run the tests locally:

```bash
mvn test
```

To run the tests using headless browser locally:

```bash
mvn test -Dheadless=true
```

### CI/CD Integration

This project is set up with GitHub Actions for continuous integration. The tests will automatically run on every push or pull request to the `main` branch.

## Acknowledgments

- [Selenium](https://www.selenium.dev/) - For providing the web automation framework.
- [Cucumber](https://cucumber.io/) - For the BDD framework.
- [JUnit](https://junit.org/) - For testing.
