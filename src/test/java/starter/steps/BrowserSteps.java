package starter.steps;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import starter.pages.DashboardPage;

public class BrowserSteps extends StepBase {


    @Before
    public void setupScenario(Scenario scenario) {
        setScenario(scenario);
    }


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
        getValidator().assertContains(actualTitle, expectedTitle, "Tab title check");
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
