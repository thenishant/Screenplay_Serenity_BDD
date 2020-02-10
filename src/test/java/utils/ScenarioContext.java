package utils;

import java.util.HashMap;
import java.util.Map;

public final class ScenarioContext {

    private static Map<String, Object> scenarioContext;

    public ScenarioContext() {
        scenarioContext = new HashMap<>();
    }

    public static void setContext(String key, Object value) {
        scenarioContext.put(key, value);
    }

    public static Object getContext(String key) {
        return scenarioContext.get(key);
    }
}
