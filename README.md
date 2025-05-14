# 🧪 UI Automation Framework with Selenium + Cucumber + Serenity

![UI Tests](https://github.com/bufaale/automation-web-java-maven/actions/workflows/maven.yml/badge.svg)
![Java](https://img.shields.io/badge/java-17-blue)
![Selenium](https://img.shields.io/badge/Selenium-4.10.0-brightgreen)
![License](https://img.shields.io/badge/license-Apache_2.0-blue.svg)

🔗 **[View Serenity Report (GitHub Pages)](https://bufaale.github.io/automation-web-java-maven/)**

---

## 🎯 About the Project

This is a professional UI automation framework built with **Selenium WebDriver**, **Cucumber BDD**, **Serenity BDD**, and **JUnit 5**. It is designed to showcase clean architecture, SOLID principles, and production-ready automation practices.

Key features:

- ✅ Parallel scenario execution with JUnit 5
- 🧱 Clean and modular architecture (SOLID)
- 🔁 Thread-safe WebDriver management
- 🎭 Screenplay pattern for reusable task modeling
- 📸 Screenshots on failure embedded in reports
- 📈 Serenity reports auto-published to GitHub Pages
- 🔁 GitHub Actions CI/CD integration

---

## 🚀 Technologies

- Java 17
- Maven
- Selenium WebDriver 4.10.0
- Serenity BDD 3.9.8
- Cucumber 7.15.0
- JUnit 5

---

## 📂 Project Structure

```
src/
  main/
    java/starter/
      core/         # DriverProvider, context
      utils/        # ElementUtils, ValidationUtils, BrowserUtils, etc.
      factory/      # PageFactory, ElementFactory
  test/
    java/starter/
      pages/        # Page Objects
      steps/        # Step Definitions
      hooks/        # Cucumber Hooks (e.g., driver setup, teardown)
      runner/       # JUnit Test Runner
resources/
  features/         # Gherkin .feature files
  junit-platform.properties
```

---

## ✅ Running Tests Locally

Run all tests:

```bash
mvn clean verify -Dwebdriver.chrome.driver=$(which chromedriver)
```

Run specific tag:

```bash
mvn clean verify -Dcucumber.filter.tags="@Browser"
```

---

## 🧪 Parallel Execution

Enabled via `junit-platform.properties`:

```properties
cucumber.execution.parallel.enabled=true
cucumber.execution.parallel.config.strategy=dynamic
cucumber.plugin=io.cucumber.core.plugin.SerenityReporterParallel
```

---

## 📈 Serenity Reports

Serenity generates rich HTML reports automatically:  
📁 `target/site/serenity/index.html`

📸 Screenshots on failure:  
📁 `target/screenshots/`

🪵 Surefire logs:  
📁 `target/surefire-reports/`

---

## ⚙️ GitHub Actions CI

This repo includes full CI support:

- Trigger: on every `push` or `pull_request` to `main`
- Runs tests in headless mode
- Uploads:
  - ✅ Serenity Report (`target/site/serenity`)
  - 📸 Screenshots on failure (`target/screenshots`)
  - 🪵 Surefire logs (`target/surefire-reports`)
- Deploys the report to GitHub Pages automatically

See workflow file: `.github/workflows/maven.yml`

---

## 👨‍💻 Author

**Alejandro Bufarini**  
Senior SDET | Java • Selenium • Serenity • RestAssured

---

[![LinkedIn](https://img.shields.io/badge/LinkedIn-AlejandroBufarini-blue?style=flat&logo=linkedin)](https://www.linkedin.com/in/alejandrobufarini/)
[![GitHub](https://img.shields.io/badge/GitHub-bufaale-blue?style=flat&logo=github)](https://github.com/bufaale)