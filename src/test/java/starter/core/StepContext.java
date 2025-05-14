package starter.core;

import io.cucumber.java.Scenario;

public class StepContext {

    private static final ThreadLocal<Scenario> currentScenario = new ThreadLocal<>();

    public static void setScenario(Scenario scenario) {
        currentScenario.set(scenario);
    }

    public static Scenario getScenario() {
        return currentScenario.get();
    }

    public static void clear() {
        currentScenario.remove();
    }
}
