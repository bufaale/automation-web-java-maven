package starter.utils;

import org.openqa.selenium.WebDriver;

import static starter.core.driver.DriverProvider.getDriver;

public class StepContext {

    private StepContext() {
        // prevent instantiation
    }

    public static WebDriver getDriver() {
        return getDriver();
    }
}
