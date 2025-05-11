package starter.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ElementUtils {

    private final WebDriver driver;

    public ElementUtils(WebDriver driver) {
        this.driver = driver;
    }

    // ========== FIND METHODS ==========
    public WebElement findBy(By locator) {
        return driver.findElement(locator);
    }

    public List<WebElement> findAll(By locator) {
        return driver.findElements(locator);
    }

    public WebElement findById(String id) {
        return findBy(By.id(id));
    }

    public WebElement findByCss(String css) {
        return findBy(By.cssSelector(css));
    }

    public WebElement findByXpath(String xpath) {
        return findBy(By.xpath(xpath));
    }

    public WebElement findByName(String name) {
        return findBy(By.name(name));
    }

    public WebElement findByClass(String className) {
        return findBy(By.className(className));
    }

    // ========== ACTIONS ==========
    public void click(By locator) {
        findBy(locator).click();
    }

    public void type(By locator, String text) {
        WebElement element = findBy(locator);
        element.clear();
        element.sendKeys(text);
    }

    public String getText(By locator) {
        return findBy(locator).getText().trim();
    }

    public String getAttribute(By locator, String attribute) {
        return findBy(locator).getAttribute(attribute);
    }

    public String getTextById(String id) {
        return findById(id).getText().trim();
    }

    // ========== VALIDATIONS ==========
    public boolean isVisible(By locator) {
        try {
            return findBy(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isEnabled(By locator) {
        try {
            return findBy(locator).isEnabled();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isSelected(By locator) {
        try {
            return findBy(locator).isSelected();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isClickable(By locator) {
        return isEnabled(locator);
    }

    public boolean isDisplayed(By locator) {
        return isVisible(locator);
    }

    public boolean isPresent(By locator) {
        return !findAll(locator).isEmpty();
    }

    public boolean isPresent(WebElement parent, By locator) {
        try {
            return parent.findElement(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isPresent(WebElement parent, String css) {
        try {
            return parent.findElement(By.cssSelector(css)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isPresent(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
