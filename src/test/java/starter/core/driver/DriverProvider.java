package starter.core.driver;

import org.openqa.selenium.WebDriver;
import starter.utils.WebDriverFactory;

public class DriverProvider {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void initializeDriver() {
        if (driver.get() == null) {
            driver.set(WebDriverFactory.create());
        }
        driver.get();
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
