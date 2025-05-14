package starter.steps;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;
import starter.pages.DashboardPage;


public class DashboardSteps extends StepBase {

    @Before
    public void setupScenario(Scenario scenario) {
        setScenario(scenario);
    }

    @Then("the dashboard should display the title {string}")
    public void theDashboardShouldDisplayTheTitle(String expectedTitle) {
        DashboardPage dashboard = onPage(DashboardPage.class);
        getValidator().assertEqualsWithLog(expectedTitle, dashboard.getHeaderTitle(), "Dashboard header title");
    }

}
