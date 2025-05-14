package starter.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;
import java.nio.file.Files;
import java.util.UUID;

public class WebDriverFactory {

    public static WebDriver create() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        // 👇 Safe unique Chrome profile per thread (CI-friendly)
        try {
            String uniqueDir = Files.createTempDirectory("chrome-profile-" + UUID.randomUUID()).toString();
            options.addArguments("--user-data-dir=" + uniqueDir);
        } catch (IOException e) {
            System.err.println("❗ Failed to create isolated profile dir: " + e.getMessage());
        }

        if (isHeadlessEnabled()) {
            options.addArguments("--headless=new");
        }

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        return driver;
    }

    private static boolean isHeadlessEnabled() {
        // ejemplo básico con variable de entorno
        String headless = System.getenv("HEADLESS");
        return headless != null && headless.equalsIgnoreCase("true");
    }
}
