package starter.steps;

import io.cucumber.java.en.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BrowserSteps extends StepBase {

    @Given("the user opens a new tab with {string}")
    public void openNewTab(String url) {
        getBrowserUtils().openNewTab(url);
    }

    @When("they switch to tab {int}")
    public void switchToTab(int index) {
        getBrowserUtils().switchToTab(index);
    }

    @Then("the tab title should contain {string}")
    public void verifyTabTitleContains(String expectedTitle) {
        String actualTitle = getWebDriver().getTitle();
        assertTrue(
                actualTitle.contains(expectedTitle),
                "Expected title to contain: " + expectedTitle + ", but got: " + actualTitle
        );
    }

    @Then("they close the current tab and switch back")
    public void closeTabAndSwitchBack() {
        getBrowserUtils().closeCurrentTabAndSwitchBack();
    }

    @Given("the user navigates to {string}")
    public void navigateToUrl(String url) {
        navigateTo(url); // Heredado de StepBase
    }
}
