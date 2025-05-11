package starter.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.UUID;

public class WebDriverFactory {

    public static WebDriver create() {
        WebDriverManager.chromedriver().setup(); // ← esto resuelve todo automáticamente

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage"); // importante en entornos Windows


        if (System.getenv("CI") != null) {
            String profile = "--user-data-dir=/tmp/chrome-profile-" + UUID.randomUUID();
            options.addArguments(profile);
        }

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        return driver;
    }
}
