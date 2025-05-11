package starter.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class LoginPage extends PageBase {

    private final By usernameField = By.id("username");
    private final By passwordField = By.id("password");
    private final By loginButton = By.cssSelector("button[type='submit']");
    private final By flashMessage = By.id("flash");

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }

    public String getFlashMessage(Duration timeout) {
        WebElement flash = wait.waitForVisibility(By.id("flash"), timeout);
        return flash.getText().trim();
    }
}
