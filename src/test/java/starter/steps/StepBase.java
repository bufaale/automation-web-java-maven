package starter.steps;

import org.openqa.selenium.WebDriver;
import starter.core.driver.DriverProvider;
import starter.pages.PageBase;
import starter.utils.*;

import java.lang.reflect.Constructor;

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

    public <T extends PageBase> T onPage(Class<T> pageClass) {
        try {
            Constructor<T> constructor = pageClass.getConstructor(WebDriver.class);
            return constructor.newInstance(getWebDriver());
        } catch (Exception e) {
            throw new RuntimeException("Failed to instantiate page: " + pageClass.getSimpleName(), e);
        }
    }


    public void navigateTo(String url) {
        getWebDriver().get(url);
    }
}
