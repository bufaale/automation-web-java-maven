package starter.core.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class DriverProvider {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void initializeDriver() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        // ⛔ Desactivá esto si estás corriendo local y tenés problemas
        boolean isCI = System.getenv("CI") != null || System.getProperty("CI") != null;

        if (isCI) {
            try {
                Path profile = Files.createTempDirectory("chrome-profile");
                options.addArguments("--user-data-dir=" + profile.toAbsolutePath().toString());
            } catch (IOException e) {
                throw new RuntimeException("Error creating user-data-dir for Chrome", e);
            }
        }

        driver.set(new ChromeDriver(options));
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
