package starter.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {
    private final WebDriver driver;

    public WaitUtils(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement waitForVisibility(By locator, Duration timeout) {
        return new WebDriverWait(driver, timeout)
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
