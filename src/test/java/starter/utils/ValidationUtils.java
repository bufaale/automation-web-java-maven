package starter.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidationUtils {

    public static void assertContains(String actual, String expectedSubstring, String description) {
        System.out.printf("🔍 Validating that [%s] contains [%s] — %s%n", actual, expectedSubstring, description);
        assertTrue(actual.contains(expectedSubstring),
                String.format("❌ Expected [%s] to contain [%s] — %s", actual, expectedSubstring, description));
    }

    public static void assertEqualsWithLog(String expected, String actual, String description) {
        System.out.printf("🔍 Comparing expected [%s] with actual [%s] — %s%n", expected, actual, description);
        assertEquals(expected, actual,
                String.format("❌ Expected [%s], but got [%s] — %s", expected, actual, description));
    }
}
