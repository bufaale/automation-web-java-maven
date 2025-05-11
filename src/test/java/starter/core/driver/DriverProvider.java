package starter.core.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverProvider {

    private static final ThreadLocal<WebDriver> driverThread = new ThreadLocal<>();

    public static void initializeDriver() {
        WebDriverManager.chromedriver().setup();
        driverThread.set(new ChromeDriver());
    }

    public static WebDriver getDriver() {
        return driverThread.get();
    }

    public static void quitDriver() {
        if (driverThread.get() != null) {
            driverThread.get().quit();
            driverThread.remove();
        }
    }
}
