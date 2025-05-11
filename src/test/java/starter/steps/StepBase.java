package starter.steps;

import org.openqa.selenium.WebDriver;
import starter.core.driver.DriverProvider;
import starter.utils.*;

public abstract class StepBase {

    protected final WebDriver driver;
    protected final ElementUtils elements;
    protected final WaitUtils wait;
    protected final AlertUtils alerts;
    protected final BrowserUtils browser;
    protected final ActionsUtils actions;

    public StepBase() {
        this.driver = DriverProvider.getDriver(); // Obtiene el driver actual
        this.elements = new ElementFactory(driver).elementUtils();
        this.wait = new ElementFactory(driver).waitUtils();
        this.alerts = new ElementFactory(driver).alertUtils();
        this.browser = new ElementFactory(driver).browserUtils();
        this.actions = new ElementFactory(driver).actionsUtils();
    }
    protected <T> T onPage(Class<T> pageClass) {
        try {
            return pageClass.getConstructor(WebDriver.class).newInstance(driver);
        } catch (Exception e) {
            throw new RuntimeException("Failed to instantiate page: " + pageClass.getSimpleName(), e);
        }
    }

    public void navigateTo(String url) {
        driver.get(url);
    }

}
