package starter.utils;

import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

import static starter.core.driver.DriverProvider.getDriver;

public class StepContext {
    private static final ThreadLocal<Scenario> currentScenario = new ThreadLocal<>();

    public static void setScenario(Scenario scenario) {
        currentScenario.set(scenario);
    }

    public static Scenario getScenario() {
        return currentScenario.get();
    }

    public static void clear() {
        currentScenario.remove();
    }
}