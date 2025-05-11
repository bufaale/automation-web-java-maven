package starter.utils;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class WindowUtils {
    private final WebDriver driver;

    public WindowUtils(WebDriver driver) {
        this.driver = driver;
    }

    public void switchToWindow(int index) {
        List<String> handles = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(handles.get(index));
    }
}
