package starter.steps;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import starter.core.TestContext;
import starter.pages.LoginPage;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginSteps extends StepBase {

    private LoginPage loginPage;

    @Before
    public void setupScenario(Scenario scenario) {
        setScenario(scenario);
    }

    @Given("the user navigates to the login page")
    public void navigateToLoginPage() {
        getWebDriver().get("https://the-internet.herokuapp.com/login");
        loginPage = onPage(LoginPage.class);
    }

    @When("they enter username {string} and password {string}")
    public void enterCredentials(String username, String password) {
        loginPage.login(username, password);
        TestContext.put("enteredUsername", username); // Guardamos el username
    }

    @Then("they should see the message {string}")
    public void verifyFlashMessage(String expectedMessage) {
        String actualMessage = loginPage.getFlashMessage(Duration.ofSeconds(2));
        TestContext.put("loginMessage", actualMessage);
        getValidator().assertContains(actualMessage, expectedMessage, "Flash message after login");
    }

}
