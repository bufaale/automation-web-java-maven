package starter.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage extends PageBase {

    private final By headerTitle = By.tagName("h2"); // por ejemplo, un <h2> que dice "Welcome to Secure Area"

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    public String getHeaderTitle() {
        return elements.findBy(headerTitle).getText().trim();
    }
}
