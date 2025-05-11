package starter.factory;

import org.openqa.selenium.WebDriver;

public class PageFactory {

    private final WebDriver driver;

    public PageFactory(WebDriver driver) {
        this.driver = driver;
    }

    public <T> T getPage(Class<T> pageClass) {
        try {
            return pageClass.getDeclaredConstructor(WebDriver.class).newInstance(driver);
        } catch (Exception e) {
            throw new RuntimeException("Failed to instantiate page: " + pageClass.getSimpleName(), e);
        }
    }
}
