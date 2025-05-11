package starter.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionsUtils {

    private final WebDriver driver;
    private final Actions actions;

    public ActionsUtils(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
    }

    // Hover sobre un elemento
    public void hoverOver(WebElement element) {
        actions.moveToElement(element).perform();
    }

    // Click sostenido
    public void clickAndHold(WebElement element) {
        actions.clickAndHold(element).perform();
    }

    // Soltar click
    public void release(WebElement element) {
        actions.release(element).perform();
    }

    // Drag and drop
    public void dragAndDrop(WebElement source, WebElement target) {
        actions.dragAndDrop(source, target).perform();
    }

    // Doble click
    public void doubleClick(WebElement element) {
        actions.doubleClick(element).perform();
    }

    // Click derecho
    public void rightClick(WebElement element) {
        actions.contextClick(element).perform();
    }

    // Enviar teclas
    public void sendKeys(WebElement element, CharSequence... keys) {
        actions.sendKeys(element, keys).perform();
    }
}
