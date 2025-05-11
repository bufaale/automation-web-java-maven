# 🧪 UI Automation Framework with Selenium + Cucumber + Serenity

![Build Status](https://github.com/tu-usuario/ui-automation/actions/workflows/maven.yml/badge.svg)
![Java](https://img.shields.io/badge/java-17-blue)
![Selenium](https://img.shields.io/badge/Selenium-4.10.0-brightgreen)
![License](https://img.shields.io/badge/license-MIT-green)

## 🎯 About the Project

This is a professional UI automation framework built with **Selenium WebDriver**, **Cucumber BDD**, **Serenity BDD**, and **JUnit 5**. It supports:

- ✅ Parallel execution at the scenario level using JUnit 5
- 🧱 Clean architecture following SOLID principles
- 🧪 Utilities and factories for easy and scalable test development
- 💡 Easy extension for Screenplay pattern (already integrated)

## 🚀 Technologies

- Java 17
- Maven
- Selenium WebDriver 4.10.0
- Serenity BDD 3.9.8
- Cucumber 7.15.0
- JUnit 5

## 📂 Project Structure

```
src/
  main/
    java/starter/
      core/         # DriverProvider, setup
      utils/        # ElementUtils, WaitUtils, BrowserUtils, etc.
      factory/      # PageFactory, ElementFactory
  test/
    java/starter/
      pages/        # Page objects
      steps/        # Step definitions
      hooks/        # Cucumber hooks
      runner/       # JUnit TestRunner
resources/
  features/         # Gherkin feature files
  junit-platform.properties
```

## ✅ How to Run Tests

```
mvn clean verify
```

> To run a specific tag:
```
mvn clean verify -Dcucumber.filter.tags="@Browser"
```

## 🧪 Parallel Execution

JUnit 5 + Cucumber 7 configuration supports running scenarios in parallel using:

```properties
# src/test/resources/junit-platform.properties
cucumber.execution.parallel.enabled=true
cucumber.execution.parallel.config.strategy=dynamic
cucumber.plugin=io.cucumber.core.plugin.SerenityReporterParallel
```

## 📈 Reports

Serenity generates rich HTML reports under:  
`target/site/serenity/index.html`

## 👨‍💻 Author

**Alejandro Bufarini**  
Senior SDET | Java • Selenium • Serenity • RestAssured

---

Licensed under the MIT License.