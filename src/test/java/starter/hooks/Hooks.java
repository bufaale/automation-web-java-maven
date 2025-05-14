package starter.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import starter.core.StepContext;
import starter.core.TestContext;
import starter.core.driver.DriverProvider;

public class Hooks {

    @Before
    public void beforeScenario(Scenario scenario) {
        StepContext.setScenario(scenario);
        OnStage.setTheStage(new OnlineCast()); // Screenplay stage
        DriverProvider.initializeDriver();      // Driver por thread
    }

    @After
    public void afterScenario() {
        TestContext.clear();
        DriverProvider.quitDriver();           // Cierra el driver de ese thread
    }

}
