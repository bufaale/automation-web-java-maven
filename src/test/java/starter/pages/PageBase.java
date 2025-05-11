package starter.pages;

import org.openqa.selenium.WebDriver;
import starter.utils.*;

public abstract class PageBase {
    protected final WebDriver driver;
    protected final ElementUtils elements;
    protected final WaitUtils wait;
    protected final AlertUtils alerts;
    protected final BrowserUtils browser;
    protected final ActionsUtils actions;


    public PageBase(WebDriver driver) {
        this.driver = driver;
        this.elements = new ElementFactory(driver).elementUtils();
        this.wait = new ElementFactory(driver).waitUtils();
        this.alerts = new ElementFactory(driver).alertUtils();
        this.browser = new ElementFactory(driver).browserUtils();
        this.actions = new ElementFactory(driver).actionsUtils();
    }
}
