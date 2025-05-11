package starter.hooks;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import starter.core.driver.DriverProvider;

public class Hooks {

    @Before
    public void beforeScenario() {
        OnStage.setTheStage(new OnlineCast()); // Screenplay stage
        DriverProvider.initializeDriver();      // Driver por thread
    }

    @After
    public void afterScenario() {
        DriverProvider.quitDriver();           // Cierra el driver de ese thread
    }
}
