package starter.utils;

import org.openqa.selenium.WebDriver;

public class AlertUtils {
    private final WebDriver driver;

    public AlertUtils(WebDriver driver) {
        this.driver = driver;
    }

    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    public String getAlertText() {
        return driver.switchTo().alert().getText();
    }
}
