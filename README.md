# BDD_Framework_Cucumber_TestNG 🚀

This project implements a Behavior-Driven Development (BDD) testing framework using Cucumber with TestNG as the test runner and Selenium WebDriver for browser automation. It is designed to facilitate the creation and execution of automated tests with a focus on collaboration between technical and non-technical stakeholders.

## Table of Contents 📋

- [Project Overview](#project-overview)
- [Features](#features-✨)
- [Tech Stack](#tech-stack-🛠️)
- [Installation](#installation-⬇️)
- [Project Structure](#project-structure-📂)
- [Usage](#usage-💡)
- [Configuration](#configuration-⚙️)
- [Reporting](#reporting-📊)
- [Contributing](#contributing-🤝)
- [License](#license-📜)
- [Footer](#footer-📝)

## Project Overview 🌟

This repository contains a Java-based BDD testing framework built with Cucumber and TestNG. The primary goal is to automate testing processes, making them more readable and maintainable through the use of Gherkin syntax (feature files) and Page Object Model (POM) design patterns. The framework supports multiple browsers and includes utilities for configuration management, logging, reporting, and dynamic WebDriver management.

## Features ✨

- **Behavior-Driven Development (BDD):** Write test scenarios in plain language using Gherkin syntax (`.feature` files).
- **Cucumber Integration:** Leverage Cucumber to parse feature files and bind them to Java step definitions.
- **TestNG Test Runner:** Utilize TestNG for test execution, parallelization (if configured), and test management.
- **Selenium WebDriver:** Automate browser interactions for web application testing.
- **Page Object Model (POM):** Encapsulate page elements and actions within dedicated Page Objects for improved maintainability and reusability.
- **WebDriver Management:** Dynamic driver instantiation and management using `WebDriverManager` for seamless browser setup.
- **Cross-Browser Support:** Easily configure and run tests on Chrome, Firefox, and Edge.
- **Headless Execution:** Option to run tests in headless mode for CI/CD environments.
- **Configuration Management:** Centralized configuration using `config.properties` for application URLs, timeouts, and execution settings.
- **Logging:** Integrated logging using Log4j2 for detailed execution tracing.
- **Reporting:** Support for Extent Reports for comprehensive test execution reports and Allure Reports for richer test results analysis.
- **Screenshot Utility:** Automatic screenshot capture on test failure for easier debugging.
- **Explicit Waits:** Robust waiting strategies using `WebDriverWait` to handle dynamic web elements.

## Tech Stack 🛠️

- **Languages:** Java
- **Build Tool:** Maven
- **Testing Frameworks:** Cucumber, TestNG
- **Automation Library:** Selenium WebDriver
- **WebDriver Manager:** `io.github.bonigarcia:webdrivermanager`
- **Reporting:** ExtentReports, Allure TestNG Adapter
- **Logging:** Log4j2
- **Configuration:** Java `Properties`

## Installation ⬇️

This project uses Maven as its build tool. Ensure you have Java Development Kit (JDK) 21 or later and Apache Maven installed on your system.

1.  **Clone the Repository:**
    ```bash
    git clone https://github.com/jjalayon/BDDFramework_Cucumber_TestNG.git
    cd BDDFramework_Cucumber_TestNG
    ```

2.  **Build the Project:**
    Use Maven to download dependencies and compile the code.
    ```bash
    mvn clean install
    ```

## Project Structure 📂

```
BDDFramework_Cucumber_TestNG/
├── src/
│   ├── main/java/
│   │   ├── base/             # Base classes for Page Objects
│   │   │   └── BasePage.java
│   │   ├── pages/            # Page Object classes
│   │   │   └── LoginPage.java
│   │   ├── driver/           # WebDriver management
│   │   │   └── DriverManager.java
│   │   └── utils/            # Utility classes (ConfigReader, Logger, Wait, Report, Screenshot)
│   │       ├── ConfigReader.java
│   │       ├── ExtentReportManager.java
│   │       ├── LoggerUtilities.java
│   │       ├── ScreenshotUtil.java
│   │       └── WaitUtilities.java
│   ├── test/java/          # Test code
│   │   ├── runners/        # Cucumber test runners
│   │   │   └── TestNGCucumberRunner.java
│   │   └── StepDefinitions/ # Cucumber step definitions
│   │       ├── Hooks.java
│   │       └── LoginPageStepDef.java
│   ├── test/resources/
│   │   ├── config/         # Configuration properties file
│   │   │   └── config.properties
│   │   ├── features/       # Cucumber feature files
│   │   │   └── loginPage.feature
│   │   ├── extent-config.xml # Extent report configuration
│   │   └── log4j2.xml      # Log4j2 configuration
├── pom.xml                 # Maven Project Object Model
├── testng.xml              # TestNG suite configuration
├── README.md               # Project README file
└── logs/                   # Log files (generated during execution)
    └── automation.log
```

## Configuration ⚙️

Configuration settings are managed through the `src/test/resources/config/config.properties` file. Key properties include:

- `base.url`: The base URL of the application under test.
- `browser`: The browser to use for testing (e.g., `chrome`, `firefox`, `edge`). Defaults to `chrome`.
- `headless`: Set to `true` for headless browser execution, `false` otherwise.
- `implicit.wait`: Implicit wait timeout in seconds.
- `page.load.timeout`: Page load timeout in seconds.
- `explicit.wait`: Explicit wait timeout in seconds.
- `screenshot.path`: Directory to save screenshots.

**Example `config.properties` snippet:**

```properties
base.url=https://www.saucedemo.com/
browser=chrome
headless=false
implicit.wait=10
page.load.timeout=60
explicit.wait=20
screenshot.path=./test-output/screenshots/
```

## How to use 💡

This project is designed for automating web application tests using a BDD approach.

### Writing Tests

1.  **Create Feature Files:** Define test scenarios in Gherkin syntax within the `src/test/resources/features/` directory. For example, `loginPage.feature` describes login scenarios.

    ```gherkin
    Feature: Login Functionality

      Scenario Outline: User attempts to log in with different credentials
        Given that User is on the login page
        When user enters username "<username>"
        And user enters password "<password>"
        And user clicks the Login Button
        Then <message> should be visible

        Examples:
          | username          | password          | message                             |
          | standard_user     | secret_sauce      | "Products"                          |
          | problem_user      | secret_sauce      | "Products"                          |
          | locked_out_user   | secret_sauce      | "Epic sadface: Username and password do not match any user in this service" |
    ```

2.  **Implement Step Definitions:** Create corresponding Java methods in the `src/test/java/StepDefinitions/` package to map Gherkin steps to actions. The `LoginPageStepDef.java` file handles login-related steps.

### Running Tests

Tests can be executed using Maven with TestNG.

1.  **Run All Tests (via TestNG XML):**
    The `testng.xml` file defines the test suite. You can run it directly from Maven.
    ```bash
    mvn test
    ```
    This command will execute tests specified in `testng.xml`, which in turn uses `TestNGCucumberRunner` to discover and run features.

2.  **Run Specific Features/Tags:**
    You can modify the `@CucumberOptions` annotation in `TestNGCucumberRunner.java` to specify tags or features to run.

    **Example:** To run tests tagged with `@smoke`:
    ```java
    @CucumberOptions(
            // ... other options ...
            tags = "@smoke",
            // ... other options ...
    )
    ```

### Browser Configuration

Edit the `src/test/resources/config/config.properties` file to specify the browser (`browser=chrome`), headless mode (`headless=true`), and timeouts.

## Reporting 📊

This framework integrates with ExtentReports and Allure Reports for detailed test reporting.

-   **Extent Reports:** Generated HTML reports are typically found in the `test-output/` directory (e.g., `ExtentReport.html`).
-   **Allure Reports:** To generate Allure reports, ensure you have the Allure command-line tool installed. After running tests, you can generate the report using:
    ```bash
    mvn site
    # Then, to view the report:
    allure open
    ```
    Allure configuration properties can be found in `src/test/resources/allure.properties`.

## Contributing 🤝

Contributions are welcome! Please follow these guidelines:

1.  Fork the repository.
2.  Create a new branch for your feature (`git checkout -b feature/AmazingFeature`).
3.  Commit your changes (`git commit -m 'Add some AmazingFeature'`).
4.  Push to the branch (`git push origin feature/AmazingFeature`).
5.  Open a Pull Request.

## License 📜

This project is not explicitly licensed. Please refer to the original repository owner for licensing details.

## Footer 📝

This README was generated based on the analysis of the **BDDFramework_Cucumber_TestNG** repository.

-   **Repository:** [BDDFramework_Cucumber_TestNG](https://github.com/jjalayon/BDDFramework_Cucumber_TestNG)
-   **Author:** jjalayon
-   **Contact:** [Link to Author's Profile or Contact Info - if available]

Star ⭐ | Fork 🍴 | Watch 👀


---
**<p align="center">Generated by [ReadmeCodeGen](https://www.readmecodegen.com/)</p>**
