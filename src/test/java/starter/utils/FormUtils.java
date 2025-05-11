package starter.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class FormUtils {

    private final WebDriver driver;
    private final ElementUtils elements;

    public FormUtils(WebDriver driver) {
        this.driver = driver;
        this.elements = new ElementUtils(driver);
    }

    // ===== SELECT (Dropdown) =====
    public void selectByVisibleText(By selectLocator, String visibleText) {
        new Select(elements.findBy(selectLocator)).selectByVisibleText(visibleText);
    }

    public void selectByValue(By selectLocator, String value) {
        new Select(elements.findBy(selectLocator)).selectByValue(value);
    }

    public void selectByIndex(By selectLocator, int index) {
        new Select(elements.findBy(selectLocator)).selectByIndex(index);
    }

    public String getSelectedOption(By selectLocator) {
        return new Select(elements.findBy(selectLocator)).getFirstSelectedOption().getText();
    }

    // ===== CHECKBOXES =====
    public void check(By checkboxLocator) {
        WebElement checkbox = elements.findBy(checkboxLocator);
        if (!checkbox.isSelected()) {
            checkbox.click();
        }
    }

    public void uncheck(By checkboxLocator) {
        WebElement checkbox = elements.findBy(checkboxLocator);
        if (checkbox.isSelected()) {
            checkbox.click();
        }
    }

    public boolean isChecked(By checkboxLocator) {
        return elements.findBy(checkboxLocator).isSelected();
    }

    // ===== RADIO BUTTONS =====
    public void selectRadio(By radioLocator) {
        WebElement radio = elements.findBy(radioLocator);
        if (!radio.isSelected()) {
            radio.click();
        }
    }

    public boolean isRadioSelected(By radioLocator) {
        return elements.findBy(radioLocator).isSelected();
    }

    // ===== FORM SUBMISSION =====
    public void submit(By formLocator) {
        elements.findBy(formLocator).submit();
    }

    // ===== GET ALL OPTIONS FROM SELECT =====
    public List<WebElement> getAllDropdownOptions(By selectLocator) {
        return new Select(elements.findBy(selectLocator)).getOptions();
    }
}
