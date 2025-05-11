package starter.steps;

import org.openqa.selenium.WebDriver;
import starter.core.driver.DriverProvider;
import starter.utils.*;

public abstract class StepBase {

    protected WebDriver getWebDriver() {
        return DriverProvider.getDriver();
    }

    protected ElementUtils getElementUtils() {
        return new ElementUtils(getWebDriver());
    }

    protected WaitUtils getWaitUtils() {
        return new WaitUtils(getWebDriver());
    }

    protected AlertUtils getAlertUtils() {
        return new AlertUtils(getWebDriver());
    }

    protected BrowserUtils getBrowserUtils() {
        return new BrowserUtils(getWebDriver());
    }

    protected ActionsUtils getActionsUtils() {
        return new ActionsUtils(getWebDriver());
    }

    protected <T> T onPage(Class<T> pageClass) {
        try {
            return pageClass.getConstructor(WebDriver.class).newInstance(getWebDriver());
        } catch (Exception e) {
            throw new RuntimeException("Failed to instantiate page: " + pageClass.getSimpleName(), e);
        }
    }

    public void navigateTo(String url) {
        getWebDriver().get(url);
    }
}
