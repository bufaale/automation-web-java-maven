package starter.steps;

import io.cucumber.java.en.Then;
import starter.pages.DashboardPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DashboardSteps extends StepBase {

    @Then("the dashboard should display the title {string}")
    public void theDashboardShouldDisplayTheTitle(String expectedTitle) {
        DashboardPage dashboard = onPage(DashboardPage.class);
        assertEquals(expectedTitle, dashboard.getHeaderTitle());
    }
}
