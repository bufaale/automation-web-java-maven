package starter.utils;

import org.openqa.selenium.WebDriver;

public class ElementFactory {

    private final WebDriver driver;

    public ElementFactory(WebDriver driver) {
        this.driver = driver;
    }

    public ElementUtils elementUtils() {
        return new ElementUtils(driver);
    }

    public WaitUtils waitUtils() {
        return new WaitUtils(driver);
    }

    public AlertUtils alertUtils() {
        return new AlertUtils(driver);
    }

    public WindowUtils windowUtils() {
        return new WindowUtils(driver);
    }

    public BrowserUtils browserUtils() {
        return new BrowserUtils(driver);
    }

    public ActionsUtils actionsUtils() {
        return new ActionsUtils(driver);
    }


}
