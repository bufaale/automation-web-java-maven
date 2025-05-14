package starter.utils;

import io.cucumber.java.Scenario;
import org.openqa.selenium.*;

import java.io.File;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class ValidationUtils {

    private final WebDriver driver;

    public ValidationUtils(WebDriver driver, Scenario scenario) {
        this.driver = driver;
    }

    private void takeAndAttachScreenshot(String context) {
        try {
            Scenario scenario = StepContext.getScenario();
            TakesScreenshot ts = (TakesScreenshot) driver;
            File screenshotFile = ts.getScreenshotAs(OutputType.FILE);

            // Guardar en carpeta local
            String filename = UUID.randomUUID() + "_" + context.replace(" ", "_") + ".png";
            File targetFile = new File("target/screenshots", filename);
            targetFile.getParentFile().mkdirs();
            screenshotFile.renameTo(targetFile);

            // Adjuntar al reporte de Serenity
            byte[] screenshotBytes = ts.getScreenshotAs(OutputType.BYTES);
            if (scenario != null) {
                scenario.attach(screenshotBytes, "image/png", filename);
            }

            System.out.println("📸 Screenshot guardado: " + targetFile.getPath());

        } catch (WebDriverException | NullPointerException e) {
            System.err.println("⚠️ No se pudo capturar el screenshot: " + e.getMessage());
        }
    }

    public void assertContains(String actual, String expected, String context) {
        try {
            assertTrue(actual.contains(expected),
                    String.format("❌ [%s] Expected to contain: '%s', but got: '%s'", context, expected, actual));
            System.out.printf("✅ [%s] '%s' contains '%s'%n", context, actual, expected);
        } catch (AssertionError e) {
            takeAndAttachScreenshot(context);
            throw e;
        }
    }

    public void assertEqualsWithLog(String expected, String actual, String context) {
        try {
            assertEquals(expected, actual,
                    String.format("❌ [%s] Expected: '%s', but got: '%s'", context, expected, actual));
            System.out.printf("✅ [%s] '%s' equals expected '%s'%n", context, actual, expected);
        } catch (AssertionError e) {
            takeAndAttachScreenshot(context);
            throw e;
        }
    }

    public void assertTextContains(By locator, String expected) {
        WebElement element = driver.findElement(locator);
        String actual = element.getText();
        assertTrue(actual.contains(expected),
                String.format("Expected text to contain: '%s' but got: '%s'", expected, actual));
    }

    public void assertTextEquals(By locator, String expected) {
        WebElement element = driver.findElement(locator);
        String actual = element.getText();
        assertEquals(expected, actual,
                String.format("Expected: '%s', but got: '%s'", expected, actual));
    }

    public void assertElementIsVisible(By locator) {
        WebElement element = driver.findElement(locator);
        assertTrue(element.isDisplayed(), "Expected element to be visible");
    }

    public void assertElementExists(By locator) {
        assertFalse(driver.findElements(locator).isEmpty(), "Expected element to exist");
    }

}
