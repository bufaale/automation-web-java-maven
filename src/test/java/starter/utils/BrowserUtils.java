package starter.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import java.util.ArrayList;
import java.util.Set;

public class BrowserUtils {

    private final WebDriver driver;
    private final JavascriptExecutor js;

    public BrowserUtils(WebDriver driver) {
        this.driver = driver;
        this.js = (JavascriptExecutor) driver;
    }

    // Scroll hacia un número de píxeles vertical
    public void scrollDown(int pixels) {
        js.executeScript("window.scrollBy(0," + pixels + ")");
    }

    // Scroll hasta el final de la página
    public void scrollToBottom() {
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    // Scroll hasta el inicio de la página
    public void scrollToTop() {
        js.executeScript("window.scrollTo(0, 0)");
    }

    public void openNewTab(String url) {
        js.executeScript("window.open('about:blank','_blank');");
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabs.size() - 1)); // Cambia a la nueva pestaña
        driver.get(url); // Navega a la URL que pasaste
    }


    // Cambiar a una pestaña por índice
    public void switchToTab(int index) {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        if (index < tabs.size()) {
            driver.switchTo().window(tabs.get(index));
        } else {
            throw new IllegalArgumentException("Tab index out of bounds: " + index);
        }
    }

    public void closeCurrentTabAndSwitchBack() {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        String currentHandle = driver.getWindowHandle();
        int currentIndex = tabs.indexOf(currentHandle);

        driver.close();

        // Volver al anterior si existe, si no, al primero
        int newIndex = (currentIndex > 0) ? currentIndex - 1 : 0;
        driver.switchTo().window(tabs.get(newIndex));
    }

    public void refresh() {
        driver.navigate().refresh();
    }

    // Volver atrás en el historial
    public void goBack() {
        driver.navigate().back();
    }

    // Adelantar en el historial
    public void goForward() {
        driver.navigate().forward();
    }
}
