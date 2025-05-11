package starter.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;
import java.nio.file.Files;

public class WebDriverFactory {

    public static WebDriver create() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        // 👇 CI-friendly: evitar conflicto de perfiles con paralelismo
        try {
            String tempProfileDir = Files.createTempDirectory("chrome-profile").toAbsolutePath().toString();
            options.addArguments("--user-data-dir=" + tempProfileDir);
        } catch (IOException e) {
            System.err.println("❗Failed to create temp profile dir: " + e.getMessage());
        }

        // 👇 Modo headless si se desea desde variable de entorno o config externa
        if (isHeadlessEnabled()) {
            options.addArguments("--headless=new"); // usar headless moderno
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
