package starter.steps;

import io.cucumber.java.en.*;
import starter.factory.PageFactory;
import starter.pages.LoginPage;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginSteps extends StepBase {

    private LoginPage loginPage;

    @Given("the user navigates to the login page")
    public void navigateToLoginPage() {
        driver.get("https://the-internet.herokuapp.com/login");
        loginPage = onPage(LoginPage.class);


    }

    @When("they enter username {string} and password {string}")
    public void enterCredentials(String username, String password) {
        loginPage.login(username, password);
    }

    @Then("they should see the message {string}")
    public void verifyFlashMessage(String expectedMessage) {
        assertTrue(loginPage.getFlashMessage(Duration.ofSeconds(2)).contains(expectedMessage));
    }
}
