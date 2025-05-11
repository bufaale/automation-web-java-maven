package starter.hooks;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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

    @After
    public void takeScreenshotOnFailure(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) DriverProvider.getDriver())
                    .getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
        DriverProvider.quitDriver();
    }

}
