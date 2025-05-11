package starter.utils;

import org.openqa.selenium.WebDriver;
import starter.pages.LoginPage;

public class PageFactory {

    private final WebDriver driver;

    public PageFactory(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage loginPage() {
        return new LoginPage(driver);
    }

    // Podés seguir agregando métodos así:
    // public HomePage homePage() { return new HomePage(driver); }
    // public CartPage cartPage() { return new CartPage(driver); }
}
