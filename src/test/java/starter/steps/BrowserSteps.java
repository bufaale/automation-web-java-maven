package starter.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BrowserSteps extends StepBase {

    public BrowserSteps() {
        super();
    }

    @Given("the user opens a new tab with {string}")
    public void openNewTab(String url) {
        browser.openNewTab(url);
    }

    @When("they switch to tab {int}")
    public void switchToTab(int index) {
        browser.switchToTab(index);
    }

    @Then("the tab title should contain {string}")
    public void verifyTabTitleContains(String expectedTitle) {
        String actualTitle = driver.getTitle();
        assertTrue(actualTitle.contains(expectedTitle),
                "Expected title to contain: " + expectedTitle + ", but got: " + actualTitle);
    }

    @Then("they close the current tab and switch back")
    public void closeTabAndSwitchBack() {
        browser.closeCurrentTabAndSwitchBack();
    }

    @Given("the user navigates to {string}")
    public void navigateToUrl(String url) {
        navigateTo(url); // viene desde StepBase
    }

}
